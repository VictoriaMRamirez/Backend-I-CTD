package Class3.test;

import Class3.model.Affiliate;
import Class3.model.Employee;
import Class3.model.Seller;
import Class3.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellerTest {

    @Test
    public void showCategoryOfEmployeeAsANewbie() {
        // Arrange
        Employee employee = new Employee("Maria", 1);
        employee.sell(1);
        String expectedResult = "Maria has a score of 5 points and categorize as Newbie";

        // Act
        String result = employee.showCategory();

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(employee.showCategory());
    }

    @Test
    public void showCategoryOfEmployeeAsATrainee() {
        // Arrange
        Employee employee = new Employee("John", 2);
        Seller affiliate = new Affiliate("Chris");
        employee.addAffiliate(affiliate);
        employee.sell(2);
        String expectedResult = "John has a score of 20 points and categorize as Trainee";

        // Act
        String result = employee.showCategory();

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(employee.showCategory());
    }

    @Test
    public void showCategoryOfAffiliateAsAMaster() {
        // Arrange
        Seller affiliate = new Affiliate("Chris");
        affiliate.sell(3);
        String expectedResult = "Chris has a score of 45 points and categorize as Master";

        // Act
        String result = affiliate.showCategory();

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(affiliate.showCategory());
    }

    @Test
    public void showCategoryOfTraineeAsANewbie() {
        // Arrange
        Seller trainee = new Trainee("Thomas");
        trainee.sell(3);
        String expectedResult = "Thomas has a score of 15 points and categorize as Trainee newbie";

        // Act
        String result = trainee.showCategory();

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(trainee.showCategory());
    }

    @Test
    public void showCategoryOfTraineeAsAExperienced() {
        // Arrange
        Seller trainee = new Trainee("Joseph");
        trainee.sell(10);
        String expectedResult = "Joseph has a score of 50 points and categorize as Experienced trainee";

        // Act
        String result = trainee.showCategory();

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(trainee.showCategory());
    }
}
