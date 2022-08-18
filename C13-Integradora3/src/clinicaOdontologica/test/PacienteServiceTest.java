package clinicaOdontologica.test;

import clinicaOdontologica.dao.impl.PacienteDaoH2;
import clinicaOdontologica.model.Domicilio;
import clinicaOdontologica.model.Paciente;
import clinicaOdontologica.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PacienteServiceTest {

    @BeforeAll
    public static void setUp() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clinicaOdontologica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void guardarPacientes() {
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

        Domicilio domicilio = new Domicilio("Oroño", 123, "Rosario", "Santa Fe");
        Paciente paciente = new Paciente("Victoria", "Ramirez", 456789, LocalDate.of(2022, 4, 8), domicilio);
        Domicilio domicilio2 = new Domicilio("Libertad", 456, "VGG", "Santa Fe");
        Paciente paciente2 = new Paciente("Irina", "Ramirez", 5476576, LocalDate.of(2022, 3, 1), domicilio2);
        Paciente pacienteResultado;
        Paciente pacienteResultado2;
        String resultadoEsperado = "Victoria";
        String resultadoEsperado2 = "Irina";

        pacienteResultado = pacienteService.guardar(paciente);
        pacienteResultado2 = pacienteService.guardar(paciente2);

        Assertions.assertEquals(pacienteResultado.getNombre(), resultadoEsperado);
        Assertions.assertEquals(pacienteResultado2.getNombre(), resultadoEsperado2);
    }

    @Test
    public void guardarYBuscarPaciente() {
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

        Domicilio domicilio3 = new Domicilio("Pellegrini", 789, "Rosario", "Santa Fe");
        Paciente paciente3 = new Paciente("Roxana", "Saied", 537435, LocalDate.of(2022, 2, 25), domicilio3);
        Paciente pacienteResultado3;
        int resultadoEsperado3 = 3;

        pacienteService.guardar(paciente3);
        pacienteResultado3 = pacienteService.buscar(3);

        Assertions.assertEquals(pacienteResultado3.getId(), resultadoEsperado3);
    }

    @Test
    public void eliminarPaciente() {
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

        pacienteService.eliminar(1);

        Assertions.assertNull(pacienteService.buscar(1));
    }

    @Test
    public void buscarListaPacientes() {
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

        List<Paciente> pacienteList = pacienteService.buscarTodos();

        Assertions.assertFalse(pacienteList.isEmpty());
        Assertions.assertEquals(2, pacienteList.size());
    }
}
