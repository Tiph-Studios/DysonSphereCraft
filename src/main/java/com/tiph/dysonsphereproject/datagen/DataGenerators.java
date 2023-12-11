package com.tiph.dysonsphereproject.datagen;

import com.tiph.dysonsphereproject.DysonSphereProject;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DysonSphereProject.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

  @SubscribeEvent
  public static void gatherData(final GatherDataEvent event) {
    final DataGenerator generator = event.getGenerator();
    final PackOutput packOutput = generator.getPackOutput();
    final ExistingFileHelper fileHelper = event.getExistingFileHelper();
    final CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    generator.addProvider(
        event.includeServer(), new DysonRecipeProvider(packOutput, lookupProvider));

    generator.addProvider(event.includeServer(), DysonLootTableProvider.create(packOutput));

    generator.addProvider(
        event.includeClient(), new DysonBlockStateProvider(packOutput, fileHelper));
    generator.addProvider(
        event.includeClient(), new DysonItemModelProvider(packOutput, fileHelper));
    generator.addProvider(
        event.includeClient(), new DysonBlockModelProvider(packOutput, fileHelper));

    final DysonBlockTagGenerator blockTagGenerator =
        generator.addProvider(
            event.includeServer(),
            new DysonBlockTagGenerator(packOutput, lookupProvider, fileHelper));

    generator.addProvider(
        event.includeServer(),
        new DysonItemTagGenerator(
            packOutput, lookupProvider, blockTagGenerator.contentsGetter(), fileHelper));
  }
}
