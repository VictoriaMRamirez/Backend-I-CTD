package Class2.Exercise1.service;

import Class2.Exercise1.model.Employee;

public abstract class Payroll {

    public String generateSalary(Employee employee) {
        String message = "The payroll cannot be calculated.";
        double salary = calculateSalary(employee);

        if(salary > 0) {
            String payroll = printPayroll(employee);
            System.out.println(depositWage(employee));
            message = payroll + "Final salary: " + salary;
        }
        return message;
    }

    protected abstract double calculateSalary(Employee employee);

    protected abstract String printPayroll(Employee employee);

    private String depositWage(Employee employee) {
        return "Deposit in account number: " + employee.getAccountNumber();
    }
}
