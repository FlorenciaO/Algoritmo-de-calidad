package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mantenibilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2830193224946007407L;
	
	private JLabel lblEvMantenibilidad;
	private JButton btnSiguiente;
	
	public Mantenibilidad(JFrame padre) {
		setTitle("Característica: Fiabilidad");
		setSize(502, 487);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(null);
		
		JLabel lblCapacidadDelCdigo = new JLabel("Capacidad del código para ser analizado");
		lblCapacidadDelCdigo.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblCapacidadDelCdigo.setBounds(10, 10, 474, 26);
		getContentPane().add(lblCapacidadDelCdigo);
		
		JLabel lblCapacidadDelCdigo2 = new JLabel("Capacidad del código para ser cambiado");
		lblCapacidadDelCdigo2.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblCapacidadDelCdigo2.setBounds(10, 146, 474, 26);
		getContentPane().add(lblCapacidadDelCdigo2);
		
		JLabel lblEstabilidad = new JLabel("Estabilidad");
		lblEstabilidad.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblEstabilidad.setBounds(10, 287, 474, 26);
		getContentPane().add(lblEstabilidad);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluar();
			}
		});
		btnEvaluar.setBounds(10, 431, 117, 29);
		getContentPane().add(btnEvaluar);
		
		lblEvMantenibilidad = new JLabel("");
		lblEvMantenibilidad.setForeground(Color.RED);
		lblEvMantenibilidad.setBounds(128, 437, 251, 16);
		getContentPane().add(lblEvMantenibilidad);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
			}
		});
		btnSiguiente.setToolTipText("Debe evaluar la característica antes de seguir");
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(379, 431, 117, 29);
		getContentPane().add(btnSiguiente);
		
		JLabel lblEvCapCodAnalizado = new JLabel("");
		lblEvCapCodAnalizado.setForeground(Color.RED);
		lblEvCapCodAnalizado.setBounds(10, 105, 404, 16);
		getContentPane().add(lblEvCapCodAnalizado);
		
		JLabel lblEvCapCodCambiado = new JLabel("");
		lblEvCapCodCambiado.setForeground(Color.RED);
		lblEvCapCodCambiado.setBounds(10, 257, 404, 16);
		getContentPane().add(lblEvCapCodCambiado);
		
		JLabel lblEvEstabilidad = new JLabel("");
		lblEvEstabilidad.setForeground(Color.RED);
		lblEvEstabilidad.setBounds(10, 403, 404, 16);
		getContentPane().add(lblEvEstabilidad);
	}
	
	private void siguiente() {
		dispose();
		//new Usabilidad(this).setVisible(true);
	}

	private void evaluar() {
		if (JOptionPane.showConfirmDialog(this, "¿Está seguro de las respuestas?", "Confirmación",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				int rCapCodAnalizado = evaluarYmostrarCapCodAnalizado();
				int rCapCodCambiado = evaluarYmostrarCapCodCambiado();
				int rEstabilidad = evaluarYmostrarEstabilidad();

				float promedio = (float) (rCapCodAnalizado + rCapCodCambiado + rEstabilidad) / (float) 2;

				if (promedio == 0) {
					Evaluacion.getInstance().rMantenibilidad = Resultado.Mala;
				} else if (promedio > 0 && promedio <= 1) {
					Evaluacion.getInstance().rMantenibilidad = Resultado.Buena;
				} else {
					Evaluacion.getInstance().rMantenibilidad = Resultado.Excelente;
				}

				lblEvMantenibilidad.setText("Resultado de evaluación: " + Evaluacion.getInstance().rMantenibilidad.toString());
				
				btnSiguiente.setEnabled(true);
			}
		
	}

	private int evaluarYmostrarEstabilidad() {
		return 0;
	}

	private int evaluarYmostrarCapCodCambiado() {
		return 0;
	}

	private int evaluarYmostrarCapCodAnalizado() {
		return 0;
	}

}
