package models;

public class Registro {
    private String Dni;
    private int numeroTest;
    private static int numeroTestStatic= 1;
    private int temperatura;

    public Registro(String dni, int temperatura) {
        this.numeroTest = numeroTestStatic++;
        Dni = dni;
        this.temperatura = temperatura;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getNumeroTest() {
        return numeroTest;
    }

    @Override
    public String toString() {
        return "Registro{ numeroTest " + numeroTest+
                ", Dni='" + Dni + '\'' +
                ", temperatura='" + temperatura + '\'' +
                '}';
    }
}
