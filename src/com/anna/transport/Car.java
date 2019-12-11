package com.anna.transport;

public class Car extends BaseTransport {
    @Override
    public TransportType getType() {
        return TransportType.CAR;
    }
}
