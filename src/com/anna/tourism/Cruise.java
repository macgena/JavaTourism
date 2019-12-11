package com.anna.tourism;

public class Cruise extends BaseTourism {
    @Override
    public TourismType getType() {
        return TourismType.CRUISE;
    }
}