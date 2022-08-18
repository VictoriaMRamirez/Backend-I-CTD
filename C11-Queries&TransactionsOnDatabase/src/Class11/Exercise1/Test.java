package Class11.Exercise1;

import java.sql.*;

public class Test {
    private static final String SQL_CREATE = "DROP TABLE IF EXISTS ACCOUNT; CREATE TABLE ACCOUNT" +
            "(ID INT PRIMARY KEY," +
            " ACCOUNT_NUMBER INT NOT NULL," +
            " NAME VARCHAR(100) NOT NULL," +
            " BALANCE NUMERIC(10,2) NOT NULL);";
    private static final String SQL_INSERT = "INSERT INTO ACCOUNT(ID, ACCOUNT_NUMBER, NAME, BALANCE) VALUES(?, ?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE ACCOUNT SET BALANCE=? WHERE ID=?;";

    public static void main(String[] args) throws Exception {
        Account account = new Account(12, "Victoria", 10);
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setInt(2, account.getAccountNumber());
            psInsert.setString(3, account.getName());
            psInsert.setDouble(4, account.getBalance());
            psInsert.execute();

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1, account.getBalance() + 10);
            psUpdate.setInt(2, 1);
            psUpdate.executeUpdate();

            connection.setAutoCommit(false);

            PreparedStatement psUpdate2 = connection.prepareStatement(SQL_UPDATE);
            psUpdate2.setDouble(1, account.getBalance() + 15);
            psUpdate2.setInt(2, 1);
            psUpdate2.executeUpdate();
            int a = 5/0;

            connection.commit();

            connection.setAutoCommit(true);

        } catch(Exception e) {
            e.printStackTrace();
            connection.rollback();

        } finally {
            connection.close();
        }

        Connection connection1 = getConnection();
        String sql = "SELECT * FROM ACCOUNT";
        Statement stmt = connection1.createStatement();
        ResultSet rd = stmt.executeQuery(sql);
        while (rd.next()) {
            System.out.println(rd.getInt(1) + rd.getInt(2) + rd.getString(3) + rd.getDouble(4));
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/class11", "sa", "");
    }
}
