package Class4.service;

import Class4.chain.*;
import Class4.model.Email;

public class ProcessEmail {
    private Handler initial;

    public ProcessEmail() {
        initial = new CommercialHandler(); // We create the links of the chain.
        Handler technical = new TechnicalHandler();
        Handler management = new ManagementHandler();
        Handler spam = new SpamHandler();

        // Put all together.
        initial.setNextHandler(management);
        management.setNextHandler(technical);
        technical.setNextHandler(spam);
    }

    public String checkEmail(Email email) {
        return initial.checkEmail(email);
    }
}
