package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SolarGeneratorBlockEntity extends DysonEnergyBlockEntity implements MenuProvider {

  private static final int MAX_CAPACITY = 100_000;
  private static final int GENERATION_AMOUNT = 4;
  private static final int MAX_EXTRACT = 20;

  private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

  public SolarGeneratorBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.SOLAR_GENERATOR_ENTITY.get(), pos, state);
  }

  @Override
  public @NotNull Component getDisplayName() {
    return Component.translatable("block.dysonsphereproject.solar_generator");
  }

  @Nullable
  @Override
  public AbstractContainerMenu createMenu(
      int i, @NotNull Inventory inventory, @NotNull Player player) {
    return null;
  }

  public void tick(final Level level) {
    generateEnergy(level);
    distributeEnergy(level);
  }

  private void generateEnergy(final Level level) {
    if (level.isDay() && level.canSeeSky(getBlockPos())) {
      generateEnergy(GENERATION_AMOUNT);
    }
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
