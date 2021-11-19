package directory.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Francisco Ovares Rojas
 */
public class MainGui extends JFrame{
  private JPanel mainWindow;
  private JButton inciarSesionButton;
  private JButton registrarseButton;
  private JButton salirButton;
  private JLabel jlTitle;

  public MainGui() {
    // Atributos.
    setContentPane(mainWindow);
    setTitle("Hospital TEC");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());

    salirButton.addActionListener(new ActionListener() {
      /**
       * Cierra y finaliza el programa.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    registrarseButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para registrar un nuevo usuario.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registrar nuevoRegistro = new Registrar();
        nuevoRegistro.setVisible(true);
      }
    });

    inciarSesionButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para logear como usuario.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        LogIn newLog = new LogIn();
        newLog.setVisible(true);
      }
    });
  }

  public static void main(String[] args) {
    // Instanciando el Gui.
    MainGui guiPrincipal = new MainGui();
  }
}
