package directory.clases;

import java.util.ArrayList;

public class Diagnostico {

    public Diagnostico(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tratamientos = new ArrayList<>();
    }

    //Atributos
    private String nombre;
    private String nivel;
    private ArrayList<Tratamiento> tratamientos;

    /**
     * Retorna tratamientos por tipo
     * @param tipo
     * @return
     */
    public ArrayList<Tratamiento> tratamientosPorTipo(String tipo) {
        ArrayList<Tratamiento> trats = new ArrayList<>();
        for (Tratamiento tratamiento: this.tratamientos) {
            if (tratamiento.getTipo().equals(tipo))
                trats.add(tratamiento);

        }
        return trats;
    }

    /**
     * Metood que retorna una lista de tratamientos por nombre
     * @param nombre
     * @return
     */
    public ArrayList<Tratamiento> tratamientosPorNombre(String nombre) {
        ArrayList<Tratamiento> trats = new ArrayList<>();
        for (Tratamiento tratamiento: this.tratamientos) {
            if (tratamiento.getNombre().equals(nombre))
                trats.add(tratamiento);

        }
        return trats;
    }

    public ArrayList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
