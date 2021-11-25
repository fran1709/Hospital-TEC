package directory.clases;

import directory.auxiliarclases.Exportable;

import java.awt.Desktop;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marco y Francisco
 */
public class Paciente extends Usuario implements Exportable{
  //Atributos
  private Date fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String lugarResidencia;
  private ArrayList<String> numerosTelefonicos;
  private ArrayList<Vacuna> vacunasAplicadas;
  private String historial;
  private ArrayList<Cita> citas;
  private ArrayList<Diagnostico> diagnosticos;
  private ArrayList<Tratamiento> tratamientos;
  private ArrayList<Hospitalizacion> hospitalizaciones;


  /**
   *  Constructor de clase
   * @param usuario
   * @param contrasehna
   * @param nombre
   * @param cedula
   * @param fechaNacimiento
   * @param tipoSangre
   * @param nacionalidad
   * @param lugarResidencia
   * @param numerosTelefonicos
   * @param vacunasAplicadas
   */
  public Paciente(String usuario, String contrasehna, String nombre, String cedula, Date fechaNacimiento, String tipoSangre,
                  String nacionalidad, String lugarResidencia, ArrayList<String> numerosTelefonicos, ArrayList<Vacuna> vacunasAplicadas) {
    this.fechaNacimiento = fechaNacimiento;
    this.tipoSangre = tipoSangre;
    this.nacionalidad = nacionalidad;
    this.lugarResidencia = lugarResidencia;
    this.numerosTelefonicos = numerosTelefonicos;
    this.vacunasAplicadas = vacunasAplicadas;
    this.citas = new ArrayList<>();
    this.setUsuario(usuario);
    this.setContrasenha(contrasehna);
    this.setNombre(nombre);
    this.setCedula(cedula);
    this.historial = "Se ha registrado al paciente en el sistema. Fecha:" + LocalDate.now() + "\n";
    this.citas = new ArrayList<>();
    this.hospitalizaciones = new ArrayList<>();
    this.tratamientos = new ArrayList<>();
    this.diagnosticos = new ArrayList<>();
  }
  public void Paciente(){}

  /* FUNCIONALIDADES DEL PACIENTE */

