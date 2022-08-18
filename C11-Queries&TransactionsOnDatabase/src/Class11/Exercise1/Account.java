package Class11.Exercise1;

public class Account {
    private int id;
    private int accountNumber;
    private String name;
    private double balance;

    public Account(int id, int accountNumber, String name, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getAccountNumber() { return accountNumber; }

    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
