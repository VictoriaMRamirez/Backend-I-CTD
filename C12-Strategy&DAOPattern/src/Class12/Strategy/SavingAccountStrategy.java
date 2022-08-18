package Class12.Strategy;

public class SavingAccountStrategy implements ExtractionStrategy {

    @Override
    public boolean extract(Account account, double amount) {
        boolean result = false;

        if(account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            result = true;
        }
        return result;
    }
}
