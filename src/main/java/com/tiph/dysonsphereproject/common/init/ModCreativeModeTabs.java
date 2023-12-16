package com.tiph.dysonsphereproject.common.init;

import com.tiph.dysonsphereproject.DysonSphereProject;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

  private ModCreativeModeTabs() {
    throw new ClassCastException("Do not instantiate");
  }

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DysonSphereProject.MODID);

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
    CREATIVE_MODE_TABS.register(
        "dysonsphereproject.tab",
        () ->
            CreativeModeTab.builder()
                .icon(() -> new ItemStack(DysonBlocks.SOLAR_GENERATOR))
                .title(Component.translatable("creativetab.dysonsphereproject.tab"))
                .displayItems(
                    (param, output) -> {
                      // BLOCKS
                      DysonBlocks.getBasicBlocks().forEach(output::accept);
                      output.accept(DysonBlocks.SOLAR_GENERATOR);
                      output.accept(DysonBlocks.WARP_DISLOCATOR);
                      output.accept(DysonBlocks.GROUND_STATION);

                      // ITEMS
                      DysonItems.getBasicItems().forEach(output::accept);
                    })
                .build());
  }
}
