package com.anna.transport;

public class Train extends BaseTransport {
    @Override
    public TransportType getType() {
        return TransportType.TRAIN;
    }
}
