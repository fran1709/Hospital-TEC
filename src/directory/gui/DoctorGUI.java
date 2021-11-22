package directory.gui;

import directory.clases.CentroAtencion;
import directory.clases.Usuario;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class DoctorGUI extends JFrame{
  private JPanel docWindow;
  private JLabel jlTitle;
  private JButton volverButton;
  private JLabel jlCedula;
  private JLabel jlNombre;
  private JLabel jlArea;
  private JComboBox comboBoxArea;
  private JTextField textFieldUsuario;
  private JTextField textFieldCedula;
  private JButton registrarButton;
  private JLabel jlCodigo;
  private JTextField textFieldCodigoMedico;
  private JTextField TextFieldContra;
  private JButton agregarEspecialidad;
  private JComboBox comboBoxCentro;

  public DoctorGUI() {
    // Atributos.
    setContentPane(docWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    comboBoxCentro.setModel(new DefaultComboBoxModel(Controlador.centrosDeAtencion.toArray(new CentroAtencion[0])));
    // Especialidades
    ArrayList<String> especialidades = new ArrayList<>();
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
        if (textFieldUsuario.getText().isEmpty() || textFieldCedula.getText().isEmpty() ||
            textFieldCodigoMedico.getText().isEmpty() ) {
          JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
          textFieldCedula.setText(null);
          textFieldUsuario.setText(null);
          comboBoxArea.setSelectedIndex(0);
        }
        // El tipo de funcionario se codifica manualmente.
        // La fecha se obtiene con LocalDate.now().
        else {
          // Atributos del nuevo objeto.
          String nombre = textFieldUsuario.getText();
          String cedula = textFieldCedula.getText();
          String codigoMedico = textFieldCodigoMedico.getText();
          CentroAtencion centroAtencion = (CentroAtencion) comboBoxArea.getSelectedItem();
          String usuario = textFieldUsuario.getText();
          String contra = TextFieldContra.getText();
          Date fecha = new Date();

          // Controlador para crear Doctor(a)
          Controlador.registrarDoctor(usuario,contra,nombre,cedula,Integer.parseInt(codigoMedico),especialidades,fecha,centroAtencion.getCodigo());

          for (Usuario doctor : Controlador.usuarios){
            System.out.println(doctor.toString());
          }


        }

      }
    });
    agregarEspecialidad.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String area = (String) comboBoxArea.getSelectedItem();
        especialidades.add(area);
        if (!especialidades.isEmpty()){}
        for (String esp : especialidades)
          System.out.println(esp);
      }
    });

  }
}
