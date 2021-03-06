package directory.clases;

import java.util.Date;

/**
 * @author Marco y Francisco
 */
public class Enfermero extends FuncionarioMedicina{
  //Atributos.
  private boolean dirigioPersonas;
  private boolean expeCapacitando;

  /**
   * Metodo constructor
   * @param usuario nombre de usuario
   * @param contrasehna contrasehna
   * @param nombre Nombre del funcionario
   * @param cedula Cedula del funcionario
   * @param dirigioPersonas Ha tenido personas a su cargo
   * @param expeCapacitando Ha tnido experiencia en capacitaciones a pacientes
   * @param localDate
   */
  public Enfermero (String usuario, String contrasehna, String nombre, String cedula, boolean dirigioPersonas, boolean expeCapacitando, Date localDate) {
    this.dirigioPersonas = dirigioPersonas;
    this.expeCapacitando = expeCapacitando;
    this.setUsuario(usuario);
    this.setContrasenha(contrasehna);
    this.setNombre(nombre);
    this.setCedula(cedula);
    this.setTipo("Enfermero");
    this.setFechaIngreso(localDate);
  }

  @Override
  public String toString() {
    return "Enfermero{" + "\n"+
            "Nombre: " + getNombre() + "\n"+
            "Experiencia: " + getExpeCapacitando() + "\n"+
            "Cedula: " + getCedula() + "\n"+
            "Usuario: " + getUsuario() + "\n"+
            "Contraseña: " + getContrasenha() + "\n"+
            "Dirigio Personas =" + getDirigioPersonas() + "\n"+
            '}';
  }

  //Metodos accesores
  public boolean isDirigioPersonas() {
    return dirigioPersonas;
  }
  public void setDirigioPersonas(boolean pDirigioPersonas) {
    this.dirigioPersonas = pDirigioPersonas;
  }
  public boolean isExpeCapacitando() {
    return expeCapacitando;
  }
  public void setExpeCapacitando(boolean pExpeCapacitando) {
    this.expeCapacitando = pExpeCapacitando;
  }
  public Boolean getExpeCapacitando() {
    return this.expeCapacitando ;
  }
  public Boolean getDirigioPersonas() {
    return this.expeCapacitando ;
  }
}
