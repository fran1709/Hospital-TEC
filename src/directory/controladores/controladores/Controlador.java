package directory.controladores.controladores;

import directory.clases.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marco
 * Controlador del sistema
 */
public class Controlador {


    private ArrayList<Usuario> usuarios;
    private ArrayList<CentroAtencion> centrosDeAtencion;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Secretaria> secretarios;
    private ArrayList<Doctor> doctores;
    private ArrayList<Enfermero> enfermeros;
    public static String usuarioEnSesion;
    public static String contrasehna;

    /**
     * METODO CONSTRUCTOR
     */
    public Controlador() {
        this.usuarios = new ArrayList<>();
        this.centrosDeAtencion = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.secretarios = new ArrayList<>();
        this.doctores = new ArrayList<>();
        this.enfermeros = new ArrayList<>();
    }

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
        if (this.usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Paciente newPaciente = new Paciente(usuario, contrasehna, nombre, cedula, fechaNacimiento, tipoSangre,
                    nacionalidad, lugarResidencia, numerosTelefonicos, vacunasAplicadas);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newPaciente);
            System.out.println("El usuario agregado");
        }else {
            // Verifica si el usuario ya existe
            if (!this.buscaUsuario(usuario)) {
                // Primero debe verificar si la cedula existe
                Paciente newPaciente = new Paciente(usuario, contrasehna, nombre, cedula, fechaNacimiento, tipoSangre,
                        nacionalidad, lugarResidencia, numerosTelefonicos, vacunasAplicadas);
                // Si cumple con los requisitos se agrega
                this.usuarios.add(newPaciente);
                System.out.println("El usuario agregado");
            }
        }



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
                                 ArrayList<String> especialidades, Date fechaDeIngreso, int codigoCentro){
        if (this.usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Doctor newDoctor = new Doctor(usuario, contrasehna, nombre, cedula, codigoMedico, especialidades, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newDoctor);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newDoctor);
                    System.out.println("El usuario agregado");
                }
            }
        }
        if (!this.buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Doctor newDoctor = new Doctor(usuario, contrasehna, nombre, cedula, codigoMedico, especialidades, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newDoctor);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newDoctor);
                    System.out.println("El usuario agregado");
                }
            }
        }

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
                                    boolean expeCapacitando, Date fechaDeIngreso, int codigoCentro){
        if (this.usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Enfermero newEnfermero = new Enfermero(usuario, contrasehna, nombre, cedula, dirigioPersonas, expeCapacitando, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newEnfermero);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newEnfermero);
                    System.out.println("El usuario agregado");
                }
            }
        }
        if (!this.buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Enfermero newEnfermero = new Enfermero(usuario, contrasehna, nombre, cedula, dirigioPersonas, expeCapacitando, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newEnfermero);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newEnfermero);
                    System.out.println("El usuario agregado");
                }
            }
        }
        // Ya existe el usuario

    }

    /**
     * Metodo para registrar secretaria
     * @param usuario
     * @param contrasehna
     * @param nombre
     * @param cedula
     */
    public void registrarSecretaria (String usuario, String contrasehna, String nombre, String cedula, Date fechaDeIngreso , int codigoCentro){
        if (this.usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Secretaria newSecretaria = new Secretaria(usuario, contrasehna, nombre, cedula, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newSecretaria);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newSecretaria);
                    System.out.println("El usuario agregado");

                }
            }
        }
        if (!this.buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Secretaria newSecretaria = new Secretaria(usuario, contrasehna, nombre, cedula, fechaDeIngreso);
            // Si cumple con los requisitos se agrega
            this.usuarios.add(newSecretaria);
            for (CentroAtencion centro : this.centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newSecretaria);
                    System.out.println("El usuario agregado");

                }
            }
        }
    }


    /**
     * Metodo para retornar como atributo las listas de los trabajadores y pacientes registrados
     * @return
     */
    public void getListasUsuarios() {

        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Enfermero> enfermeroArrayList = new ArrayList<>();
        ArrayList<Paciente> newPacientes = new ArrayList<>();
        ArrayList<Secretaria> newSecretarias = new ArrayList<>();

        for (Usuario usuario : this.usuarios) {
            if (usuario instanceof Paciente) {
                newPacientes.add((Paciente) usuario);

            }else if (usuario instanceof  Doctor) {
                doctors.add((Doctor) usuario);

            } else if (usuario instanceof Enfermero) {
                enfermeroArrayList.add((Enfermero) usuario);

            } else if (usuario instanceof Secretaria) {
                newSecretarias.add((Secretaria) usuario);
            }
        }

        this.pacientes = newPacientes;
        this.doctores = doctors;
        this.enfermeros = enfermeroArrayList;
        this.secretarios = newSecretarias;
    }

    /**
     * Metodo para registrar centro medico
     * @param codigo
     * @param capacidadPacientes
     * @param nombre
     * @param lugarUbicacion
     * @param tipo
     */
    public void registrarCentroDeAtencion(int codigo, int capacidadPacientes, String nombre, String lugarUbicacion, String tipo){
        CentroAtencion centroAtencion = new CentroAtencion(codigo,capacidadPacientes,nombre,lugarUbicacion,tipo);
        this.centrosDeAtencion.add(centroAtencion);
    }



    //Metodos accesores

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<CentroAtencion> getCentrosDeAtencion() {
        return centrosDeAtencion;
    }

    public void setCentrosDeAtencion(ArrayList<CentroAtencion> centrosDeAtencion) {
        this.centrosDeAtencion = centrosDeAtencion;
    }
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Secretaria> getSecretarios() {
        return secretarios;
    }
    public void setSecretarios(ArrayList<Secretaria> secretarios) {
        this.secretarios = secretarios;
    }

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(ArrayList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public ArrayList<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(ArrayList<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }


}
