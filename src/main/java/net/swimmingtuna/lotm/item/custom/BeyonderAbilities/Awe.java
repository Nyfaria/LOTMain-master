package net.swimmingtuna.lotm.item.custom.BeyonderAbilities;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;
import net.swimmingtuna.lotm.spirituality.SpiritualityMain;
import net.swimmingtuna.lotm.util.effect.ModEffects;

public class Awe extends Item {

    public Awe(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use (Level level, Player pPlayer, InteractionHand hand) {
        pPlayer.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence -> {
                    if (spectatorSequence.getSpectatorSequence() >= 3) {
                        applyPotionEffectToEntities(pPlayer);
                        if (!pPlayer.getAbilities().instabuild)
                            pPlayer.getCooldowns().addCooldown(this,240);
                        SpiritualityMain.consumeSpirituality(pPlayer,75);
                    }
                });
        return super.use(level,pPlayer,hand);}

    private void applyPotionEffectToEntities(Player pPlayer) {
        pPlayer.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence ->  {
            double radius = spectatorSequence.getSpectatorSequence() + 5.0;
            float damage = (float) ((spectatorSequence.getSpectatorSequence()) /2 + 3);
            for (LivingEntity entity : pPlayer.level().getEntitiesOfClass(LivingEntity.class, pPlayer.getBoundingBox().inflate(radius))) {
                if (entity != pPlayer)
                    entity.addEffect((new MobEffectInstance(ModEffects.AWE.get(),100,1)));
                entity.hurt(entity.damageSources().magic(), damage);
            }
        });
    }
}
