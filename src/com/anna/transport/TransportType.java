package com.anna.transport;

public enum TransportType {
    CAR("car"),
    BUS("bus"),
    PLANE("plane"),
    TRAIN("train");

    private String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
