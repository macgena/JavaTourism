package com.anna.menu;

public abstract class BaseMenu {
    public abstract MenuType getType();

    @Override
    public String toString() {
        return getType().getName();
    }
}
