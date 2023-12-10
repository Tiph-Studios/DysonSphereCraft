package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DysonBlockModelProvider extends BlockModelProvider {

    public DysonBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DysonSphereProject.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
