package directory.gui;

import directory.auxiliarclases.JsonManager;
import directory.clases.*;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class MainGui extends JFrame{
  private JPanel mainWindow;
  private JButton inciarSesionButton;
  private JButton registrarseButton;
  private JButton salirButton;
  private JLabel jlTitle;
  private JButton bajarJSONButton;

  public MainGui() {
    // Atributos.
    setContentPane(mainWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    // usuario doctor
    ArrayList<String> especial = new ArrayList<String>();
    Date fecha = new Date();
    Doctor one = new Doctor("fran17", "123", "Francisco Javier", "207710202",
            1,especial, fecha);

    Controlador.registrarDoctor("drMendez","123","Eduardo Mendez", "4578123565", 1, especial,fecha,1);
    // usuario enfermero
    Controlador.registrarEnfermero("Pedro Mendez","123","peMendez", "4578123565", true,true,fecha,1);
    // usuario secretario
    Controlador.registrarSecretaria("sonia1","123","Sonia Perez","1234556",fecha,1);
    // usuario paciente
    ArrayList<String> numeros = new ArrayList<String>();
    ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();

    Controlador.registrarPaciente("mreveiz","123","Marco Reveiz","117680133",fecha,"B-",
            "Costarricense","Heredia", numeros,vacunas);

    Cita cita = new Cita("Medicina General",fecha,"Sin comentarios",1,8);

    Controlador.registrarCentroDeAtencion(1,125,"Hospital TEC","Cartago","Hospital");


    Tratamiento tratamiento = new Tratamiento("Pastillas",1,"Medicamento");
    Tratamiento tratamiento1 = new Tratamiento("Jarabe",1,"Medicamento");
    Tratamiento tratamiento2 = new Tratamiento("Curita",1,"Sutura");

    Controlador.catalogoTratamientos.add(tratamiento);
    Controlador.catalogoTratamientos.add(tratamiento1);
    Controlador.catalogoTratamientos.add(tratamiento2);


    bajarJSONButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JsonManager jsonManager = new JsonManager();
        Controlador.getListasUsuarios();
        jsonManager.setUsuarios(Controlador.usuarios);
        Controlador.getListasUsuarios();
        jsonManager.setPacientes(Controlador.pacientes);
        jsonManager.setCentrosDeAtencion(Controlador.centrosDeAtencion);
        jsonManager.setDoctors(Controlador.doctores);
        jsonManager.setEnfermeros(Controlador.enfermeros);
        jsonManager.setSecretarios(Controlador.secretarios);
        try {
          jsonManager.setJsons();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    });
    // Fin usuarios prueba

    salirButton.addActionListener(new ActionListener() {
      /**
       * Cierra y finaliza el programa.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    registrarseButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para registrar un nuevo usuario.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registrar nuevoRegistro = new Registrar();
        nuevoRegistro.setVisible(true);
      }
    });

    inciarSesionButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para logear como usuario.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        LogIn newLog = new LogIn();
        newLog.setVisible(true);
      }
    });
  }


  public static void main(String[] args) {
    // Instanciando el Gui.
    MainGui guiPrincipal = new MainGui();
  }
}
