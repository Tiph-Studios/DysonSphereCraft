package com.tiph.dysonsphere.common.items;

import com.tiph.dysonsphere.common.blocks.SolarGeneratorBlock;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;

public class SolarGeneratorBlockItem extends DysonItem {

    public static final DeferredItem<BlockItem> SOLAR_GENERATOR_1_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("solar_generator_1",
            SolarGeneratorBlock.SOLAR_GENERATOR_1_BLOCK);

    public static void init() {
        // Instantiate block items
    }

    public SolarGeneratorBlockItem(Properties p) {
        super(p);
    }
}
