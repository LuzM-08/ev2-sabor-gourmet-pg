package cl.ipss.saborgourmetev02.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int cantSillas;
    private String disponible;


    public String getDisponible() {
        return disponible;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva")
    private Reservas reservas;


    public Mesas(int cantSillas, String disponible) {
        this.cantSillas = cantSillas;
        this.disponible = disponible;
    }
    
    public Mesas() { 
    }
    
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public int getCantSillas() {
        return cantSillas;
    }


    public void setCantSillas(int cantSillas) {
        this.cantSillas = cantSillas;
    }


    public String isDisponible() {
        return disponible;
    }


    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }


    public Reservas getReserva() {
        return reservas;
    }


    public void setReserva(Reservas reservas) {
        this.reservas = reservas;
    }



}