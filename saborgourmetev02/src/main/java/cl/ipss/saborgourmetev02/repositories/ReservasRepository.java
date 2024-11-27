package cl.ipss.saborgourmetev02.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import cl.ipss.saborgourmetev02.models.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas, Long>{
@Query("SELECT r FROM Reservas r JOIN FETCH r.mesas")
    List<Reservas> findAllWithMesas();
}
