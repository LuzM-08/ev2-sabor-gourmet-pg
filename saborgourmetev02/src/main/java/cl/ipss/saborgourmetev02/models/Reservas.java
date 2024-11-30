package cl.ipss.saborgourmetev02.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomCliente;
    private String apeCliente;
    private String fecha;

    /*
     * @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservas", cascade =
     * CascadeType.ALL)
     * private List<Mesas> mesas;
     */

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservas", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Mesas> mesas;

    public Reservas(String nomCliente, String apeCliente, String fecha) {
        this.nomCliente = nomCliente;
        this.apeCliente = apeCliente;
        this.fecha = fecha;
    }

    public Reservas() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApeCliente() {
        return apeCliente;
    }

    public void setApeCliente(String apeCliente) {
        this.apeCliente = apeCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Mesas> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesas> mesas) {
        this.mesas = mesas;
    }

}
