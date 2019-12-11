package com.anna.tourism;

public enum TourismType {
    CRUISE("cruise"), // public static final CRUISE = new TourismType("cruise");
    EXCURSION("excursion"), // public static final EXCURSION = new TourismType("excursion");
    SHOPPING("shopping"),
    TREATMENT("treatment");

    private String name;

    TourismType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}