package directory.clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Marco y Francisco
 */
public class Doctor extends FuncionarioMedicina{
  // Atributos.
  private int codigoMedico;
  private ArrayList<String> especialidades;

  /**
   * Metodo constructor
   * @param usuario nombre de usuario
   * @param contrasehna contrasehna
   * @param nombre Nombre del funcionario
   * @param cedula Cedula del funcionario
   * @param codigoMedico Codigo de medico
   * @param especialidades espcialidades de medicina
   */
  public Doctor (String usuario, String contrasehna, String nombre, String cedula, int codigoMedico, ArrayList<String> especialidades, LocalDate localDate) {
    this.codigoMedico = codigoMedico;
    this.especialidades = especialidades;
    this.setUsuario(usuario);
    this.setContrasenha(contrasehna);
    this.setNombre(nombre);
    this.setCedula(cedula);
    this.setTipo("Doctor");
    this.setFechaIngreso(localDate);

  }

  /* FUNCIONALIDADES DOCTOR */
  public void aplicarVacuna(Paciente paciente) {}
  public void atenderCita(Paciente paciente){}

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
