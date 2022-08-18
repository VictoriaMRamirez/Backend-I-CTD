package Class4.test;

import Class4.model.Email;
import Class4.service.ProcessEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckEmailTest {

    @Test
    public void mustAnswerCommercial() {
        ProcessEmail processEmail = new ProcessEmail();
        String expectedResult = "Sent to commercial.";
        Email email = new Email("vicky@gmail.com", "commercial@colmena.com", "New advances");

        String result = processEmail.checkEmail(email);

        Assertions.assertEquals(expectedResult, result);
        System.out.println(processEmail.checkEmail(email));
    }

    @Test
    public void mustAnswerTechnical() {
        ProcessEmail processEmail = new ProcessEmail();
        String expectedResult = "Sent to technical.";
        Email email = new Email("vicky@gmail.com", "clients@colmena.com", "Technical");

        String result = processEmail.checkEmail(email);

        Assertions.assertEquals(expectedResult, result);
        System.out.println(processEmail.checkEmail(email));
    }

    @Test
    public void mustAnswerManagement() {
        ProcessEmail processEmail = new ProcessEmail();
        String expectedResult = "Sent to management.";
        Email email = new Email("vicky@gmail.com", "management@colmena.com", "Management");

        String result = processEmail.checkEmail(email);

        Assertions.assertEquals(expectedResult, result);
        System.out.println(processEmail.checkEmail(email));
    }

    @Test
    public void mustAnswerAsSpam() {
        ProcessEmail processEmail = new ProcessEmail();
        String expectedResult = "Marked as SPAM.";
        Email email = new Email("dddnn@gmail.com", "leaders@colmena.com", "You won a prize!!");

        String result = processEmail.checkEmail(email);

        Assertions.assertEquals(expectedResult, result);
        System.out.println(processEmail.checkEmail(email));
    }
}
