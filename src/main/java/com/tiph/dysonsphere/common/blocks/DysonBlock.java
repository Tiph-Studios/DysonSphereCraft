package com.tiph.dysonsphere.common.blocks;

import com.tiph.dysonsphere.ExampleMod;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public abstract class DysonBlock extends Block {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExampleMod.MODID);

    public DysonBlock(final Properties p) {
        super(p);
    }

    public static void register(final IEventBus eventBus) {
        //todo this is braindead
        SolarGeneratorBlock.init();
        BLOCKS.register(eventBus);
    }


}
