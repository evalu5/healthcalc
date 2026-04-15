package healthcalc.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class HealthCalcView extends JFrame implements ViewHealthCalc {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JLabel lblResultado;
	private JLabel lblInterpretacion;
	private JLabel lblMensaje;
	private JButton btnCalcular;

	/**
	 * Create the frame.
	 */
	public HealthCalcView() {
		setTitle("Calculadora de Salud");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 15));

		// errores
		lblMensaje = new JLabel("", SwingConstants.CENTER);
		lblMensaje.setForeground(Color.RED);
		contentPane.add(lblMensaje, BorderLayout.SOUTH);

		//las pestañas
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// pestañas
		tabbedPane.addTab("Información", new JPanel()); 
		tabbedPane.addTab("IMC", crearPanelIMC());
		tabbedPane.addTab("IBW", new JPanel());
		tabbedPane.addTab("WC", new JPanel());

		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	//pestaña imc
	private JPanel crearPanelIMC() {
		JPanel panelIMC = new JPanel();
		panelIMC.setLayout(new GridLayout(0, 1, 0, 8));
		panelIMC.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel lblExplicacion = new JLabel("<html>Para calcular el <b>Índice de masa corporal</b> se ha utilizado la siguiente fórmula:</html>");
		panelIMC.add(lblExplicacion);

		JLabel lblFormula = new JLabel("IMC = peso (kg) / altura (m)²");
		lblFormula.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelIMC.add(lblFormula);
		
		panelIMC.add(new JSeparator());

		panelIMC.add(new JLabel("Introduzca su peso (kg):"));
		txtPeso = new JTextField();
		panelIMC.add(txtPeso);
		
		panelIMC.add(new JLabel("Introduzca su altura (m):"));
		txtAltura = new JTextField();
		panelIMC.add(txtAltura);
		
		
		btnCalcular = new JButton("Calcular IMC");
		btnCalcular.setBackground(new Color(173, 216, 230));
		JPanel pBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pBoton.add(btnCalcular);
		panelIMC.add(pBoton);
		
		panelIMC.add(new JSeparator());

		
		JLabel label = new JLabel("<html><b>Resultado numérico:</b></html>");
		panelIMC.add(label);
		lblResultado = new JLabel("-"); 
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelIMC.add(lblResultado);

		JLabel label_1 = new JLabel("<html><b>Interpretación:</b></html>");
		panelIMC.add(label_1);
		lblInterpretacion = new JLabel("-");
		lblInterpretacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelIMC.add(lblInterpretacion);

		return panelIMC;
	}

	@Override
	public String getPeso() { return txtPeso.getText(); }

	@Override
	public String getAltura() { return txtAltura.getText(); }

	@Override
	public void setResultado(String res) {
		lblResultado.setText(res);
		lblMensaje.setText(""); 
	}

	@Override
	public void setMessage(String msg) {
		lblMensaje.setText(msg);
	}
	
	@Override
	public void setInterpretacion(String texto) {
	    lblInterpretacion.setText(texto);
	}

	@Override
	public void setController(ActionListener ctr) {
		btnCalcular.addActionListener(ctr);
		btnCalcular.setActionCommand("CALCULAR");
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcView frame = new HealthCalcView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}