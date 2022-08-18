package Class4.chain;

import Class4.model.Email;

public abstract class Handler {
    private Handler nextHandler;

    public Handler getNextHandler() { return nextHandler; }

    public void setNextHandler(Handler nextHandler) { this.nextHandler = nextHandler; }

    // To be resolved in each handler if it has to.
    public abstract String checkEmail(Email email);
}
