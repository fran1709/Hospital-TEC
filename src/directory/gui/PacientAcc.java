package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class PacientAcc extends JFrame{
  private JPanel PacientAccWindow;
  private JButton cerrarSesionButton;
  private JButton solicitarCitaButton;
  private JButton cancelarCitaButton;
  private JButton reportesButton;

  public PacientAcc() {
    // Atributos.
    setContentPane(PacientAccWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    cerrarSesionButton.addActionListener(new ActionListener() {
      /**
       * Cierra la ventana de Doctor y vuelve al menu principal.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "¡Hasta Pronto Paciente!");
        setVisible(false);
        MainGui menuPincipal = new MainGui();
        menuPincipal.setVisible(true);
      }
    });

    solicitarCitaButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para registar una nueva cita del paciente seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

        RegistrarCita nuevaCita = new RegistrarCita();
        nuevaCita.setVisible(true);
        setVisible(false);

      }
    });

    cancelarCitaButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para cancelar una cita.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        CancelaCita cancelacion = new CancelaCita();
        cancelacion.setVisible(true);
        setVisible(false);
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
        setVisible(false);
      }
    });
  }
}
