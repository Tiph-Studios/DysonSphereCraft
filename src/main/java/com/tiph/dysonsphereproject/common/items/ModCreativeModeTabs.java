package com.tiph.dysonsphereproject.common.items;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.blocks.BasicBlocks;
import com.tiph.dysonsphereproject.common.init.DysonBlocks;
import com.tiph.dysonsphereproject.common.init.DysonItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

  private ModCreativeModeTabs() {
    throw new ClassCastException("Do not instansiate");
  }

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DysonSphereProject.MODID);

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
    CREATIVE_MODE_TABS.register(
        "dsp_tab",
        () ->
            CreativeModeTab.builder()
                .icon(() -> new ItemStack(DysonBlocks.SOLAR_GENERATOR))
                .title(Component.translatable("creativetab.dsp_tab"))
                .displayItems(
                    (param, output) -> {
                      // BLOCKS
                      output.accept(DysonBlocks.getBasicBlock(BasicBlocks.EXAMPLE_BASIC_BLOCK));
                      output.accept(DysonBlocks.SOLAR_GENERATOR);
                      output.accept(DysonBlocks.WARP_DISLOCATOR);
                      output.accept(DysonBlocks.GROUND_STATION);

                      // ITEMS
                      output.accept(DysonItems.getBasicItem(BasicItems.MIRROR));
                      output.accept(DysonItems.getBasicItem(BasicItems.ORBITAL_COLLECTOR));
                    })
                .build());
  }
}
