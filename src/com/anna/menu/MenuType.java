package com.anna.menu;

public enum MenuType {
    BREAKFAST_INCLUDED("breakfast"),
    ALL_INCLUDED("all");

    private String name;

    MenuType(String name) {
        this.name = name;
    };

    public String getName() {
        return name;
    }
}
