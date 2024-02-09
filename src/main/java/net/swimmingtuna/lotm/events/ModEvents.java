package net.swimmingtuna.lotm.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.swimmingtuna.lotm.LOTM;
import net.swimmingtuna.lotm.beyonder.SpectatorSequence;
import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;
import net.swimmingtuna.lotm.spirituality.ModGameLogic;

@Mod.EventBusSubscriber(modid = LOTM.MOD_ID)
public class ModEvents {
    @SubscribeEvent

    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
    if(event.getObject() instanceof Player) {
        if(!event.getObject().getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).isPresent()) {
            event.addCapability(new ResourceLocation(LOTM.MOD_ID, "spectatorsequence"), new SpectatorSequenceProvider());
        }
    }
}


    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(SpectatorSequence.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            if (event.player.getRandom().nextFloat() < 0.005f)
                ModGameLogic.addSpirituality(event.player);
        }

    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
    }
}
