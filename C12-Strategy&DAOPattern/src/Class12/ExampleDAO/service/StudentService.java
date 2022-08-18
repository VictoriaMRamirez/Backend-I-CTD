package Class12.ExampleDAO.service;

import Class12.ExampleDAO.dao.IDao;
import Class12.ExampleDAO.model.Student;

import java.util.List;

public class StudentService {
    /* Same methods when we want to search, delete or save. Know it's a responsibility of
    the dao object student which is an object inside and an attribute of studentservice. */
    private IDao<Student> studentIDao;

    public IDao<Student> getStudentIDao() { return studentIDao; }

    public void setStudentIDao(IDao<Student> studentIDao) {
        this.studentIDao = studentIDao;
    } // Method to set dao. Sets a mechanism strategy of persistence, in this case, h2

    // We create the methods, we can call them with another name.
    public Student saveStudent(Student student) {
        return studentIDao.save(student); // Delegate responsibility of saving to the dao.
    }

    public void deleteStudent(Long id) {
       studentIDao.delete(id);
    }

    public Student searchStudent(Long id) {
        return studentIDao.search(id);
    }

    public List<Student> findAll() {
        return studentIDao.findAll();
    }
}
