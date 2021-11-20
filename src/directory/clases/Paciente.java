package directory.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marco y Francisco
 */
public class Paciente extends Usuario{
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
    this.setUsuario(usuario);
    this.setContrasenha(contrasehna);
    this.setNombre(nombre);
    this.setCedula(cedula);
    this.historial = "Se ha registrado al paciente en el sistema. Fecha:" + LocalDate.now() + "\n";
  }
  public void Paciente(){}

  /* FUNCIONALIDADES DEL PACIENTE */

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
        if (diagnostico.getNombre().equals(nombre))
          tmp.add(diagnostico);
      }
    }
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
    return trats;
  }

  /**
   * Pone el historial de hospitalizaciones
   * @return
   */
  public String historialPaciente(){return this.historial;}
  /**
   * Metodo para actualizar historial de paciente
   * @return
   */
  public void actualizarHistorial(String bitacora) {
    this.historial += bitacora +" Fecha: " + LocalDate.now();
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


}
