package com.tiph.dysonsphereproject.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

public class SolarGeneratorBlock extends DysonBlock {

  private static final float DESTROY_TIME = 2.0f;
  private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

  public static final DeferredBlock<SolarGeneratorBlock> SOLAR_GENERATOR_BLOCK =
      DysonBlock.registerBlock(
          "solar_generator",
          () ->
              new SolarGeneratorBlock(
                  BlockBehaviour.Properties.of()
                      .destroyTime(DESTROY_TIME)
                      .sound(SoundType.METAL)
                      .dynamicShape()));

  @Override
  public VoxelShape getShape(
      @NotNull BlockState state,
      @NotNull BlockGetter getter,
      @NotNull BlockPos pos,
      @NotNull CollisionContext context) {
    return SHAPE;
  }

  public static void init() {
    // Instantiate blocks
  }

  public SolarGeneratorBlock(Properties p) {
    super(p);
  }
}
