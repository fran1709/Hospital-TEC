package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import directory.controladores.controladores.Controlador;

/**
 * @author Francisco Ovares
 */
public class CentroMedic extends JFrame {
  private JPanel CentroMedicWindow;
  private JButton volverButton;
  private JComboBox cbTipo;
  private JTextField tfCodigo;
  private JTextField tfNombre;
  private JTextField tfUbicacion;
  private JTextField tfCantidadPacientes;
  private JButton registrarButton;

  public CentroMedic() {
    // Atributos.
    setContentPane(CentroMedicWindow);
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
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registrar nuevoRegistro = new Registrar();
        nuevoRegistro.setVisible(true);
      }
    });

    registrarButton.addActionListener(new ActionListener() {
      /**
       * Registra el nuevo centro medico.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tfNombre.getText().isEmpty() || tfCodigo.getText().isEmpty() ||
                tfCantidadPacientes.getText().isEmpty() || tfUbicacion.getText().isEmpty() ) {
          JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
          tfNombre.setText(null);
          tfCodigo.setText(null);
          tfCantidadPacientes.setText(null);
          tfUbicacion.setText(null);
          cbTipo.setSelectedIndex(0);
        }
        // El tipo de funcionario se codifica manualmente.
        // La fecha se obtiene con LocalDate.now().
        else {
          // Atributos del nuevo objeto.
          int codigo = Integer.parseInt(tfCodigo.getText());
          int capacity = Integer.parseInt(tfCantidadPacientes.getText());
          String nombre = tfNombre.getText();
          String ubicacion = tfUbicacion.getText();
          String tipo = (String) cbTipo.getSelectedItem();

          // Controlador de registro de centros medicos
          Controlador.registrarCentroDeAtencion(codigo,capacity,nombre,ubicacion,tipo);

          JOptionPane.showMessageDialog(null,"¡Registrado Exitosamente!");
          tfNombre.setText(null);
          tfCodigo.setText(null);
          tfCantidadPacientes.setText(null);
          tfUbicacion.setText(null);
          cbTipo.setSelectedIndex(0);
        }
      }
    });
  }
}
