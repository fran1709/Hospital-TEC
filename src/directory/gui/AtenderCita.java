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
  private JComboBox cbCentroMedico;

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

    if (Controlador.catalogoDiagnosticos.isEmpty()){
      Diagnostico diagnostico = new Diagnostico("Diarrea","Leve");
      Diagnostico diagnostico2 = new Diagnostico("Calentura","Leve");
      Diagnostico diagnostico3 = new Diagnostico("Vomito","Leve");
      Diagnostico diagnostico4 = new Diagnostico("Dolor de cabeza","Leve");
      Diagnostico diagnostico5 = new Diagnostico("Mareo","Leve");
      Diagnostico diagnostico6 = new Diagnostico("Dolor de articulaciones","Leve");
      Diagnostico diagnostico7 = new Diagnostico("Depresion","Grave");
      Diagnostico diagnostico8 = new Diagnostico("Gastritis","Muy grave");
      Controlador.catalogoDiagnosticos.add(diagnostico);
      Controlador.catalogoDiagnosticos.add(diagnostico2);
      Controlador.catalogoDiagnosticos.add(diagnostico3);
      Controlador.catalogoDiagnosticos.add(diagnostico4);
      Controlador.catalogoDiagnosticos.add(diagnostico5);
      Controlador.catalogoDiagnosticos.add(diagnostico6);
      Controlador.catalogoDiagnosticos.add(diagnostico7);
      Controlador.catalogoDiagnosticos.add(diagnostico8);

    }
    if (Controlador.catalogoTratamientos.isEmpty()){
      Tratamiento tratamiento = new Tratamiento("Pastillas de Belladona",1,"Medicamento");
      Tratamiento tratamiento1 = new Tratamiento("Jarabe",1,"Medicamento");
      Tratamiento tratamiento2 = new Tratamiento("Curita",1,"Sutura");
      Tratamiento tratamiento3 = new Tratamiento("Dorival",1,"Medicamento");

      Controlador.catalogoTratamientos.add(tratamiento);
      Controlador.catalogoTratamientos.add(tratamiento1);
      Controlador.catalogoTratamientos.add(tratamiento2);
      Controlador.catalogoTratamientos.add(tratamiento3);
    }

    cbCitas.setModel(new DefaultComboBoxModel(Controlador.getCitasDisponibles(paciente).toArray()));
    cbDiagnosticos.setModel(new DefaultComboBoxModel(Controlador.catalogoDiagnosticos.toArray()));
    cbTratamientos.setModel((new DefaultComboBoxModel(Controlador.catalogoTratamientos.toArray())));
    cbCentroMedico.setModel((new DefaultComboBoxModel(Controlador.centrosDeAtencion.toArray())));

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
        FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
        Date fecha = new Date();
        CentroAtencion centroAtencion = (CentroAtencion) cbCentroMedico.getSelectedItem();
        Cita cita = (Cita) cbCitas.getSelectedItem();
        CentroAtencion nombreCentro = (CentroAtencion) cbCentroMedico.getSelectedItem();
        Hospitalizacion newHospitalizacion = new Hospitalizacion(fecha,centroAtencion,funcionarioMedicina,diagnosticos,cita.getEspecialidad());
        paciente.agregarHospitalizacion(newHospitalizacion);
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
          setVisible(false);
          DocAccount newDocAcc = new DocAccount();
          newDocAcc.setVisible(true);

        }
      }
    });
  }
}
