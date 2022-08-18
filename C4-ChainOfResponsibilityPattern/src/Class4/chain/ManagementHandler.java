package Class4.chain;

import Class4.model.Email;

public class ManagementHandler extends Handler {

    @Override
    public String checkEmail(Email email) {
        if(email.getDestination().equals("management@colmena.com") || email.getSubject().equals("Management")) {
            return "Sent to management.";
        } else {
            return getNextHandler().checkEmail(email);
        }
    }
}
