package directory.clases;

public class Enfermero extends Funcionario{
  //Atributos.
  private boolean dirigioPersonas;
  private boolean expeCapacitando;

  /**
   * Constructor de la clase.
   */
  public Enfermero() {
    ;
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
}
