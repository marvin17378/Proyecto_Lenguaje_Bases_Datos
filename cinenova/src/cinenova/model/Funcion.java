package cinenova.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Funcion {
    private int idFuncion;
    private int idPelicula;
    private int idSala;
    private LocalDate fecha;
    private LocalDateTime horaInicio;

    public Funcion() {
    }

    public Funcion(int idFuncion, int idPelicula, int idSala, LocalDate fecha, LocalDateTime horaInicio) {
        this.idFuncion = idFuncion;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }
}