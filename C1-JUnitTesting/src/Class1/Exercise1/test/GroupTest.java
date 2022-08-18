package Class1.Exercise1.test;

import Class1.Exercise1.Group;
import Class1.Exercise1.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupTest {

    @Test
    public void controlGroup() {
        // Arrange: conditions to begin with. We create the people and the group.
        Person juan = new Person("Juan", 19);
        Person pedro = new Person("Pedro", 20);
        Person ana = new Person("Ana", 25);
        Person luz = new Person("Luz", 30);
        Person julian = new Person("Julián", 35);
        Group group = new Group();

        // Act: when the fundamentals processes are occurring. We tried the test.
        group.addPerson(juan);
        group.addPerson(pedro);
        group.addPerson(ana);
        group.addPerson(luz);
        group.addPerson(julian);

        // Assert: based in the results, we verify if happened what we expected.
        Assertions.assertTrue(group.getPeopleInTheGroup() == 2);
    }
}
