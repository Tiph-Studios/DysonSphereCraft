package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.items.DysonItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class DysonItemModelProvider extends ItemModelProvider {

  public DysonItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, DysonSphereProject.MODID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    this.basicItem(DysonItem.MIRROR_ITEM.get());
  }

  private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
    return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
        .texture(
            "layer0",
            new ResourceLocation(DysonSphereProject.MODID, "item/" + item.getId().getPath()));
  }
}
