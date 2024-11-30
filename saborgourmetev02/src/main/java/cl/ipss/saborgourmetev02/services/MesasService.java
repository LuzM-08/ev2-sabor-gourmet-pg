package cl.ipss.saborgourmetev02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.ipss.saborgourmetev02.models.Mesas;
import cl.ipss.saborgourmetev02.models.Reservas;
import cl.ipss.saborgourmetev02.repositories.MesasRepository;

@Service
public class MesasService {
    @Autowired
    private MesasRepository mesasRepository;

    public List<Mesas> listarTodas() {
        return mesasRepository.findAll();
    }

    public Mesas guardar(Mesas reserva) {
        return mesasRepository.save(reserva);
    }

    public Mesas obtenerPorId(Long id) {
        return mesasRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        mesasRepository.deleteById(id);
    }

}
