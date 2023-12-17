package com.tiph.dysonsphereproject.util;

import com.tiph.dysonsphereproject.DysonSphereProject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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

  public int getNumCollectors() {
    return numCollectors;
  }

  @Override
  public CompoundTag save(CompoundTag compoundTag) {
    compoundTag.putInt(TAG_KEY, numCollectors);
    return compoundTag;
  }

  public static OrbitalCollectorSavedData getOrbitalCollectorData(final ServerLevel serverLevel) {
    return serverLevel
        .getDataStorage()
        .computeIfAbsent(
            // This looks funny. Those are 2 different constructors.
            // One is the initial constructor if no save exists,
            // and the other deserializes from an existing tag.
            new SavedData.Factory<>(
                OrbitalCollectorSavedData::new, OrbitalCollectorSavedData::new, null),
            DysonSphereProject.MODID);
  }
}
