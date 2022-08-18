package Class4.chain;

import Class4.model.Email;

public class SpamHandler extends Handler {

    @Override
    public String checkEmail(Email email) {
        return "Marked as SPAM.";
    }
}
