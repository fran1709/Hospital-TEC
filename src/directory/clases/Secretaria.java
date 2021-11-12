package directory.clases;

import java.time.LocalDate;

/**
 * @author Marco y Francisco
 */
public class Secretaria extends Funcionario{
    /**
     *
     * @param usuario
     * @param contrasehna
     * @param nombre
     * @param cedula
     */
    public Secretaria (String usuario, String contrasehna, String nombre, String cedula, LocalDate localDate) {
        this.setUsuario(usuario);
        this.setContrasenha(contrasehna);
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.setTipo("Secretaria");
        this.setFechaIngreso(localDate);
    }

    /* FUNCIONALIDADES SECRETARIA */
    public void cancelarCita(Paciente paciente) {

    }

    public void asignarCita(Paciente paciente) {

    }
    public void citasRegistradasEnSistema(int casoDeOrden) {}
    public void hospitalizacionesEnSistema(int casoDeOrden) {}

}
