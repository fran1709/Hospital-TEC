package directory.gui;

import directory.clases.Cita;
import directory.clases.Paciente;
import directory.clases.Secretaria;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class SecreAcc extends JFrame{
  private JPanel SecreAccWindow;
  private JButton cerrarSesionButton;
  private JComboBox cbPacientes;
  private JButton registrarCitaButton;
  private JButton cancelarCitaButton;
  private JComboBox cbPacientes2;
  private JButton reportesButton;

  public SecreAcc() {
    // Atributos.
    setContentPane(SecreAccWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    Secretaria secretaria = (Secretaria) Controlador.usuario;
    Controlador.getListasUsuarios();
    ArrayList<Paciente> pacienteArrayList= Controlador.pacientes;
    cbPacientes.setModel(new DefaultComboBoxModel(pacienteArrayList.toArray(new Paciente[0])));
    cbPacientes2.setModel(new DefaultComboBoxModel(pacienteArrayList.toArray(new Paciente[0])));

    cerrarSesionButton.addActionListener(new ActionListener() {
      /**
       * Cierra la ventana de Doctor y vuelve al menu principal.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "¡Hasta Pronto Secretario(a)!");
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
        Controlador.tmpPaciente = (Paciente) cbPacientes.getSelectedItem();
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
        Controlador.tmpPaciente = (Paciente) cbPacientes.getSelectedItem();
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
