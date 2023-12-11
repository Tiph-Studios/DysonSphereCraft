package com.tiph.dysonsphereproject.util;

import com.tiph.dysonsphereproject.DysonSphereProject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DysonTags {

  private DysonTags() {
    throw new UnsupportedOperationException("Do not instantiate tag utility class");
  }

  public static class Blocks {

    private Blocks() {
      throw new UnsupportedOperationException("Do not instantiate block utility class");
    }

    // Example tag key to use to check block types in code
    public static final TagKey<Block> SOLAR_GENERATORS = tag("solar_generators");

    private static TagKey<Block> tag(final String name) {
      return BlockTags.create(new ResourceLocation(DysonSphereProject.MODID, name));
    }
  }

  public static class Items {

    private Items() {
      throw new UnsupportedOperationException("Do not instantiate item utility class");
    }

    private static TagKey<Item> tag(final String name) {
      return ItemTags.create(new ResourceLocation(DysonSphereProject.MODID, name));
    }
  }
}
