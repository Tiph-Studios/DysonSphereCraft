package com.tiph.dysonsphereproject;

import com.mojang.logging.LogUtils;
import com.tiph.dysonsphereproject.common.blocks.DysonBlock;
import com.tiph.dysonsphereproject.common.blocks.SolarGeneratorBlock;
import com.tiph.dysonsphereproject.common.items.DysonItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DysonSphereProject.MODID)
public class DysonSphereProject {
  // Define mod id in a common place for everything to reference
  public static final String MODID = "dysonsphereproject";

  // Directly reference a slf4j logger
  private static final Logger LOGGER = LogUtils.getLogger();

  // The constructor for the mod class is the first code that is run when your mod is loaded.
  // FML will recognize some parameter types like IEventBus or ModContainer and pass them in
  // automatically.
  public DysonSphereProject(IEventBus modEventBus) {
    // Register the commonSetup method for modloading
    modEventBus.addListener(this::commonSetup);

    // Register the Deferred Register to the mod event bus so blocks get registered
    DysonBlock.register(modEventBus);
    // Register the Deferred Register to the mod event bus so items get registered
    DysonItem.register(modEventBus);

    // Register ourselves for server and other game events we are interested in
    NeoForge.EVENT_BUS.register(this);

    // Register the item to a creative tab
    modEventBus.addListener(this::addCreative);

    // Register our mod's ModConfigSpec so that FML can create and load the config file for us
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    // Some common setup code
    LOGGER.info("HELLO FROM COMMON SETUP");

    if (Config.logDirtBlock)
      LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

    LOGGER.info("{}{}", Config.magicNumberIntroduction, Config.magicNumber);

    Config.items.forEach(item -> LOGGER.info("ITEM >> {}", item));
  }

  // Add the example block item to the building blocks tab
  private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
      event.accept(SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK);
      event.accept(DysonItem.MIRROR_ITEM);
    }
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    // Do something when the server starts
    LOGGER.info("HELLO from server starting");
  }

  // You can use EventBusSubscriber to automatically register all static methods in the class
  // annotated with @SubscribeEvent
  @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {

    private ClientModEvents() {
      // Do not instantiate
      throw new UnsupportedOperationException("Utility class");
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
      // Some client setup code
      LOGGER.info("HELLO FROM CLIENT SETUP");
      LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
  }
}
