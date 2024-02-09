package net.swimmingtuna.lotm.util.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class AdvancementEffect0 extends MobEffect {
    public AdvancementEffect0(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory,color);}

    @Override
    public void applyEffectTick(LivingEntity pEntity, int pAmplifier) {
        var effect = new MobEffectInstance(MobEffects.BLINDNESS,5000,1);
        effect.setCurativeItems(List.of());
        var effect1 = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,5000,4);
        effect1.setCurativeItems(List.of());
        var effect2 = new MobEffectInstance(MobEffects.CONFUSION,5000,1);
        effect2.setCurativeItems(List.of());
        var effect3 = new MobEffectInstance(MobEffects.POISON,5000,20);
        effect2.setCurativeItems(List.of());

        if (!pEntity.level().isClientSide()) {
            pEntity.addEffect(effect);
            pEntity.addEffect(effect1);
            pEntity.addEffect(effect2);
            pEntity.addEffect(effect3);
            pEntity.setHealth(1);
        }
        super.applyEffectTick(pEntity, pAmplifier);
    }
    @Override
    public boolean isDurationEffectTick(int pDuration,int pAmplifier) {
        return true;
    }
}
