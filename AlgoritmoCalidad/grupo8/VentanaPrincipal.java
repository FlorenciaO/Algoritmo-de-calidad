package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal() {
		setTitle("Evaluación de Calidad de Software");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCaractersticasAEvaluar = new JLabel("Características a evaluar:");
		lblCaractersticasAEvaluar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCaractersticasAEvaluar.setBounds(39, 26, 208, 16);
		getContentPane().add(lblCaractersticasAEvaluar);
		
		JLabel lblFuncionabilidad = new JLabel("· Funcionabilidad");
		lblFuncionabilidad.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblFuncionabilidad.setBounds(82, 80, 130, 16);
		getContentPane().add(lblFuncionabilidad);
		
		JLabel lblEficiencia = new JLabel("· Eficiencia");
		lblEficiencia.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblEficiencia.setBounds(82, 130, 119, 16);
		getContentPane().add(lblEficiencia);
		
		JLabel lblFiabilidad = new JLabel("· Fiabilidad");
		lblFiabilidad.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblFiabilidad.setBounds(82, 180, 119, 16);
		getContentPane().add(lblFiabilidad);
		
		JLabel lblMantenibilidad = new JLabel("· Mantenibilidad");
		lblMantenibilidad.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblMantenibilidad.setBounds(82, 232, 119, 16);
		getContentPane().add(lblMantenibilidad);
		
		JLabel lblUsabilidad = new JLabel("· Usabilidad");
		lblUsabilidad.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblUsabilidad.setBounds(82, 282, 119, 16);
		getContentPane().add(lblUsabilidad);
		
		JLabel lblPortabilidad = new JLabel("· Portabilidad");
		lblPortabilidad.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
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
	
	private void comenzar() {
		dispose();
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
