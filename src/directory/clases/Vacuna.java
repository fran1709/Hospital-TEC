package directory.clases;

import java.time.LocalDate;
import java.util.Date;

public class Vacuna {
  //Atributos
  private Date fechaAplicacion;
  private String nombreVacuna;
  private String farmaceutica;
  private int numLote;



  public Vacuna(Date fechaAplicacion, String nombreVacuna, String farmaceutica, int numLote) {
    this.fechaAplicacion = fechaAplicacion;
    this.nombreVacuna = nombreVacuna;
    this.farmaceutica = farmaceutica;
    this.numLote = numLote;
  }


  // Metodos accesores.
  public Date getFechaAplicacion() {
    return fechaAplicacion;
  }
  public void setFechaAplicacion(Date fechaAplicacion) {
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
