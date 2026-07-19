package cinenova.model;

public class Empleado {
    private int idEmpleado;
    private String cedula;
    private String nombre;
    private String apellidos;
    private String cargo;
    private String areaTrabajo;
    private String turnoHorario;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String cedula, String nombre, String apellidos, String cargo, String areaTrabajo, String turnoHorario) {
        this.idEmpleado = idEmpleado;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.areaTrabajo = areaTrabajo;
        this.turnoHorario = turnoHorario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getTurnoHorario() {
        return turnoHorario;
    }

    public void setTurnoHorario(String turnoHorario) {
        this.turnoHorario = turnoHorario;
    }
}