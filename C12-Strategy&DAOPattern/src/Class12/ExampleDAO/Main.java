package Class12.ExampleDAO;

import Class12.ExampleDAO.dao.impl.StudentDAOH2;
import Class12.ExampleDAO.model.Student;
import Class12.ExampleDAO.service.StudentService;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.setId(1L); // "L" is for long.
        student.setName("Victoria");
        student.setSurname("Ramirez");

        StudentService studentService = new StudentService();
        studentService.setStudentIDao(new StudentDAOH2()); // We set a dao

        studentService.saveStudent(student);
        studentService.deleteStudent(1L);
        studentService.searchStudent(1L);
        studentService.findAll();

        StudentService studentService1 = new StudentService();
        studentService1.setStudentIDao(new StudentDAOH2());

        Student student1 = new Student();

        student1.setId(2L);
        student1.setName("Milo");
        student1.setSurname("Ramirez");

        studentService1.saveStudent(student1);
        studentService1.searchStudent(2L);
        studentService1.deleteStudent(2L);
    }
}
