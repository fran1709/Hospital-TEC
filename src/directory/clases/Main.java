package directory.clases;


import directory.auxiliarclases.JsonManager;
import directory.controladores.controladores.Controlador;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        Controlador controlador = new Controlador();

        JsonManager jsonManager = new JsonManager();

        ArrayList<String> especialidades = new ArrayList<>();
        /*
        especialidades.add("Ginecologia");
        especialidades.add("Pediatria");
        Date date = new Date();
        controlador.registrarCentroDeAtencion(1,120,"Hospital TEC","Heredia","Hospital");
        controlador.registrarDoctor("drMendez","123","Eduardo Mendez", "4578123565", 1, especialidades,date,1);
        controlador.registrarEnfermero("Pedro Mendez","123","peMendez", "4578123565", true,true,date,1);
        controlador.registrarPaciente("mreveiz","123","Marco Reveiz","117680133",date,"B-",
                "Costarricense","Heredia",null,null);
        controlador.registrarSecretaria("sonia1","123","Sonia Perez","1234556",date,1);

        jsonManager.setUsuarios(controlador.getUsuarios());
        controlador.getListasUsuarios();
        jsonManager.setPacientes(controlador.getPacientes());
        jsonManager.setCentrosDeAtencion(controlador.getCentrosDeAtencion());
        jsonManager.setDoctors(controlador.getDoctores());
        jsonManager.setEnfermeros(controlador.getEnfermeros());
        jsonManager.setSecretarios(controlador.getSecretarios());
        jsonManager.setJsons();
        */
        jsonManager.getJsons();
        controlador.setDoctores(jsonManager.getDoctors());
        System.out.println(jsonManager.getDoctors().get(0));





    }
}