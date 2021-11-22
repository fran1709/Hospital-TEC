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
public class NuserAccount extends  JFrame{
  private JPanel panel1;
  private JButton cerrarSesionButton;
  private JButton registrarCitaButton;
  private JButton cancelarCitaButton;
  private JComboBox cbPacientesRegistrar;
  private JComboBox cbPacientesCancelar;
  private JButton reportesButton;

  public NuserAccount() {
    // Atributos.
    setContentPane(panel1);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    Controlador.getListasUsuarios();
    ArrayList<Paciente> pacienteArrayList= Controlador.pacientes;
    cbPacientesRegistrar.setModel(new DefaultComboBoxModel(pacienteArrayList.toArray(new Paciente[0])));
    cbPacientesCancelar.setModel(new DefaultComboBoxModel(pacienteArrayList.toArray(new Paciente[0])));

    cerrarSesionButton.addActionListener(new ActionListener() {
        /**
         * Cierra la ventana de Enfermero(a) y vuelve al menu principal.
         * @param e
         */
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "¡Hasta Pronto Enfermero(a)!");
        setVisible(false);
        MainGui menuPincipal = new MainGui();
        menuPincipal.setVisible(true);
      }
    });

    registrarCitaButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para registar una nueva cita del paciente seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

        Controlador.tmpPaciente = (Paciente) cbPacientesRegistrar.getSelectedItem();
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
        Controlador.tmpPaciente = (Paciente) cbPacientesCancelar.getSelectedItem();
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
