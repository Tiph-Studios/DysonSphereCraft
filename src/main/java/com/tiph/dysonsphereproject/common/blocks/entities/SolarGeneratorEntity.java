package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SolarGeneratorEntity extends DysonBlockEntity {

  public SolarGeneratorEntity(BlockPos pos, BlockState state) {
    super(DysonBlocks.SOLAR_GENERATOR_ENTITY.get(), pos, state);
  }
}
