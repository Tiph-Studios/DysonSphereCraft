package com.tiph.dysonsphereproject.common.items;

import com.tiph.dysonsphereproject.common.api.IResource;

public enum BasicItems implements IResource {
  MIRROR("mirror"),
  ORBITAL_COLLECTOR("orbital_collector");

  private final String registrySuffix;

  BasicItems(String registrySuffix) {
    this.registrySuffix = registrySuffix;
  }

  @Override
  public String getRegistrySuffix() {
    return this.registrySuffix;
  }
}
