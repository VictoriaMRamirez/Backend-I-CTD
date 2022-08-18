package Class4.chain;

import Class4.model.Email;

public class TechnicalHandler extends Handler {

    @Override
    public String checkEmail(Email email) {
        if(email.getDestination().equals("technical@colmena.com") || email.getSubject().equals("Technical")) {
            return "Sent to technical.";
        } else {
            return getNextHandler().checkEmail(email);
        }
    }
}
