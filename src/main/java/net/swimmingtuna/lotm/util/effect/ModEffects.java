package net.swimmingtuna.lotm.util.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swimmingtuna.lotm.LOTM;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LOTM.MOD_ID);

    public static final RegistryObject<MobEffect> ADVANCEMENT9 = MOB_EFFECTS.register("advancementeffect9",
            () -> new AdvancementEffect9(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT8 = MOB_EFFECTS.register("advancementeffect8",
            () -> new AdvancementEffect8(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT7 = MOB_EFFECTS.register("advancementeffect7",
            () -> new AdvancementEffect7(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT6 = MOB_EFFECTS.register("advancementeffect6",
            () -> new AdvancementEffect6(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT5 = MOB_EFFECTS.register("advancementeffect5",
            () -> new AdvancementEffect5(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT4 = MOB_EFFECTS.register("advancementeffect4",
            () -> new AdvancementEffect4(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT3 = MOB_EFFECTS.register("advancementeffect3",
            () -> new AdvancementEffect3(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT2 = MOB_EFFECTS.register("advancementeffect2",
            () -> new AdvancementEffect2(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT1 = MOB_EFFECTS.register("advancementeffect1",
            () -> new AdvancementEffect1(MobEffectCategory.HARMFUL,3124687));
    public static final RegistryObject<MobEffect> ADVANCEMENT0 = MOB_EFFECTS.register("advancementeffect",
            () -> new AdvancementEffect0(MobEffectCategory.HARMFUL,3124687));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
