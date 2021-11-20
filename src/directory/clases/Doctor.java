package directory.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

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
  public Doctor (String usuario, String contrasehna, String nombre, String cedula, int codigoMedico, ArrayList<String> especialidades, Date localDate) {
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
  /**
   * Metodo para atender cita
   * @param paciente
   * @param cita
   * @param diagnosticos
   */
  public void atenderCita(Paciente paciente, Cita cita,ArrayList<Diagnostico> diagnosticos) {
    if (cita.getEstadoCita().equals("Registrada") | cita.getEstadoCita().equals("Asignada")){
      if (!diagnosticos.isEmpty()) {
        cita.getDiagnosticos().addAll(diagnosticos);
        cita.actualizarBitacora("Fecha: " + LocalDateTime.now() + "Se ha atendido la cita a nombre del funcionario de medicina " + this.getNombre());
        cita.setEstadoCita("Realizada");
        paciente.actualizarHistorial("Se ha atendido la cita ID: " + cita.getIdentificador() + " a nombre del funcionario de medicina " + this.getNombre());
      }
    }
    System.out.println("La cita no tiene el estado Registrada o Asignada.");
  }

  /**
   * Metodo para aplicar vacuna
   * @param paciente
   */
  public void aplicarVacuna(Paciente paciente) {
    //Vacuna vacuna = new Vacuna();
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

  @Override
  public String toString() {
    return "Doctor{" + "\n"+
            "Nombre: " + getNombre() + "\n"+
            "Codigo Medico: " + String.valueOf(getCodigoMedico()) + "\n"+
            "Cedula: " + getCedula() + "\n"+
            "Usuario: " + getUsuario() + "\n"+
            "Contraseña: " + getContrasenha() + "\n"+
            "especialidades=" + especialidades + "\n"+
            '}';
  }
}
