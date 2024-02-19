package net.swimmingtuna.lotm.item.custom.BeyonderAbilities;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.LazyOptional;
import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;
import net.swimmingtuna.lotm.events.ReachChangeUUIDs;
import net.swimmingtuna.lotm.spirituality.SpiritualityMain;
import net.swimmingtuna.lotm.util.effect.ModEffects;

public class Frenzy extends Item implements ReachChangeUUIDs {

    private final LazyOptional<Multimap<Attribute, AttributeModifier>> lazyAttributeMap = LazyOptional.of(() -> createAttributeMap()); //LazyOptional in this instance basically makes it so that the reach change is only in effect when something happens

    public Frenzy(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pSlot) {
        if (pSlot == EquipmentSlot.MAINHAND) {
            return lazyAttributeMap.orElseGet(() -> createAttributeMap());
        }
        return super.getDefaultAttributeModifiers(pSlot);
    }
    private Multimap<Attribute, AttributeModifier> createAttributeMap() {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = ImmutableMultimap.builder();
        attributeBuilder.putAll(super.getDefaultAttributeModifiers(EquipmentSlot.MAINHAND));

        //reach should be ___
        attributeBuilder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BeyonderEntityReach, "Reach modifier", 12, AttributeModifier.Operation.ADDITION)); //adds a 12 block reach for interacting with entities
        attributeBuilder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(BeyonderBlockReach, "Reach modifier", 12, AttributeModifier.Operation.ADDITION)); //adds a 12 block reach for interacting with blocks, p much useless for this item
        return attributeBuilder.build();
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
            Player pPlayer = pContext.getPlayer();
            Level level = pPlayer.level();
            BlockPos positionClicked = pContext.getClickedPos();
            if (!pContext.getLevel().isClientSide) {
                pPlayer.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence -> {
                if (spectatorSequence.getSpectatorSequence() >= 3) {
                    applyPotionEffectToEntities(pPlayer,level,positionClicked);
                    if (!pPlayer.getAbilities().instabuild) {
                        pPlayer.getCooldowns().addCooldown(this,300);
                        SpiritualityMain.consumeSpirituality(pPlayer,125);
                    }
                }
            });}
            return InteractionResult.SUCCESS;
    }
    private void applyPotionEffectToEntities(Player pPlayer, Level level, BlockPos targetPos) {
        pPlayer.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence ->  {
            double radius = spectatorSequence.getSpectatorSequence() + 5.0;
            float damage = (float) ((spectatorSequence.getSpectatorSequence()) + 3);
            AABB boundingBox = new AABB(targetPos).inflate(radius);
            level.getEntitiesOfClass(LivingEntity.class, boundingBox, entity -> entity.isAlive()).forEach(livingEntity -> {
                if (livingEntity != pPlayer)
                    (livingEntity).addEffect((new MobEffectInstance(ModEffects.FRENZY.get(),100,1)));
                livingEntity.hurt(livingEntity.damageSources().magic(), damage);
            });
    });
}}