package com.anna.transport;

public abstract class BaseTransport {
  public abstract TransportType getType();

  @Override
  public String toString() {
    return getType().getName();
  }
}
