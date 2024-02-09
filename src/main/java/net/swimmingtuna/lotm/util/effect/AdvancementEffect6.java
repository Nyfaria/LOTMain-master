package net.swimmingtuna.lotm.util.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class AdvancementEffect6 extends MobEffect {
    public AdvancementEffect6(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory,color);}

    @Override
    public void applyEffectTick(LivingEntity pEntity, int pAmplifier) {
        var effect = new MobEffectInstance(MobEffects.BLINDNESS,400,1);
        effect.setCurativeItems(List.of());
        var effect1 = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,400,4);
        effect1.setCurativeItems(List.of());
        var effect2 = new MobEffectInstance(MobEffects.CONFUSION,400,1);
        effect2.setCurativeItems(List.of());
        var effect3 = new MobEffectInstance(MobEffects.POISON,400,20);
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
