package directory.gui;

import directory.clases.Paciente;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class DocAccount extends JFrame{
  private JPanel DocAccWindow;
  private JLabel jlTitle;
  private JButton cerrarSesionButton;
  private JButton registrarCitaButton;
  private JButton cancelarCitaButton;
  private JButton atenderCitaButton;
  private JButton reportesButton;
  private JComboBox cbPacientes;
  private JComboBox cbPacientes3;
  private JComboBox cbPacientes2;

  public DocAccount() {
    // Atributos.
    setContentPane(DocAccWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    Controlador.getListasUsuarios();
    ArrayList<Paciente> pacienteArrayList= Controlador.pacientes;
    cbPacientes.setModel(new DefaultComboBoxModel(pacienteArrayList.toArray(new Paciente[0])));
    cbPacientes2.setModel(new DefaultComboBoxModel(pacienteArrayList.toArray(new Paciente[0])));
    cbPacientes3.setModel(new DefaultComboBoxModel(pacienteArrayList.toArray(new Paciente[0])));

    cerrarSesionButton.addActionListener(new ActionListener() {
      /**
       * Cierra la ventana de Doctor y vuelve al menu principal.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "¡Hasta Pronto Doctor(a)!");
        setVisible(false);
        MainGui menuPincipal = new MainGui();
        menuPincipal.setVisible(true);
      }
    });

    atenderCitaButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para atender cita del paciente seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        Controlador.tmpPaciente = (Paciente) cbPacientes.getSelectedItem();
        setVisible(false);
        AtenderCita atendiendo = new AtenderCita();
        atendiendo.setVisible(true);
      }
    });

    registrarCitaButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para registar una nueva cita del paciente seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        Controlador.tmpPaciente = (Paciente) cbPacientes2.getSelectedItem();
        //setVisible(false);
        RegistrarCita nuevaCita = new RegistrarCita();
        nuevaCita.setVisible(true);
      }
    });

    cancelarCitaButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para cancelar una cita del paciente seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        Controlador.tmpPaciente = (Paciente) cbPacientes3.getSelectedItem();
        CancelaCita cancelacion = new CancelaCita();
        cancelacion.setVisible(true);
      }
    });

    reportesButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para acceder a los reportes.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        Reporte reporte = new Reporte();
        reporte.setVisible(true);
      }
    });
  }
}
