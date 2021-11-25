package directory.gui;

import directory.clases.CentroAtencion;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class SecretarioGUI extends JFrame {
  private JPanel secreWindow;
  private JLabel jlTitle;
  private JButton registrarButton;
  private JButton volverButton;
    private JLabel jlNombre;
    private JLabel jlCedula;
    private JComboBox comboBoxArea;
    private JTextField textFieldName;
    private JTextField textFieldCedula;
  private JTextField textFieldUsuario;
  private JTextField textFieldContrasehna;

  public SecretarioGUI() {
    // Atributos.
    setContentPane(secreWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    comboBoxArea.setModel(new DefaultComboBoxModel(Controlador.centrosDeAtencion.toArray(new CentroAtencion[0])));

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
        if (textFieldName.getText().isEmpty()|| textFieldCedula.getText().isEmpty()) {
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
          CentroAtencion centroAtencion = (CentroAtencion) comboBoxArea.getSelectedItem();
          String usuario = textFieldUsuario.getText();
          String contra = textFieldContrasehna.getText();
          Date fecha = new Date();
          // Controlador para crear Secretario(a).
          Controlador.registrarSecretaria(usuario,contra,nombre,cedula,fecha,centroAtencion.getCodigo());
          JOptionPane.showMessageDialog(null,"¡Registrado Exitosamente!");
          textFieldCedula.setText(null);
          textFieldName.setText(null);
          textFieldUsuario.setText(null);
          textFieldContrasehna.setText(null);
          comboBoxArea.setSelectedIndex(0);
        }
      }
    });
  }
}
