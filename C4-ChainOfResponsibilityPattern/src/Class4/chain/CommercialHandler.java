package Class4.chain;

import Class4.model.Email;

public class CommercialHandler extends Handler {

    @Override
    public String checkEmail(Email email) {
        if(email.getDestination().equals("commercial@colmena.com") || email.getSubject().equals("Commercial")) {
            return "Sent to commercial.";
        } else {
            return getNextHandler().checkEmail(email);
        }
    }
}
