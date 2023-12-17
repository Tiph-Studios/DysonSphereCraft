package com.tiph.dysonsphereproject.common.blocks.entities.warpdislocator;

import com.tiph.dysonsphereproject.common.init.DysonItems;
import com.tiph.dysonsphereproject.common.items.BasicItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class WarpDislocatorItemStackHandler extends ItemStackHandler {

    public WarpDislocatorItemStackHandler(int size) {
        super(size);
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        if (stack.getItem() != DysonItems.getBasicItem(BasicItems.ORBITAL_COLLECTOR).get()) {
            return false;
        }
        return super.isItemValid(slot, stack);
    }
}
