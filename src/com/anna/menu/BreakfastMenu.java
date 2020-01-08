package com.anna.menu;

public class BreakfastMenu extends BaseMenu {
    public BreakfastMenu() {}
    public BreakfastMenu(double calories) {
        super(calories);
    }

    @Override
    public MenuType getType() {
        return MenuType.BREAKFAST_INCLUDED;
    }
}
