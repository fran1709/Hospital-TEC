package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class RegistrarCita extends JFrame {
  private JPanel RegistrandoCitaWindow;
  private JButton volverButton;
  private JTextField tfAnhio;
  private JTextField tfMes;
  private JTextField tfDia;
  private JComboBox cbHora;
    private JComboBox cbEspecialidades;
  private JTextField tfObervation;
  private JButton asignarButton;

  public RegistrarCita() {
    // Atributos.
    setContentPane(RegistrandoCitaWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        //DocAccount newDocAcc = new DocAccount();
        //newDocAcc.setVisible(true);
      }
    });

    asignarButton.addActionListener(new ActionListener() {
      /**
       * Registra/Asigna la cita al paciente respectivo.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tfAnhio.getText().length() <= 2 || tfDia.getText().length() <= 2 || tfMes.getText().length() <= 2 ||
            tfObervation.getText().length() <= 2) {
          JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
        }
        else {
          // Asignar cita al usuario respectivo.
        }
      }
    });
  }
}
