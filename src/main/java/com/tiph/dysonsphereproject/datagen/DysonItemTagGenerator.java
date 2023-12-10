package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DysonItemTagGenerator extends ItemTagsProvider {

  public DysonItemTagGenerator(
      PackOutput packOutput,
      CompletableFuture<HolderLookup.Provider> provider,
      CompletableFuture<TagLookup<Block>> blockTagLookup,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(packOutput, provider, blockTagLookup, DysonSphereProject.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {

  }
}
