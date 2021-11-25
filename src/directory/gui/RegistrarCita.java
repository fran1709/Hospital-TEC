package directory.gui;

import directory.auxiliarclases.JavaMailAPI;
import directory.clases.*;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class RegistrarCita extends JFrame {
  private JPanel RegistrandoCitaWindow;
  private JButton volverButton;
  private JTextField tfAnhio;
  private JTextField tfMes;
  private JTextField tfDia;
  private JComboBox cbHora;
  private JComboBox cbEspecialidades;
  private JTextField tfObervation;
  private JButton asignarButton;
  private JButton correoBTN;
  private JTextField tfCorreo;

  public RegistrarCita() {
    // Atributos.
    setContentPane(RegistrandoCitaWindow);
    setTitle("Hospital TEC");
    setSize(450,400);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());


    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu de la cuenta.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    asignarButton.addActionListener(new ActionListener() {
      /**
       * Registra/Asigna la cita al paciente respectivo.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tfAnhio.getText().isEmpty() || tfDia.getText().isEmpty() || tfMes.getText().isEmpty() ||
            tfObervation.getText().isEmpty()) {
          JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
        }
        else {
          Date fecha = null;
          try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            fecha = formatter.parse(tfDia.getText()+"-"+tfMes.getText()+ "-" +tfAnhio.getText());
            System.out.println(fecha);
          } catch (ParseException ex) {
            ex.printStackTrace();
          }
            if (Controlador.usuario.getClass() == Paciente.class) {
              // Asignar cita al usuario respectivo.
              Paciente paciente = (Paciente) Controlador.usuario;
              Controlador.idCita = Controlador.idCita + 1;
              Cita newCita = new Cita(cbEspecialidades.getSelectedItem().toString(), fecha, tfObervation.getText(), Controlador.idCita, Integer.parseInt(cbHora.getSelectedItem().toString()));
              paciente.getCitas().add(newCita);
              JOptionPane.showMessageDialog(null,"Cita asignada");
              try {
                JavaMailAPI.enviarCorreo(paciente.getNombre(),tfCorreo.getText(), newCita.printCitaHTML());
              } catch (Exception ex) {
                ex.printStackTrace();
              }
              setVisible(false);
              PacientAcc newPatientAcc = new PacientAcc();
              newPatientAcc.setVisible(true);

            } else if (Controlador.usuario.getClass() == Secretaria.class) {
              Paciente paciente = Controlador.tmpPaciente;
              Secretaria secretaria = (Secretaria) Controlador.usuario;
              Controlador.idCita = Controlador.idCita + 1;
              secretaria.asignarCita(paciente,cbEspecialidades.getSelectedItem().toString(),fecha,tfObervation.getText(),Controlador.idCita,Integer.parseInt(cbHora.getSelectedItem().toString()));
              JOptionPane.showMessageDialog(null,"Cita asignada");
              setVisible(false);
              SecreAcc newDocAcc = new SecreAcc();
              newDocAcc.setVisible(true);

            }
            else if (Controlador.usuario.getClass() == Enfermero.class){
              Paciente paciente = Controlador.tmpPaciente;
              Enfermero enfermero = (Enfermero) Controlador.usuario;
              Controlador.idCita = Controlador.idCita + 1;
              enfermero.asignarCita(paciente,cbEspecialidades.getSelectedItem().toString(),fecha,tfObervation.getText(),Controlador.idCita,Integer.parseInt(cbHora.getSelectedItem().toString()));
              JOptionPane.showMessageDialog(null,"Cita asignada");
              setVisible(false);
              NuserAccount newEnfermeroACC = new NuserAccount();
              newEnfermeroACC.setVisible(true);
            }
            else if (Controlador.usuario.getClass() == Doctor.class){
              Paciente paciente = Controlador.tmpPaciente;
              Doctor doctor = (Doctor) Controlador.usuario;
              Controlador.idCita = Controlador.idCita + 1;
              doctor.asignarCita(paciente,cbEspecialidades.getSelectedItem().toString(),fecha,tfObervation.getText(),Controlador.idCita,Integer.parseInt(cbHora.getSelectedItem().toString()));
              JOptionPane.showMessageDialog(null,"Cita asignada");
              setVisible(false);
              DocAccount newDocAccount = new DocAccount();
              newDocAccount.setVisible(true);
            }


        }
      }
    });
  }
}
