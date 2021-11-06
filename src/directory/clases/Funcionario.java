package directory.clases;

import java.time.LocalDate;

public abstract class Funcionario {
  //Atributos.
  private String cedula;
  private String nombre;
  private String tipo; //(Doctor(a), Enfermero(a), Secretario(a))
  private String areaTrabajo;
  private LocalDate fechaIngreso;

  // Metodos accesores.
  public String getCedula() {
    return cedula;
  }
  public void setCedula(String pCedula) {
    this.cedula = pCedula;
  }
  public String getTipo() {
    return tipo;
  }
  public void setTipo(String pTipo) {
    this.tipo = pTipo;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }
  public String getAreaTrabajo() {
    return areaTrabajo;
  }
  public void setAreaTrabajo(String pAreaTrabajo) {
    this.areaTrabajo = pAreaTrabajo;
  }
  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }
  public void setFechaIngreso(LocalDate pFechaIngreso) {
    this.fechaIngreso = pFechaIngreso;
  }
}
