package com.anna.menu;

public class AllIncludedMenu extends BaseMenu {
    public AllIncludedMenu(double calories) {
        super(calories);
    }

    @Override
    public MenuType getType() {
        return MenuType.ALL_INCLUDED;
    }
}
