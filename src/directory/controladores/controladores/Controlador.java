package directory.controladores.controladores;

import directory.clases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marco
 * Controlador del sistema
 */
public class Controlador {

    // Atributos
    private ArrayList<Usuario> usuarios;
    private ArrayList<CentroAtencion> centrosDeAtencion;
    public static String usuarioEnSesion;
    public static String contrasehna;


    /** METODOS DE VALIDACION DE USUARIOS **/
    /**
     * Metodo para ingresar al sistema
     * @param usuarioEnSesion nombre de usuario
     * @param contrasehna contrasehna del usuario
     */
    public void iniciarSesion (String usuarioEnSesion, String contrasehna) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getUsuario().equals(usuarioEnSesion) & usuario.getContrasenha().equals(contrasehna)) {
                this.usuarioEnSesion = usuarioEnSesion;
                this.contrasehna = contrasehna;
                break;
            }
        }
        System.out.println("El usuario es inexistente");
    }

    /**
     * Verifica si el usuario ya existe
     * @param usuarioEnSesion nombre del usuario
     * @return Si es true exite, si no no existe
     */
    public boolean buscaUsuario (String usuarioEnSesion){
        for (Usuario usuario : this.usuarios) {
            if (usuario.getUsuario().equals(usuarioEnSesion)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para registrar paciente
     * @param usuario
     * @param contrasehna
     * @param nombre
     * @param cedula
     * @param fechaNacimiento
     * @param tipoSangre
     * @param nacionalidad
     * @param lugarResidencia
     * @param numerosTelefonicos
     * @param vacunasAplicadas
     */
    public void registrarPaciente(String usuario, String contrasehna, String nombre, String cedula, Date fechaNacimiento, String tipoSangre,
                                  String nacionalidad, String lugarResidencia, ArrayList<String> numerosTelefonicos, ArrayList<Vacuna> vacunasAplicadas){
        // Verifica si el usuario ya existe
        if (!this.buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Paciente newPaciente = new Paciente( usuario, contrasehna,  nombre,  cedula,  fechaNacimiento,  tipoSangre,
                    nacionalidad,  lugarResidencia, numerosTelefonicos, vacunasAplicadas);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newPaciente);
        }

        // Ya existe el usuario
        System.out.println("El usuario no es valido");

    }

    /**
     * Metodo para registrar doctor
     * @param usuario
     * @param contrasehna
     * @param nombre
     * @param cedula
     * @param codigoMedico
     * @param especialidades
     */
    public void registrarDoctor (String usuario, String contrasehna, String nombre, String cedula, int codigoMedico,
                                 ArrayList<String> especialidades, LocalDate fechaDeIngreso, int codigoCentro){
        if (!this.buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Doctor newDoctor = new Doctor( usuario, contrasehna,  nombre,  cedula,  codigoMedico,  especialidades, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newDoctor);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newDoctor);
                }
            }
        }
        // Ya existe el usuario
        System.out.println("El usuario no es valido");
    }

    /**
     * Metodo para registrar enfermero
     * @param usuario
     * @param contrasehna
     * @param nombre
     * @param cedula
     * @param dirigioPersonas
     * @param expeCapacitando
     */
    public void registrarEnfermero (String nombre, String usuario, String contrasehna, String cedula, boolean dirigioPersonas,
                                    boolean expeCapacitando, LocalDate fechaDeIngreso, int codigoCentro){

        if (!this.buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Enfermero newEnfermero = new Enfermero( usuario, contrasehna,  nombre,  cedula,  dirigioPersonas,  expeCapacitando, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newEnfermero);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newEnfermero);
                }
            }
        }
        // Ya existe el usuario
        System.out.println("El usuario no es valido");
    }

    /**
     * Metodo para registrar secretaria
     * @param usuario
     * @param contrasehna
     * @param nombre
     * @param cedula
     */
    public void registrarSecretaria (String usuario, String contrasehna, String nombre, String cedula, LocalDate fechaDeIngreso , int codigoCentro){

        if (!this.buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Secretaria newSecretaria = new Secretaria( usuario, contrasehna,  nombre,  cedula, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newSecretaria);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newSecretaria);
                }
            }
        }
        // Ya existe el usuario
        System.out.println("El usuario no es valido");
        
        // Ya existe el usuario
        System.out.println("El usuario no es valido");
    }

    /**
     * Metodo para sacar los pacientes de la lista de usuarios
     * @return
     */
    public ArrayList<Paciente> getListaPacientes(){
        ArrayList<Paciente> pacientes = new ArrayList<>();
        for (Usuario usuario : this.usuarios) {
            if (usuario instanceof Paciente) {
                pacientes.add((Paciente) usuario);
            }

        }
        return pacientes;
    }


}
