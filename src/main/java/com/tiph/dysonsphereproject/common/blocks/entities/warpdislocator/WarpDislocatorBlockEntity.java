package com.tiph.dysonsphereproject.common.blocks.entities.warpdislocator;

import com.tiph.dysonsphereproject.common.blocks.entities.DysonBlockEntity;
import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import com.tiph.dysonsphereproject.common.init.DysonItems;
import com.tiph.dysonsphereproject.common.items.BasicItems;
import com.tiph.dysonsphereproject.screen.WarpDislocatorMenu;
import com.tiph.dysonsphereproject.util.DysonEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WarpDislocatorBlockEntity extends DysonBlockEntity implements MenuProvider {

  private final DysonEnergyStorage energyStorage = new DysonEnergyStorage(100_000, 500, 0);
  private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
  private static final int FIRING_ENERGY_COST = 50_000;

  private final ItemStackHandler itemHandler = new WarpDislocatorItemStackHandler(1);
  private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
  private static final int INPUT_SLOT = 0;

  // Time in ticks it takes to fire an orbital collector
  private static final int DISLOCATION_TIME = 60;

  private int dislocationProgress = 0;

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(
      @NotNull Capability<T> cap, @Nullable Direction side) {

    if (side == Direction.UP) {
      return super.getCapability(cap, side);
    }

    if (cap == Capabilities.ENERGY) {
      return lazyEnergyHandler.cast();
    }

    if (cap == Capabilities.ITEM_HANDLER) {
      return lazyItemHandler.cast();
    }

    return super.getCapability(cap, side);
  }

  public WarpDislocatorBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.WARP_DISLOCATOR_ENTITY.get(), pos, state);
  }

  @Override
  public void onLoad() {
    super.onLoad();
    lazyEnergyHandler = LazyOptional.of(() -> energyStorage);
    lazyItemHandler = LazyOptional.of(() -> itemHandler);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    lazyEnergyHandler.invalidate();
    lazyItemHandler.invalidate();
  }

  @Override
  protected void saveAdditional(CompoundTag compoundTag) {
    compoundTag.putInt("energy", energyStorage.getEnergyStored());
    compoundTag.put("inventory", itemHandler.serializeNBT());
    compoundTag.putInt("dislocationProgress", dislocationProgress);
    super.saveAdditional(compoundTag);
  }

  @Override
  public void load(CompoundTag compoundTag) {
    energyStorage.deserializeNBT(compoundTag.get("energy"));
    itemHandler.deserializeNBT(compoundTag.getCompound("inventory"));
    dislocationProgress = compoundTag.getInt("dislocationProgress");
    super.load(compoundTag);
  }

  public void tick(final Level level, final BlockPos pos, final BlockState blockState) {

    if (!hasOrbitalCollector() || !hasRequiredEnergy()) {
      dislocationProgress = 0;
      return;
    }

    if (dislocationProgress >= DISLOCATION_TIME) {
      fireCollector(level);
      setChanged(level, pos, blockState);
      dislocationProgress = 0;
    } else {

      if (dislocationProgress == 0) {
        // Start animation/sound
      }

      dislocationProgress++;
      // todo - not sure how animations and sounds work
      //  but maybe we need to continue running them here
    }
  }

  private boolean hasOrbitalCollector() {
    return itemHandler.getStackInSlot(INPUT_SLOT).getItem()
        == DysonItems.getBasicItem(BasicItems.ORBITAL_COLLECTOR).get();
  }

  private boolean hasRequiredEnergy() {
    return energyStorage.getEnergyStored() >= FIRING_ENERGY_COST;
  }

  private void fireCollector(final Level level) {
    // todo investigate level.isClientSide. pretty sure we just ignore client stuff here
    if (level.isClientSide) {
      return;
    }

    //    if (level.)

    // Register orbital collector in the world somehow
    // Or maybe in the future this is by player or by team or something
    // todo get/save data to world

    // Remove the orbital collector
    itemHandler.extractItem(INPUT_SLOT, 1, false);
  }

  @Override
  public @NotNull Component getDisplayName() {
    return Component.translatable("block.dysonsphereproject.warp_dislocator");
  }

  @Nullable
  @Override
  public AbstractContainerMenu createMenu(
      int i, @NotNull Inventory inventory, @NotNull Player player) {
    return new WarpDislocatorMenu(
        i,
        inventory,
        this,
        new ContainerData() {
          @Override
          public int get(int i) {
            return i;
          }

          @Override
          public void set(int p_39285_, int p_39286_) {}

          @Override
          public int getCount() {
            return 1;
          }
        });
  }
}
