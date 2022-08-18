package Class2.Exercise2.service;

import Class2.Exercise2.model.Menu;

public abstract class MenuMaker {

    public abstract String makingMenu(Menu menu);

    public String finalPrice(Menu menu) {
        return "Final price of the order is: $" + (menu.getBasePrice() + menu.extraCharges());
    }
}
