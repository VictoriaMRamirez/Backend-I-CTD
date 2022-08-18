package clinicaOdontologica.dao.impl;

import clinicaOdontologica.dao.IDao;
import clinicaOdontologica.model.Domicilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement psGuardarDomicilio = null;

        try {
            connection = getConnection();
            psGuardarDomicilio = connection.prepareStatement("INSERT INTO DOMICILIOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            psGuardarDomicilio.setString(1, domicilio.getCalle());
            psGuardarDomicilio.setInt(2, domicilio.getNumero());
            psGuardarDomicilio.setString(3, domicilio.getLocalidad());
            psGuardarDomicilio.setString(4, domicilio.getProvincia());
            psGuardarDomicilio.executeUpdate();

            ResultSet clavesGeneradas = psGuardarDomicilio.getGeneratedKeys();
            if(clavesGeneradas.next()) {
                domicilio.setId(clavesGeneradas.getInt(1)); // cargo id al objeto domicilio
            }

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(int id) {
        Connection connection = null;
        PreparedStatement psBuscarDomicilio = null;
        Domicilio domicilio = null;

        try {
            connection = getConnection();
            psBuscarDomicilio = connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID=?");
            psBuscarDomicilio.setInt(1, id);

            ResultSet idBuscado = psBuscarDomicilio.executeQuery();
            while(idBuscado.next()) {
                domicilio = new Domicilio(idBuscado.getInt(1), idBuscado.getString(2), idBuscado.getInt(3), idBuscado.getString(4), idBuscado.getString(5));
            }

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement eliminarDomicilio = null;

        try {
            connection = getConnection();
            eliminarDomicilio = connection.prepareStatement("DELETE FROM DOMICILIOS WHERE ID=?");
            eliminarDomicilio.setInt(1, id);
            eliminarDomicilio.executeUpdate();

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = null;
        PreparedStatement psBuscarListaDomicilio = null;
        Domicilio domicilio = null;
        List<Domicilio> domiciliosList = new ArrayList<>();

        try {
            connection = getConnection();
            psBuscarListaDomicilio = connection.prepareStatement("SELECT * FROM DOMICILIOS");

            ResultSet listaBuscada = psBuscarListaDomicilio.executeQuery();
            while(listaBuscada.next()) {
                domicilio = new Domicilio(listaBuscada.getInt(1), listaBuscada.getString(2), listaBuscada.getInt(3), listaBuscada.getString(4), listaBuscada.getString(5));
                domiciliosList.add(domicilio);
            }

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return domiciliosList;
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clinicaOdontologica", "sa", "");
    }
}
