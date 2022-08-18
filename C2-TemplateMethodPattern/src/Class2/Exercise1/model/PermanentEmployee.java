package Class2.Exercise1.model;

public class PermanentEmployee extends Employee {
    private double baseSalary;
    private double deductions;
    private double prizes;

    public PermanentEmployee(String name, String surname, String accountNumber, double baseSalary, double deductions, double prizes) {
        super(name, surname, accountNumber);
        this.baseSalary = baseSalary;
        this.deductions = deductions;
        this.prizes = prizes;
    }

    public double getBaseSalary() { return baseSalary; }

    public double getDeductions() { return deductions; }

    public double getPrizes() { return prizes; }
}
