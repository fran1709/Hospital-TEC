package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class CancelaCita extends JFrame{
  private JPanel CancelaCitaWindow;
  private JComboBox cbCitas;
  private JButton cancelarButton;
  private JButton volverButton;

  public CancelaCita() {
    // Atributos.
    setContentPane(CancelaCitaWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
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

    cancelarButton.addActionListener(new ActionListener() {
      /**
       * Cancela la cita seleccionada.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
  }
}
