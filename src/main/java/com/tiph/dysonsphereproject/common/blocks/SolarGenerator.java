package com.tiph.dysonsphereproject.common.blocks;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SolarGenerator extends Block {
  private static final String REGISTRY_SUFFIX = "solar_generator";
  private static final float DESTROY_TIME = 2.0f;
  private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16.0, 8.0, 16.0);

  private final int powerGen;

  @Override
  public void appendHoverText(
      @NotNull ItemStack itemStack,
      @Nullable BlockGetter blockGetter,
      List<Component> components,
      @NotNull TooltipFlag tooltipFlag) {
    components.add(
        Component.translatable("tooltip.dysonspherecraft.solar_generator.tooltip", this.powerGen));
    super.appendHoverText(itemStack, blockGetter, components, tooltipFlag);
  }

  @Override
  public @NotNull VoxelShape getShape(
      @NotNull BlockState blockState,
      @NotNull BlockGetter blockGetter,
      @NotNull BlockPos blockPos,
      @NotNull CollisionContext collisionContext) {
    return SHAPE;
  }

  public SolarGenerator(Properties p, final int powerGen) {
    super(p);
    this.powerGen = powerGen;
  }

  public static String getRegistrySuffix() {
    return REGISTRY_SUFFIX;
  }

  public static float getDestroyTime() {
    return DESTROY_TIME;
  }
}
