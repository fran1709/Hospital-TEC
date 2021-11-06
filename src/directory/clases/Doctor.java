package directory.clases;

import java.util.ArrayList;

public class Doctor extends Funcionario{
  // Atributos.
  private int codigoMedico;
  private ArrayList<String> especialidades;

  /**
   * Constructor de la clase.
   */
  public Doctor() {
    ;
  }

  // Metodos accesores.
  public int getCodigoMedico() {
    return codigoMedico;
  }
  public void setCodigoMedico(int codigoMedico) {
    this.codigoMedico = codigoMedico;
  }
  public ArrayList<String> getEspecialidades() {
    return especialidades;
  }
  public void setEspecialidades(ArrayList<String> especialidades) {
    this.especialidades = especialidades;
  }
}
