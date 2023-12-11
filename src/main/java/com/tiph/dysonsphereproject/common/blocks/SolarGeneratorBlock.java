package com.tiph.dysonsphereproject.common.blocks;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SolarGeneratorBlock extends DysonBlock {

  private static final float DESTROY_TIME = 2.0f;
  private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

  private final int powerGen;

  public static final DeferredBlock<SolarGeneratorBlock> SOLAR_GENERATOR_BLOCK =
      DysonBlock.registerBlock(
          "solar_generator",
          () ->
              new SolarGeneratorBlock(
                  BlockBehaviour.Properties.of()
                      .destroyTime(DESTROY_TIME)
                      .requiresCorrectToolForDrops()
                      .sound(SoundType.METAL)
                      .dynamicShape(),
                  4));

  @Override
  public VoxelShape getShape(
      @NotNull BlockState state,
      @NotNull BlockGetter getter,
      @NotNull BlockPos pos,
      @NotNull CollisionContext context) {
    return SHAPE;
  }

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

  public static void init() {
    // Instantiate blocks
  }

  public SolarGeneratorBlock(Properties p, final int powerGen) {
    super(p);
    this.powerGen = powerGen;
  }
}
