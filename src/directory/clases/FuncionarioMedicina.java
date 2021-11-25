package directory.clases;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class FuncionarioMedicina extends Funcionario{



    /* FUNCIONALIDADES DOCTOR y ENFERMERO*/

    /** CITAS **/

    public void reportarCitasHTML (ArrayList<Cita> citas) {
        try {
            File f = new File(".../src/htmls/UltimoReporteCitasFuncionarioM.html");
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

    public void reportarDiagnosticoHTML (ArrayList<Diagnostico> citas) {
        try {
            File f = new File(".../src/htmls/UltimoReporteDiagnosticosFuncionarioM.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html>");
            bw.write("<head><title>Diagnostico</title></head>");
            bw.write("<body>");
            for (Diagnostico cita : citas)
                bw.write("<p>" + cita.toString() + "</p>");
            bw.write("</html>");
            bw.close();
            Desktop.getDesktop().browse(f.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reportarTratamientoHTML (ArrayList<Tratamiento> citas) {
        try {
            File f = new File(".../src/htmls/UltimoReporteTratamientosFuncionarioM.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html>");
            bw.write("<head><title>Tratamiento</title></head>");
            bw.write("<body>");
            for (Tratamiento cita : citas)
                bw.write("<p>" + cita.toString() + "</p>");
            bw.write("</html>");
            bw.close();
            Desktop.getDesktop().browse(f.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cancelar cita de paciente
     * @param paciente
     * @param identificadorCita
     */
    public void cancelarCita(Paciente paciente, int identificadorCita) {
        for (Cita cita : paciente.getCitas()) {
            if (cita.getIdentificador() == identificadorCita) {
                cita.setEstadoCita("Cita cancelada por el funcionario de medicina" + this.getNombre());
                cita.actualizarBitacora("Fecha: " +  LocalDateTime.now() + "Se ha cancelado la cita a nombre del funcionario de medicina " + this.getNombre());
                paciente.actualizarHistorial("Se ha cancelado la cita ID: " + cita.getIdentificador() +" a nombre del funcionario de medicina " + this.getNombre());
                cita.setEstadoCita("Cancelada por funcionario de medicina");
                cita.printCita();
            }
        }

    }

    /**
     * Metodo para que un funcionario de medicina asigne una cita
     * @param paciente
     */
    public void asignarCita(Paciente paciente, String especialidad, Date fechaCita, String comentario, int identificador, int hora){
        Cita pCita = new Cita(especialidad,fechaCita,comentario,identificador, hora);
        pCita.actualizarBitacora("Fecha: " +  LocalDateTime.now() + "Se ha asignado la cita a nombre del funcionario de medicina " + this.getNombre());
        pCita.setEstadoCita("Asignada");
        paciente.getCitas().add(pCita);
        paciente.actualizarHistorial("Se ha asignado la cita ID: " + pCita.getIdentificador() +" a nombre del funcionario de medicina " + this.getNombre());
        pCita.printCita();
    }


    /** DIAGNOSTICOS **/


    /**
     * Metodo para retornar un arraylist de diagnosticos asociados a un paciente de acuerdo a un rango de fechas
     * @param paciente
     * @param fechaInicio
     * @param fechaFinal
     * @return
     */
    public ArrayList<Diagnostico> diagnosticosPacientePorFecha(Paciente paciente, Date fechaInicio, Date fechaFinal) {
        return paciente.diagnosticosPorFecha(fechaInicio,fechaFinal);
    }

    /**
     * Metodo que retorna una lista de diagnosticos de acuerdo a un nivel dado
     * @param paciente
     * @param nivel
     * @return
     */
    public ArrayList<Diagnostico> diagnosticosPacientePorNivel(Paciente paciente, String nivel){
        return paciente.diagnosticosPorNivel(nivel);
    }

    /**
     * Metodo que retorna una lista de diagnosticos de acuerdo a un nombre dado
     * @param paciente
     * @param nombre
     * @return
     */
    public ArrayList<Diagnostico> diagnosticosPacientePorNombre(Paciente paciente, String nombre){
        return paciente.diagnosticosPorNombre(nombre);
    }


    /** TRATAMIENTOS **/
    /**
     * Metodo que retorna una lista de tratamientos por fecha
     * @param paciente
     * @param fechaInicio
     * @param fechaFinal
     * @return
     */
    public ArrayList<Tratamiento> tratamientosPacientePorFechas(Paciente paciente, Date fechaInicio, Date fechaFinal) {
        return paciente.tratamientosPorFecha(fechaInicio,fechaFinal);
    }

    /**
     * Metodo que retorna una lista de tratamientos por tipo
     * @param paciente
     * @param tipo
     * @return
     */
    public ArrayList<Tratamiento> tratamientosPacientePorTipo(Paciente paciente,String tipo) {
        return paciente.tratamientosPorTipo(tipo);
    }

    /**
     * Metodo que retorna una lista de tratamientos de acuerdo a un nombre dado
     * @param paciente
     * @param nombre
     * @return
     */
    public ArrayList<Tratamiento> tratamientosPacientePorNombre(Paciente paciente, String nombre) {
        return paciente.tratamientosPorNombre(nombre);
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
        ArrayList<Cita> pCitas = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            pCitas.addAll(paciente.citasDePacientePorEspecialidad(especialidad));
        }
        reportarCitasHTML(pCitas);
        return pCitas;
    }

    /**
     * Metodo que retorna la cantidad de tratamientos generales registrados en pacientes
     * @param pacientes
     * @return
     */
    public ArrayList<Tratamiento> cantidadTratamientosGeneral(ArrayList<Paciente> pacientes) {
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            for (Cita cita : paciente.getCitas()){
                for (Diagnostico diagnostico : cita.getDiagnosticos()){
                    tratamientos.addAll(diagnostico.getTratamientos());
                }
            }
        }
        reportarTratamientoHTML(tratamientos);
        return tratamientos;

    }

    /**
     * Cantidad de tratamientos asociados a los diagnosticos de un paciente
     * @param paciente
     * @return
     */
    public ArrayList<Tratamiento> cantidadTratamientosPorPaciente(Paciente paciente) {
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();

        for (Cita cita : paciente.getCitas()) {
            for (Diagnostico diagnostico : cita.getDiagnosticos()){
                tratamientos.addAll(diagnostico.getTratamientos());
            }
        }
        reportarTratamientoHTML(tratamientos);
        return tratamientos;
    }

    /**
     * Cantidad de tratamientos asociados a los diagnosticos de un paciente
     * @param pacientes
     * @param especialidad
     * @return
     */
    public ArrayList<Tratamiento> cantidadTratamientosPorEspecialidad(ArrayList<Paciente> pacientes, String especialidad) {
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            for (Cita cita : paciente.getCitas()){
                if (cita.getEspecialidad().equals(especialidad)) {
                    for (Diagnostico diagnostico : cita.getDiagnosticos()) {
                        tratamientos.addAll(diagnostico.getTratamientos());
                    }
                }
            }
        }
        reportarTratamientoHTML(tratamientos);
        return tratamientos;
    }

    /**
     * Retorna el historial de un paciente
     * @param paciente
     * @return
     */
    public String detallesPaciente(Paciente paciente){
        return paciente.historialPaciente();
    }


}
