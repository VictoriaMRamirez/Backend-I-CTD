package Class9.Exercise1;

import java.sql.*;

public class Test {
    private static final String SQL_CREATE = "DROP TABLE IF EXISTS USERS; CREATE TABLE USERS" +
            " (ID INT PRIMARY KEY," +
            " FIRST_NAME VARCHAR(100) NOT NULL," +
            " SURNAME VARCHAR(100) NOT NULL," +
            " AGE INT NOT NULL);";
    private static final String SQL_INSERT = "INSERT INTO USERS(ID, FIRST_NAME, SURNAME, AGE) VALUES(1, 'Pedro', 'Pedroni', 60);";
    private static final String SQL_SELECT = "SELECT * FROM USERS;";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/class9", "sa", "");
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try { // Try/catch is to be sure if connection to database is correct, available or even wrong access.

            connection = getConnection(); // Works if I'm connected to the database, only I need to communicate.
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);

            /* Statement (stmt): Java uses stmt to communicate to the database and send instructions. In stmt we have to
            provide information to prepare a query ready to send to the database. Then, when we execute it, we send an order
            to interpret the given information into the database. In this case, we prepared the queries earlier, we only have
            named them */

            Statement statement1 = connection.createStatement(); // Stmt can be reused.
            statement1.execute(SQL_INSERT);

            Statement statement2 = connection.createStatement(); // Show information.
            ResultSet resultSet = statement2.executeQuery(SQL_SELECT); // Don't want to update information, instead bring it back.
            // ResultSet bring the information.
            while(resultSet.next()) { // While ResultSet has a following element, it shows the information that it has (the row of the table)
                System.out.println("ID: " + resultSet.getInt(1) + ", name: " + resultSet.getString(2) +
                        ", surname: " + resultSet.getString(3) + ", age: " + resultSet.getInt(4));
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally { // Finally always executes, doesn't matter if happens an error. The idea is to minimize resources, in this case, the database.
            // If there's an error, we fix it (that's why exceptions are useful, they provide information about what is happening).
            connection.close();
        }
    }

}
