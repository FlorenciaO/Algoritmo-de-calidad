package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal() {
		setTitle("Evaluación de Calidad de Software");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCaractersticasAEvaluar = new JLabel("Características a evaluar:");
		lblCaractersticasAEvaluar.setBounds(39, 26, 162, 16);
		getContentPane().add(lblCaractersticasAEvaluar);
		
		JLabel lblFuncionabilidad = new JLabel("Funcionabilidad");
		lblFuncionabilidad.setBounds(82, 80, 119, 16);
		getContentPane().add(lblFuncionabilidad);
		
		JLabel lblEficiencia = new JLabel("Eficiencia");
		lblEficiencia.setBounds(82, 130, 119, 16);
		getContentPane().add(lblEficiencia);
		
		JLabel lblFiabilidad = new JLabel("Fiabilidad");
		lblFiabilidad.setBounds(82, 180, 119, 16);
		getContentPane().add(lblFiabilidad);
		
		JLabel lblMantenibilidad = new JLabel("Mantenibilidad");
		lblMantenibilidad.setBounds(82, 232, 119, 16);
		getContentPane().add(lblMantenibilidad);
		
		JLabel lblUsabilidad = new JLabel("Usabilidad");
		lblUsabilidad.setBounds(82, 282, 119, 16);
		getContentPane().add(lblUsabilidad);
		
		JLabel lblPortabilidad = new JLabel("Portabilidad");
		lblPortabilidad.setBounds(82, 334, 119, 16);
		getContentPane().add(lblPortabilidad);
		
		JButton btnComenzarEvaluacin = new JButton("Comenzar Evaluación");
		btnComenzarEvaluacin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comenzar();
			}
		});
		btnComenzarEvaluacin.setBounds(162, 388, 167, 29);
		getContentPane().add(btnComenzarEvaluacin);
		setLocationRelativeTo(null);
	}
	
	public void comenzar() {
		new Funcionabilidad(this).setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1305314416940746484L;
	
	public static void main(String args[]) {
		new VentanaPrincipal().setVisible(true);
	}
}
