package directory.gui;

import directory.clases.*;
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
  private JButton agregarDiagnosticoButton;
  private JButton agregarTratamiento;
  private JButton refrescarDiagbtn;
  private JLabel tfNombrePaciente;
  private JTextField tfFarmaceuticaVacuna;
  private JTextField tfNombreVacuna;
  private JTextField tfLoteVacuna;
  private JButton btnAgregarVacuna;
  private JButton agregarDiagnosticoACitaButton;
  private JButton hospitalizacionbtn;

  public AtenderCita() {
    // Atributos.
    setContentPane(AtendiendoCitaWindow);
    setTitle("Hospital TEC");
    setSize(900,700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    Paciente paciente = Controlador.tmpPaciente;
    tfNombrePaciente.setText(paciente.getNombre());
    ArrayList<Diagnostico> diagnosticos = new ArrayList<>();

    cbCitas.setModel(new DefaultComboBoxModel(paciente.getCitas().toArray()));
    cbDiagnosticos.setModel(new DefaultComboBoxModel(Controlador.catalogoDiagnosticos.toArray()));
    cbTratamientos.setModel((new DefaultComboBoxModel(Controlador.catalogoTratamientos.toArray())));

    btnAgregarVacuna.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!(tfFarmaceuticaVacuna.getText().isEmpty() || tfLoteVacuna.getText().isEmpty() || tfNombreVacuna.getText().isEmpty())) {
          String farmaceutica = tfFarmaceuticaVacuna.getText();
          int lote = Integer.parseInt(tfLoteVacuna.getText());
          String nombre = tfNombreVacuna.getText();
          Date fecha = new Date();
          Vacuna newVacuna = new Vacuna(fecha,nombre,farmaceutica,lote);
          paciente.getVacunasAplicadas().add(newVacuna);
          JOptionPane.showMessageDialog(null,"Vacuna añadida!");
        }
      }
    });

    refrescarDiagbtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cbDiagnosticos.setModel(new DefaultComboBoxModel(Controlador.catalogoDiagnosticos.toArray()));
      }
    });

    agregarDiagnosticoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DiagnosticoGUI diagnosticoGUI = new DiagnosticoGUI();
        diagnosticoGUI.setVisible(true);
      }
    });

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu de la cuenta.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        DocAccount newDocAcc = new DocAccount();
        newDocAcc.setVisible(true);
      }
    });
    agregarDiagnosticoACitaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Diagnostico diagnostico = (Diagnostico) cbDiagnosticos.getSelectedItem();
        diagnosticos.add(diagnostico);
        JOptionPane.showMessageDialog(null,"Diagnostico agregado a la cita!");
      }
    });
    agregarTratamiento.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Diagnostico diagnostico = (Diagnostico) cbDiagnosticos.getSelectedItem();
        Tratamiento tratamiento = (Tratamiento) cbTratamientos.getSelectedItem();
        diagnostico.getTratamientos().add(tratamiento);
        diagnostico.printDiagnostico();
      }
    });
    hospitalizacionbtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Date fecha = new Date();
        paciente.agregarHospitalizacion("Se ha hospitalizado al paciente. Fecha : " + fecha);
        paciente.printPaciente();
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
          Doctor doctor = (Doctor) Controlador.usuario;
          Cita cita = (Cita) cbCitas.getSelectedItem();
          doctor.atenderCita(paciente,cita,diagnosticos);
          cita.printCita();
          JOptionPane.showMessageDialog(null,"La cita ha sido atendida!");
        }
      }
    });
  }
}
