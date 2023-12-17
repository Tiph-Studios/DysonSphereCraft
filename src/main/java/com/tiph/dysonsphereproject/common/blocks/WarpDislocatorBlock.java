package com.tiph.dysonsphereproject.common.blocks;

import com.tiph.dysonsphereproject.common.blocks.entities.warpdislocator.WarpDislocatorBlockEntity;
import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class WarpDislocatorBlock extends BaseEntityBlock {
  private static final String REGISTRY_SUFFIX = "warp_dislocator";
  private static final float DESTROY_TIME = 2.0f;

  public WarpDislocatorBlock(Properties p) {
    super(p);
  }

  public static String getRegistrySuffix() {
    return REGISTRY_SUFFIX;
  }

  public static float getDestroyTime() {
    return DESTROY_TIME;
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new WarpDislocatorBlockEntity(pos, state);
  }

  @Override
  public RenderShape getRenderShape(BlockState blockState) {
    return RenderShape.MODEL;
  }

  @Nullable
  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      @NotNull Level level,
      @NotNull BlockState blockState,
      @NotNull BlockEntityType<T> blockEntityType) {

    if (level.isClientSide) {
      return null;
    }

    return createTickerHelper(
        blockEntityType,
        DysonBlockEntities.WARP_DISLOCATOR_ENTITY.get(),
        (level1, pos, blockState1, blockEntity) -> blockEntity.tick(level1, pos, blockState1));
  }
}
