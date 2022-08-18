package Class12.Strategy;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(2000);
        account.setNumber(1001);
        account.setExtractionStrategy(new SavingAccountStrategy());
        account.extract(2100);

        account.setExtractionStrategy(new CheckingAccountStrategy());
        account.extract(2100);
        System.out.println(account.getBalance());
    }
}
