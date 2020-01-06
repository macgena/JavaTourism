package com.anna.tourism;

import java.io.Serializable;

public abstract class BaseTourism implements Serializable {
    public abstract TourismType getType();

    @Override
    public String toString() {
        return getType().getName();
    }
}
