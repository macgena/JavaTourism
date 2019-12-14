package com.anna.menu;

public abstract class BaseMenu {
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
