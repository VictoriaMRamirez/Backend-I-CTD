package Class8.Exercise1;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    // Needs a referral to the class so when we run the program knows in which row has to log.
    private static final Logger logger = Logger.getLogger(App.class);
    private List<Integer> list = new ArrayList<>();

    public void addIntegers(Integer num) {
        list.add(num);

        if(list.size() > 10 ) {
            logger.info("The list has more than 10 elements. Total: " + list.size());
        } else if(list.size() > 5) {
            logger.info("The list has more than 5 elements. Total: " + list.size());
        }
    }

    public Integer calculateAverage() throws Exception {
        if(list.isEmpty()) {
            Exception error = new Exception("The list is empty.");
            logger.error(error.getMessage(), error); // With getMessage I can show the exception.
            throw error;
        } else {
            Integer sum = list.stream().reduce((a, b) -> a+b).get();
            Integer average = sum/list.size();
            logger.info("The average of the list is: " + average);
            return average;
        }
    }
}
