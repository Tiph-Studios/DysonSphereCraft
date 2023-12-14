package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class WarpDislocatorBlockEntity extends DysonBlockEntity {
  public WarpDislocatorBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.WARP_DISLOCATOR_ENTITY.get(), pos, state);
  }
}
