package cl.ipss.saborgourmetev02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.saborgourmetev02.models.Mesas;
import cl.ipss.saborgourmetev02.models.Reservas;
import cl.ipss.saborgourmetev02.repositories.ReservasRepository;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reservas> listarTodas() {
        return reservasRepository.findAllWithMesas();
    }

    public Reservas guardar(Reservas reserva) {
        if (reserva.getMesas() != null) {
            for (Mesas mesa : reserva.getMesas()) {
                mesa.setReserva(reserva); // Establece la relación bidireccional entre reserva y mesas
            }
        }
        return reservasRepository.save(reserva);
    }

    public Reservas obtenerPorId(Long id) {
        return reservasRepository.findById(id).orElse(null);
    }

    /*
     * public void eliminar(Long id){
     * reservasRepository.deleteById(id);
     * }
     */

    public void eliminar(Long id) {
        Reservas reserva = reservasRepository.findById(id).orElse(null);
        if (reserva != null) {
            // Desasociar mesas de la reserva
            reserva.getMesas().forEach(mesa -> mesa.setReserva(null));
            reservasRepository.delete(reserva);
        }
    }

}
