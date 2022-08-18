package Class2.Exercise1.test;

import Class2.Exercise1.model.ContractualEmployee;
import Class2.Exercise1.model.Employee;
import Class2.Exercise1.model.PermanentEmployee;
import Class2.Exercise1.service.Payroll;
import Class2.Exercise1.service.impl.ContractualEmployeePayroll;
import Class2.Exercise1.service.impl.PermanentEmployeePayroll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PayrollTest {

    @Test
    public void digitalDocumentToPermanentEmployee() {
        // Arrange
        Payroll payroll = new PermanentEmployeePayroll();
        Employee permanentEmployee = new PermanentEmployee("Martín", "Martini", "001A", 400, 40, 60);
        String expectedResult = "Generated payroll is a digital document. Final salary: 420.0";

        // Act
        String result = payroll.generateSalary(permanentEmployee);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void printedDocumentToContractualEmployee() {
        // Arrange
        Payroll payroll = new ContractualEmployeePayroll();
        Employee contractualEmployee = new ContractualEmployee("Pompilia", "Pompini", "001B", 120, 7);
        String expectedResult = "Generated payroll is a printed document. Final salary: 840.0";

        // Act
        String result = payroll.generateSalary(contractualEmployee);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void errorMessage() {
        // Arrange
        Payroll payroll = new PermanentEmployeePayroll();
        Employee contractualEmployee = new ContractualEmployee("Pompilia", "Pompini", "001B", 120, 7);
        String expectedResult = "The payroll cannot be calculated.";

        // Act
        String result = payroll.generateSalary(contractualEmployee);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}
