package Class11.Example;

import java.sql.*;

public class Test {
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS USERS; CREATE TABLE USERS"
            + "(ID INT PRIMARY KEY,"
            + " NAME VARCHAR(100) NOT NULL,"
            + " EMAIL VARCHAR(100) NOT NULL,"
            + " BALANCE NUMERIC(15, 2) NOT NULL"
            + ")";
    // The values that have ? are going to be placed according to the given order. Ex.: the 1st ? = value that will have the id.
    private static final String SQL_INSERT = "INSERT INTO USERS(ID, NAME, EMAIL, BALANCE) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE USERS SET BALANCE=? WHERE EMAIL=?";

    public static void main(String[] args) throws Exception {
        User user = new User("Pedro", "pedro@dh.com", 10.0); // New user to save.
        Connection connection = null;  // Connection is null because we're going to create the connection inside the try-catch.

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE); // Build the table.

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            // We start to insert data into the database.
            psInsert.setInt(1, 1); // 1st is the parameter, 2nd is the value.
            psInsert.setString(2, user.getName());
            psInsert.setString(3, user.getEmail()); // Data from the user.
            psInsert.setDouble(4, user.getBalance());

            psInsert.execute(); // Execute insert. This insert Pedro with a balance of 10.

            // If we don't place anything, everytime we made something on the database, it'll commit directly.
            connection.setAutoCommit(false); // As long, we put the autocommit in false, we have to commit ourselves.

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE); // 2nd stmt: transaction.

            psUpdate.setDouble(1, user.addToBalance(10));
            psUpdate.setString(2, user.getEmail());
            psUpdate.execute();

            // Connection makes a rollback when appears an error.
            int a = 4/0; // Error we built out after the update.

            connection.commit();

            connection.setAutoCommit(true); // If everything seems okay, and we could commit, we turn the autocommit in true (good practise).
            String sql = "SELECT * FROM USERS"; // With this query we find out if balance changed to 20.

            Statement stmt = connection.createStatement(); // New stmt for a new search.
            ResultSet rd = stmt.executeQuery(sql); // ResultSet is a way to search in the database.
            while(rd.next()) {
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3) + rd.getDouble(4));
            } // Print data in screen.

        } catch (Exception e) {
            e.printStackTrace(); // If connection fails, returns what happened.
            connection.rollback(); // Returns values before update.

        } finally {
            connection.close(); // Good practise.
        }

        // Build a query to see if there is 20 instead of 10 in the database.
        Connection connection1 = getConnection(); // Create another connection.
        String sql = "SELECT * FROM USERS";
        Statement stmt = connection1.createStatement();
        ResultSet rd = stmt.executeQuery(sql);
        while (rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3) + rd.getDouble(4));
        }
        /* We use this 2 times. First, when we want to see the change in balance, from 10 to 20. Second, when we
        want to see the result of the rollback, bringing the balance with 10, value that was saved before. */
    }

    private static Connection getConnection() throws Exception { // Create connection with the database H2.
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/class11", "sa", "");
    }
}
