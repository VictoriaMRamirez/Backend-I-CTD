package Class12.ExampleDAO.dao.impl;

import Class12.ExampleDAO.dao.IDao;
import Class12.ExampleDAO.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOH2 implements IDao<Student> {
    // We implement dao methods'. Then we have to build a mechanism to save information into the H2-
    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/class12";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    @Override
    public Student save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // 1- Driver and connection. Table done in H2.
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2- Create a query. We can introduce as parameter the queries in each dynamic part. Easier & clean.
            preparedStatement = connection.prepareStatement("INSERT INTO STUDENTS VALUES(?,?,?)");
            preparedStatement.setLong(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());

            // 3- Execute the query.
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public void delete(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM STUDENTS WHERE ID=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Student search(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Student student = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM STUDENTS WHERE ID=?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(); // See further information of the query.
            while(resultSet.next()) { // See the results.
                Long idStudent = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                student = new Student(); // Instance student.
                student.setId(idStudent);
                student.setName(name);
                student.setSurname(surname);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Student> students = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM STUDENTS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Long idStudent = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                Student student = new Student();
                student.setId(idStudent);
                student.setName(name);
                student.setSurname(surname);

                students.add(student);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
}
