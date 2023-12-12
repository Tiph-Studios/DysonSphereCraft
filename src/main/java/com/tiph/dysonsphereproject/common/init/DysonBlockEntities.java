package com.tiph.dysonsphereproject.common.init;

import com.tiph.dysonsphereproject.DysonSphereProject;
import com.tiph.dysonsphereproject.common.blocks.entities.SolarGeneratorBlockEntity;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DysonBlockEntities {

    private DysonBlockEntities() {
        throw new IllegalStateException("Do not instantiate.");
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DysonSphereProject.MODID);

    public static final Supplier<BlockEntityType<SolarGeneratorBlockEntity>> SOLAR_GENERATOR_ENTITY =
            BLOCK_ENTITIES.register(
                    "solar_generator",
                    () ->
                            BlockEntityType.Builder.of(SolarGeneratorBlockEntity::new, DysonBlocks.SOLAR_GENERATOR.get())
                                    .build(null));


    public static void register(final IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
