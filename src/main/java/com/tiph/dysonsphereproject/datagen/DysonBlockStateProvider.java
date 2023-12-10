package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.blocks.DysonBlock;
import com.tiph.dysonsphereproject.common.blocks.SolarGeneratorBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DysonBlockStateProvider extends BlockStateProvider {

    public DysonBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DysonSphereProject.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK);
    }

    private <T extends DysonBlock> void blockWithItem(DeferredBlock<T> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
