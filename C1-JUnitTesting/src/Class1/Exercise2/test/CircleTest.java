package Class1.Exercise2.test;

import Class1.Exercise2.Circle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircleTest {

    @Test
    public void checkIsGreaterThanZero() {
        // Arrange
        Circle circle = new Circle(0);

        // Act
        Boolean result = circle.greaterThanZero();

        // Assert
        Assertions.assertFalse(result, "The radio can't be 0.");
        System.out.println(circle.calculateArea());
    }

    @Test
    public void calcuteAreaCircle() {
        // Arrange
        Circle circle = new Circle(2);

        // Act
        String result = circle.calculateArea();

        // Assert
        Assertions.assertEquals(result, "The area of the circle is 12.566370614359172 units.");
        System.out.println(result);
    }
}
