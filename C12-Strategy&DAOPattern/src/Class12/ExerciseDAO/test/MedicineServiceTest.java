package Class12.ExerciseDAO.test;

import Class12.ExerciseDAO.dao.impl.MedicineDAOH2;
import Class12.ExerciseDAO.model.Medicine;
import Class12.ExerciseDAO.service.MedicineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedicineServiceTest {

    @Test
    public void saveMedicine() {
        // Arrange
        Medicine medicine = new Medicine(1L, "Penicilin", "Pzifer");
        MedicineService medicineService = new MedicineService();
        medicineService.setMedicineIDao(new MedicineDAOH2());

        // Act
        medicineService.saveMedicine(medicine);

        //Assert
        Assertions.assertTrue(medicine != null);
    }

    @Test
    public void searchById() {
        // Arrange
        Medicine medicine1 = new Medicine(2L, "Buscapina", "Moderna");
        MedicineService medicineService1 = new MedicineService();
        medicineService1.setMedicineIDao(new MedicineDAOH2());

        // Act
        medicineService1.saveMedicine(medicine1);
        medicineService1.searchMedicine(2L);

        // Assert
        Assertions.assertTrue(medicine1 != null);
    }
}
