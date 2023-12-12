package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SolarGeneratorBlockEntity extends DysonBlockEntity implements MenuProvider {
  private final EnergyStorage energyStorage = new EnergyStorage(100_000, 20, 20, 50000);

  private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

  public SolarGeneratorBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.SOLAR_GENERATOR_ENTITY.get(), pos, state);
  }

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(
      @NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == Capabilities.ENERGY) {
      return lazyEnergyHandler.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void onLoad() {
    super.onLoad();
    lazyEnergyHandler = LazyOptional.of(() -> energyStorage);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    lazyEnergyHandler.invalidate();
  }

  @Override
  public Component getDisplayName() {
    return Component.translatable("block.dysonsphereproject.solar_generator");
  }

  @Nullable
  @Override
  public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
    return null;
  }

  @Override
  protected void saveAdditional(CompoundTag compoundTag) {
    compoundTag.putInt("energy", energyStorage.getEnergyStored());
    super.saveAdditional(compoundTag);
  }

  @Override
  public void load(CompoundTag compoundTag) {
    energyStorage.deserializeNBT(compoundTag.get("energy"));
    super.load(compoundTag);
  }

  public void tick(final Level level, final BlockPos pos, final BlockState blockState) {
    if (level.isDay()) {
      energyStorage.receiveEnergy(4, false);
      setChanged(level, pos, blockState);
    }
  }
}
