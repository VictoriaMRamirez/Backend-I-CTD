package Class12.Strategy;

public class CheckingAccountStrategy implements ExtractionStrategy {

    @Override
    public boolean extract(Account account, double amount) {
        account.setBalance(account.getBalance() - amount);
        return true;
    }
}
