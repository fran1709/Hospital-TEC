package directory.gui;

import directory.clases.*;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class CancelaCita extends JFrame{
  private JPanel CancelaCitaWindow;
  private JComboBox cbCitas;
  private JButton cancelarButton;
  private JButton volverButton;
  private JLabel tfPaciente;


  public CancelaCita() {
    // Atributos.
    setContentPane(CancelaCitaWindow);
    setTitle("Hospital TEC");
    setSize(450,350);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    if (Controlador.usuario.getClass() == Paciente.class) {
        Paciente paciente = (Paciente) Controlador.usuario;
        ArrayList<Cita> citas = paciente.getCitas();
        tfPaciente.setText(paciente.getNombre());
        cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));

    } else if (Controlador.usuario.getClass() == Secretaria.class) {
      Paciente paciente = Controlador.tmpPaciente;
      ArrayList<Cita> citas = paciente.getCitas();
      tfPaciente.setText(paciente.getNombre());
      cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));

    }else if (Controlador.usuario.getClass() == Enfermero.class) {
      Paciente paciente = Controlador.tmpPaciente;
      ArrayList<Cita> citas = paciente.getCitas();
      tfPaciente.setText(paciente.getNombre());
      cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));

    }else if (Controlador.usuario.getClass() == Doctor.class) {
      Paciente paciente = Controlador.tmpPaciente;
      ArrayList<Cita> citas = paciente.getCitas();
      tfPaciente.setText(paciente.getNombre());
      cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));
    }



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

    cancelarButton.addActionListener(new ActionListener() {
      /**
       * Cancela la cita seleccionada.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

          if (Controlador.usuario.getClass() == Paciente.class) {
            Paciente paciente = (Paciente) Controlador.usuario;
            ArrayList<Cita> citas = paciente.getCitas();
            tfPaciente.setText(paciente.getNombre());
            cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));
            cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));
            Cita pCita = (Cita) cbCitas.getSelectedItem();
            paciente.cancelarCita(pCita.getIdentificador());
            JOptionPane.showMessageDialog(null,"Cita cancelada por el paciente");

          }
          if (Controlador.usuario.getClass() == Secretaria.class) {
            Secretaria secretaria = (Secretaria) Controlador.usuario;
            Paciente paciente = Controlador.tmpPaciente;
            ArrayList<Cita> citas = paciente.getCitas();
            tfPaciente.setText(paciente.getNombre());
            cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));
            Cita pCita = (Cita) cbCitas.getSelectedItem();
            System.out.println(pCita.getIdentificador());
            secretaria.cancelarCita(paciente,pCita.getIdentificador());
            JOptionPane.showMessageDialog(null,"Cita cancelada por el centro medico");



          }

          if (Controlador.usuario.getClass() == Enfermero.class) {

            Enfermero enfermero = (Enfermero) Controlador.usuario;
            Paciente paciente = Controlador.tmpPaciente;
            ArrayList<Cita> citas = paciente.getCitas();
            tfPaciente.setText(paciente.getNombre());
            cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));
            Cita pCita = (Cita) cbCitas.getSelectedItem();
            enfermero.cancelarCita(paciente,pCita.getIdentificador());
            JOptionPane.showMessageDialog(null,"Cita cancelada por el enfermero " + enfermero.getNombre());

          }

        if (Controlador.usuario.getClass() == Doctor.class) {

          Doctor doctor = (Doctor) Controlador.usuario;
          Paciente paciente = Controlador.tmpPaciente;
          ArrayList<Cita> citas = paciente.getCitas();
          tfPaciente.setText(paciente.getNombre());
          cbCitas.setModel(new DefaultComboBoxModel(citas.toArray()));
          Cita pCita = (Cita) cbCitas.getSelectedItem();
          System.out.println(pCita.getIdentificador());
          doctor.cancelarCita(paciente,pCita.getIdentificador());
          JOptionPane.showMessageDialog(null,"Cita cancelada por el doctor " + doctor.getNombre());

        }


        }
    });
  }
}
