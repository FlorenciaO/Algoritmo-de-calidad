package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fiabilidad extends JFrame{
	
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JLabel lblEvToleranciaFallos;
	private JLabel lblEvCapRecupErrores;
	private JLabel lblEvFiabilidad;
	private JButton btnSiguiente;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8906346275403872575L;
	
	public Fiabilidad(JFrame padre) {
		setTitle("Característica: Fiabilidad");
		setSize(502, 392);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(null);
		
		JLabel lblToleranciaAFallos = new JLabel("Tolerancia a fallos");
		lblToleranciaAFallos.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblToleranciaAFallos.setBounds(10, 10, 474, 26);
		getContentPane().add(lblToleranciaAFallos);
		
		JLabel lblCapacidadRecuperacion = new JLabel("Capacidad de recuperación de errores");
		lblCapacidadRecuperacion.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblCapacidadRecuperacion.setBounds(10, 171, 474, 26);
		getContentPane().add(lblCapacidadRecuperacion);
		
		JLabel lbl1 = new JLabel("- Cuando sucede un error se protegen los datos procesados.");
		lbl1.setBounds(20, 117, 432, 16);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("- Se realiza un log de actividades que el sistema estaba haciendo.");
		lbl2.setBounds(20, 48, 432, 16);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("- Tratamiento adecuado para cada error mostrando un mensaje");
		lbl3.setBounds(20, 76, 432, 16);
		getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("acorde al usuario.");
		lbl4.setBounds(32, 91, 392, 16);
		getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("- El sistema reanuda las actividades si se produce una falla crítica.");
		lbl5.setBounds(20, 207, 432, 16);
		getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("- El sistema recupera el estado en el que se encontraba");
		lbl6.setBounds(20, 235, 432, 16);
		getContentPane().add(lbl6);
		
		JLabel lbl7 = new JLabel("previamente al fallo.");
		lbl7.setBounds(30, 251, 432, 16);
		getContentPane().add(lbl7);
		
		checkBox1 = new JCheckBox("");
		checkBox1.setBounds(459, 45, 25, 23);
		getContentPane().add(checkBox1);
		
		checkBox2 = new JCheckBox("");
		checkBox2.setBounds(459, 76, 25, 23);
		getContentPane().add(checkBox2);
		
		checkBox3 = new JCheckBox("");
		checkBox3.setBounds(459, 117, 25, 23);
		getContentPane().add(checkBox3);
		
		checkBox4 = new JCheckBox("");
		checkBox4.setBounds(459, 203, 25, 23);
		getContentPane().add(checkBox4);
		
		checkBox5 = new JCheckBox("");
		checkBox5.setBounds(459, 240, 25, 23);
		getContentPane().add(checkBox5);
		
		lblEvToleranciaFallos = new JLabel("");
		lblEvToleranciaFallos.setForeground(Color.RED);
		lblEvToleranciaFallos.setBounds(20, 149, 404, 16);
		getContentPane().add(lblEvToleranciaFallos);
		
		lblEvCapRecupErrores = new JLabel("");
		lblEvCapRecupErrores.setForeground(Color.RED);
		lblEvCapRecupErrores.setBounds(18, 290, 404, 16);
		getContentPane().add(lblEvCapRecupErrores);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluar();
			}
		});
		btnEvaluar.setBounds(6, 330, 117, 29);
		getContentPane().add(btnEvaluar);
		
		lblEvFiabilidad = new JLabel("");
		lblEvFiabilidad.setForeground(Color.RED);
		lblEvFiabilidad.setBounds(130, 338, 251, 16);
		getContentPane().add(lblEvFiabilidad);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
			}
		});
		btnSiguiente.setToolTipText("Debe evaluar la característica antes de seguir");
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(385, 330, 117, 29);
		getContentPane().add(btnSiguiente);
	}
	
	private void siguiente() {
		clearFrame();
		dispose();
		new Mantenibilidad(this).setVisible(true);
	}

	private void evaluar() {
		if (JOptionPane.showConfirmDialog(this, "¿Está seguro de las respuestas?", "Confirmación",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				int rToleranciaFallos = evaluarYmostrarToleraciaFallos();
				int rCapRecupErrores = evaluarYmostrarCapRecupErrores();

				float promedio = (float) (rToleranciaFallos + rCapRecupErrores) / (float) 2;

				if (promedio == 0) {
					Evaluacion.getInstance().rFiabilidad = Resultado.Mala;
				} else if (promedio > 0 && promedio <= 1) {
					Evaluacion.getInstance().rFiabilidad = Resultado.Buena;
				} else {
					Evaluacion.getInstance().rFiabilidad = Resultado.Excelente;
				}

				lblEvFiabilidad.setText("Resultado de evaluación: " + Evaluacion.getInstance().rFiabilidad.toString());
				
				btnSiguiente.setEnabled(true);
			}
		
	}
	
	private int evaluarYmostrarCapRecupErrores() {
		int puntaje = 0;
		if(checkBox4.isSelected() && checkBox5.isSelected()) {
			puntaje = 2;
		} else if(checkBox4.isSelected()) {
			puntaje = 1;
		}
		lblEvCapRecupErrores.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private int evaluarYmostrarToleraciaFallos() {
		int puntaje = 0;
		if(checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected()) {
			puntaje = 2;
		} else if(checkBox1.isSelected() && checkBox2.isSelected()) {
			puntaje = 1;
		}
		lblEvToleranciaFallos.setText("Puntaje: " + puntaje);
		return puntaje;

	}

	private void clearFrame() {
		checkBox1.setSelected(false);
		checkBox2.setSelected(false);
		checkBox3.setSelected(false);
		checkBox4.setSelected(false);
		checkBox5.setSelected(false);
	}
}
