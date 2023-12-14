package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.init.DysonItems;
import com.tiph.dysonsphereproject.common.items.BasicItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DysonItemModelProvider extends ItemModelProvider {

  public DysonItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, DysonSphereProject.MODID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    this.basicItem(DysonItems.getBasicItem(BasicItems.MIRROR).get());
    this.basicItem(DysonItems.getBasicItem(BasicItems.ORBITAL_COLLECTOR).get());
  }

  //  private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
  //    return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
  //        .texture(
  //            "layer0",
  //            new ResourceLocation(DysonSphereProject.MODID, "item/" + item.getId().getPath()));
  //  }
}
