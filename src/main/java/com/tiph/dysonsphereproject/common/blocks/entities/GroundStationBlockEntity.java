package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import com.tiph.dysonsphereproject.util.OrbitalCollectorSavedData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GroundStationBlockEntity extends DysonEnergyBlockEntity {

  private static final int MAX_CAPACITY = 100_000;
  private static final int MAX_RECEIVE = Integer.MAX_VALUE;
  private static final int MAX_EXTRACT = Integer.MAX_VALUE;

  // Could have different kinds of orbital collectors with different power gen
  private static final int COLLECTOR_POWER_GEN = 100;

  private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

  public GroundStationBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.GROUND_STATION_ENTITY.get(), pos, state);
  }

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == Capabilities.ENERGY && side != Direction.UP) {
      return lazyEnergyHandler.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    lazyEnergyHandler.invalidate();
  }

  @Override
  public void onLoad() {
    super.onLoad();
    lazyEnergyHandler = LazyOptional.of(() -> this);
  }

  public void tick(final Level level, final BlockPos pos, final BlockState blockState) {

    if (level.isClientSide) {
      return;
    }

    // Get number of orbital collectors in the dimension
    final int numCollectors = getCollectors(level);

    // Generate power based on # collectors
    final boolean changed = generatePower(numCollectors);

    if (changed) {
      setChanged(level, pos, blockState);
    }
  }

  private int getCollectors(final Level level) {
    if (level instanceof ServerLevel serverLevel) {
      final OrbitalCollectorSavedData data =
          OrbitalCollectorSavedData.getOrbitalCollectorData(serverLevel);
      return data.getNumCollectors();
    }

    return 0;
  }

  boolean generatePower(final int numCollectors) {
    final int powerGen = numCollectors * COLLECTOR_POWER_GEN;
    receiveEnergy(powerGen, false);
    return powerGen != 0;
  }

  @Override
  int getMaxExtract() {
    return MAX_EXTRACT;
  }

  @Override
  int getMaxReceive() {
    return MAX_RECEIVE;
  }

  @Override
  public int getMaxEnergyStored() {
    return MAX_CAPACITY;
  }

  @Override
  public boolean canExtract() {
    return true;
  }

  @Override
  public boolean canReceive() {
    return true;
  }
}
