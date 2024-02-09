package net.swimmingtuna.lotm.item;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swimmingtuna.lotm.LOTM;
import net.swimmingtuna.lotm.item.custom.BeyonderAbilities.MindReading;
import net.swimmingtuna.lotm.item.custom.BeyonderPotions.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LOTM.MOD_ID);

    public static final RegistryObject<Item> MindReading = ITEMS.register("mindreading",
            ()-> new MindReading(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Awe = ITEMS.register("awe",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Frenzy = ITEMS.register("frenzy",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Placate = ITEMS.register("placate",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BattleHypnotism = ITEMS.register("battlehypnotism",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PsychologicalInvisibility = ITEMS.register("psychologicalinvisibility",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Guidance = ITEMS.register("guidance",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Manipulation = ITEMS.register("manipulation",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MentalPlague = ITEMS.register("mentalplague",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MindStorm = ITEMS.register("mindstorm",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ConsciousnessStroll = ITEMS.register("consciousnessstroll",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DragonBreath = ITEMS.register("dragonbreath",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PlagueStorm = ITEMS.register("plaguestorm",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DreamWeaving = ITEMS.register("dreamweaving",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Discern = ITEMS.register("discern",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DreamIntoReality = ITEMS.register("dreamintoreality",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Prophesize = ITEMS.register("prophesize",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionLife = ITEMS.register("envisionlife",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionNature = ITEMS.register("envisionnature",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionWeather = ITEMS.register("envisionweather",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionBarrier = ITEMS.register("envisionbarrier",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionDeath = ITEMS.register("envisiondeath",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionKingdom = ITEMS.register("envisionkingdom",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionLocation = ITEMS.register("envisionlocation",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EnvisionHealth = ITEMS.register("envisionhealth",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Spectator9Potion = ITEMS.register("spectator9potion",
            ()-> new Spectator9Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 25, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator8Potion = ITEMS.register("spectator8potion",
            ()-> new Spectator8Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 50, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator7Potion = ITEMS.register("spectator7potion",
            ()-> new Spectator7Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 125, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator6Potion = ITEMS.register("spectator6potion",
            ()-> new Spectator6Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 160, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator5Potion = ITEMS.register("spectator5potion",
            ()-> new Spectator5Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 240, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator4Potion = ITEMS.register("spectator4potion",
            ()-> new Spectator4Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 500, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator3Potion = ITEMS.register("spectator3potion",
            ()-> new Spectator3Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 1000, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator2Potion = ITEMS.register("spectator2potion",
            ()-> new Spectator2Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 1750, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator1Potion = ITEMS.register("spectator1potion",
            ()-> new Spectator1Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 3000, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> Spectator0Potion = ITEMS.register("spectator0potion",
            ()-> new Spectator0Potion(new Item.Properties().stacksTo(1), new AttributeModifier("spirituality", 5000, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<Item> BeyonderResetPotion = ITEMS.register("beyonderresetpotion",
            ()-> new BeyonderResetPotion(new Item.Properties().stacksTo(1)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
