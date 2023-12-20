package com.tiph.dysonsphereproject.common.blocks;

import com.tiph.dysonsphereproject.common.blocks.entities.GroundStationBlockEntity;
import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class GroundStationBlock extends DysonEntityBlock {
  private static final String REGISTRY_SUFFIX = "ground_station";
  private static final float DESTROY_TIME = 2.0f;

  public GroundStationBlock(Properties p) {
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
  public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
    return new GroundStationBlockEntity(pos, state);
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
        DysonBlockEntities.GROUND_STATION_ENTITY.get(),
        (level1, pos, blockState1, blockEntity) -> blockEntity.tick(level1));
  }
}
