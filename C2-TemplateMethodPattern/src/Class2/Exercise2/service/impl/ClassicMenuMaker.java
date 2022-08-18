package Class2.Exercise2.service.impl;

import Class2.Exercise2.model.ChildrenMenu;
import Class2.Exercise2.model.Menu;
import Class2.Exercise2.service.MenuMaker;

public class ClassicMenuMaker extends MenuMaker {

    @Override
    public String makingMenu(Menu menu) {
       return "Classic menu does not have additionals.";
    }
}
