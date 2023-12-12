package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.init.DysonBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DysonBlockModelProvider extends BlockModelProvider {

  public DysonBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, DysonSphereProject.MODID, existingFileHelper);
  }

  @Override
  protected void registerModels() {



    // Solar generator
    this.cubeAll("solar_generator", new ResourceLocation(
                    DysonSphereProject.MODID, "block/" + DysonBlocks.SOLAR_GENERATOR.getId().getPath()))
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

  private void simpleBlockItem(final DeferredBlock<Block> block) {
//    this.withExistingParent(DysonSphereProject.MODID + ":" + Registries.BLOCK.registry().getKey(block.get()).getPath(),
//            modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
  }

}
