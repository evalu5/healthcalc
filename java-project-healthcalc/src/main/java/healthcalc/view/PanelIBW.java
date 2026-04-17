package healthcalc.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class PanelIBW extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtAltura;
    private JTextField txtGenero;
    private JButton btnCalcular;

    public PanelIBW() {
        setLayout(new GridLayout(0, 1, 0, 8));
        setBorder(new EmptyBorder(15, 15, 15, 15));
        add(new JLabel("<html><b>Cálculo de IBW (Peso Ideal)</b></html>"));
        add(new JLabel("Altura (cm):"));
        txtAltura = new JTextField();
        add(txtAltura);
        add(new JLabel("Género (H/M):"));
        txtGenero = new JTextField();
        add(txtGenero);
        btnCalcular = new JButton("Calcular IBW");
        btnCalcular.setBackground(new Color(173, 216, 230));
        add(btnCalcular);
        add(new JSeparator());
    }
    
    public String getAltura() { return txtAltura.getText(); }
    
    public String getGenero() { return txtGenero.getText(); }
    
    public void setBtnController(ActionListener ctr) {
        btnCalcular.addActionListener(ctr);
        btnCalcular.setActionCommand("CALCULAR_IBW");
    }
}
