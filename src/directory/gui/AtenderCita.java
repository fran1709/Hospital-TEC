package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class AtenderCita extends JFrame{
  private JPanel AtendiendoCitaWindow;
  private JComboBox cbCitas;
  private JButton atenderButton;
  private JButton volverButton;
  private JComboBox cbDiagnosticos;
  private JComboBox cbNivel;
  private JTextField tfObervacion;
  private JComboBox cbTratamientos;
  private JComboBox cbDosis;

  public AtenderCita() {
    // Atributos.
    setContentPane(AtendiendoCitaWindow);
    setTitle("Hospital TEC");
    setSize(450,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
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

    atenderButton.addActionListener(new ActionListener() {
      /**
       * Atiende la cita seleccionada.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tfObervacion.getText().length() <= 2 ) {
          JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
          tfObervacion.setText(null);
        }
          else {
            // Atenderla || Hospitalizar
        }
      }
    });
  }
}
