package com.anna.transport;

import java.io.Serializable;

public abstract class BaseTransport implements Serializable {
  public abstract TransportType getType();

  @Override
  public String toString() {
    return getType().getName();
  }
}
