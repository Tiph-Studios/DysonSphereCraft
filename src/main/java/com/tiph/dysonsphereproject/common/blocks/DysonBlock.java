package com.tiph.dysonsphereproject.common.blocks;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.items.DysonItem;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public abstract class DysonBlock extends Block {

  public static final DeferredRegister.Blocks BLOCKS =
      DeferredRegister.createBlocks(DysonSphereProject.MODID);

  public static <T extends Block> DeferredBlock<T> registerBlock(
      final String name, Supplier<T> block) {
    final DeferredBlock<T> registeredBlock = BLOCKS.register(name, block);
    registerBlockItem(name, registeredBlock);
    return registeredBlock;
  }

  private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(
      final String name, final DeferredBlock<T> block) {
    return DysonItem.ITEMS.registerSimpleBlockItem(name, block);
  }
  public DysonBlock(final Properties p) {
    super(p);
  }

  public static void register(final IEventBus eventBus) {
    // todo this is braindead
    SolarGeneratorBlock.init();
    BLOCKS.register(eventBus);
  }
}
