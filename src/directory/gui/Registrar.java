package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class Registrar extends JFrame{
  private JPanel regristrosWindow;
  private JLabel jlTitle;
  private JButton volverButton;
  private JButton doctorAButton;
  private JButton enfermeroAButton;
  private JButton secretarioAButton;
  private JButton pacienteButton;

  public Registrar() {
    // Atributos.
    setContentPane(regristrosWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve a la ventana de menu principal.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        MainGui mainMenu = new MainGui();
        mainMenu.setVisible(true);
      }
    });

    doctorAButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para registrar un(a) nuevo(a) Doctor(a).
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Doctor newDoc = new Doctor();
        newDoc.setVisible(true);
      }
    });

    enfermeroAButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para registrar un(a) nuevo(a) Enfermero(a).
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Enfermero newNurse = new Enfermero();
        newNurse.setVisible(true);
      }
    });

    secretarioAButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para registrar un(a) nuevo(a) Secretario(a).
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Secretario nuevoSecre = new Secretario();
        nuevoSecre.setVisible(true);
      }
    });

    pacienteButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para registrar un nuevo Paciente.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Paciente newPacient = new Paciente();
        newPacient.setVisible(true);
      }
    });
  }
}
