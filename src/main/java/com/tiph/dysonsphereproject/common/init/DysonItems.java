package com.tiph.dysonsphereproject.common.init;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.api.IResource;
import com.tiph.dysonsphereproject.common.items.BasicItems;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DysonItems {
  public static final DeferredRegister.Items ITEMS =
      DeferredRegister.createItems(DysonSphereProject.MODID);
  private static final Map<IResource, DeferredItem<Item>> BASIC_ITEMS = new LinkedHashMap<>();

  // Basic Items
  static {
    for (BasicItems item : BasicItems.values()) {
      BASIC_ITEMS.put(item, registerBasicItem(item));
    }
  }

  private DysonItems() {}

  private static DeferredItem<Item> registerBasicItem(BasicItems item) {
    return ITEMS.registerSimpleItem(item.getRegistrySuffix(), new Item.Properties());
  }

  public static void register(final IEventBus eventBus) {
    ITEMS.register(eventBus);
  }

  public static DeferredItem<Item> getBasicItem(BasicItems item) {
    return BASIC_ITEMS.get(item);
  }
}
