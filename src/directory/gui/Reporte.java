package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Reporte extends JFrame{
  private JPanel ReportesWindow;
  private JTable jtableReportes;
  private JButton generarButton;
  private JButton volverButton;
  private JComboBox cbPacientes;
  private JComboBox cbReportes;
  private JTextField tfAnhio;
  private JTextField tfMes;
  private JTextField tfDia;
  private JTextField tfAnhioFinal;
  private JTextField tfMesFinal;
  private JTextField tfDiaFinal;

  public Reporte() {
    // Atributos.
    setContentPane(ReportesWindow);
    setTitle("Hospital TEC");
    setSize(650,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu de la cuenta.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });

    generarButton.addActionListener(new ActionListener() {
      /**
       * Genera y muestra los resultados del reporte deseado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
  }
}
