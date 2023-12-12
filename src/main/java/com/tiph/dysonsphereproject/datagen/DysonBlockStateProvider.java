package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.init.DysonBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DysonBlockStateProvider extends BlockStateProvider {

  public DysonBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, DysonSphereProject.MODID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {

    for (final DeferredBlock<Block> block: DysonBlocks.BASIC_BLOCKS.values()) {
      blockWithItem(block);
    }

    blockWithItem(DysonBlocks.SOLAR_GENERATOR);
  }

  private <T extends Block> void blockWithItem(DeferredBlock<T> block) {
    simpleBlockWithItem(block.get(), cubeAll(block.get()));
  }
}
