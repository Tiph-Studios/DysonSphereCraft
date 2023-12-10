package com.tiph.dysonsphereproject.util;

import com.tiph.dysonsphereproject.DysonSphereProject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DysonTags {
    public static class Blocks {
        public static final TagKey<Block> SOLAR_GENERATORS = tag("solar_generators");

        private static TagKey<Block> tag(final String name) {
            return BlockTags.create(new ResourceLocation(DysonSphereProject.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(final String name) {
            return ItemTags.create(new ResourceLocation(DysonSphereProject.MODID, name));
        }
    }
}
