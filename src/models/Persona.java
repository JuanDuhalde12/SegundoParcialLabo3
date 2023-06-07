package models;

public class Persona {
    private String  nombre, edad, barrio, DNI , ocupación;

    public Persona(String nombre, String edad, String barrio, String DNI, String ocupación) {
        this.nombre = nombre;
        this.edad = edad;
        this.barrio = barrio;
        this.DNI = DNI;
        this.ocupación = ocupación;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getOcupación() {
        return ocupación;
    }

    public void setOcupación(String ocupación) {
        this.ocupación = ocupación;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", barrio='" + barrio + '\'' +
                ", DNI='" + DNI + '\'' +
                ", ocupación='" + ocupación + '\'' +
                '}';
    }
}
