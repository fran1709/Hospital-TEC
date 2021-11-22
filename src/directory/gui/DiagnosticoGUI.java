package directory.gui;

import directory.clases.Diagnostico;
import directory.clases.Tratamiento;
import directory.controladores.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class DiagnosticoGUI extends JFrame{
    private JPanel AtendiendoCitaWindow;
    private JButton agregarDiagnosticoButton;
    private JButton volverButton;
    private JComboBox cbNivel;
    private JComboBox cbTratamientos;
    private JTextField tfNombre;
    private JButton agregarNuevoTratamientoButton;
    private JTextField tfNombreTratamiento;
    private JTextField tfDosisTra;
    private JTextField tfTipoTrat;
    private JButton agregarTratamientoDelCatalogoButton;
    private JLabel tfDosisCat;
    private JLabel l1;
    private JComboBox cbCatalogoTrats;
    private JTextField tfDosisCAT;
    private JComboBox cbTratNew;
    private JTextField tfTipoCat;

    public DiagnosticoGUI() {
        // Atributos.
        setContentPane(AtendiendoCitaWindow);
        setTitle("Hospital TEC");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();
        cbCatalogoTrats.setModel(new DefaultComboBoxModel(Controlador.catalogoTratamientos.toArray(new Tratamiento[0])));

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        agregarNuevoTratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfDosisTra.getText().isEmpty() || tfNombreTratamiento.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
                    tfDosisTra.setText(null);
                    tfNombreTratamiento.setText(null);
                    tfTipoTrat.setText(null);
                }else{
                    String dosis = tfDosisTra.getText();
                    String nombre = tfNombreTratamiento.getText();
                    String tipo =(String) cbTratNew.getSelectedItem();
                    Tratamiento newTratamiento = new Tratamiento(nombre,Integer.parseInt(dosis),tipo);
                    tratamientos.add(newTratamiento);
                    newTratamiento.printTratamiento();
                    JOptionPane.showMessageDialog(null,"Tratamiento agregado!");
                }
            }
        });

        agregarTratamientoDelCatalogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfDosisCat.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
                    tfNombre.setText(null);
                }else {
                    int dosis = Integer.parseInt(tfDosisCAT.getText());
                    String tipo = (String) cbTratamientos.getSelectedItem();
                    String nombre = cbTratamientos.getSelectedItem().toString();
                    Tratamiento newTratamiento = new Tratamiento(nombre,dosis,tipo);
                    tratamientos.add(newTratamiento);
                    newTratamiento.printTratamiento();
                    JOptionPane.showMessageDialog(null,"Tratamiento agregado!");
                }
            }
        });

        agregarDiagnosticoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNombre.getText().length() <= 2) {
                    JOptionPane.showMessageDialog(null,"Ingrese datos válidos!");
                    tfNombre.setText(null);
                }
                else{
                    String nombre = tfNombre.getText();
                    String nivel = cbNivel.getSelectedItem().toString();
                    Diagnostico newDiagnostico = new Diagnostico(nombre,nivel);
                    newDiagnostico.setTratamientos(tratamientos);
                    Controlador.catalogoDiagnosticos.add(newDiagnostico);
                    newDiagnostico.printDiagnostico();
                    setVisible(false);

                }
            }
        });
    }
}
