package Class2.Exercise2.service.impl;

import Class2.Exercise2.model.ChildrenMenu;
import Class2.Exercise2.model.Menu;
import Class2.Exercise2.service.MenuMaker;

public class ChildrenMenuMaker extends MenuMaker {

    @Override
    public String makingMenu(Menu menu) {
        String message = "";

        if(menu instanceof ChildrenMenu) {
            ChildrenMenu childrenMenu = (ChildrenMenu) menu;
            double toys = childrenMenu.getToys();
            message = "Children menu has an additional of: " + toys + " toys.";
        }
        return message;
    }
}
