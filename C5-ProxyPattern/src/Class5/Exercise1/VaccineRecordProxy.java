package Class5.Exercise1;

import java.util.Date;

public class VaccineRecordProxy implements Record {
    private VaccineRecord vaccineRecord;

    @Override
    public String shot(Person person) {
        Date today = new Date();
        String message = "Come back when it's your turn :)";

        if(today.after(person.getAssignedDate())) {
            // Move to vaccination sector
            vaccineRecord = new VaccineRecord();
            message = vaccineRecord.shot(person);
        }
        return message;
    }
}
