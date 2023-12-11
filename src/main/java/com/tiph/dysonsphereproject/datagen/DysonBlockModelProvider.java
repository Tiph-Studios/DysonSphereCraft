package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.blocks.SolarGeneratorBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DysonBlockModelProvider extends BlockModelProvider {

  public DysonBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, DysonSphereProject.MODID, existingFileHelper);
  }

  @Override
  protected void registerModels() {

    final ResourceLocation location =
        new ResourceLocation(
            DysonSphereProject.MODID,
            "block/" + SolarGeneratorBlock.SOLAR_GENERATOR_BLOCK.getId().getPath());

    this.cubeAll("solar_generator", location)
        .element()
        .from(0, 0, 0)
        .to(16, 8, 16)
        .face(Direction.DOWN)
        .uvs(0f, 9.6f, 16f, 16f)
        .texture("#all")
        .end()
        .face(Direction.UP)
        .uvs(0f, 0f, 16f, 6.4f)
        .texture("#all")
        .end()
        .face(Direction.NORTH)
        .uvs(0f, 6.4f, 16f, 9.6f)
        .texture("#all")
        .end()
        .face(Direction.SOUTH)
        .uvs(0f, 6.4f, 16f, 9.6f)
        .texture("#all")
        .end()
        .face(Direction.EAST)
        .uvs(0f, 6.4f, 16f, 9.6f)
        .texture("#all")
        .end()
        .face(Direction.WEST)
        .uvs(0f, 6.4f, 16f, 9.6f)
        .texture("#all")
        .end();
  }
}
