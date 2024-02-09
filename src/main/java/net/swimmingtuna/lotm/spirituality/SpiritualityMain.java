package net.swimmingtuna.lotm.spirituality;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class SpiritualityMain {

@SubscribeEvent
    public static void spiritualityChange(TickEvent.PlayerTickEvent event) {
    Player player = event.player;
    AttributeInstance maxSpiritualityInstance = player.getAttribute(ModAttributes.MAX_SPIRITUALITY.get());
    AttributeInstance spiritualityInstance = player.getAttribute(ModAttributes.SPIRITUALITY.get());
    if (maxSpiritualityInstance == null || spiritualityInstance == null) {
        return;
        }
    double maxSpirituality = maxSpiritualityInstance.getValue();
    double spirituality = spiritualityInstance.getBaseValue();
    double intel = player.getAttributeValue(ModAttributes.INTELLIGENCE.get());
    double curSpiritualityRegen = player.getAttributeValue(ModAttributes.SPIRITUALITY_REGEN.get());
    double spiritualityRegen = maxSpirituality / 500 * (1 + curSpiritualityRegen / 100);
    CompoundTag tag = player.getPersistentData();
    tag.putDouble("spiritualityRegen", spiritualityRegen);
        if (spirituality > maxSpirituality) {
            spirituality = maxSpirituality;
        }
        maxSpirituality = 100 + intel;

        spiritualityInstance.setBaseValue(spirituality);
        maxSpiritualityInstance.setBaseValue(maxSpirituality);
    }
    public static boolean consumeSpirituality(LivingEntity living, double spiritualityToConsume) {
    if (spiritualityToConsume <= 0) return true;
    double spirituality = getSpirituality(living);
    if (spiritualityToConsume > 0) {
        spirituality -= spiritualityToConsume;
    }
    setSpirituality(living,spirituality);
    return true;
    }

    public static double getSpirituality(LivingEntity living) {
    return AttributeHelper.getSaveAttributeValue(ModAttributes.SPIRITUALITY.get(), living);
    }
    public static void setSpirituality(LivingEntity living, double spirituality) {
    AttributeInstance instance = living.getAttribute(ModAttributes.SPIRITUALITY.get());
    if (instance != null) {
        instance.setBaseValue(spirituality);
    }
    }
}
