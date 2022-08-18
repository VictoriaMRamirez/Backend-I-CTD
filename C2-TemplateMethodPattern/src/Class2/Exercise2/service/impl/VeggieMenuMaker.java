package Class2.Exercise2.service.impl;

import Class2.Exercise2.model.Menu;
import Class2.Exercise2.model.VeggieMenu;
import Class2.Exercise2.service.MenuMaker;

public class VeggieMenuMaker extends MenuMaker {

    @Override
    public String makingMenu(Menu menu) {
        String message = "";

        if(menu instanceof VeggieMenu) {
            VeggieMenu veggieMenu = (VeggieMenu) menu;
            double spices = veggieMenu.getSpices();
            double sauces = veggieMenu.getSauces();
            message = "Veggie menu has an additional of: " + spices
                    + " spices and " + sauces + " sauces.";
        }
        return message;
    }
}
