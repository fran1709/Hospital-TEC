package directory.clases;

import java.time.LocalDate;

public class Vacuna {
  //Atributos
  private LocalDate fechaAplicacion;
  private String nombreVacuna;
  private String farmaceutica;
  private int numLote;

  /**
   * Constructor de la clase.
   */
  public Vacuna() {
    ;
  }

  // Metodos accesores.
  public LocalDate getFechaAplicacion() {
    return fechaAplicacion;
  }
  public void setFechaAplicacion(LocalDate fechaAplicacion) {
    this.fechaAplicacion = fechaAplicacion;
  }
  public String getNombreVacuna() {
    return nombreVacuna;
  }
  public void setNombreVacuna(String nombreVacuna) {
    this.nombreVacuna = nombreVacuna;
  }
  public String getFarmaceutica() {
    return farmaceutica;
  }
  public void setFarmaceutica(String farmaceutica) {
    this.farmaceutica = farmaceutica;
  }
  public int getNumLote() {
    return numLote;
  }
  public void setNumLote(int numLote) {
    this.numLote = numLote;
  }
}
