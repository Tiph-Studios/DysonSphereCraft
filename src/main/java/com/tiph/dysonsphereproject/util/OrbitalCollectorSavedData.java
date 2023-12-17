package com.tiph.dysonsphereproject.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class OrbitalCollectorSavedData extends SavedData {

    private int numCollectors;

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        compoundTag.putInt("numOrbitalCollectors", numCollectors);
        return compoundTag;
    }
}
