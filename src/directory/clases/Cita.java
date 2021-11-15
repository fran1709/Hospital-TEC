package directory.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marco
 */
public class Cita {
  // Atributos.
  private String especialidad;
  private Date fechaCita;
  private String comentario;
  private int identificador;
  private String estadoCita;
  private String bitacora;
  private ArrayList<Diagnostico> diagnosticos;

  /**
   * Metodo constructor
   * @param especialidad area en que se realizara la cita
   * @param fechaCita fecha de la cita
   * @param comentario comentario de razon de la cita
   * @param identificador id de la cita
   */
  public Cita (String especialidad, Date fechaCita, String comentario, int identificador) {
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

  /**
   * Metodo para crear una lista de tratamientos por cita de acuerdo a un tipo
   * @param tipo
   * @return
   */
  public ArrayList<Tratamiento> tratamientosPorTipo(String tipo) {
    ArrayList<Tratamiento> trats = new ArrayList<>();

    for (Diagnostico diag : this.diagnosticos){
      trats.addAll(diag.tratamientosPorTipo(tipo));
    }
    return trats;
  }
  /**
   * Metodo para crear una lista de tratamientos por cita de acuerdo a un nombre
   * @param nombre
   * @return
   */
  public ArrayList<Tratamiento> tratamientosPorNombre(String nombre) {
    ArrayList<Tratamiento> trats = new ArrayList<>();

    for (Diagnostico diag : this.diagnosticos){
      trats.addAll(diag.tratamientosPorNombre(nombre));
    }
    return trats;
  }

  // Metodos accesores.
  public String getEspecialidad() {
    return especialidad;
  }
  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }
  public Date getFechaCita() {
    return fechaCita;
  }
  public void setFechaCita(Date fechaCita) {
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
  public void setEstadoCita(String estadoCita) {this.estadoCita = estadoCita;}
  public String getEstadoCita() {return this.estadoCita;}
  public ArrayList<Diagnostico> getDiagnosticos() {
    return diagnosticos;
  }

  public void setDiagnosticos(ArrayList<Diagnostico> diagnosticos) {
    this.diagnosticos = diagnosticos;
  }
}
