package Class8.ExerciseInGroup;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    private static List<Integer> list;

    public static void main(String[] args) {
        list = new ArrayList<>(); // To show empty list.
        list.add(1); // Shows more than 5 elements.
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7); // Shows more than 10 elements.
        list.add(8);
        list.add(9);
        list.add(10);

        if (list.size() >= 10) logger.info("The list has more than 10 elements.");
        else if (list.size() >= 5) logger.info("The list has more than 5 elements.");
        if (list.size() == 0) {
            logger.error("The list is empty.");
        } else { // Obtain average
            Integer suma = list.stream().reduce((a, b) -> a+b).get();
            double average = suma/list.size();
            logger.info("Average: " + average);
        }
    }
}
