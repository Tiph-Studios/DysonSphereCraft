package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GroundStationBlockEntity extends DysonBlockEntity {
  public GroundStationBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.GROUND_STATION_ENTITY.get(), pos, state);
  }
}
