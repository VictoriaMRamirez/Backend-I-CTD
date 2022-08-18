package Class9.Exercise2;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: unable to load drive.");
            System.exit(1);
        }

        String URL = "jdbc:h2:~/class9";
        String USER = "sa";
        String PASSWORD = "";

        String SQL_CREATE = "DROP TABLE IF EXISTS FIGURES; CREATE TABLE FIGURES" +
                "(ID INT PRIMARY KEY, TYPE VARCHAR(255) NOT NULL, COLOR VARCHAR(255) NOT NULL)";
        String SQL_INSERT = "INSERT INTO FIGURES(ID, TYPE, COLOR) VALUES(1, 'circle', 'red'), (2, 'circle', 'blue'), " +
                "(3, 'square', 'red'), (4, 'square', 'blue'), (5, 'square', 'yellow')";
        String SQL_ALL = "SELECT * FROM FIGURES";

        List<Figure> figures = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement()) {

            logger.info("Creating table in given database.");

            statement.execute(SQL_CREATE);
            statement.execute(SQL_INSERT);

            ResultSet resultSet = statement.executeQuery(SQL_ALL);
            while(resultSet.next()) {
                Figure figure = new Figure();
                figure.setId(resultSet.getInt("ID"));
                figure.setType(resultSet.getString("TYPE"));
                figure.setColor(resultSet.getString("COLOR"));
                figures.add(figure);
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        figures.forEach(figure -> logger.info(figure));
    }
}
