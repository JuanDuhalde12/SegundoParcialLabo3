package Exception;

public class AislarException extends Exception{
    private String barrio;
    private int numeroTest;

    public AislarException(String msg, String barrio, int numeroTest) {
        super(msg + "en el barrio: "+ barrio + " con el numero de Test: "+ numeroTest );
    }
}
