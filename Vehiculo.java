import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vehiculo {
    private String patente;
    private int numeroRuedas;
    private String tipoVehiculo;
    private int numeroAsientos;
    private String estado;

    public  Vehiculo(String patente, int numeroAsientos, String tipoVehiculo,  String estado, int numeroRuedas){
        this.patente = patente;
        this.numeroRuedas = numeroRuedas;
        this.tipoVehiculo = tipoVehiculo;
        this.numeroAsientos = numeroAsientos;
        this.estado = estado;
    }

    public boolean validarPatente() {
        // es una expresión regular que se utiliza para validar si una cadena cumple con un patrón específico.
        String patenteRegex = "^[A-Z]{4}-\\d{2}$";
        Pattern pattern = Pattern.compile(patenteRegex);
        Matcher matcher = pattern.matcher(patente);

        if (matcher.matches()) {
            System.out.println("patente valida. ");
            return true;
        } else {
            System.out.println("patente no valida. debe tener el formato ABCD-12. ");
            return false;
        }
    }

    public String getPatente() {
        return patente;
    }
}


