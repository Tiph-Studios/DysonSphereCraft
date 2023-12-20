package com.tiph.dysonsphereproject.common.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DysonEnergyBlockEntity extends DysonBlockEntity implements IEnergyStorage {
  
  protected int energy;
  private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

  protected DysonEnergyBlockEntity(BlockEntityType<?> entityType, BlockPos pos, BlockState state) {
    super(entityType, pos, state);
    energy = 0;
  }

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(
      @NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == Capabilities.ENERGY && side != Direction.UP) {
      return lazyEnergyHandler.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void onLoad() {
    super.onLoad();
    lazyEnergyHandler = LazyOptional.of(() -> this);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    lazyEnergyHandler.invalidate();
  }

  @Override
  public int receiveEnergy(int receiveAmount, boolean simulate) {
    if (!this.canReceive()) {
      return 0;
    } else {
      int energyReceived =
          Math.min(
              this.getMaxEnergyStored() - this.energy,
              Math.min(this.getMaxReceive(), receiveAmount));
      if (!simulate) {
        this.energy += energyReceived;
      }

      return energyReceived;
    }
  }

  @Override
  public int extractEnergy(int extractAmount, boolean simulate) {
    if (!this.canExtract()) {
      return 0;
    } else {
      int energyExtracted = Math.min(this.energy, Math.min(this.getMaxExtract(), extractAmount));
      if (!simulate) {
        this.energy -= energyExtracted;
      }

      return energyExtracted;
    }
  }

  @Override
  public int getEnergyStored() {
    return energy;
  }

  @Override
  protected void saveAdditional(CompoundTag tag) {
    tag.putInt("energy", energy);
    super.saveAdditional(tag);
  }

  @Override
  public void load(CompoundTag tag) {
    this.energy = tag.getInt("energy");
    super.load(tag);
  }

  protected void distributeEnergy(final Level level) {
    // Check all sides of the block and send energy if that block supports the energy capability
    for (Direction direction : Direction.values()) {
      if (this.energy <= 0) {
        return;
      }
      BlockEntity be = level.getBlockEntity(getBlockPos().relative(direction));
      if (be != null) {
        be.getCapability(Capabilities.ENERGY).map(e -> {
          if (e.canReceive()) {
            int received = e.receiveEnergy(Math.min(this.energy, this.getMaxExtract()), false);
            this.extractEnergy(received, false);
            setChanged();
            return received;
          }
          return 0;
        });
      }
    }
  }

  abstract int getMaxExtract();

  abstract int getMaxReceive();
}
