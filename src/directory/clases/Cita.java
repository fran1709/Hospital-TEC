package directory.clases;

import java.time.LocalDate;

/**
 * @author Marco
 */
public class Cita {
  // Atributos.
  private String especialidad; //area
  private LocalDate fechaCita;
  private String comentario;
  private int identificador;
  private String estadoCita;
  private String bitacora;

  /**
   * Metodo constructor
   * @param especialidad area en que se realizara la cita
   * @param fechaCita fecha de la cita
   * @param comentario comentario de razon de la cita
   * @param identificador id de la cita
   */
  public Cita (String especialidad, LocalDate fechaCita, String comentario, int identificador) {
    this.especialidad = especialidad;
    this.fechaCita = fechaCita;
    this.comentario = comentario;
    this.identificador = identificador;
    this.bitacora = "Se ha registrado la cita\n";
  }

  /**
   * Metodo que agrega un comentario a la bitacora de la cita
   * @return void
   */
  public void actualizarBitacora(String comentarioAgregado) {
    this.bitacora = this.bitacora + comentarioAgregado + "\n";
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
