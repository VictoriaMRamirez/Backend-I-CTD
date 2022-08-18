package Class12.Strategy;

public class CheckingAccount extends Account {

    public boolean extract(double amount) {
        setBalance(getBalance() - amount);
        return true;
    }
}
