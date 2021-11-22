package directory.clases;

/**
 * @author Marco
 */
public class Tratamiento {
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     * @param dosis
     * @param tipo
     */
    public Tratamiento(String nombre, int dosis, String tipo) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Attributes
    private String nombre;
    private int dosis;
    private String tipo;

    public void printTratamiento() {
        String msg = "Tratamiento: " +
                "nombre='" + nombre + '\n' +
                ", dosis=" + dosis + '\n' +
                ", tipo='" + tipo + '\n' ;
        System.out.println(msg);
    }
    @Override
    public String toString() {
        return "Tratamiento: " + nombre;
    }
}
