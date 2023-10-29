public class Cliente {
    private String RUT;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String tipoLicencia;

    public Cliente(String RUT, String nombre, String apellido, String fechaNacimiento) {
        this.RUT = RUT;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoLicencia = tipoLicencia;
    }


    public boolean validarRut() {
        // implementar la validacion de RUT
        String rutSinGuiones = RUT.replace("-", "");
        if (rutSinGuiones.length() != 9) {
            System.out.println("El RUT debe tener 9 caracteres (sin guiones).");
            return false;
        }

        try {
            int rutNumerico = Integer.parseInt(rutSinGuiones.substring(0, 8));
            // DV significa digito verificador
            char dvCalculado = calcularDV(rutNumerico);
            char dvIngresado = rutSinGuiones.charAt(8);

            if (dvCalculado == dvIngresado) {
                System.out.println("RUT valido. ");
                return true;
            } else {
                System.out.println("el digito verificador del RUT es incorrecto. ");
                return false;
            }


        } catch (NumberFormatException e) {
            System.out.println("el RUT contiene caracteres no validos");
            return false;

        }

    }
    private char calcularDV(int rut){
        int m = 0;
        int s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        // en este codigo si el valor es igual a 11, se considera como 0. Para manejar esto en el código, se usa el operador condicional (? :).
        return (char) (s != 0 ? s + 47 : 75);
    }
    public boolean validarLincencia(){
        String[] tiposValidos = {"A1", "A2", "A3", "B", "C"};
        if (tipoLicencia != null && (tipoLicencia.equals("B") || tipoLicencia.equals("C")|| tipoLicencia.equals("A1")
                || tipoLicencia.equals("A2")|| tipoLicencia.equals("A3"))) {
            System.out.println("licencia valida. ");
            return true;
        } else {
            System.out.println("licencia no valida. ");
            return false;
        }
    }

    public String getRUT() {
        return RUT;
    }


    public String getApellido(){
        return apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }


}





