package net.swimmingtuna.lotm;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.swimmingtuna.lotm.client.ClientConfigs;
import net.swimmingtuna.lotm.events.ClientEvents;
import net.swimmingtuna.lotm.item.ModItems;
import net.swimmingtuna.lotm.networking.ModMessages;
import net.swimmingtuna.lotm.spirituality.ModAttributes;
import net.swimmingtuna.lotm.util.effect.ModEffects;
import org.slf4j.Logger;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LOTM.MOD_ID)
public class LOTM {

    public static Supplier<Boolean> fadeOut;
    public static Supplier<Integer> fadeTicks;
    public static Supplier<Double> maxBrightness;
    public static Supplier<Double> fadeRate = () -> maxBrightness.get() / fadeTicks.get();

    public static ResourceLocation res(String name) {return new ResourceLocation(MOD_ID, name);}

    public static <T> DeferredRegister<T> makeRegistry(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, MOD_ID);
    }

    public static <T> DeferredRegister<T> makeRegistry(String location) {
        return DeferredRegister.create(res(location), MOD_ID);
    }

    public static <T> DeferredRegister<T> makeRegistry(ResourceKey<Registry<T>> key) {
        return DeferredRegister.create(key, MOD_ID);
    }

    public static <T> DeferredRegister<T> makeCustomRegistry(ResourceKey<Registry<T>> key, final Supplier<RegistryBuilder<T>> sup) {
        DeferredRegister<T> register = makeRegistry(key);
        register.makeRegistry(sup);
        return register;
    }
    public static final String MOD_ID = "lotm";

    private static final Logger LOGGER = LogUtils.getLogger();
    public LOTM()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);
        ModAttributes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ClientEvents::onRegisterOverlays);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, String.format("%s-client.toml", LOTM.MOD_ID));
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }



    private void commonSetup(final FMLCommonSetupEvent event) {
        ModMessages.register();
        event.enqueueWork(() -> {
    });}

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
                event.accept(ModItems.MindReading);
                event.accept(ModItems.Awe);
                event.accept(ModItems.Frenzy);
                event.accept(ModItems.Placate);
                event.accept(ModItems.BattleHypnotism);
                event.accept(ModItems.PsychologicalInvisibility);
                event.accept(ModItems.Guidance);
                event.accept(ModItems.Manipulation);
                event.accept(ModItems.MentalPlague);
                event.accept(ModItems.MindStorm);
                event.accept(ModItems.ConsciousnessStroll);
                event.accept(ModItems.DragonBreath);
                event.accept(ModItems.PlagueStorm);
                event.accept(ModItems.DreamWeaving);
                event.accept(ModItems.Discern);
                event.accept(ModItems.DreamIntoReality);
                event.accept(ModItems.Prophesize);
                event.accept(ModItems.EnvisionLife);
                event.accept(ModItems.EnvisionNature);
                event.accept(ModItems.EnvisionWeather);
                event.accept(ModItems.EnvisionBarrier);
                event.accept(ModItems.EnvisionDeath);
                event.accept(ModItems.EnvisionKingdom);
                event.accept(ModItems.EnvisionLocation);
                event.accept(ModItems.EnvisionHealth);
                event.accept(ModItems.Spectator9Potion);
                event.accept(ModItems.Spectator8Potion);
                event.accept(ModItems.Spectator7Potion);
                event.accept(ModItems.Spectator6Potion);
                event.accept(ModItems.Spectator5Potion);
                event.accept(ModItems.Spectator4Potion);
                event.accept(ModItems.Spectator3Potion);
                event.accept(ModItems.Spectator2Potion);
                event.accept(ModItems.Spectator1Potion);
                event.accept(ModItems.Spectator0Potion);
                event.accept(ModItems.BeyonderResetPotion);





        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
}
