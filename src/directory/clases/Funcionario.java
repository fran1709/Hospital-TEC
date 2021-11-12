package directory.clases;

import java.time.LocalDate;

/**
 * @author Francisco y Marco
 */
public abstract class Funcionario extends Usuario {
  //Atributos.
  private String tipo; //(Doctor(a), Enfermero(a), Secretario(a))
  private String areaTrabajo;
  private LocalDate fechaIngreso;



  // Metodos accesores.

  public String getTipo() {
    return tipo;
  }
  public void setTipo(String pTipo) {
    this.tipo = pTipo;
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
