package Class2.Exercise1.model;

public abstract class Employee {
    private String name;
    private String surname;
    private String accountNumber;

    public Employee(String name, String surname, String accountNumber) {
        this.name = name;
        this.surname = surname;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() { return accountNumber; }
}
