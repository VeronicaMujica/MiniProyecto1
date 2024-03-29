package Cliente;

public class Clientes {
    private String nombre;
    private String cedula;
    private double nivelIngresos;
    private String fechaCreacion;

    public Clientes(String nombre, String cedula, double nivelIngresos, String fechaCreacion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nivelIngresos = nivelIngresos;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getNivelIngresos() {
        return nivelIngresos;
    }

    public void setNivelIngresos(double nivelIngresos) {
        this.nivelIngresos = nivelIngresos;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String toString() {
        return "Cliente:" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nivelIngresos=" + nivelIngresos +
                ", fechaCreacion='" + fechaCreacion + '\'';
    }
}
