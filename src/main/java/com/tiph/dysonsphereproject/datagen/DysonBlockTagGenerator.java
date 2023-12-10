package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.blocks.SolarGeneratorBlock;
import com.tiph.dysonsphereproject.util.DysonTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DysonBlockTagGenerator extends BlockTagsProvider {

  public DysonBlockTagGenerator(
      PackOutput output,
      CompletableFuture<HolderLookup.Provider> lookupProvider,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, DysonSphereProject.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(@NotNull HolderLookup.Provider provider) {
    this.tag(DysonTags.Blocks.SOLAR_GENERATORS)
            .add(SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK.get());

    this.tag(BlockTags.NEEDS_STONE_TOOL)
            .add(SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK.get());

    this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK.get());
  }
}
