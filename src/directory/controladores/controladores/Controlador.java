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


    public static ArrayList<Usuario> usuarios = new ArrayList<>();;
    public static ArrayList<CentroAtencion> centrosDeAtencion = new ArrayList<>();;
    public static ArrayList<Paciente> pacientes = new ArrayList<>();;
    public static ArrayList<Secretaria> secretarios = new ArrayList<>();;
    public static ArrayList<Doctor> doctores = new ArrayList<>();;
    public static ArrayList<Enfermero> enfermeros = new ArrayList<>();;
    public static ArrayList<Tratamiento> catalogoTratamientos = new ArrayList<>();
    public static ArrayList<Diagnostico> catalogoDiagnosticos = new ArrayList<>();
    public static Paciente tmpPaciente;
    public static Usuario usuario;
    public static int idCita = 0;

    /**
     * METODO CONSTRUCTOR
     */
    public Controlador() {}



    /** METODOS DE VALIDACION DE USUARIOS **/

    /**
     * Verifica si el usuario ya existe
     * @param usuarioEnSesion nombre del usuario
     * @return Si es true exite, si no no existe
     */
    public static boolean buscaUsuario (String usuarioEnSesion){
        for (Usuario usuario : usuarios) {
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
    public static void registrarPaciente(String usuario, String contrasehna, String nombre, String cedula, Date fechaNacimiento, String tipoSangre,
                                  String nacionalidad, String lugarResidencia, ArrayList<String> numerosTelefonicos, ArrayList<Vacuna> vacunasAplicadas){

        if (usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Paciente newPaciente = new Paciente(usuario, contrasehna, nombre, cedula, fechaNacimiento, tipoSangre,
                    nacionalidad, lugarResidencia, numerosTelefonicos, vacunasAplicadas);
            System.out.println(newPaciente.toString());
            // Si cumple con los requisitos se agrega
            usuarios.add(newPaciente);
            System.out.println("El usuario agregado");
        }else {
            // Verifica si el usuario ya existe
            if (!buscaUsuario(usuario)) {
                // Primero debe verificar si la cedula existe
                Paciente newPaciente = new Paciente(usuario, contrasehna, nombre, cedula, fechaNacimiento, tipoSangre,
                        nacionalidad, lugarResidencia, numerosTelefonicos, vacunasAplicadas);
                System.out.println(newPaciente.toString());
                // Si cumple con los requisitos se agrega
                usuarios.add(newPaciente);
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
     * @param fechaDeIngreso
     */
    public static void registrarDoctor (String usuario, String contrasehna, String nombre, String cedula, int codigoMedico,
                                 ArrayList<String> especialidades, Date fechaDeIngreso, int codigoCentro){
        if (usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Doctor newDoctor = new Doctor(usuario, contrasehna, nombre, cedula, codigoMedico, especialidades, fechaDeIngreso);
            System.out.println(newDoctor.toString());
            // Si cumple con los requisitos se agrega
            usuarios.add(newDoctor);
            for (CentroAtencion centro :centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newDoctor);
                    System.out.println("El usuario agregado");
                }
            }
        }
        if (!buscaUsuario(usuario)) {
            System.out.println("Entra");
            // Primero debe verificar si la cedula existe
            Doctor newDoctor = new Doctor(usuario, contrasehna, nombre, cedula, codigoMedico, especialidades, fechaDeIngreso);
            System.out.println(newDoctor.toString());
            // Si cumple con los requisitos se agrega
           usuarios.add(newDoctor);
            for (CentroAtencion centro : centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newDoctor);
                    System.out.println("El usuario agregado");
                }
            }
        }

    }

    /**
     * Metodo para registrar enfermero
     * @param nombre
     * @param usuario
     * @param contrasehna
     * @param cedula
     * @param dirigioPersonas
     * @param expeCapacitando
     * @param fechaDeIngreso
     */
    public static void registrarEnfermero (String nombre, String usuario, String contrasehna, String cedula, boolean dirigioPersonas,
                                    boolean expeCapacitando, Date fechaDeIngreso, int codigoCentro){
        if (usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Enfermero newEnfermero = new Enfermero(usuario, contrasehna, nombre, cedula, dirigioPersonas, expeCapacitando, fechaDeIngreso);
            System.out.println(newEnfermero.toString());
            // Si cumple con los requisitos se agrega
            usuarios.add(newEnfermero);
            for (CentroAtencion centro : centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newEnfermero);
                    System.out.println("El usuario agregado");
                }
            }
        }
        if (!buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Enfermero newEnfermero = new Enfermero(usuario, contrasehna, nombre, cedula, dirigioPersonas, expeCapacitando, fechaDeIngreso);
            System.out.println(newEnfermero.toString());
            // Si cumple con los requisitos se agrega
            usuarios.add(newEnfermero);
            for (CentroAtencion centro : centrosDeAtencion) {
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
     * @param fechaDeIngreso
     */
    public static void registrarSecretaria (String usuario, String contrasehna, String nombre, String cedula, Date fechaDeIngreso , int codigoCentro){
        if (usuarios.isEmpty()) {
            // Primero debe verificar si la cedula existe
            Secretaria newSecretaria = new Secretaria(usuario, contrasehna, nombre, cedula, fechaDeIngreso);
            System.out.println(newSecretaria.toString());
            // Si cumple con los requisitos se agrega
            usuarios.add(newSecretaria);
            for (CentroAtencion centro :centrosDeAtencion) {
                if (centro.getCodigo() == codigoCentro) {
                    centro.agregarFuncionario(newSecretaria);
                    System.out.println("El usuario agregado");

                }
            }
        }
        if (!buscaUsuario(usuario)) {
            // Primero debe verificar si la cedula existe
            Secretaria newSecretaria = new Secretaria(usuario, contrasehna, nombre, cedula, fechaDeIngreso);
            System.out.println(newSecretaria.toString());
            // Si cumple con los requisitos se agrega
            usuarios.add(newSecretaria);
            for (CentroAtencion centro : centrosDeAtencion) {
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
    public static void getListasUsuarios() {

        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Enfermero> enfermeroArrayList = new ArrayList<>();
        ArrayList<Paciente> newPacientes = new ArrayList<>();
        ArrayList<Secretaria> newSecretarias = new ArrayList<>();

        for (Usuario usuario : usuarios) {
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

        pacientes = newPacientes;
        doctores = doctors;
        enfermeros = enfermeroArrayList;
        secretarios = newSecretarias;
    }

    /**
     * Metodo para registrar centro medico
     * @param codigo
     * @param capacidadPacientes
     * @param nombre
     * @param lugarUbicacion
     * @param tipo
     */
    public static void registrarCentroDeAtencion(int codigo, int capacidadPacientes, String nombre, String lugarUbicacion, String tipo){
        CentroAtencion centroAtencion = new CentroAtencion(codigo,capacidadPacientes,nombre,lugarUbicacion,tipo);
        centrosDeAtencion.add(centroAtencion);
    }

    /**
     * Metodo que retorna la lista de hospitalizaciones registyradas en un rango de fechas
     * @param fechaInicio
     * @param fechaFinal
     * @return
     */
    public static ArrayList<Hospitalizacion> getHospitalizacionesPorFecha(Date fechaInicio, Date fechaFinal){
        ArrayList<Hospitalizacion> hospitalizacionArrayList = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            hospitalizacionArrayList.addAll(paciente.hospitalizacionesPorFecha(fechaInicio,fechaFinal));
        }
        return hospitalizacionArrayList;
    }

    /**
     * Metodo que retorna lista de hospitalizaciones de todos los pacientes de acuerdo a un estado
     * @param estadoH
     * @return
     */
    public static ArrayList<Hospitalizacion> getHospitalizacionesPorEstado(String estadoH){
        ArrayList<Hospitalizacion> hospitalizacionArrayList = new ArrayList<>();
        for (Paciente paciente :pacientes){
            hospitalizacionArrayList.addAll(paciente.hospitalizacionesPorEstado(estadoH));
        }
        return hospitalizacionArrayList;

    }

    /**
     * Metodo que retorna lista de hospitalizaciones de todos los pacientes de acuerdo a una especialidad dada
     * @param especialidadH
     * @return
     */
    public static ArrayList<Hospitalizacion> getHospitalizacionesPorEspecialidad(String especialidadH){
        ArrayList<Hospitalizacion> hospitalizacionArrayList = new ArrayList<>();
        for (Paciente paciente :pacientes){
            hospitalizacionArrayList.addAll(paciente.hospitalizacionesPorEspecialidad(especialidadH));
        }
        return hospitalizacionArrayList;
    }

    /**
     * Metodo que retorna citas disponibles
     * @param paciente
     * @return
     */
    public static ArrayList<Cita> getCitasDisponibles(Paciente paciente) {
        ArrayList<Cita> citasDisp = new ArrayList<>();
        for (Cita cita : paciente.getCitas()) {
            if (!(cita.getEstadoCita().equals("Realizada"))){
                citasDisp.add(cita);
            }

        }
        return citasDisp;
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
