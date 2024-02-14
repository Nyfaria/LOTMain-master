package net.swimmingtuna.lotm.spirituality;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.swimmingtuna.lotm.beyonder.SpectatorSequenceProvider;

import static net.swimmingtuna.lotm.spirituality.ModAttributes.MAX_SPIRITUALITY;
import static net.swimmingtuna.lotm.spirituality.ModAttributes.SPIRITUALITY_REGEN;

public class ModGameLogic {
    public static void addSpirituality(Entity pEntity) {
        if (pEntity instanceof Player) {
            AttributeInstance spiritualityAttribute = ((Player) pEntity).getAttribute(ModAttributes.SPIRITUALITY.get());
            pEntity.getCapability(SpectatorSequenceProvider.SPECTATORSEQUENCE).ifPresent(spectatorSequence -> {
                if (spiritualityAttribute != null && spectatorSequence.getSpectatorSequence() >= 1) {
                    double spirititualityRegen = (int) ((Player) pEntity).getAttributeValue(SPIRITUALITY_REGEN.get());
                    double currentSpirituality = spiritualityAttribute.getValue();
                    double newSpirituality = currentSpirituality + Math.random() * (spirititualityRegen * 1.5);

                    spiritualityAttribute.setBaseValue(Math.max(0, newSpirituality));
                }
            });
        }
    }
}
