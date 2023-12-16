package com.tiph.dysonsphereproject.common.blocks.entities;

import com.tiph.dysonsphereproject.common.init.DysonBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WarpDislocatorBlockEntity extends DysonBlockEntity implements MenuProvider {
  public WarpDislocatorBlockEntity(BlockPos pos, BlockState state) {
    super(DysonBlockEntities.WARP_DISLOCATOR_ENTITY.get(), pos, state);
  }

  @Override
  public Component getDisplayName() {
    return null;
  }

  @Nullable
  @Override
  public AbstractContainerMenu createMenu(int p_39954_, Inventory p_39955_, Player p_39956_) {
    return null;
  }

  @Override
  public void deserializeNBT(CompoundTag nbt) {
    super.deserializeNBT(nbt);
  }

  @Override
  public CompoundTag serializeNBT() {
    return super.serializeNBT();
  }

  @Override
  public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
    super.onDataPacket(net, pkt);
  }

  @Override
  public void handleUpdateTag(CompoundTag tag) {
    super.handleUpdateTag(tag);
  }

  @Override
  public void onLoad() {
    super.onLoad();
  }

  @Override
  public void requestModelDataUpdate() {
    super.requestModelDataUpdate();
  }

  @Override
  public @NotNull ModelData getModelData() {
    return super.getModelData();
  }

  @Override
  public boolean hasCustomOutlineRendering(Player player) {
    return super.hasCustomOutlineRendering(player);
  }

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
    return super.getCapability(cap);
  }
}
