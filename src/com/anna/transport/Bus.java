package com.anna.transport;

public class Bus extends BaseTransport {
    @Override
    public TransportType getType() {
        return TransportType.BUS;
    }
}
