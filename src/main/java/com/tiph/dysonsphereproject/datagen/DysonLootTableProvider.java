package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.datagen.loot.DysonBlockLootTables;
import java.util.List;
import java.util.Set;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class DysonLootTableProvider {

  private DysonLootTableProvider() {
    throw new UnsupportedOperationException("Do not instantiate directly");
  }

  public static LootTableProvider create(final PackOutput output) {
    return new LootTableProvider(
        output,
        Set.of(),
        List.of(
            new LootTableProvider.SubProviderEntry(
                DysonBlockLootTables::new, LootContextParamSets.BLOCK)));
  }
}
