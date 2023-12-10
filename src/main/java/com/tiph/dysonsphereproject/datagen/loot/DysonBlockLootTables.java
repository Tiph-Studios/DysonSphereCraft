package com.tiph.dysonsphereproject.datagen.loot;

import com.tiph.dysonsphereproject.common.blocks.DysonBlock;
import com.tiph.dysonsphereproject.common.blocks.SolarGeneratorBlock;
import java.util.Collections;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

public class DysonBlockLootTables extends BlockLootSubProvider {

  public DysonBlockLootTables() {
    super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
  }

  @Override
  protected void generate() {
    this.dropSelf(SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK.get());
  }

  @Override
  protected @NotNull Iterable<Block> getKnownBlocks() {
    return DysonBlock.BLOCKS.getEntries().stream().map(DeferredHolder::get).map(Block.class::cast)
        ::iterator;
  }
}
