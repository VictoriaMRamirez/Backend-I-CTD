package clinicaOdontologica.service;

import clinicaOdontologica.dao.IDao;
import clinicaOdontologica.model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    public Paciente buscar(int id) {
        return pacienteIDao.buscar(id);
    }

    public void eliminar(int id) {
        pacienteIDao.eliminar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }
}
