package directory.gui;

import directory.clases.Doctor;
import directory.clases.Enfermero;
import directory.clases.Secretaria;
import directory.clases.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class LogIn extends JFrame{
  private JPanel panel1;
  private JLabel jlTitle;
  private JTextField tfUsuario;
  private JTextField tfContrasenhia;
  private JButton logearButton;
  private JButton volverButton;
  private JLabel jlContra;
  private JLabel jlUser;

  public LogIn() {
    setContentPane(panel1);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    volverButton.addActionListener(new ActionListener() {
      /**
       *  Vuelve al menu principal.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        MainGui menuPincipal = new MainGui();
        menuPincipal.setVisible(true);
      }
    });

    logearButton.addActionListener(new ActionListener() {
      /**
       * Inicia sesión dependiendo de las credenciales y el tipo de usuario.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
          // Validación de campos vacíos
          if (tfUsuario.getText().length() <= 2 || tfContrasenhia.getText().length() <= 2) {
              JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
              tfUsuario.setText(null);
              tfContrasenhia.setText(null);
          }
          else {
              // Validar el tipo de credenciales .

              // Usuarios prueba
              ArrayList<String> especial = new ArrayList<String>();
              LocalDate fecha = LocalDate.now();
              Doctor one = new Doctor("fran17", "123", "Francisco Javier", "207710202",
                                      1709,especial, fecha);
              ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
              usuarios.add(one);
              Enfermero two = new Enfermero("sandra05", "123", "Sandra Piedra", "207710082",
                      true, true,fecha);
              usuarios.add(two);
              // Fin usuarios prueba

              // necesario cambiar el ArrayList -> usuarios por la que almacena todos los que serán creados.
              for (Usuario userActual : usuarios) {
                // Validación de usuario
                if (userActual.getUsuario().compareTo(tfUsuario.getText()) == 0 &&
                        userActual.getContrasenha().compareTo(tfContrasenhia.getText()) == 0) {
                  // Validaciones del tipo
                  if (userActual.getClass() == Doctor.class) {
                    JOptionPane.showMessageDialog(null, "Bienvenido(a)!");
                    setVisible(false);
                    DocAccount doc = new DocAccount();
                    doc.setVisible(true);
                  }
                  else if (userActual.getClass() == Enfermero.class) {
                    JOptionPane.showMessageDialog(null, "Bienvenido(a)!");
                    setVisible(false);
                    NuserAccount nurse = new NuserAccount();
                    nurse.setVisible(true);
                  }
                  else if (userActual.getClass() == Secretaria.class) {
                      JOptionPane.showMessageDialog(null, "Bienvenido(a)!");
                      setVisible(false);
                      // Falta agregar secreAcc
                  }
                  else {
                      JOptionPane.showMessageDialog(null, "Bienvenido(a)!");
                      setVisible(false);
                      // Falta agregar pascienteAcc
                  }
                }
              }
          }
      }
    });
  }
}
