package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.common.blocks.SolarGeneratorBlock;
import com.tiph.dysonsphereproject.common.items.DysonItem;
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

    public DysonRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        // Mirror
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DysonItem.MIRROR_ITEM)
                .pattern("GGG")
                .pattern("SIS")
                .define('G', Items.GLASS_PANE)
                .define('S', ItemTags.WOODEN_SLABS)
                .define('I', Items.IRON_INGOT)
//                .unlockedBy()
                .save(recipeOutput);

        // Solar Generator
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK)
                .pattern("MMM")
                .pattern("RRR")
                .pattern("PPP")
                .define('M', DysonItem.MIRROR_ITEM)
                .define('R', Items.REDSTONE)
                .define('P', ItemTags.PLANKS)
                .save(recipeOutput);



    }
}
