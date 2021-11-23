package directory.gui;

import directory.clases.*;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Reporte extends JFrame{
  private JPanel ReportesWindow;
  private JTable jtableReportes;
  private JButton generarButton;
  private JButton volverButton;
  private JComboBox cbPacientes;
  private JComboBox cbReportes;
  private JTextField tfAnhio;
  private JTextField tfMes;
  private JTextField tfDia;
  private JTextField tfAnhioFinal;
  private JTextField tfMesFinal;
  private JTextField tfDiaFinal;
  private JComboBox comboBox1;
  private JLabel tf1;
  private JTextField textField1;
  private JButton empezarConsultaButton;
  private JLabel l1;
  private JLabel l2;
  private JLabel l3;
  private JLabel anho;
  private JLabel mes;
  private JLabel dia;
  private JList list;

  public Reporte() {
    // Atributos.
    setContentPane(ReportesWindow);
    setTitle("Hospital TEC");
    setSize(1000,900);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    Controlador.getListasUsuarios();
    tfAnhio.setVisible(false);
    tfAnhioFinal.setVisible(false);
    tfAnhio.setVisible(false);
    tfMes.setVisible(false);
    tfMesFinal.setVisible(false);
    tfDia.setVisible(false);
    tfDiaFinal.setVisible(false);
    anho.setVisible(false);
    mes.setVisible(false);
    dia.setVisible(false);
    l1.setVisible(false);
    l2.setVisible(false);
    l3.setVisible(false);
    tf1.setVisible(false);
    textField1.setVisible(false);

    if (!(Controlador.usuario.getClass() == Paciente.class)) {
      Controlador.getListasUsuarios();
      cbPacientes.setModel(new DefaultComboBoxModel(Controlador.pacientes.toArray(new Paciente[0])));
    }else {
      cbPacientes.addItem(Controlador.usuario);
      cbPacientes.setEnabled(false);


    }

    empezarConsultaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String choice = (String) comboBox1.getSelectedItem();

        if (choice.equals("Por rango de fechas")) {
          tfAnhio.setVisible(true);
          tfAnhioFinal.setVisible(true);
          tfAnhio.setVisible(true);
          tfMes.setVisible(true);
          tfMesFinal.setVisible(true);
          tfDia.setVisible(true);
          tfDiaFinal.setVisible(true);
          anho.setVisible(true);
          mes.setVisible(true);
          dia.setVisible(true);
          l1.setVisible(true);
          l2.setVisible(true);
          l3.setVisible(true);
          tf1.setVisible(false);
          textField1.setVisible(false);

        }else if (choice.equals("Por estado")) {

          tf1.setVisible(true);
          tf1.setText("Filtro por estado: ");
          textField1.setVisible(true);
          tfAnhio.setVisible(false);
          tfAnhioFinal.setVisible(false);
          tfAnhio.setVisible(false);
          tfMes.setVisible(false);
          tfMesFinal.setVisible(false);
          tfDia.setVisible(false);
          tfDiaFinal.setVisible(false);
          anho.setVisible(false);
          mes.setVisible(false);
          dia.setVisible(false);
          l1.setVisible(false);
          l2.setVisible(false);
          l3.setVisible(false);

        }else if (choice.equals("Por especialidad")) {
          tf1.setVisible(true);
          tf1.setText("Filtro por especialidad: ");
          tfAnhio.setVisible(false);
          tfAnhioFinal.setVisible(false);
          tfAnhio.setVisible(false);
          tfMes.setVisible(false);
          tfMesFinal.setVisible(false);
          tfDia.setVisible(false);
          tfDiaFinal.setVisible(false);
          anho.setVisible(false);
          mes.setVisible(false);
          dia.setVisible(false);
          l1.setVisible(false);
          l2.setVisible(false);
          l3.setVisible(false);
          textField1.setVisible(true);

        } else if (choice.equals("Por nombre de paciente")) {
          if (Controlador.usuario.getClass() == Paciente.class)
            JOptionPane.showMessageDialog(null,"Selecciona otra opcion, esta opcion es solo para funcionarios");
        } else if (choice.equals("Por nivel")){
          tf1.setVisible(true);
          textField1.setVisible(true);
          tf1.setText("Filtro por nivel de diagnóstico: ");
        }else if (choice.equals("Por nombre de diagnóstico")){
          tf1.setVisible(true);
          textField1.setVisible(true);
          tf1.setText("Filtro por nombre de diagnóstico: ");
        }

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
      }
    });

    generarButton.addActionListener(new ActionListener() {
      /**
       * Genera y muestra los resultados del reporte deseado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        String reporte = (String) cbReportes.getSelectedItem();

        if (reporte.equals("Citas")) {

          String choice = (String) comboBox1.getSelectedItem();
          ArrayList<Cita> citasArrayList = new ArrayList<>();


          // Consultas de Citas de Paciente
          if (Controlador.usuario.getClass() == Paciente.class) {

            Paciente paciente = (Paciente) Controlador.usuario;

            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              citasArrayList = paciente.citasDePacientePorFecha(dateInicio, dateFinal);
            } else if (choice.equals("Por estado")) {
              citasArrayList = paciente.citasDePacientePorEstado(textField1.getText());
            } else if (choice.equals("Por especialidad")) {
              citasArrayList = paciente.citasDePacientePorEspecialidad(textField1.getText());
            }else
              JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionario");
          }
          // Consulta de Citas de Enfermeros y Doctores
          if (Controlador.usuario.getClass() == FuncionarioMedicina.class) {
            FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }

              citasArrayList = funcionarioMedicina.cantidadCitasPorFecha(Controlador.pacientes, dateInicio, dateFinal);
            } else if (choice.equals("Por estado")) {
              citasArrayList = funcionarioMedicina.cantidadCitasPorEstado(Controlador.pacientes, textField1.getText());
            } else if (choice.equals("Por especialidad")) {
              citasArrayList = funcionarioMedicina.cantidadCitasPorEspecialidad(Controlador.pacientes, textField1.getText());
            } else if (choice.equals("Por nombre de paciente")) {
              Paciente paciente = (Paciente) cbPacientes.getSelectedItem();
              citasArrayList = paciente.getCitas();
            }
          }
          // Consulta de Citas por Secretarios
          if (Controlador.usuario.getClass() == Secretaria.class) {
            Secretaria secretaria = (Secretaria) Controlador.usuario;
            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              citasArrayList = secretaria.cantidadCitasPorFecha(Controlador.pacientes, dateInicio, dateFinal);
            } else if (choice.equals("Por estado")) {
              citasArrayList = secretaria.cantidadCitasPorEstado(Controlador.pacientes, textField1.getText());
            } else if (choice.equals("Por especialidad")) {
              citasArrayList = secretaria.cantidadCitasPorEspecialidad(Controlador.pacientes, textField1.getText());
            } else if (choice.equals("Por nombre de paciente")) {
              Paciente paciente = (Paciente) cbPacientes.getSelectedItem();
              citasArrayList = paciente.getCitas();
            }
          }
          // Llena el list Table
          DefaultListModel<String> listModel = new DefaultListModel<>();
          listModel.addElement("Identificador" + "                                          " + "Fecha" + "                                          " + "Hora" +
                  "                                          " + "Estado");
          for (Cita cita : citasArrayList) {
            String citaRow =
                    String.valueOf(cita.getIdentificador()) + "                                          " +
                            cita.getFechaCita() + "                         " +
                            String.valueOf(cita.getHora()) + "                                     " +
                            cita.getEstadoCita();
            listModel.addElement(citaRow);
          }
          list.setModel(listModel);
        }

        if (cbReportes.equals("Diagnosticos")) {

          String choice = (String) comboBox1.getSelectedItem();
          ArrayList<Diagnostico> diagnosticoArrayList = new ArrayList<>();

          if (Controlador.usuario.getClass() == Paciente.class) {

            Paciente paciente = (Paciente) Controlador.usuario;
            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              paciente.diagnosticosPorFecha(dateInicio, dateFinal);
            } else if (choice.equals("Por nivel")) {
              diagnosticoArrayList = paciente.diagnosticosPorNivel(textField1.getText());
            } else if (choice.equals("Por nombre de diagnóstico")) {
              diagnosticoArrayList = paciente.diagnosticosPorNombre(textField1.getText());
            }else
              JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionario");

          }
          if (Controlador.usuario.getClass() == FuncionarioMedicina.class) {
            FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
            Paciente paciente = (Paciente) cbPacientes.getSelectedItem();
            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              diagnosticoArrayList = funcionarioMedicina.diagnosticosPacientePorFecha(paciente, dateInicio, dateFinal);
            } else if (choice.equals("Por nivel")) {
              diagnosticoArrayList = funcionarioMedicina.diagnosticosPacientePorNivel(paciente, textField1.getText());
            } else if (choice.equals("Por nombre de diagnóstico")) {
              diagnosticoArrayList = funcionarioMedicina.diagnosticosPacientePorNombre(paciente, textField1.getText());
            }
          }
          if (Controlador.usuario.getClass() == Secretaria.class) {
            JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionarios de medicina");
          }
          // Llena el list Table
          DefaultListModel<String> listModel = new DefaultListModel<>();
          listModel.addElement("Nombre" + "                                          " + "Nivel");
          for (Diagnostico diagnostico : diagnosticoArrayList) {
            String diagRow =
                    String.valueOf(diagnostico.getNombre()) + "                                          " +
                            diagnostico.getNivel();
            listModel.addElement(diagRow);
          }
          list.setModel(listModel);
        }

        if (cbReportes.equals("Tratamientos")) {
          String choice = (String) comboBox1.getSelectedItem();
          ArrayList<Tratamiento> tratamientoArrayList = new ArrayList<>();

          if (Controlador.usuario.getClass() == Paciente.class) {
            Paciente paciente = (Paciente) Controlador.usuario;
            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              paciente.tratamientosPorFecha(dateInicio, dateFinal);
            } else if (choice.equals("Por tipo de tratamiento")) {
              tratamientoArrayList = paciente.tratamientosPorTipo(textField1.getText());
            } else if (choice.equals("Por nombre de tratamiento")) {
              tratamientoArrayList = paciente.tratamientosPorNombre(textField1.getText());
            }else {
              JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionario");
            }
          } else if (Controlador.usuario.getClass() == FuncionarioMedicina.class) {
            FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
            Paciente paciente = (Paciente) cbPacientes.getSelectedItem();
            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              tratamientoArrayList = funcionarioMedicina.tratamientosPacientePorFechas(paciente, dateInicio, dateFinal);
            } else if (choice.equals("Por tipo de tratamiento")) {
              tratamientoArrayList = funcionarioMedicina.tratamientosPacientePorTipo(paciente, textField1.getText());
            } else if (choice.equals("Por nombre de tratamiento")) {
              tratamientoArrayList = funcionarioMedicina.tratamientosPacientePorNombre(paciente, textField1.getText());
            } else if (Controlador.usuario.getClass() == Secretaria.class) {
              JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionarios de medicina");
            }
            // Llena el list Table
            DefaultListModel<String> listModel = new DefaultListModel<>();
            listModel.addElement("Nombre" + "                                          " + "Tipo" + "                                          " + "Dosis");
            for (Tratamiento tratamiento : tratamientoArrayList) {
              String tratRow =
                      String.valueOf(tratamiento.getNombre()) + "                                          " +
                              tratamiento.getTipo() + "                                          " +
                              tratamiento.getDosis();
              listModel.addElement(tratRow);
            }
            list.setModel(listModel);

          }

        }


        if (cbReportes.equals("Cantidad Citas")) {
          ArrayList<Cita> citasArrayList = new ArrayList<>();
          String choice = (String) cbReportes.getSelectedItem();
          if (Controlador.usuario.getClass() == FuncionarioMedicina.class) {
            FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
            if (choice.equals("Por rango de fechas")) {
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              citasArrayList = funcionarioMedicina.cantidadCitasPorFecha(Controlador.pacientes, dateInicio, dateFinal);
            } else if (choice.equals("Por especialidad")) {
              citasArrayList = funcionarioMedicina.cantidadCitasPorEspecialidad(Controlador.pacientes, textField1.getText());
            } else if (choice.equals("Por estado")) {
              citasArrayList = funcionarioMedicina.cantidadCitasPorEstado(Controlador.pacientes, textField1.getText());
            }
            // Llena el list Table
            DefaultListModel<String> listModel = new DefaultListModel<>();
            listModel.addElement("Identificador" + "                                          " + "Fecha" + "                                          " + "Hora" +
                    "                                          " + "Estado");
            for (Cita cita : citasArrayList) {
              String citaRow =
                      String.valueOf(cita.getIdentificador()) + "                                          " +
                              cita.getFechaCita() + "                         " +
                              String.valueOf(cita.getHora()) + "                                     " +
                              cita.getEstadoCita();
              listModel.addElement(citaRow);
            }
            list.setModel(listModel);

          } else {
            JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionarion de medicina");
          }
        }


        if (cbReportes.equals("Cantidad Diagnosticos")) {
          if (Controlador.usuario.getClass() == FuncionarioMedicina.class) {
            ArrayList<Diagnostico> diagnosticoArrayList = new ArrayList<>();
            String choice = (String) cbReportes.getSelectedItem();
            if (Controlador.usuario.getClass() == FuncionarioMedicina.class) {
              FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
              if (choice.equals("Por rango de fechas")) {
                String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
                String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date dateInicio = null;
                Date dateFinal = null;
                try {
                  dateInicio = formatter.parse(date_inicio);
                } catch (ParseException ex) {
                  ex.printStackTrace();
                }
                try {
                  dateFinal = formatter.parse(date_final);
                } catch (ParseException ex) {
                  ex.printStackTrace();
                }
                ArrayList<Cita> citasArrayList = funcionarioMedicina.cantidadCitasPorFecha(Controlador.pacientes, dateInicio, dateFinal);
                for (Cita cita : citasArrayList) {
                  diagnosticoArrayList.addAll(cita.getDiagnosticos());
                }
              } else if (choice.equals("Por especialidad")) {
                ArrayList<Cita> citasArrayList = funcionarioMedicina.cantidadCitasPorEstado(Controlador.pacientes, textField1.getText());
                for (Cita cita : citasArrayList) {
                  diagnosticoArrayList.addAll(cita.getDiagnosticos());
                }
              } else if (choice.equals("Por estado")) {
                ArrayList<Cita> citasArrayList = funcionarioMedicina.cantidadCitasPorEspecialidad(Controlador.pacientes, textField1.getText());
                for (Cita cita : citasArrayList) {
                  diagnosticoArrayList.addAll(cita.getDiagnosticos());
                }
              }
              // Llena el list Table
              DefaultListModel<String> listModel = new DefaultListModel<>();
              listModel.addElement("Nombre" + "                                          " + "Nivel");
              for (Diagnostico diagnostico : diagnosticoArrayList) {
                String diagRow =
                        String.valueOf(diagnostico.getNombre()) + "                                          " +
                                diagnostico.getNivel();
                listModel.addElement(diagRow);
              }
              list.setModel(listModel);
            }
          }else {
            JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionarion de medicina");
          }
        }

        if (cbReportes.equals("Cantidad Tratamientos")) {
          String choice = (String) comboBox1.getSelectedItem();
          FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
          Paciente paciente = (Paciente) cbPacientes.getSelectedItem();
          ArrayList<Tratamiento> tratamientoArrayList = new ArrayList<>();
          if (Controlador.usuario.getClass() == FuncionarioMedicina.class) {
            if (choice.equals("Conteo general")) {
              tratamientoArrayList = funcionarioMedicina.cantidadTratamientosGeneral(Controlador.pacientes);
            } else if (choice.equals("Por especialidad")) {
              tratamientoArrayList = funcionarioMedicina.cantidadTratamientosPorEspecialidad(Controlador.pacientes, textField1.getText());
            } else if (choice.equals("Por nombre de paciente")) {
              tratamientoArrayList = funcionarioMedicina.cantidadTratamientosPorPaciente(paciente);
            }
            // Llena el list Table
            DefaultListModel<String> listModel = new DefaultListModel<>();
            listModel.addElement("Nombre" + "                                          " + "Tipo" + "                                          " + "Dosis");
            for (Tratamiento tratamiento : tratamientoArrayList) {
              String tratRow =
                      String.valueOf(tratamiento.getNombre()) + "                                          " +
                              tratamiento.getTipo() + "                                          " +
                              tratamiento.getDosis();
              listModel.addElement(tratRow);
            }
            list.setModel(listModel);
          } else {
            JOptionPane.showMessageDialog(null, "Selecciona otra opcion, esta opcion es solo para funcionarios de medicina");
          }
        }
        if (cbReportes.equals("Hospitalizaciones")) {

          if (Controlador.usuario.getClass() == Paciente.class){
            Paciente paciente = (Paciente) Controlador.usuario;
            ArrayList<Hospitalizacion> hospitalizaciones = paciente.getHospitalizaciones();
            // Llena el list Table
            DefaultListModel<String> listModel = new DefaultListModel<>();
            listModel.addElement("Hospitalizaciones");
            listModel.addElement("");
            for (Hospitalizacion hospitalizacion : hospitalizaciones) {
              listModel.addElement(hospitalizacion.toString());
            }
            list.setModel(listModel);


          }
          else if (Controlador.usuario.getClass() == Secretaria.class){
            Secretaria secretaria = (Secretaria) Controlador.usuario;
            String choice = (String) comboBox1.getSelectedItem();
            ArrayList<Hospitalizacion> hospitalizaciones = new ArrayList<>();
            if (choice.equals("Por rango de fechas")){
              String date_inicio = tfDia.getText() + "-" + tfMes.getText() + "-" + tfAnhio.getText();
              String date_final = tfDiaFinal.getText() + "-" + tfMesFinal.getText() + "-" + tfAnhioFinal.getText();
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
              Date dateInicio = null;
              Date dateFinal = null;
              try {
                dateInicio = formatter.parse(date_inicio);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              try {
                dateFinal = formatter.parse(date_final);
              } catch (ParseException ex) {
                ex.printStackTrace();
              }
              hospitalizaciones = Controlador.getHospitalizacionesPorFecha(dateInicio,dateFinal);
            }
            else if (choice.equals("Por estado")){
              hospitalizaciones = Controlador.getHospitalizacionesPorEstado(textField1.getText());
            }
            else if (choice.equals("Por especialidad")){
              hospitalizaciones = Controlador.getHospitalizacionesPorEspecialidad(textField1.getText());
            }
            else if (choice.equals("Por nombre de paciente")){
              Paciente paciente = (Paciente) cbPacientes.getSelectedItem();
              hospitalizaciones = paciente.getHospitalizaciones();
            }
            // Llena el list Table
            DefaultListModel<String> listModel = new DefaultListModel<>();
            listModel.addElement("Hospitalizaciones");
            listModel.addElement("");
            for (Hospitalizacion hospitalizacion : hospitalizaciones) {
              listModel.addElement(hospitalizacion.toString());
            }
            list.setModel(listModel);

          }else if (Controlador.usuario.getClass() == FuncionarioMedicina.class){
            FuncionarioMedicina funcionarioMedicina = (FuncionarioMedicina) Controlador.usuario;
            Paciente paciente = (Paciente) cbPacientes.getSelectedItem();
            ArrayList<Hospitalizacion> hospitalizaciones = paciente.getHospitalizaciones();
            // Llena el list Table
            DefaultListModel<String> listModel = new DefaultListModel<>();
            listModel.addElement("Hospitalizaciones");
            listModel.addElement("");
            for (Hospitalizacion hospitalizacion : hospitalizaciones) {
              listModel.addElement(hospitalizacion.toString());
            }
            list.setModel(listModel);

          }
        }
      }
    });
  }
}
