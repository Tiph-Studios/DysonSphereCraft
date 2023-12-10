package com.tiph.dysonsphereproject.common.items;

import com.tiph.dysonsphereproject.common.api.IResource;

public enum BasicItems implements IResource {
  MIRROR("mirror");

  private final String registrySuffix;

  BasicItems(String registrySuffix) {
    this.registrySuffix = registrySuffix;
  }

  @Override
  public String getRegistrySuffix() {
    return this.registrySuffix;
  }
}
