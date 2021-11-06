package directory.clases;

import java.time.LocalDate;

public class Cita {
  // Atributos.
  private String especialidad; //area
  private LocalDate fechaCita;
  private String comentario;
  private int identificador;
  private String estadoCita;

  /**
   * Constructor de la clase.
   */
  public Cita() {
    ;
  }

  // Metodos accesores.
  public String getEspecialidad() {
    return especialidad;
  }
  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }
  public LocalDate getFechaCita() {
    return fechaCita;
  }
  public void setFechaCita(LocalDate fechaCita) {
    this.fechaCita = fechaCita;
  }
  public int getIdentificador() {
    return identificador;
  }
  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }
  public String getComentario() {
    return comentario;
  }
  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
}
