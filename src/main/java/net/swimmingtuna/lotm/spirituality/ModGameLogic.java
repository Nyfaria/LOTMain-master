package net.swimmingtuna.lotm.spirituality;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;

public class ModGameLogic {
    public static void addSpirituality(Entity pEntity) {
        if (pEntity instanceof Player) {
            AttributeInstance spiritualityAttribute = ((Player) pEntity).getAttribute(ModAttributes.SPIRITUALITY.get());
            pEntity.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence -> {
                if (spiritualityAttribute != null && spectatorSequence.getSpectatorSequence() == 0) {
                    double currentSpirituality = spiritualityAttribute.getValue();
                    double newSpirituality = currentSpirituality + 1;

                    spiritualityAttribute.setBaseValue(Math.max(0, newSpirituality));
                }
            });
        }
    }
}
