package com.tiph.dysonsphereproject.common.init;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.api.IResource;
import com.tiph.dysonsphereproject.common.blocks.BasicBlocks;
import com.tiph.dysonsphereproject.common.blocks.GroundStationBlock;
import com.tiph.dysonsphereproject.common.blocks.SolarGeneratorBlock;
import com.tiph.dysonsphereproject.common.blocks.WarpDislocatorBlock;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DysonBlocks {
  public static final DeferredRegister.Blocks BLOCKS =
      DeferredRegister.createBlocks(DysonSphereProject.MODID);
  private static final Map<IResource, DeferredBlock<Block>> BASIC_BLOCKS = new LinkedHashMap<>();
  ///////////////////
  // Special Blocks
  ///////////////////
  public static final DeferredBlock<SolarGeneratorBlock> SOLAR_GENERATOR =
      registerBlockAndItem(
          SolarGeneratorBlock.getRegistrySuffix(),
          () ->
              new SolarGeneratorBlock(
                  BlockBehaviour.Properties.of().destroyTime(SolarGeneratorBlock.getDestroyTime()),
                  4));
  public static final DeferredBlock<WarpDislocatorBlock> WARP_DISLOCATOR =
      registerBlockAndItem(
          WarpDislocatorBlock.getRegistrySuffix(),
          () ->
              new WarpDislocatorBlock(
                  BlockBehaviour.Properties.of()
                      .destroyTime(WarpDislocatorBlock.getDestroyTime())));
  public static final DeferredBlock<GroundStationBlock> GROUND_STATION =
      registerBlockAndItem(
          GroundStationBlock.getRegistrySuffix(),
          () ->
              new GroundStationBlock(
                  BlockBehaviour.Properties.of().destroyTime(GroundStationBlock.getDestroyTime())));

  ///////////////////
  // Basic Blocks
  ///////////////////
  static {
    for (BasicBlocks block : BasicBlocks.values()) {
      BASIC_BLOCKS.put(block, registerBasicBlock(block));
    }
  }

  private DysonBlocks() {}

  ///////////////////
  // Util methods
  ///////////////////

  private static DeferredBlock<Block> registerBasicBlock(BasicBlocks block) {
    return registerBlockAndItem(
        block.getRegistrySuffix(),
        () -> new Block(BlockBehaviour.Properties.of().destroyTime(block.getDestroyTime())));
  }

  private static <T extends Block> DeferredBlock<T> registerBlockAndItem(
      final String name, Supplier<T> block) {
    final DeferredBlock<T> registeredBlock = BLOCKS.register(name, block);
    registerBlockItem(name, registeredBlock);
    return registeredBlock;
  }

  private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(
      final String name, final DeferredBlock<T> block) {
    return DysonItems.ITEMS.registerSimpleBlockItem(name, block);
  }

  public static void register(final IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }

  public static Collection<DeferredBlock<Block>> getBasicBlocks() {
    return BASIC_BLOCKS.values();
  }

  public static DeferredBlock<Block> getBasicBlock(BasicBlocks block) {
    return BASIC_BLOCKS.get(block);
  }
}
