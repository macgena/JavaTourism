package com.anna.menu;

import java.io.Serializable;

public abstract class BaseMenu implements Serializable {
    private double calories;

    BaseMenu(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public abstract MenuType getType();

    @Override
    public String toString() {
        return "Type:" +  getType().getName() + " Calories: " + calories;
    }
}
