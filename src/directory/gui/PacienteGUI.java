package directory.gui;

import directory.clases.Vacuna;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static java.lang.Integer.parseInt;

/**
 * @author Francisco Ovares Rojas
 */
public class PacienteGUI extends JFrame {
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
  private JTextField tfUsuario;
  private JTextField tfContra;
  private JComboBox anhoVacuna;
  private JComboBox mesVacuna;
  private JComboBox diaVacuna;
  private JTextField tfFarmaceutica;
  private JTextField tfNombreVacuna;
  private JButton agregarVacunaButton;
  private JTextField tfLote;

  public PacienteGUI() {
    // Atributos.
    setContentPane(pacienteWindow);
    setTitle("Hospital TEC");
    setSize(800, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    ArrayList<Vacuna> vacunas = new ArrayList<>();

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

    agregarVacunaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Date fechaVacuna = null;
        String farmaceutica = tfFarmaceutica.getText();
        String nombreVacuna = tfNombreVacuna.getText();
        String idLote = tfLote.getText();
        try {
          SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
          fechaVacuna = formatter.parse(anhoVacuna.getSelectedItem().toString()+"-"+mesVacuna.getSelectedItem().toString()+ "-" +diaVacuna.getSelectedItem().toString());
        } catch (ParseException ex) {
          ex.printStackTrace();
        }
        Vacuna vacuna = new Vacuna(fechaVacuna,nombreVacuna,farmaceutica,Integer.parseInt(idLote));
        vacunas.add(vacuna);
        JOptionPane.showMessageDialog(null,"Vacuna agregada!");
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
          JOptionPane.showMessageDialog(null, "Ingrese datos válidos!");
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
          String usuario = (String) tfUsuario.getText();
          String contrasehna = (String) tfContra.getText();
          SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
          Date fecha = null;

          try {
            fecha = formatter.parse(cbDay.getSelectedItem().toString()+"-"+cbMonth.getSelectedItem().toString()+ "-" +cbYear.getSelectedItem().toString());
          } catch (ParseException ex) {
            ex.printStackTrace();
          }
          String tipoSangre = (String) cbTipoSangre.getSelectedItem();
          String nacionalidad = (String) cbNacionalidad.getSelectedItem();
          ArrayList<String> numeros = new ArrayList<String>();
          numeros.add(tfCelular.getText());
          numeros.add(tfTelefono.getText());
          String residencia = tfResidencia.getText();

          // Controlador para crear Paciente.
          Controlador.registrarPaciente(usuario,contrasehna,nombre,cedula,fecha,tipoSangre,nacionalidad,residencia,numeros,vacunas);

          JOptionPane.showMessageDialog(null,"¡Registrado Exitosamente!");
          tfName.setText(null);
          tfUsuario.setText(null);
          tfTelefono.setText(null);
          tfCelular.setText(null);
          tfResidencia.setText(null);
          tfFarmaceutica.setText(null);
          tfNombreVacuna.setText(null);
          tfLote.setText(null);
          tfContra.setText(null);
          tfCedula.setText(null);
          cbNacionalidad.setSelectedIndex(0);
          cbDay.setSelectedIndex(0);
          cbMonth.setSelectedIndex(0);
          cbTipoSangre.setSelectedIndex(0);
          cbYear.setSelectedIndex(0);
          anhoVacuna.setSelectedIndex(0);
          mesVacuna.setSelectedIndex(0);
          diaVacuna.setSelectedIndex(0);
        }
      }
    });

  } // end Paciente()

}
