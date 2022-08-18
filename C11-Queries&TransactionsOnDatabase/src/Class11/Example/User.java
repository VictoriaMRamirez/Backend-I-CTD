package Class11.Example;

public class User {
    private Long id;
    private String name;
    private String email;
    private double balance;

    public User(String name, String email, double balance) { // Constructor doesn't have id. It'll be created when we introduce the row into the database.
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    public double addToBalance(double price) {
        this.balance = this.balance + price;
        return this.balance;
    }
}
