package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Eficiencia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8372710732746229410L;

	private static final String EMPTY_STRING = "";
	private JTextField txtUsoCPU;
	private JTextField txtUsoMemPrinc;
	private JTextField txtCompTiempo;
	
	private JLabel lblEvUsoCPU;
	private JLabel lblEvUsoMemPrinc;
	private JLabel lblEvUtilizacionRecursos;
	private JLabel lblEvCompTiempo;
	private JLabel lblEvEficiencia;
	
	private JButton btnEvaluar;
	private JButton btnSiguiente;
	private JLabel label;
	private JLabel label_1;
	
	public Eficiencia(JFrame padre) {
		setTitle("Característica: Eficiencia");
		setSize(502, 507);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(null);
		
		JLabel lblUtilizacionRecursos = new JLabel("Utilización de Recursos");
		lblUtilizacionRecursos.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblUtilizacionRecursos.setBounds(10, 17, 474, 26);
		getContentPane().add(lblUtilizacionRecursos);
		
		JLabel lblCompTiempo = new JLabel("Comportamiento frente al Tiempo");
		lblCompTiempo.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblCompTiempo.setBounds(10, 300, 474, 26);
		getContentPane().add(lblCompTiempo);
		
		JLabel lblUsoA = new JLabel("a. Uso de CPU");
		lblUsoA.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblUsoA.setBounds(20, 55, 474, 26);
		getContentPane().add(lblUsoA);
		
		JLabel lblUsoB = new JLabel("b. Uso de Memoria Principal");
		lblUsoB.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblUsoB.setBounds(20, 177, 474, 26);
		getContentPane().add(lblUsoB);
		
		JLabel lbl1 = new JLabel("- Indique porcentaje de uso de CPU");
		lbl1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl1.setBounds(20, 82, 474, 26);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("- Indique porcentaje de uso de Memoria Principal");
		lbl2.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl2.setBounds(20, 205, 474, 26);
		getContentPane().add(lbl2);
		
		txtUsoCPU = new JTextField();
		txtUsoCPU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtUsoCPU);
			}
		});
		txtUsoCPU.setBounds(30, 120, 96, 26);
		getContentPane().add(txtUsoCPU);
		txtUsoCPU.setColumns(10);
		
		txtUsoMemPrinc = new JTextField();
		txtUsoMemPrinc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtUsoMemPrinc);
			}
		});
		txtUsoMemPrinc.setColumns(10);
		txtUsoMemPrinc.setBounds(30, 239, 96, 26);
		getContentPane().add(txtUsoMemPrinc);
		
		JLabel lbl3 = new JLabel("- Indique tiempo de respuesta del software (en segundos) ");
		lbl3.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl3.setBounds(20, 338, 474, 26);
		getContentPane().add(lbl3);
		
		txtCompTiempo = new JTextField();
		txtCompTiempo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtCompTiempo);
			}
		});
		txtCompTiempo.setColumns(10);
		txtCompTiempo.setBounds(30, 376, 130, 26);
		getContentPane().add(txtCompTiempo);
		
		lblEvUsoCPU = new JLabel("");
		lblEvUsoCPU.setBounds(172, 125, 281, 16);
		getContentPane().add(lblEvUsoCPU);
		
		lblEvUsoMemPrinc = new JLabel("");
		lblEvUsoMemPrinc.setBounds(172, 244, 281, 16);
		getContentPane().add(lblEvUsoMemPrinc);
		
		lblEvUtilizacionRecursos = new JLabel("");
		lblEvUtilizacionRecursos.setBounds(20, 277, 404, 16);
		getContentPane().add(lblEvUtilizacionRecursos);
		
		lblEvCompTiempo = new JLabel("");
		lblEvCompTiempo.setBounds(20, 414, 428, 16);
		getContentPane().add(lblEvCompTiempo);
		
		btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluar();
			}
		});
		btnEvaluar.setBounds(10, 454, 117, 29);
		getContentPane().add(btnEvaluar);
		
		lblEvEficiencia = new JLabel("");
		lblEvEficiencia.setForeground(Color.RED);
		lblEvEficiencia.setBounds(126, 460, 251, 16);
		getContentPane().add(lblEvEficiencia);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
			}
		});
		btnSiguiente.setToolTipText("Debe evaluar la característica antes de seguir");
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(379, 454, 117, 29);
		getContentPane().add(btnSiguiente);
		
		label = new JLabel("%");
		label.setBounds(126, 125, 9, 16);
		getContentPane().add(label);
		
		label_1 = new JLabel("%");
		label_1.setBounds(126, 243, 9, 16);
		getContentPane().add(label_1);
		
	}
	
	private void validarIngreso(KeyEvent e, JTextField txt) {
		int key = e.getKeyCode();
		
		if(!((key>= 48 && key<=57) || key == KeyEvent.VK_BACK_SPACE)) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un número", "Ingreso inválido", JOptionPane.WARNING_MESSAGE);
			txt.setText(EMPTY_STRING);
		}	
	}
	
	private void siguiente() {
		clearFrame();
		dispose();
		//new Fiabilidad(this).setVisible(true);
	}

	private void evaluar() {
		if (txtCompTiempo.getText().equals(EMPTY_STRING) || txtUsoCPU.getText().equals(EMPTY_STRING) || txtUsoMemPrinc.getText().equals(EMPTY_STRING)) {
			JOptionPane.showMessageDialog(this, "Debe responder todas las preguntas.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
		} else {
			if (JOptionPane.showConfirmDialog(this, "¿Está seguro de las respuestas?", "Confirmación",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				int rUtilizacionRecursos = evaluarYmostrarUtilizacionRecursos();
				int rCompTiempo = evaluarYmostrarCompTiempo();

				float promedio = (float) (rCompTiempo + rUtilizacionRecursos) / (float) 3;

				if (promedio == 0) {
					Evaluacion.getInstance().rEficiencia = Resultado.Mala;
				} else if (promedio > 0 && promedio <= 1) {
					Evaluacion.getInstance().rEficiencia = Resultado.Buena;
				} else {
					Evaluacion.getInstance().rEficiencia = Resultado.Excelente;
				}

				lblEvEficiencia.setText("Resultado de evaluación: " + Evaluacion.getInstance().rEficiencia.toString());
				
				btnSiguiente.setEnabled(true);
			}
		}
	}
	
	private int evaluarYmostrarCompTiempo() {
		float tiempo = Float.valueOf(txtCompTiempo.getText());
		int puntaje = 2;
		if( tiempo > 4 ) {
			puntaje = 0;
		} else if(tiempo >= 1 && tiempo <= 4) {
			puntaje = 1;
		}
		lblEvCompTiempo.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private int evaluarYmostrarUtilizacionRecursos() {
		int rUsoCPU = evaluarYmostrarUsoCPU();
		int rUsoMem = evaluarYmostrarUsoMem();
		int promedio = (rUsoCPU + rUsoMem) / 2;
		lblEvUtilizacionRecursos.setText("Puntaje: " + promedio);
		return promedio;
	}

	private int evaluarYmostrarUsoCPU() {
		int porcentaje = Integer.valueOf(txtUsoCPU.getText());
		int puntaje = 2;
		if( porcentaje >= 41) {
			puntaje = 0;
		} else if(porcentaje >= 11 && porcentaje < 41) {
			puntaje = 1;
		}
		lblEvUsoCPU.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private int evaluarYmostrarUsoMem() {
		int porcentaje = Integer.valueOf(txtUsoCPU.getText());
		int puntaje = 2;
		if( porcentaje >= 51 ) {
			puntaje = 0;
		} else if(porcentaje >= 16 && porcentaje < 51) {
			puntaje = 1;
		}
		lblEvUsoMemPrinc.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private void clearFrame() {
		txtCompTiempo.setText(EMPTY_STRING);
		txtUsoCPU.setText(EMPTY_STRING);
		txtUsoMemPrinc.setText(EMPTY_STRING);
		lblEvCompTiempo.setText(EMPTY_STRING);
		lblEvEficiencia.setText(EMPTY_STRING);
		lblEvUsoCPU.setText(EMPTY_STRING);
		lblEvUsoMemPrinc.setText(EMPTY_STRING);
		lblEvUtilizacionRecursos.setText(EMPTY_STRING);
	}
}
