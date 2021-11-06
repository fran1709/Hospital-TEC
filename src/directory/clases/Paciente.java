package directory.clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente {
  //Atributos
  private String cedula;
  private String nombre;
  private LocalDate fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String lugarResidencia;
  private ArrayList<String> numerosTelefonicos;
  private ArrayList<Vacuna> vacunasAplicadas;

  /**
   * Constructor de la clase.
   */
  public Paciente() {
    ;
  }

  // Metodos accesores.
  public String getCedula() {
    return cedula;
  }
  public void setCedula(String cedula) {
    this.cedula = cedula;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
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
