package net.swimmingtuna.lotm.item.custom.BeyonderPotions;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;
import net.swimmingtuna.lotm.util.effect.ModEffects;

import java.util.List;

public class Spectator8Potion extends Item{
    public Spectator8Potion(Properties pProperties, AttributeModifier mana) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level,Player pPlayer,InteractionHand hand) {
        var effect = new MobEffectInstance(ModEffects.ADVANCEMENT8.get(),1,1);
        effect.setCurativeItems(List.of());
        ItemStack itemStack = pPlayer.getItemInHand(hand);
            pPlayer.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence ->  {
                if (spectatorSequence.getSpectatorSequence() == 1 && !level.isClientSide()){
                    spectatorSequence.addSpectatorSequence(1);
                    level.playSound(null,pPlayer.getOnPos(), SoundEvents.PORTAL_AMBIENT, SoundSource.PLAYERS,0.5f,level.random.nextFloat() * 0.1F + 0.9F);
                    pPlayer.sendSystemMessage(Component.literal("You have advanced to a Telepathist").withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.BOLD));
                    pPlayer.addEffect(new MobEffectInstance(ModEffects.ADVANCEMENT8.get(),1,1));
                    pPlayer.getAttribute(Attributes.MAX_HEALTH).setBaseValue(28.0);
                    if (!pPlayer.getAbilities().instabuild) {
                        itemStack.shrink(1);}};});
            return super.use(level,pPlayer,hand);}}