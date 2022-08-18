package clinicaOdontologica.dao.impl;

import clinicaOdontologica.dao.IDao;
import clinicaOdontologica.model.Domicilio;
import clinicaOdontologica.model.Paciente;
import clinicaOdontologica.dao.impl.DomicilioDaoH2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;

        try {
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            domicilioDaoH2.guardar(paciente.getDomicilio());

            connection = getConnection();
            PreparedStatement psGuardarPaciente = connection.prepareStatement("INSERT INTO PACIENTES(NOMBRE, APELLIDO, DNI, FECHA_INGRESO, DOMICILIO_ID) VALUES(?,?,?,?,?)");
            psGuardarPaciente.setString(1, paciente.getNombre());
            psGuardarPaciente.setString(2, paciente.getApellido());
            psGuardarPaciente.setInt(3, paciente.getDni());
            psGuardarPaciente.setDate(4, Date.valueOf(paciente.getFechaIngreso())); // me da la fecha que viene con java.sql, localdate tiene un metodo mas facil
            psGuardarPaciente.setInt(5, paciente.getDomicilio().getId());
            psGuardarPaciente.executeUpdate();

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        Connection connection = null;
        PreparedStatement psBuscarPaciente = null;
        Paciente paciente = null;
        Domicilio domicilio = null;

        try {
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            connection = getConnection();
            psBuscarPaciente = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID=?");
            psBuscarPaciente.setInt(1, id);

            ResultSet idBuscado = psBuscarPaciente.executeQuery();
            while(idBuscado.next()) {
                int domId = idBuscado.getInt(6);
                domicilio = domicilioDaoH2.buscar(domId);
                paciente = new Paciente(idBuscado.getInt(1), idBuscado.getString(2), idBuscado.getString(3),
                        idBuscado.getInt(4), idBuscado.getDate(5).toLocalDate(), domicilio);
            }

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement eliminarPaciente = null;

        try {
            connection = getConnection();
            eliminarPaciente = connection.prepareStatement("DELETE FROM PACIENTES WHERE ID=?");
            eliminarPaciente.setInt(1, id);
            eliminarPaciente.executeUpdate();

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = null;
        PreparedStatement psBuscarListaDomicilio = null;
        Paciente paciente = null;
        List<Paciente> pacientesList = new ArrayList<>();
        Domicilio domicilio = null;

        try {
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            connection = getConnection();
            psBuscarListaDomicilio = connection.prepareStatement("SELECT * FROM PACIENTES");

            ResultSet listaBuscada = psBuscarListaDomicilio.executeQuery();
            while(listaBuscada.next()) {
                int domId = listaBuscada.getInt(6);
                domicilio = domicilioDaoH2.buscar(domId);
                paciente = new Paciente(listaBuscada.getInt(1), listaBuscada.getString(2), listaBuscada.getString(3),
                        listaBuscada.getInt(4), listaBuscada.getDate(5).toLocalDate(), domicilio);
                pacientesList.add(paciente);
            }

            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return pacientesList;
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clinicaOdontologica", "sa", "");
    }
}
