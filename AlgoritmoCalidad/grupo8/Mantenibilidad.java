package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Mantenibilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2830193224946007407L;
	private static final String EMPTY_STRING = "";
	private JLabel lblEvMantenibilidad;
	private JLabel lblEvEstabilidad;
	private JLabel lblEvCapCodAnalizado;
	private JLabel lblEvCapCodCambiado ;
	private JButton btnSiguiente;
	private JTextField txtAnalizado;
	private JTextField txtCambiado;
	private JTextField txtEstabilidad;
	
	public Mantenibilidad(JFrame padre) {
		setTitle("Característica: Mantenibilidad");
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
		
		 lblEvCapCodAnalizado = new JLabel("");
		lblEvCapCodAnalizado.setForeground(Color.RED);
		lblEvCapCodAnalizado.setBounds(10, 118, 404, 16);
		getContentPane().add(lblEvCapCodAnalizado);
		
		 lblEvCapCodCambiado = new JLabel("");
		lblEvCapCodCambiado.setForeground(Color.RED);
		lblEvCapCodCambiado.setBounds(10, 257, 404, 16);
		getContentPane().add(lblEvCapCodCambiado);
		
		 lblEvEstabilidad = new JLabel("");
		lblEvEstabilidad.setForeground(Color.RED);
		lblEvEstabilidad.setBounds(10, 391, 404, 16);
		getContentPane().add(lblEvEstabilidad);
		
		JLabel lbl1 = new JLabel("Indique porcentaje de código comentado");
		lbl1.setBounds(20, 48, 425, 16);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Indique la complejidad ciclomática");
		lbl2.setBounds(20, 184, 425, 16);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Indique el promedio de errores por prueba");
		lbl3.setBounds(20, 325, 425, 16);
		getContentPane().add(lbl3);
		
		txtAnalizado = new JTextField();
		txtAnalizado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtAnalizado);
			}
		});
		txtAnalizado.setBounds(43, 76, 130, 26);
		getContentPane().add(txtAnalizado);
		txtAnalizado.setColumns(10);
		
		txtCambiado = new JTextField();
		txtCambiado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtCambiado);
			}
		});
		txtCambiado.setColumns(10);
		txtCambiado.setBounds(43, 219, 130, 26);
		getContentPane().add(txtCambiado);
		
		txtEstabilidad = new JTextField();
		txtEstabilidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtEstabilidad);
			}
		});
		txtEstabilidad.setColumns(10);
		txtEstabilidad.setBounds(43, 353, 130, 26);
		getContentPane().add(txtEstabilidad);
		
		JLabel lbl4 = new JLabel("%");
		lbl4.setBounds(174, 81, 61, 16);
		getContentPane().add(lbl4);
	}
	
	private void validarIngreso(KeyEvent e, JTextField txt) {
		int key = e.getKeyCode();
		
		if(!((key>= 48 && key<=57) || key == KeyEvent.VK_BACK_SPACE)) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un número", "Ingreso inválido", JOptionPane.WARNING_MESSAGE);
			txt.setText(EMPTY_STRING);
		}	
	}
	
	private void siguiente() {
		dispose();
		clearFrame();
		new Usabilidad(this).setVisible(true);
	}

	private void evaluar() {
		if (txtAnalizado.getText().equals(EMPTY_STRING) || txtCambiado.getText().equals(EMPTY_STRING) || txtEstabilidad.getText().equals(EMPTY_STRING)) {
			JOptionPane.showMessageDialog(this, "Debe responder todas las preguntas.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
		} else {
			if (JOptionPane.showConfirmDialog(this, "¿Está seguro de las respuestas?", "Confirmación",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				int rCapCodAnalizado = evaluarYmostrarCapCodAnalizado();
				int rCapCodCambiado = evaluarYmostrarCapCodCambiado();
				int rEstabilidad = evaluarYmostrarEstabilidad();

				float promedio = (float) (rCapCodAnalizado + rCapCodCambiado + rEstabilidad) / (float) 3;

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
		
	}

	private int evaluarYmostrarEstabilidad() {
		int porcentaje = Integer.valueOf(txtEstabilidad.getText());
		int puntaje = 2;
		if( porcentaje >= 5) {
			puntaje = 0;
		} else if(porcentaje >= 2 && porcentaje <= 4) {
			puntaje = 1;
		}
		lblEvEstabilidad.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private int evaluarYmostrarCapCodCambiado() {
		int porcentaje = Integer.valueOf(txtCambiado.getText());
		int puntaje = 2;
		if( porcentaje >= 21) {
			puntaje = 0;
		} else if(porcentaje < 21 && porcentaje > 10) {
			puntaje = 1;
		}
		lblEvCapCodCambiado.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private int evaluarYmostrarCapCodAnalizado() {
		int porcentaje = Integer.valueOf(txtAnalizado.getText());
		int puntaje = 2;
		if( porcentaje <= 14) {
			puntaje = 0;
		} else if(porcentaje > 14 && porcentaje < 30) {
			puntaje = 1;
		}
		lblEvCapCodAnalizado.setText("Puntaje: " + puntaje);
		return puntaje;
	}
	
	private void clearFrame() {
		txtAnalizado.setText(EMPTY_STRING);
		txtCambiado.setText(EMPTY_STRING);
		txtEstabilidad.setText(EMPTY_STRING);
	}
}
