package cinenova.model;

public class Sala {
    private int idSala;
    private int numeroSala;
    private int capacidadTotal;
    private String tipoSala;

    public Sala() {
    }

    public Sala(int idSala, int numeroSala, int capacidadTotal, String tipoSala) {
        this.idSala = idSala;
        this.numeroSala = numeroSala;
        this.capacidadTotal = capacidadTotal;
        this.tipoSala = tipoSala;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }
}