package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class Secretario extends JFrame {
  private JPanel secreWindow;
  private JLabel jlTitle;
  private JButton registrarButton;
  private JButton volverButton;
    private JLabel jlNombre;
    private JLabel jlCedula;
    private JComboBox comboBoxArea;
    private JTextField textFieldName;
    private JTextField textFieldCedula;

    public Secretario() {
    // Atributos.
    setContentPane(secreWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registrar nuevoRegistro = new Registrar();
        nuevoRegistro.setVisible(true);
      }
    });

    registrarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Validación de campos vacíos
        if (textFieldName.getText().length() <= 2 || textFieldCedula.getText().length() <= 2) {
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
          String area = (String) comboBoxArea.getSelectedItem();
          LocalDate fecha = LocalDate.now();

          // Controlador para crear Secretario(a).
        }
      }
    });
  }
}
