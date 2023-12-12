package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.common.init.DysonBlocks;
import com.tiph.dysonsphereproject.common.init.DysonItems;
import com.tiph.dysonsphereproject.common.items.BasicItems;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

public class DysonRecipeProvider extends RecipeProvider implements IConditionBuilder {

  public DysonRecipeProvider(
      PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(packOutput, lookupProvider);
  }

  @Override
  protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
    // Mirror
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DysonItems.getBasicItem(BasicItems.MIRROR))
        .pattern("GGG")
        .pattern("SIS")
        .define('G', Items.GLASS_PANE)
        .define('S', ItemTags.WOODEN_SLABS)
        .define('I', Items.IRON_INGOT)
        .unlockedBy(getHasName(Items.GLASS_PANE), has(Items.GLASS_PANE))
        .save(recipeOutput);

    // Solar Generator
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DysonBlocks.SOLAR_GENERATOR)
        .pattern("MMM")
        .pattern("RRR")
        .pattern("PPP")
        .define('M', DysonItems.getBasicItem(BasicItems.MIRROR))
        .define('R', Items.REDSTONE)
        .define('P', ItemTags.PLANKS)
        .unlockedBy(
            getHasName(DysonItems.getBasicItem(BasicItems.MIRROR).get()),
            has(DysonItems.getBasicItem(BasicItems.MIRROR).get()))
        .save(recipeOutput);

    // Ground Station
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DysonBlocks.GROUND_STATION)
        .pattern("MIM")
        .pattern("MRM")
        .pattern("BDB")
        .define('M', DysonItems.getBasicItem(BasicItems.MIRROR))
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .define('B', Items.IRON_BLOCK)
        .define('D', Items.DIAMOND_BLOCK)
        .unlockedBy(
            getHasName(DysonItems.getBasicItem(BasicItems.MIRROR).get()),
            has(DysonItems.getBasicItem(BasicItems.MIRROR).get()))
        .save(recipeOutput);

    // Warp Dislocator
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DysonBlocks.WARP_DISLOCATOR)
        .pattern("IXI")
        .pattern("BRB")
        .pattern("BPB")
        .define('I', Items.IRON_BARS)
        .define('R', Items.REDSTONE)
        .define('P', Items.PISTON)
        .define('B', Items.IRON_BLOCK)
        .save(recipeOutput);
  }
}
