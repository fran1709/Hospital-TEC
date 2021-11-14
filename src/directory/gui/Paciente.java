package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Paciente extends JFrame{
  private JPanel pacienteWindow;
  private JLabel jlTitle;
  private JLabel jlNombre;
  private JLabel jlCedula;
  private JLabel jlFechaNacimiento;
  private JLabel jlSangre;
  private JLabel jlNacionalidad;
  private JLabel jlResidencia;
  private JLabel jlTelefono;
  private JLabel jlCelular;
    private JTextField tfCedula;
  private JTextField tfName;
  private JTextField tfResidencia;
  private JTextField tfTelefono;
  private JTextField tfCelular;
  private JButton registrarButton;
  private JButton volverButton;
  private JComboBox cbNacionalidad;
  private JComboBox cbTipoSangre;
  private JComboBox cbYear;
  private JComboBox cbMonth;
  private JComboBox cbDay;

  public Paciente() {
    // Atributos.
    setContentPane(pacienteWindow);
    setTitle("Hospital TEC");
    setSize(600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve a la ventana de registros.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registrar nuevoRegistro = new Registrar();
        nuevoRegistro.setVisible(true);
      }
    });

    registrarButton.addActionListener(new ActionListener() {
      /**
       * Registra un nuevo Paciente.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        // Validación de campos vacíos
        if (tfName.getText().length() <= 2 || tfCedula.getText().length() <= 2 || tfTelefono.getText().length() <= 2 ||
            tfCelular.getText().length() <= 2 || tfResidencia.getText().length() <= 2) {
          JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
          tfCedula.setText(null);
          tfName.setText(null);
          cbYear.setSelectedIndex(0);
          cbMonth.setSelectedIndex(0);
          cbDay.setSelectedIndex(0);
          cbNacionalidad.setSelectedIndex(0);
          cbTipoSangre.setSelectedIndex(0);
          tfCelular.setText(null);
          tfTelefono.setText(null);
        }
        // El tipo de funcionario se codifica manualmente.
        // La fecha se obtiene con LocalDate.now().
        else {
          // Atributos del nuevo objeto.
          String nombre = tfName.getText();
          String cedula = tfCedula.getText();
          String area = (String) cbNacionalidad.getSelectedItem();
          LocalDate fecha = LocalDate.of(parseInt(cbYear.getSelectedItem().toString()),
                                         parseInt(cbMonth.getSelectedItem().toString()),
                                         parseInt(cbDay.getSelectedItem().toString()));
          String tipoSangre = (String) cbTipoSangre.getSelectedItem();
          String nacionalidad = (String) cbNacionalidad.getSelectedItem();
          ArrayList<String> numeros = new ArrayList<String>();
          numeros.add(tfCelular.getText());
          numeros.add(tfTelefono.getText());
          String residencia = tfResidencia.getText();
          /* Falta definir como obtener las vacunas */
          // Controlador para crear Paciente.
        }
      }
    });

  } // end Paciente()

}
