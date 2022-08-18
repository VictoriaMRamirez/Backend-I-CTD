package Class1.Exercise1;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        // Condition:
        if(person.getAge() >= 18 && person.getName().length() >= 5) {
            people.add(person);
        } else {
            System.out.println("Cannot be added " + person);
        }
    }

    public int getPeopleInTheGroup() {
        return people.size(); // Size allows me to know the size of the collection.
    }
}
