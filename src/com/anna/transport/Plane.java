package com.anna.transport;

public class Plane extends BaseTransport {
    @Override
    public TransportType getType() {
        return TransportType.PLANE;
    }
}
