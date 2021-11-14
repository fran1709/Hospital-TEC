package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class Enfermero extends JFrame {
  private JPanel enfermeroWindow;
  private JLabel jlCedula;
  private JLabel jlNombre;
  private JButton registrarButton;
  private JButton volverButton;
  private JTextField textFieldCedula;
  private JTextField textFieldName;
  private JComboBox comboBoxArea;
  private JComboBox cbLideradoPersonas;
  private JComboBox cbExpCapacitando;

  public Enfermero() {
    // Atributos.
    setContentPane(enfermeroWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve a la ventana de registros.
       * @param e
       */
      @Override public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registrar newRegistro = new Registrar();
        newRegistro.setVisible(true);
      }
    });

    registrarButton.addActionListener(new ActionListener() {
      /**
       * Registra al nuevo funcionario de tipo Enfermero (a).
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
          // Validación de campos vacíos
          if (textFieldName.getText().length() <= 2 || textFieldCedula.getText().length() <= 2) {
              JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
              textFieldCedula.setText(null);
              textFieldName.setText(null);
              comboBoxArea.setSelectedIndex(0);
              cbLideradoPersonas.setSelectedIndex(0);
              cbExpCapacitando.setSelectedIndex(0);
          }
          // El tipo de funcionario se codifica manualmente.
          // La fecha se obtiene con LocalDate.now().
          else {
              // Atributos del nuevo objeto.
              String nombre = textFieldName.getText();
              String cedula = textFieldCedula.getText();
              String area = (String) comboBoxArea.getSelectedItem();
              LocalDate fecha = LocalDate.now();
              String cbExpe = (String) cbExpCapacitando.getSelectedItem();
              boolean expCapacitando = false;
              String lidero = (String) cbLideradoPersonas.getSelectedItem();
              boolean dirigePersonas = false;
              if (cbExpe.compareTo("Si") == 0) {
                  expCapacitando = true;
              }
              if (lidero.compareTo("Si") == 0) {
                  dirigePersonas = true;
              }
              //System.out.println(dirigePersonas);

              // Controlador para crear Enfermero(a).
          }
      }
    });
  }
}
