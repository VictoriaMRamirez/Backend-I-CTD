package Class9.Example;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try { // Register controller.
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: unable to load drive class.");
            System.exit(1);
        }

        String URL = "jdbc:h2:~/class9";
        String USER = "sa";
        String PASS = "";

        String sqlCreate = "DROP TABLE IF EXISTS ANIMALS; CREATE TABLE ANIMALS(ID INT PRIMARY KEY, NAME VARCHAR(20), TYPE VARCHAR(20))";
        String sqlInsert = "INSERT INTO ANIMALS VALUES(5, 'Firulais', 'dog')";
        //String sqlDelete = "DELETE FROM ANIMALS WHERE NAME='Firulais'";
        String sqlQuery = "SELECT * FROM ANIMALS ";

        Collection<Animal> animals = new ArrayList<>();

        Statement statement2 = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); // Establish a connection using URL and data autentication (optional).
             Statement statement = connection.createStatement()) { // Instance Statement to execute queries.

            System.out.println("Creating table in given database");
            statement.execute(sqlCreate);
            statement.executeUpdate(sqlInsert);
            //statement.executeUpdate(sqlDelete);

            ResultSet resultSet = statement.executeQuery(sqlQuery); // With ResultSet we can obtain the data coming from the queries

            while(resultSet.next()) {
                Animal animal = new Animal();
                animal.setId(resultSet.getInt("ID"));
                animal.setName(resultSet.getString("NAME"));
                animal.setType(resultSet.getString("TYPE"));
                animals.add(animal);
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        animals.forEach(a -> logger.info(a));
    }
}
