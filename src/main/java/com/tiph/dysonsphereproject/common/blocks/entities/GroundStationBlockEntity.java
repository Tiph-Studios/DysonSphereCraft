package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import com.tiph.dysonsphereproject.util.OrbitalCollectorSavedData;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class GroundStationBlockEntity extends DysonEnergyBlockEntity {

  private static final int MAX_CAPACITY = 100_000;
  private static final int MAX_EXTRACT = Integer.MAX_VALUE;

  // Could have different kinds of orbital collectors with different power gen
  private static final int COLLECTOR_POWER_GEN = 100;

  public GroundStationBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.GROUND_STATION_ENTITY.get(), pos, state);
  }

  public void tick(final Level level) {
    generateEnergy(level);
    distributeEnergy(level);
  }

  private void generateEnergy(final Level level) {
    if (level.isClientSide) {
      return;
    }

    // Get number of orbital collectors in the dimension
    final int numCollectors = getCollectors(level);

    // Generate power based on # collectors
    generatePower(numCollectors);
  }

  private int getCollectors(final Level level) {
    if (level instanceof ServerLevel serverLevel) {
      final OrbitalCollectorSavedData data =
          OrbitalCollectorSavedData.getOrbitalCollectorData(serverLevel);
      return data.getNumCollectors();
    }

    return 0;
  }

  void generatePower(final int numCollectors) {
    final int powerGen = numCollectors * COLLECTOR_POWER_GEN;
    generateEnergy(powerGen);
  }

  @Override
  int getMaxExtract() {
    return MAX_EXTRACT;
  }

  @Override
  int getMaxReceive() {
    return 0;
  }

  @Override
  public boolean canExtract() {
    return true;
  }

  @Override
  public boolean canReceive() {
    return false;
  }

  @Override
  public int getMaxEnergyStored() {
    return MAX_CAPACITY;
  }
}