  public void reportarCitasHTML (ArrayList<Cita> citas) {
    try {
      File f = new File(".../src/htmls/UltimoReporteCitasPaciente.html");
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
      File f = new File(".../src/htmls/UltimoReporteDiagnosticosPaciente.html");
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
      File f = new File(".../src/htmls/UltimoReporteTratamientosPaciente.html");
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

  public void reportarHistorial () {
    try {
      File f = new File(".../src/htmls/UltimoReporteHistorialPaciente.html");
      BufferedWriter bw = new BufferedWriter(new FileWriter(f));
      bw.write("<html>");
      bw.write("<head><title>Historial</title></head>");
      bw.write("<body>");
      bw.write("<p>" + this.historial + "</p>");
      bw.write("</html>");
      bw.close();
      Desktop.getDesktop().browse(f.toURI());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Agregar cita ya validada a la lista de citas
   * @param cita cita que va a ser anhadida
   */
  public void solicitarCita(Cita cita){
    cita.setEstadoCita("Registrada");
    this.citas.add(cita);
    this.historial += "Se ha registrado la cita" + cita.getIdentificador() + "en el sistema. Fecha:" + LocalDate.now() + "\n";
  }

  /**
   * Cancela una cita
   * @param identificarCita
   */
  public void cancelarCita(int identificarCita){
    for (Cita cita : this.citas) {
      cita.setEstadoCita("Cancelada por paciente");
      this.historial += "Se ha cancelado la cita" + cita.getIdentificador() + "en el sistema. Fecha:" + LocalDate.now() + "\n";
    }
  }

  /** CONSULTAS DE CITAS **/
  /**
   * Retorna un array de citas de acuerdo al estado que se desee
   * @param estado
   * @return
   */
  public ArrayList<Cita> citasDePacientePorEstado (String estado) {
    ArrayList<Cita> tmp = new ArrayList<>();
    for (Cita cita : this.citas) {
      if (cita.getEstadoCita().equals(estado)) {
        tmp.add(cita);
      }
    }
    reportarCitasHTML(tmp);
    return tmp;
  }

  /**
   * Retorna un array de citas de acuerdo a la especialiddd que se desee
   * @param especialidad
   * @return
   */
  public ArrayList<Cita> citasDePacientePorEspecialidad (String especialidad) {
    ArrayList<Cita> tmp = new ArrayList<>();
    for (Cita cita : this.citas) {
      if (cita.getEspecialidad().equals(especialidad)) {

        tmp.add(cita);
      }
    }
    reportarCitasHTML(tmp);
    return tmp;
  }

  /**
   * Retorna un array de citas por un rango de fechas dado
   * @param fechaFinal
   * @param fechaInicio
   * @return
   */
  public ArrayList<Cita> citasDePacientePorFecha (Date fechaInicio, Date fechaFinal) {
    ArrayList<Cita> tmp = new ArrayList<>();
    for (Cita cita : this.citas) {
      if (fechaInicio.after(cita.getFechaCita()) && fechaFinal.before(fechaFinal)){
        tmp.add(cita);
      }
    }
    reportarCitasHTML(tmp);
    return tmp;
  }
  /** CONSULTAS DE DIAGNOSTICOS **/
  /**
   * Retorna diagnosticos del paciente de acuerdo a un nivel
   * @param nivel
   * @return
   */
  public ArrayList<Diagnostico> diagnosticosPorNivel (String nivel) {
    ArrayList<Diagnostico> tmp = new ArrayList<>();
    for (Cita cita: this.citas) {
      for (Diagnostico diagnostico : cita.getDiagnosticos()) {
        if (diagnostico.getNivel().equals(nivel))
          tmp.add(diagnostico);
      }
    }
    reportarDiagnosticoHTML(tmp);
    return tmp;
  }
  /**
   * Retorna una lista de diagnosticos del paciente de acuerdo al nombre dado
   * @param nombre
   * @return
   */
  public ArrayList<Diagnostico> diagnosticosPorNombre (String nombre) {
    ArrayList<Diagnostico> tmp = new ArrayList<>();
    for (Cita cita: this.citas) {
      for (Diagnostico diagnostico : cita.getDiagnosticos()) {
        System.out.println(diagnostico.toString());
        if (diagnostico.getNombre().equals(nombre))
          tmp.add(diagnostico);
      }
    }
    reportarDiagnosticoHTML(tmp);
    return tmp;
  }

  /**
   * Retorna una lista de diagnostivos por las citas de una fecha determinada
   * @param fechaInicio
   * @param fechaFinal
   * @return
   */
  public ArrayList<Diagnostico> diagnosticosPorFecha (Date fechaInicio, Date fechaFinal) {
    ArrayList<Cita> pCitas = this.citasDePacientePorFecha(fechaInicio,fechaFinal);
    ArrayList<Diagnostico> tmp = new ArrayList<>();
    for (Cita cita : pCitas) {
      tmp.addAll(cita.getDiagnosticos());
    }
    reportarDiagnosticoHTML(tmp);
    return tmp;
  }

  /** CONSULTAS DE TRATAMIENTOS **/
  /**
   * Retorna una lista de tratamientos por fecha
   * @param fechaInicio
   * @param fechaFinal
   * @return
   */
  public ArrayList<Tratamiento> tratamientosPorFecha(Date fechaInicio, Date fechaFinal){
    ArrayList<Diagnostico> pDiagnosticos = this.diagnosticosPorFecha(fechaInicio,fechaFinal);
    ArrayList<Tratamiento> tmp = new ArrayList<>();

    for (Diagnostico diagnostico : pDiagnosticos) {
      tmp.addAll(diagnostico.getTratamientos());
    }
    reportarTratamientoHTML(tmp);
    return tmp;
  }

  /**
   * Metodo que ayuda a crear una lista de los tratamientos del paciente por tipo
   * @param tipo
   * @return
   */
  public ArrayList<Tratamiento> tratamientosPorTipo(String tipo){
    ArrayList<Tratamiento> trats = new ArrayList<>();
    for (Cita cita : this.citas) {
      trats.addAll(cita.tratamientosPorTipo(tipo));
    }
    reportarTratamientoHTML(trats);
    return trats;
  }

  /**
   * Metodo que ayuda a crear una lista de los tratamientos de paciente por nombre
   * @param nombre
   * @return
   */
  public ArrayList<Tratamiento> tratamientosPorNombre (String nombre ) {
    ArrayList<Tratamiento> trats = new ArrayList<>();
    for (Cita cita : this.citas) {
      trats.addAll(cita.tratamientosPorNombre(nombre));
    }
    reportarTratamientoHTML(trats);
    return trats;
  }

  /**
   * Retorna hospitalizacion en el lapso de la fecha dada
   * @param fechaInicio
   * @param fechaFinal
   * @return
   */

  public ArrayList<Hospitalizacion> hospitalizacionesPorFecha(Date fechaInicio, Date fechaFinal) {
    ArrayList<Hospitalizacion> hospitalizacionArrayList = new ArrayList<>();
    for (Hospitalizacion hosp : this.hospitalizaciones) {
      if (fechaInicio.after(hosp.getFechaInicio()) && fechaFinal.before(fechaFinal)){
        hospitalizacionArrayList.add(hosp);
      }
    }
    return hospitalizacionArrayList;
  }

  /**
   * Metodo que retorna lista de hospitalizaciones de acuerdo a un estado dado
   * @param especialidadHosp
   * @return
   */
  public ArrayList<Hospitalizacion> hospitalizacionesPorEspecialidad(String especialidadHosp) {
    ArrayList<Hospitalizacion> hospitalizacionArrayList = new ArrayList<>();
    for (Hospitalizacion hosp : this.hospitalizaciones) {
      if (hosp.especialidad.equals(especialidadHosp)){
        hospitalizacionArrayList.add(hosp);
      }
    }
    return hospitalizacionArrayList;
  }
  /**
   * Metodo que retorna lista de hospitalizaciones de acuerdo a un estado dado
   * @param estadoHosp
   * @return
   */
  public ArrayList<Hospitalizacion> hospitalizacionesPorEstado(String estadoHosp) {
    ArrayList<Hospitalizacion> hospitalizacionArrayList = new ArrayList<>();
    for (Hospitalizacion hosp : this.hospitalizaciones) {
      if (hosp.estado.equals(estadoHosp)){
        hospitalizacionArrayList.add(hosp);
      }
    }
    return hospitalizacionArrayList;
  }

  /**
   * Pone el historial de hospitalizaciones
   * @return
   */
  public String historialPaciente() {
    reportarHistorial();
    return this.historial;
  }
  /**
   * Metodo para actualizar historial de paciente
   * @return
   */
  public void actualizarHistorial(String bitacora) {
    this.historial += bitacora +" Fecha: " + LocalDate.now();
  }

  public void exportarPDF() {}
  public void exportarHTML(){}
  public void exportarCSV(){}

  /**
   * Metodo para agregar hospitalizacion
   * @param hospitalizacion
   */
  public void agregarHospitalizacion(Hospitalizacion hospitalizacion){
    this.hospitalizaciones.add(hospitalizacion);
  }
  // Metodos accesores.
  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  public String getTipoSangre() {
    return tipoSangre;
  }
  public void setTipoSangre(String tipoSangre) {
    this.tipoSangre = tipoSangre;
  }
  public String getNacionalidad() {
    return nacionalidad;
  }
  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }
  public String getLugarResidencia() {
    return lugarResidencia;
  }
  public void setLugarResidencia(String lugarResidencia) {
    this.lugarResidencia = lugarResidencia;
  }
  public ArrayList<String> getNumerosTelefonicos() {
    return numerosTelefonicos;
  }
  public void setNumerosTelefonicos(ArrayList<String> numerosTelefonicos) {
    this.numerosTelefonicos = numerosTelefonicos;
  }
  public ArrayList<Vacuna> getVacunasAplicadas() {
    return vacunasAplicadas;
  }
  public void setVacunasAplicadas(ArrayList<Vacuna> vacunasAplicadas) {
    this.vacunasAplicadas = vacunasAplicadas;
  }
  public ArrayList<Cita> getCitas() {
    return citas;
  }

  public void setCitas(ArrayList<Cita> citas) {
    this.citas = citas;
  }

  public ArrayList<Diagnostico> getDiagnosticos() {
    return diagnosticos;
  }

  public void setDiagnosticos(ArrayList<Diagnostico> diagnosticos) {
    this.diagnosticos = diagnosticos;
  }

  public ArrayList<Tratamiento> getTratamientos() {
    return tratamientos;
  }

  public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
    this.tratamientos = tratamientos;
  }
  public ArrayList<Hospitalizacion> getHospitalizaciones() {
    return hospitalizaciones;
  }

  public void setHospitalizaciones(ArrayList<Hospitalizacion> hospitalizaciones) {
    this.hospitalizaciones = hospitalizaciones;
  }

  public void printPaciente(){
    String msg = "Paciente{" + "\n"+
            "Nombre: " + getNombre() + "\n"+
            "Fecha Nacimiento: " + getFechaNacimiento() + "\n"+
            "Cedula: " + getCedula() + "\n"+
            "Usuario: " + getUsuario() + "\n"+
            "Contraseña: " + getContrasenha() + "\n"+
            "Lugar de Residencia: " + getLugarResidencia() + "\n"+
            "Nacionalidad: " + getNacionalidad() + "\n";
    System.out.println(msg);
    System.out.println("NUMEROS TELEFONICOS");
    for (String cel : this.numerosTelefonicos)
      System.out.println(cel);
    System.out.println("VACUNAS");
    for (Vacuna vacuna : this.vacunasAplicadas)
      System.out.println(vacuna.toString());
    System.out.println("CITAS");
    for (Cita cita : this.citas)
      cita.printCita();
    System.out.println("TRATAMIENTOS");
    for (Tratamiento tratamiento : this.tratamientos)
      tratamiento.printTratamiento();
    System.out.println("DIAGNOSTICOS");
    for (Diagnostico diagnostico : this.diagnosticos)
      diagnostico.printDiagnostico();
    System.out.println("HOSPITALIZACIONES");
    for (Hospitalizacion hospitalizacion : this.hospitalizaciones)
      System.out.println(hospitalizacion.toString());
  }
  @Override
  public String toString() {
    return "Nombre: " + getNombre() ;
            /*"Paciente{" + "\n"+
            +
            "Fecha Nacimiento: " + getFechaNacimiento() + "\n"+
            "Cedula: " + getCedula() + "\n"+
            "Usuario: " + getUsuario() + "\n"+
            "Contraseña: " + getContrasenha() + "\n"+
            "Lugar de Residencia: " + getLugarResidencia() + "\n"+
            "Nacionalidad: " + getNacionalidad() + "\n"+
            "Tipo de Sangre: " + getTipoSangre() + "\n"+
            "Numeros Telefonicos: " + getNumerosTelefonicos() + "\n"+
            "Vacunas=" + getVacunasAplicadas() + "\n"+
            '}';
            /*
  */
  }


}
