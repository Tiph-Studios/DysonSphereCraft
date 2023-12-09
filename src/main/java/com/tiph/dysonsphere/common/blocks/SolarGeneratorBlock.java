package com.tiph.dysonsphere.common.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SolarGeneratorBlock extends DysonBlock {

    private static final float DESTROY_TIME = 2.0f;

    public static final DeferredBlock<SolarGeneratorBlock> SOLAR_GENERATOR_1_BLOCK = DysonBlock.registerBlock("solar_generator_1",
            () -> new SolarGeneratorBlock(BlockBehaviour.Properties.of()
                    .destroyTime(DESTROY_TIME)
                    .sound(SoundType.METAL)
            ));

    public static void init() {
        // Instantiate blocks
    }

    public SolarGeneratorBlock(Properties p) {
        super(p);
    }

}
