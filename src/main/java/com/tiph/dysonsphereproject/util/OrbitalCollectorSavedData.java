package com.tiph.dysonsphereproject.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class OrbitalCollectorSavedData extends SavedData {

  private static final String TAG_KEY = "numOrbitalCollectors";

  private int numCollectors;

  public OrbitalCollectorSavedData() {
    this.numCollectors = 0;
  }

  public OrbitalCollectorSavedData(final CompoundTag compoundTag) {
    this.numCollectors = compoundTag.getInt(TAG_KEY);
  }

  public void addCollector() {
    numCollectors++;
    setDirty();
  }

  @Override
  public CompoundTag save(CompoundTag compoundTag) {
    compoundTag.putInt(TAG_KEY, numCollectors);
    return compoundTag;
  }
}
