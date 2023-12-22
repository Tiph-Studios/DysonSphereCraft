package com.tiph.dysonsphereproject.common.blocks;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract class DysonEntityBlock extends BaseEntityBlock {

  public DysonEntityBlock(Properties p) {
    super(p);
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState()
        .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite())
        .setValue(BlockStateProperties.POWERED, false);
  }

  @Override
  protected void createBlockStateDefinition(
      StateDefinition.@NotNull Builder<Block, BlockState> builder) {
    super.createBlockStateDefinition(builder);
    builder.add(BlockStateProperties.POWERED, BlockStateProperties.FACING);
  }

  @Override
  @NotNull
  public RenderShape getRenderShape(@NotNull BlockState blockState) {
    return RenderShape.MODEL;
  }
}
