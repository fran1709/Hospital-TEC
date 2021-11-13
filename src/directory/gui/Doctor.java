package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class Doctor extends JFrame{
  private JPanel docWindow;
  private JLabel jlTitle;
  private JButton volverButton;
  private JLabel jlCedula;
  private JLabel jlNombre;
  private JLabel jlArea;
  private JComboBox comboBoxArea;
  private JTextField textFieldName;
  private JTextField textFieldCedula;
  private JButton registrarButton;
  private JLabel jlCodigo;
  private JTextField textFieldCodigoMedico;

  public Doctor() {
    // Atributos.
    setContentPane(docWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registrar newRegistro = new Registrar();
        newRegistro.setVisible(true);
      }
    });

    registrarButton.addActionListener(new ActionListener() {
      /**
       * Registra al nuevo funcionario de tipo Doctor(a).
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        // Validación de campos vacíos
        if (textFieldName.getText().length() <= 2 || textFieldCedula.getText().length() <= 2 ||
            textFieldCodigoMedico.getText().length() <=2 ) {
          JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
          textFieldCedula.setText(null);
          textFieldName.setText(null);
          comboBoxArea.setSelectedIndex(0);
        }
        // El tipo de funcionario se codifica manualmente.
        // La fecha se obtiene con LocalDate.now().
        else {
          // Atributos del nuevo objeto.
          String nombre = textFieldName.getText();
          String cedula = textFieldCedula.getText();
          String codigoMedico = textFieldCodigoMedico.getText();
          String area = (String) comboBoxArea.getSelectedItem();
          LocalDate fecha = LocalDate.now();

          // Controlador para crear Doctor(a).
        }

      }
    });

  }
}
