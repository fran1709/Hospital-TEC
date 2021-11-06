package directory.clases;

public class CentroAtencion {
  // Atributos.
  private int codigo;
  private int capacidadPacientes;
  private String nombre;
  private String lugarUbicacion;
  private String tipo;

  /**
   * Constructor de clase.
   * Sin parametros.
   */
  public CentroAtencion() {
    ;
  }

  // Metods accesores.
  public int getCodigo() {
    return this.codigo;
  }
  public void setCodigo(int pCodigo) {
    this.codigo = pCodigo;
  }
  public int getCapacidadPacientes() {
    return this.capacidadPacientes;
  }
  public void setCapacidadPacientes(int pCantidad) {
    this.capacidadPacientes = pCantidad;
  }
  public String getNombre() {
    return this.nombre;
  }
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }
  public String getLugarUbicacion() {
    return this.lugarUbicacion;
  }
  public void setLugarUbicacion(String pLugar) {
    this.lugarUbicacion = pLugar;
  }
  public String getTipo() {
    return this.tipo;
  }
}
