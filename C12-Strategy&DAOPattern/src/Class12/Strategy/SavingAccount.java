package Class12.Strategy;

public class SavingAccount extends Account {

    public boolean extract(double amount) {
        boolean result = false;

        if(getBalance() >= amount) {
            setBalance(getBalance() - amount);
            result = true;
        }
        return result;
    }
}
