package directory.clases;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marco
 */
public class Hospitalizacion {

    // Atributos
    Date fechaInicio;
    Date fechaSalida;
    CentroAtencion centroAtencion;
    FuncionarioMedicina funcionarioMedicina;
    ArrayList<Diagnostico> diagnosticos;
    String especialidad;
    String estado;

    @Override
    public String toString() {
        String msg = "Diagnosticos:     ";
        for (Diagnostico diagnostico : diagnosticos) {
            msg += diagnostico.toString()+ "          ";
        }
        return "Hospitalizacion:    " + "             " +
                "fechaInicio =" + fechaInicio + "             " +
                ", fechaSalida =" + fechaSalida + "             " +
                ", centroAtencion =" + centroAtencion + "             " +
                ", funcionarioMedicina =" + funcionarioMedicina.getNombre() + "             " +
                ", especialidad ='" + especialidad + "             "+
                ", estado = " + estado + "             "+
                msg;


    }

    /**
     *
     * @param fechaInicio
     * @param centroAtencion
     * @param funcionarioMedicina
     * @param diagnosticos
     * @param especialidad
     */
    public Hospitalizacion(Date fechaInicio, CentroAtencion centroAtencion, FuncionarioMedicina funcionarioMedicina, ArrayList<Diagnostico> diagnosticos, String especialidad) {
        this.fechaInicio = fechaInicio;
        this.centroAtencion = centroAtencion;
        this.funcionarioMedicina = funcionarioMedicina;
        this.diagnosticos = diagnosticos;
        this.especialidad = especialidad;
        this.estado = "Hospitalizado.";
    }


    // Metodos accesores
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public CentroAtencion getCentroAtencion() {
        return centroAtencion;
    }

    public void setCentroAtencion(CentroAtencion centroAtencion) {
        this.centroAtencion = centroAtencion;
    }

    public FuncionarioMedicina getFuncionarioMedicina() {
        return funcionarioMedicina;
    }

    public void setFuncionarioMedicina(FuncionarioMedicina funcionarioMedicina) {
        this.funcionarioMedicina = funcionarioMedicina;
    }

    public ArrayList<Diagnostico> getDiagnostico() {
        return diagnosticos;
    }

    public void setDiagnostico(ArrayList<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
