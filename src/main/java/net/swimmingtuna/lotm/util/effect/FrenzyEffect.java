package net.swimmingtuna.lotm.util.effect;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class FrenzyEffect extends MobEffect {
    public FrenzyEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory,color);
        }
        @Override
        public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
            if (!pLivingEntity.level().isClientSide()) {
                    //Ignore for now
                    Double x = pLivingEntity.getX() + Math.random() * 0.2 - 0.1;
                    Double y = pLivingEntity.getY();
                    Double z = pLivingEntity.getZ() + Math.random() * 0.2 - 0.1;
                    pLivingEntity.setDeltaMovement(pLivingEntity.getDeltaMovement().add(Math.random() * 0.25 + (Math.random() -1.072) * 0.25,0,Math.random() * 0.25 + (Math.random() -1.055) * 0.25));
                    pLivingEntity.setSprinting(true);
                    pLivingEntity.hurtMarked = true;
                if (pLivingEntity instanceof Player && pLivingEntity.getRandom().nextFloat() > 0.5f && pLivingEntity.onGround()) {
                    ((Player) pLivingEntity).jumpFromGround();
                }

            }
            super.applyEffectTick(pLivingEntity, pAmplifier);
        }

        @Override
        public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
            return true;
        }
    }

