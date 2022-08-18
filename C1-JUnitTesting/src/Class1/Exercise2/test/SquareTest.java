package Class1.Exercise2.test;

import Class1.Exercise2.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    public void checkIsGreaterThanZero() {
        // Arrange
        Square square = new Square(0);
        String expectedResult = "The size can't be 0.";

        // Act
        Boolean result = square.greaterThanZero();

        // Assert
        Assertions.assertFalse(result, expectedResult);
        System.out.println(square.calculateArea());
    }

    @Test
    public void calcuteAreaSquare() {
        // Arrange
        Square square = new Square(2);
        String expectedResult = "The area of the square is 4.0 units.";

        // Act
        String result = square.calculateArea();

        // Assert
        Assertions.assertEquals(result, expectedResult);
        System.out.println(result);
    }
}
