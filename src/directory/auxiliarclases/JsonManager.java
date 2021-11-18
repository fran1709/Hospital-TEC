package directory.auxiliarclases;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import directory.clases.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Marco
 * Clase encarga de manejar los archivos .json en los que se almacenara informacion vital para el programa
 * @version 1.0
 */
public class JsonManager {


    private ArrayList<Usuario> usuarios;
    private ArrayList<CentroAtencion> centrosDeAtencion;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Secretaria> secretarios;
    private ArrayList<Doctor> doctors;
    private ArrayList<Enfermero> enfermeros;


    /**
     * Metodo constructor
     */
    public JsonManager() {
        this.usuarios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.centrosDeAtencion = new ArrayList<>();
        this.secretarios = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.enfermeros = new ArrayList<>();
    }

    /**
     * Guarda los tres archivos JSON con los datos de los array registrados
     * @throws IOException si el programa no puede escribir el archivo
     */

    public void setJsons() throws IOException {

        //Path
        String path = System.getProperty("user.dir") + "\\src\\directory\\jsons\\";
        // Objecto Gson
        Gson gson = new Gson();
        // Usuarios
        File fileUsuarios = new File(path + "usuarios.json");
        Writer wUsuarios = new FileWriter(fileUsuarios);
        gson.toJson(this.usuarios, wUsuarios);
        wUsuarios.close();

        // Pacientes
        File filePacientes = new File(path + "pacientes.json");
        Writer wPacientes = new FileWriter(filePacientes);
        gson.toJson(this.pacientes, wPacientes);
        wPacientes.close();

        // Centro de Atencion
        File fileCentroAtencion = new File(path + "centros.json");
        Writer wCentroAtencion = new FileWriter(fileCentroAtencion);
        gson.toJson(this.centrosDeAtencion, wCentroAtencion);
        wCentroAtencion.close();


        // Funcionarios de Medicina (Doctor)
        File fileFuncMedicina = new File(path + "doctores.json");
        Writer wFuncMedicina = new FileWriter(fileFuncMedicina);
        gson.toJson(this.doctors, wFuncMedicina);
        wFuncMedicina.close();

        // Funcionarios de Medicina (Enfermeria)
        File fileFuncMedicina2 = new File(path + "enfermeros.json");
        Writer wFuncMedicina2 = new FileWriter(fileFuncMedicina2);
        gson.toJson(this.enfermeros, wFuncMedicina2);
        wFuncMedicina2.close();

        // Funcionarios de Secretaria
        File fileFuncSecretaria = new File(path + "secretaria.json");
        Writer wFuncSecretaria = new FileWriter(fileFuncSecretaria);
        gson.toJson(this.secretarios, wFuncSecretaria);
        wFuncSecretaria.close();


    }

    /**
     * Obtiene los datos de los JSON guardados y los iguala a los atributos
     */
    public void getJsons() throws IOException {
        // Objecto Gson
        Gson gson = new Gson();
        // Path

        // Usuarios
        String path = System.getProperty("user.dir") + "\\src\\directory\\jsons\\";
        /**
        String listaUsuarios = Files.readString(Paths.get(path+"usuarios.json"));
        Type usuariosALType = new TypeToken<ArrayList<Usuario>>(){}.getType();
        ArrayList<Usuario> usuariosArrayList = gson.fromJson(listaUsuarios,usuariosALType);
        this.setUsuarios(usuariosArrayList);
         */
        // Pacientes
        String listaPacientes = Files.readString(Paths.get(path+"pacientes.json"));
        Type pacienteALType = new TypeToken<ArrayList<Paciente>>(){}.getType();
        ArrayList<Paciente> pacienteArrayList = gson.fromJson(listaPacientes,pacienteALType);
        this.setPacientes(pacienteArrayList);
        // Funcionarios Medicina (Enfermero)
        String listaFuncMedicia = Files.readString(Paths.get(path+"enfermeros.json"));
        Type funcMedicinaALType = new TypeToken<ArrayList<Enfermero>>(){}.getType();
        ArrayList<Enfermero> funcMedicinaArrayList = gson.fromJson(listaFuncMedicia,funcMedicinaALType);
        this.setEnfermeros(funcMedicinaArrayList);
        // Funcionarios Medicina (Doctor)
        String listaFuncMedicia2 = Files.readString(Paths.get(path+"doctores.json"));
        Type funcMedicinaALType2 = new TypeToken<ArrayList<Doctor>>(){}.getType();
        ArrayList<Doctor> funcMedicinaArrayList2 = gson.fromJson(listaFuncMedicia2,funcMedicinaALType2);
        this.setDoctors(funcMedicinaArrayList2);
        // Secretario
        String listaSecretarios = Files.readString(Paths.get(path+"secretaria.json"));
        Type secALType = new TypeToken<ArrayList<Secretaria>>(){}.getType();
        ArrayList<Secretaria> secArrayList = gson.fromJson(listaSecretarios,secALType);
        this.setSecretarios(secArrayList);


    }

    /** METODOS ACCESORES **/
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

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


    public ArrayList<Secretaria> getSecretarios() {
        return secretarios;
    }

    public void setSecretarios(ArrayList<Secretaria> secretarios) {
        this.secretarios = secretarios;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(ArrayList<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }
}
