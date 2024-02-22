package net.swimmingtuna.lotm.events;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkEvent;
import net.swimmingtuna.lotm.LOTM;
import net.swimmingtuna.lotm.beyonder.SpectatorSequence;
import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;
import net.swimmingtuna.lotm.beyonder.TyrantSequenceProvider;
import net.swimmingtuna.lotm.spirituality.ModAttributes;
import net.swimmingtuna.lotm.spirituality.ModGameLogic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import static java.util.Locale.filter;

@Mod.EventBusSubscriber(modid = LOTM.MOD_ID)
public class ModEvents {
    @SubscribeEvent

    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
    if(event.getObject() instanceof Player) {
        if (!event.getObject().getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).isPresent()) {
            event.addCapability(new ResourceLocation(LOTM.MOD_ID, "spectatorsequence"), new SpectatorSequenceProvider());
        }
        if (!event.getObject().getCapability(TyrantSequenceProvider.TYRANTSEQUENCE).isPresent()) {
            event.addCapability(new ResourceLocation(LOTM.MOD_ID, "tyrantsequence"), new TyrantSequenceProvider());
        }
    }}
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            Player oldPlayer = event.getOriginal();
            Player newPlayer = event.getEntity();
            AttributeInstance oldAttribute = oldPlayer.getAttribute(ModAttributes.MAX_SPIRITUALITY.get());
            AttributeInstance newAttribute = newPlayer.getAttribute(ModAttributes.MAX_SPIRITUALITY.get());
            AttributeInstance oldAttribute1 = oldPlayer.getAttribute(ModAttributes.SPIRITUALITY_REGEN.get());
            AttributeInstance newAttribute1 = newPlayer.getAttribute(ModAttributes.SPIRITUALITY_REGEN.get());
            AttributeInstance oldAttribute2 = oldPlayer.getAttribute(ModAttributes.SOUL_BODY.get());
            AttributeInstance newAttribute2 = newPlayer.getAttribute(ModAttributes.SOUL_BODY.get());
            if (oldAttribute != null && newAttribute != null && oldAttribute1 != null && newAttribute1 != null && oldAttribute2 != null && newAttribute2 != null)
                newAttribute.setBaseValue(oldAttribute.getBaseValue());
                newAttribute1.setBaseValue(oldAttribute1.getBaseValue());
                newAttribute2.setBaseValue(oldAttribute2.getBaseValue());

            event.getOriginal().getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
            event.getOriginal().getCapability(TyrantSequenceProvider.TYRANTSEQUENCE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(TyrantSequenceProvider.TYRANTSEQUENCE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });}
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(SpectatorSequence.class);
        event.register(TyrantSequenceProvider.class);
    }
    private static final AtomicInteger spiritualityTimer = new AtomicInteger(0);
    private static final int SPIRITUALITY_DELAY = 1;
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            int addSpiritualityTimer = spiritualityTimer.incrementAndGet();
            if (addSpiritualityTimer >= SPIRITUALITY_DELAY)
                ModGameLogic.addSpirituality(event.player);
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
    }
}
