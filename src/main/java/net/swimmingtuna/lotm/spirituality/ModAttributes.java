package net.swimmingtuna.lotm.spirituality;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swimmingtuna.lotm.LOTM;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(ForgeRegistries.ATTRIBUTES, LOTM.MOD_ID);

    public static final RegistryObject<Attribute> MAX_SPIRITUALITY = ATTRIBUTES.register("max_spirituality",
            ()-> new RangedAttribute("attribute.lotm.spirituality",0.0D,0.0D,10000000).setSyncable(true));
    public static final RegistryObject<Attribute> SPIRITUALITY = ATTRIBUTES.register("spirituality",
            ()-> new RangedAttribute("attribute.lotm.spirituality",100.0D,0.0D,10000000).setSyncable(true));
    public static final RegistryObject<Attribute> SPIRITUALITY_REGEN = ATTRIBUTES.register("spirituality_regen",
            ()-> new RangedAttribute("attribute.lotm.spirituality",100.0D,0.0D,10000000).setSyncable(true));
    public static final RegistryObject<Attribute> INTELLIGENCE = ATTRIBUTES.register("intelligence",
            ()-> new RangedAttribute("attribute.lotm.spirituality",100.0D,0.0D,10000000).setSyncable(true));


    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }

}