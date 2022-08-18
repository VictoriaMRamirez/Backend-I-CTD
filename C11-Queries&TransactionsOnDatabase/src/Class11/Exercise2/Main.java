package Class11.Exercise2;

import java.sql.*;
import org.apache.log4j.Logger;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS DENTISTS; CREATE TABLE DENTISTS"
            + "(ID INT PRIMARY KEY,"
            + " SURNAME VARCHAR(100) NOT NULL,"
            + " NAME VARCHAR(100) NOT NULL,"
            + " REGISTRATION_NUMBER varchar(100) NOT NULL"
            + ")";
    private static final String SQL_INSERT = "INSERT INTO DENTISTS(ID, SURNAME, NAME, REGISTRATION_NUMBER) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE DENTISTS SET REGISTRATION_NUMBER=? WHERE SURNAME=?";

    public static void main(String[] args) throws Exception {
        Dentist dentist = new Dentist("Libonati", "Micaela", "1234");
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, dentist.getSurname());
            psInsert.setString(3, dentist.getName());
            psInsert.setString(4, dentist.getRegistrationNumber());
            psInsert.execute();

            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, dentist.setRegistrationNumber("5678"));
            psUpdate.setString(2, dentist.getSurname());
            psUpdate.execute();

            logger.error("");
            int a = 4/0;

            connection.commit();
            connection.setAutoCommit(true);

            String sql = "SELECT * FROM DENTISTS";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            logger.info(resultSet.next() ? "ID: " + resultSet.getInt("ID") +
                    ", SURNAME & NAME: " + resultSet.getString("SURNAME") + " " + resultSet.getString("NAME") +
                    ", REGISTRATION NUMBER: " + resultSet.getString("REGISTRATION_NUMBER") : "The table is empty.");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            connection.rollback();
        } finally {
            connection.close();
        }

        Connection connection1 = getConnection();
        String sql = "SELECT * FROM DENTISTS";
        Statement stmt = connection1.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        logger.info(resultSet.next() ? "ID: " + resultSet.getInt("ID") +
                ", SURNAME & NAME: " + resultSet.getString("SURNAME") + " " + resultSet.getString("NAME") +
                ", REGISTRATION NUMBER: " + resultSet.getString("REGISTRATION_NUMBER") : "The table is empty.");
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/class11", "sa", "");
    }
}
