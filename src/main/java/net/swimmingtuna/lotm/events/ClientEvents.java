package net.swimmingtuna.lotm.events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;
import net.swimmingtuna.lotm.client.SpiritualityBarOverlay;

import java.util.concurrent.atomic.AtomicInteger;


@Mod.EventBusSubscriber (Dist.CLIENT)
public class ClientEvents {

    private static final AtomicInteger crouchTimer = new AtomicInteger(0);
    private static final int CROUCH_DELAY = 60;


    @SubscribeEvent
    public static void onRegisterOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.EXPERIENCE_BAR.id(), "spirituality_overlay", SpiritualityBarOverlay.instance);
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START && event.player != null) {
            event.player.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence -> {
                if (spectatorSequence.getSpectatorSequence() >= 1) {
                    event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,20,1));
                    if (event.player.isCrouching()) {
                        int currentTimer = crouchTimer.incrementAndGet();
                        if (currentTimer >= CROUCH_DELAY) {
                            event.player.setInvisible(true);
                            crouchTimer.set(0);
                        }
                    } else {
                        // Reset timer and make the player visible if not crouching
                        crouchTimer.set(0);
                        event.player.setInvisible(false);
                    }
                }
            });
        }
    }
}

