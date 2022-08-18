package Class2.Exercise1.model;

public class ContractualEmployee extends Employee {
    private int amountHours;
    private int hourlyRate;

    public ContractualEmployee(String name, String surname, String accountNumber, int amountHours, int hourlyRate) {
        super(name, surname, accountNumber);
        this.amountHours = amountHours;
        this.hourlyRate = hourlyRate;
    }

    public int getAmountHours() { return amountHours; }

    public int getHourlyRate() { return hourlyRate; }
}
