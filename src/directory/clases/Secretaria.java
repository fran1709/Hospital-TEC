package directory.clases;

import directory.auxiliarclases.Exportable;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marco y Francisco
 */
public class Secretaria extends Funcionario implements Exportable {
    /**
     *
     * @param usuario
     * @param contrasehna
     * @param nombre
     * @param cedula
     */
    public Secretaria (String usuario, String contrasehna, String nombre, String cedula, Date localDate) {
        this.setUsuario(usuario);
        this.setContrasenha(contrasehna);
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.setTipo("Secretaria");
        this.setFechaIngreso(localDate);
    }

    /* FUNCIONALIDADES SECRETARIA */

    public void reportarCitasHTML (ArrayList<Cita> citas) {
        try {
            File f = new File(".../src/htmls/UltimoReporteCitasSecretaria.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html>");
            bw.write("<head><title>Citas</title></head>");
            bw.write("<body>");
            for (Cita cita : citas)
                bw.write("<p>" + cita.toString() + "</p>");
            bw.write("</html>");
            bw.close();
            Desktop.getDesktop().browse(f.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reportarHistorial (String historial) {
        try {
            File f = new File(".../src/htmls/UltimoReporteHistorialSecretaria.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html>");
            bw.write("<head><title>Historial</title></head>");
            bw.write("<body>");
            bw.write("<p>" + historial + "</p>");
            bw.write("</html>");
            bw.close();
            Desktop.getDesktop().browse(f.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que cancela una cita
     * @param paciente
     * @param identificador
     */
    public void cancelarCita(Paciente paciente, int identificador) {
        for (Cita cita : paciente.getCitas()) {

            if (cita.getIdentificador() == identificador) {
                cita.setEstadoCita("Cita cancelada por la secretaria " + this.getNombre());
                cita.actualizarBitacora("Fecha: " +  LocalDateTime.now() + "Se ha cancelado la cita a nombre del funcionario  " + this.getNombre());
                paciente.actualizarHistorial("Se ha cancelado la cita ID: " + cita.getIdentificador() +" a nombre del funcionario " + this.getNombre());
                cita.setEstadoCita("Cancelada por el centro m??dico");
                cita.printCita();
            }
        }
        //System.out.println("El paciente no tiene citas");
    }

    /**
     * Metodo que agrega una cita
     * @param paciente
     * @param especialidad
     * @param fechaCita
     * @param comentario
     * @param identificador
     */
    public void asignarCita(Paciente paciente, String especialidad, Date fechaCita, String comentario, int identificador, int hora) {
        Cita pCita = new Cita(especialidad,fechaCita,comentario,identificador, hora);
        pCita.actualizarBitacora("Fecha: " +  LocalDateTime.now() + "Se ha asignado la cita a nombre del funcionario " + this.getNombre());
        pCita.setEstadoCita("Asignada");
        paciente.getCitas().add(pCita);
        paciente.actualizarHistorial("Se ha asignado la cita ID: " + pCita.getIdentificador() +" a nombre del funcionario " + this.getNombre());
    }
    /**
     * Metodo que retorna la cantidad total de citas en el sistema por fecha
     * @param pacientes
     * @param fechaInicio
     * @param fechaFinal
     * @return
     */
    public ArrayList<Cita> cantidadCitasPorFecha(ArrayList<Paciente> pacientes, Date fechaInicio, Date fechaFinal){
        ArrayList<Cita> citas = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            citas.addAll(paciente.citasDePacientePorFecha(fechaInicio,fechaFinal));
        }
        reportarCitasHTML(citas);
        return citas;
    }
    /**
     * Metodo que retorna la cantidad total de citas en el sistema por estado de la cita
     * @param pacientes
     * @param estado
     * @return
     */
    public ArrayList<Cita> cantidadCitasPorEstado(ArrayList<Paciente> pacientes, String estado){
        ArrayList<Cita> citas = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            citas.addAll(paciente.citasDePacientePorEstado(estado));
        }
        reportarCitasHTML(citas);
        return citas;
    }
    /**
     * Metodo que retorna la cantidad total de citas en el sistema por especialidad de la cita
     * @param pacientes
     * @param especialidad
     * @return
     */
    public ArrayList<Cita> cantidadCitasPorEspecialidad(ArrayList<Paciente> pacientes, String especialidad){
        ArrayList<Cita> citas = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            citas.addAll(paciente.citasDePacientePorEspecialidad(especialidad));
        }
        reportarCitasHTML(citas);
        return citas;
    }

    /**
     * Retorna una lista de citas de acuerdo al nombre de un paciente
     * @param pacientes
     * @param nombre
     * @return
     */
    public  ArrayList<Cita> cantidadCitasDeUnPaciente (ArrayList<Paciente> pacientes, String nombre) {

        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equals(nombre))
                return paciente.getCitas();
        }
        return null;
    }

    /**
     * Metodo que retorna todos los historiales de los pacientes en un string
     * @param pacientes
     * @return
     */
    public String hospitalizacionesEnSistema(ArrayList<Paciente> pacientes) {

        String msg = "\n";
        for (Paciente paciente : pacientes) {
            msg += "Nombre: " + paciente.getNombre() +" \n";
            msg += "Historial de Paciente: " + "\n";
            msg += paciente.historialPaciente();

        }
        reportarHistorial(msg);
        return msg;
    }

    @Override
    public String toString() {
        return "Secretaria{" + "\n"+
                "Nombre: " + getNombre() + "\n"+
                "Cedula: " + getCedula() + "\n"+
                "Usuario: " + getUsuario() + "\n"+
                "Contrase??a: " + getContrasenha() + "\n"+
                '}';
    }

    @Override
    public void exportarPDF() {}

    @Override
    public void exportarCSV() {}

    @Override
    public void exportarHTML() {}
}
