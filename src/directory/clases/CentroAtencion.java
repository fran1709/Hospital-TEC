package directory.clases;

import java.util.ArrayList;

/**
 * @author Marco
 */
public class CentroAtencion {
  // Atributos.
  private int codigo;
  private int capacidadPacientes;
  private String nombre;
  private String lugarUbicacion;
  private String tipo;
  private ArrayList<Funcionario> funcionarios;
  /**
   * Constructor de clase.
   * @param capacidadPacientes capacidadDePacientes
   * @param codigo codiog del centro autonumerico
   * @param lugarUbicacion lugar donde se ubica
   * @param nombre nombre del cenrtro
   * @param tipo tipo de centro (Clinica, Hospuital, EBAIS,....)
   */
  public CentroAtencion (int codigo, int capacidadPacientes, String nombre, String lugarUbicacion, String tipo) {
    this.codigo = codigo;
    this.capacidadPacientes = capacidadPacientes;
    this.nombre = nombre;
    this.lugarUbicacion = lugarUbicacion;
    this.tipo = tipo;
    this.funcionarios = new ArrayList<>();
  }

  /**
   * Metodo para agregar funcionarios
   * @return
   */
  public void agregarFuncionario(Funcionario funcionario) {
    this.funcionarios.add(funcionario);
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
