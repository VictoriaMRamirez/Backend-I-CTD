package Class12.ExerciseDAO.service;

import Class12.ExerciseDAO.dao.IDao;
import Class12.ExerciseDAO.dao.impl.MedicineDAOH2;
import Class12.ExerciseDAO.model.Medicine;

public class MedicineService {
    private IDao<Medicine> medicineIDao;

    public IDao<Medicine> getMedicineIDao() {
        return medicineIDao;
    }

    public void setMedicineIDao(IDao<Medicine> medicineIDao) {
        this.medicineIDao = medicineIDao;
    }

    public Medicine saveMedicine(Medicine medicine) {
        return medicineIDao.save(medicine);
    }

    public Medicine searchMedicine(Long id) {
        return medicineIDao.search(id);
    }
}
