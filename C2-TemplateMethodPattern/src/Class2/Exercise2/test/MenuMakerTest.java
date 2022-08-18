package Class2.Exercise2.test;

import Class2.Exercise2.model.ChildrenMenu;
import Class2.Exercise2.model.ClassicMenu;
import Class2.Exercise2.model.Menu;
import Class2.Exercise2.model.VeggieMenu;
import Class2.Exercise2.service.MenuMaker;
import Class2.Exercise2.service.impl.ChildrenMenuMaker;
import Class2.Exercise2.service.impl.ClassicMenuMaker;
import Class2.Exercise2.service.impl.VeggieMenuMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuMakerTest {

    @Test
    public void makingClassicMenu() {
        // Arrange
        MenuMaker menuMaker = new ClassicMenuMaker();
        Menu menu = new ClassicMenu(300.0);
        String expectedResult = "Classic menu does not have additionals.";

        // Act
        String result = menuMaker.makingMenu(menu);

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(menuMaker.finalPrice(menu));
    }

    @Test
    public void makingVeggieMenu() {
        // Arrange
        MenuMaker menuMaker = new VeggieMenuMaker();
        Menu menu = new VeggieMenu(300.0, 4.0, 3.0);
        String expectedResult = "Veggie menu has an additional of: 4.0 spices and 3.0 sauces.";

        // Act
        String result = menuMaker.makingMenu(menu);

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(menuMaker.finalPrice(menu));
    }

    @Test
    public void makingChildrenMenu() {
        // Arrange
        MenuMaker menuMaker = new ChildrenMenuMaker();
        Menu menu = new ChildrenMenu(300.0, 5.0);
        String expectedResult = "Children menu has an additional of: 5.0 toys.";

        // Act
        String result = menuMaker.makingMenu(menu);

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(menuMaker.finalPrice(menu));
    }
}
