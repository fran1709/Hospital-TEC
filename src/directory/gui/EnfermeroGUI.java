package directory.gui;

import directory.clases.CentroAtencion;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class EnfermeroGUI extends JFrame {
  private JPanel enfermeroWindow;
  private JLabel jlCedula;
  private JLabel jlNombre;
  private JButton registrarButton;
  private JButton volverButton;
  private JTextField textFieldName;
  private JTextField textFieldCedula;
  private JComboBox cbLideradoPersonas;
  private JComboBox cbExpCapacitando;
  private JTextField textFieldContra;
  private JTextField textFieldUsuario;
  private JComboBox comboBoxCentro;


  public EnfermeroGUI() {
    // Atributos.
    setContentPane(enfermeroWindow);
    setTitle("Hospital TEC");
    setSize(450,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    comboBoxCentro.setModel(new DefaultComboBoxModel(Controlador.centrosDeAtencion.toArray(new CentroAtencion[0])));

    cbExpCapacitando.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cbExpCapacitando.getSelectedItem().toString();
        }
    });

    cbLideradoPersonas.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cbLideradoPersonas.getSelectedItem().toString();
        }
    });

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
          if (textFieldCedula.getText().isEmpty()|| textFieldName.getText().isEmpty()) {
              JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
              textFieldName.setText(null);
              textFieldCedula.setText(null);
              comboBoxCentro.setSelectedIndex(0);
              cbLideradoPersonas.setSelectedIndex(0);
              cbExpCapacitando.setSelectedIndex(0);
          }
          // El tipo de funcionario se codifica manualmente.
          // La fecha se obtiene con LocalDate.now().
          else {
              // Atributos del nuevo objeto.
              String nombre = textFieldName.getText();
              String cedula = textFieldCedula.getText();
              String usuario = textFieldUsuario.getText();
              String contrasehna = textFieldContra.getText();
              CentroAtencion centroAtencion = (CentroAtencion) comboBoxCentro.getSelectedItem();
              Date fecha = new Date();
              String cbExpe = (String) cbExpCapacitando.getSelectedItem();
              boolean expCapacitando = false;
              String lidero = (String) cbLideradoPersonas.getSelectedItem();
              boolean dirigePersonas = false;
              if (cbExpe.equals("Si")) {
                  expCapacitando = true;
              }
              if (lidero.equals("Si")) {
                  dirigePersonas = true;
              }
              //System.out.println(dirigePersonas);

              // Controlador para crear Enfermero(a).
              Controlador.registrarEnfermero(nombre,usuario,contrasehna,cedula,dirigePersonas,expCapacitando,fecha,centroAtencion.getCodigo());

              JOptionPane.showMessageDialog(null,"¡Registrado Exitosamente!");
              textFieldUsuario.setText(null);
              textFieldCedula.setText(null);
              textFieldName.setText(null);
              textFieldContra.setText(null);
              comboBoxCentro.setSelectedIndex(0);
              cbExpCapacitando.setSelectedIndex(0);
              cbLideradoPersonas.setSelectedIndex(0);
          }
      }
    });
  }
}
