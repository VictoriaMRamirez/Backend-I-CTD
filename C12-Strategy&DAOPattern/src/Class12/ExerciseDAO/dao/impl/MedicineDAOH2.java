package Class12.ExerciseDAO.dao.impl;

import Class12.ExerciseDAO.dao.IDao;
import Class12.ExerciseDAO.model.Medicine;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicineDAOH2 implements IDao<Medicine> {
    private Logger logger = Logger.getLogger(MedicineDAOH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/class12;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    @Override
    public Medicine save(Medicine medicine) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO MEDICINE VALUES(?,?,?)");
            preparedStatement.setLong(1, medicine.getId());
            preparedStatement.setString(2, medicine.getName());
            preparedStatement.setString(3, medicine.getFactory());
            preparedStatement.executeUpdate();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MEDICINE");
            while(resultSet.next()) {
            logger.info("ID: " + resultSet.getLong(1) +
                    ", name: " + resultSet.getString(2) +
                    ", factory: " + resultSet.getString(3) + ".");
            }

            preparedStatement.close();
        } catch (ClassNotFoundException ex) {
            logger.error(ex.toString());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return medicine;
    }

    @Override
    public Medicine search(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicine medicine = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM MEDICINE WHERE ID=?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                logger.info("ID: " + resultSet.getLong(1));
            }
            preparedStatement.close();
        } catch (ClassNotFoundException ex) {
            logger.error(ex.toString());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return medicine;
    }
}
