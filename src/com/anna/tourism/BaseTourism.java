package com.anna.tourism;

public abstract class BaseTourism {
    public abstract TourismType getType();

    @Override
    public String toString() {
        return getType().getName();
    }
}
