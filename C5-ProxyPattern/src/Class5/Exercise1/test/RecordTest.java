package Class5.Exercise1.test;

import Class5.Exercise1.Person;
import Class5.Exercise1.VaccineRecordProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class RecordTest {

    @Test
    public void proveRightPersonWasVaccinated() {
        // Arrange
        Person person = new Person ("John", "Doe", "41.563.489", "Pzifer", new Date(2022-1900, 3, 4));
        VaccineRecordProxy vaccineRecordProxy = new VaccineRecordProxy();
        String expectedResult = "Dni 41.563.489 has been registered as a vaccinated person with Pzifer";

        // Act
        String result = vaccineRecordProxy.shot(person);

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(result);
    }

    @Test
    public void proveIsNotYetTheTurn() {
        // Arrange
        Person person = new Person ("Jane", "Doe", "13.458.215", "Moderna", new Date(2022-1900, 4, 4));
        VaccineRecordProxy vaccineRecordProxy = new VaccineRecordProxy();
        String expectedResult = "Come back when it's your turn :)";

        // Act
        String result = vaccineRecordProxy.shot(person);

        // Assert
        Assertions.assertEquals(expectedResult, result);
        System.out.println(result);
    }
}
