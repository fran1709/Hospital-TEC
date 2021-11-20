package directory.gui;

import directory.clases.Cita;
import directory.clases.Paciente;
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

  public RegistrarCita() {
    // Atributos.
    setContentPane(RegistrandoCitaWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu de la cuenta.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        //DocAccount newDocAcc = new DocAccount();
        //newDocAcc.setVisible(true);
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
            fecha = formatter.parse(tfAnhio.getText()+"-"+tfMes.getText()+ "-" +tfDia.getText());
          } catch (ParseException ex) {
            ex.printStackTrace();
          }
          // Asignar cita al usuario respectivo.
          Paciente paciente = (Paciente) Controlador.usuario;
          Controlador.idCita = Controlador.idCita+1;
          Cita newCita = new Cita(cbEspecialidades.getSelectedItem().toString(),fecha,tfObervation.getText(),Controlador.idCita,Integer.parseInt(cbHora.getSelectedItem().toString()));
          paciente.getCitas().add(newCita);
          for (Cita pCita : paciente.getCitas()) {
            System.out.println(pCita.toString());
          }

        }
      }
    });
  }
}
