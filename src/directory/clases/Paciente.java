package directory.clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Marco y Francisco
 */
public class Paciente extends Usuario{
  //Atributos
  private LocalDate fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String lugarResidencia;
  private ArrayList<String> numerosTelefonicos;
  private ArrayList<Vacuna> vacunasAplicadas;

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
  public Paciente(String usuario, String contrasehna, String nombre, String cedula, LocalDate fechaNacimiento, String tipoSangre,
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
  }

  /* FUNCIONALIDADES DEL PACIENTE */
  public void solicitarCita(){}
  public void cancelarCita(){}
  public String citasDePaciente(){ return "";}
  public String diagnosticosPaciente(){return "";}
  public String tratamientosPaciente(){return "";}
  public String historialPaciente(){return "";}


  // Metodos accesores.
  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
}
