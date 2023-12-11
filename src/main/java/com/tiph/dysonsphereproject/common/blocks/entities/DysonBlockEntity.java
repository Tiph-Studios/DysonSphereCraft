package com.tiph.dysonsphereproject.common.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class DysonBlockEntity extends BlockEntity {
  protected DysonBlockEntity(BlockEntityType<?> entityType, BlockPos pos, BlockState state) {
    super(entityType, pos, state);
  }
}
