package Class2.Exercise1.service.impl;

import Class2.Exercise1.model.ContractualEmployee;
import Class2.Exercise1.model.Employee;
import Class2.Exercise1.service.Payroll;

public class ContractualEmployeePayroll extends Payroll {

    @Override
    protected double calculateSalary(Employee employee) {
        double message = 0;

        if(employee instanceof Employee) {
            ContractualEmployee contractualEmployee = (ContractualEmployee) employee;
            double totalEarnings = contractualEmployee.getAmountHours() * contractualEmployee.getHourlyRate();
            message = totalEarnings;
        }
        return message;
    }

    @Override
    protected String printPayroll(Employee employee) {
        return "Generated payroll is a printed document. ";
    }
}
