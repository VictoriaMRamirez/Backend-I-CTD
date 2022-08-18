package Class2.Exercise1.service.impl;

import Class2.Exercise1.model.Employee;
import Class2.Exercise1.model.PermanentEmployee;
import Class2.Exercise1.service.Payroll;

public class PermanentEmployeePayroll extends Payroll {

    @Override
    protected double calculateSalary(Employee employee) {
        double message = 0;

        if(employee instanceof PermanentEmployee) {
            PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
            double totalEarnings = permanentEmployee.getBaseSalary() + permanentEmployee.getPrizes() - permanentEmployee.getDeductions();
            message = totalEarnings;
        }
        return message;
    }

    @Override
    protected String printPayroll(Employee employee) {
        return "Generated payroll is a digital document. ";
    }
}
