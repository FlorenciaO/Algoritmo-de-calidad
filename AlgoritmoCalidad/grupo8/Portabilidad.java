package grupo8;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Portabilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3806570944302041930L;
	
	private static final String EMPTY_STRING = "";
	private JTextField txtAdaptabilidad;
	private JTextField txtInstabilidad;
	private JLabel lblEvAdaptabilidad;
	private JLabel lblEvInstabilidad;
	private JLabel lblEvPortabilidad;
	private JButton btnEvaluar;
	private JButton btnSiguiente ;
	
	public Portabilidad(JFrame padre) {
		setTitle("Característica: Portabilidad");
		setSize(502, 364);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Adaptabilidad");
		lbl1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl1.setBounds(10, 10, 474, 26);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Instalabilidad");
		lbl2.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl2.setBounds(10, 154, 474, 26);
		getContentPane().add(lbl2);
		
		JLabel lblconCuntosSistemas = new JLabel("¿Con cuántos sistemas operativos es compatbile?");
		lblconCuntosSistemas.setBounds(20, 41, 425, 16);
		getContentPane().add(lblconCuntosSistemas);
		
		txtAdaptabilidad = new JTextField();
		txtAdaptabilidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtAdaptabilidad);
			}
		});
		txtAdaptabilidad.setColumns(10);
		txtAdaptabilidad.setBounds(30, 69, 130, 26);
		getContentPane().add(txtAdaptabilidad);
		
		lblEvAdaptabilidad = new JLabel("");
		lblEvAdaptabilidad.setForeground(Color.RED);
		lblEvAdaptabilidad.setBounds(10, 126, 404, 16);
		getContentPane().add(lblEvAdaptabilidad);
		
		JLabel lblCantidadDePasos = new JLabel("Cantidad de pasos para la instalación");
		lblCantidadDePasos.setBounds(20, 189, 425, 16);
		getContentPane().add(lblCantidadDePasos);
		
		txtInstabilidad = new JTextField();
		txtInstabilidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtInstabilidad);
			}
		});
		txtInstabilidad.setColumns(10);
		txtInstabilidad.setBounds(30, 217, 130, 26);
		getContentPane().add(txtInstabilidad);
		
		lblEvInstabilidad = new JLabel("");
		lblEvInstabilidad.setForeground(Color.RED);
		lblEvInstabilidad.setBounds(10, 254, 404, 16);
		getContentPane().add(lblEvInstabilidad);
		
		 btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				evaluar();
			}
		});
		btnEvaluar.setBounds(10, 307, 117, 29);
		getContentPane().add(btnEvaluar);
		
		lblEvPortabilidad = new JLabel("");
		lblEvPortabilidad.setForeground(Color.RED);
		lblEvPortabilidad.setBounds(128, 312, 251, 16);
		getContentPane().add(lblEvPortabilidad);
		
		 btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				siguiente();
			}
		});
		btnSiguiente.setToolTipText("Debe evaluar la característica antes de seguir");
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(379, 307, 117, 29);
		getContentPane().add(btnSiguiente);
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
		if(JOptionPane.showConfirmDialog(this, "La evaluación de su software dio como resultado: " + 
				Evaluacion.getInstance().calcularPuntajeFinal().toString() + "\n" + "¿Desea realizar otra evaluación?",
				"Resultado final de la evaluación del software", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
			clearFrame();
			new VentanaPrincipal().setVisible(true);
		} else {
			System.exit(0);
		}
	}

	private void evaluar() {

		if (txtAdaptabilidad.getText().equals(EMPTY_STRING) || txtInstabilidad.getText().equals(EMPTY_STRING)) {
			JOptionPane.showMessageDialog(this, "Debe responder todas las preguntas.", "Campos incompletos",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (JOptionPane.showConfirmDialog(this, "¿Está seguro de las respuestas?", "Confirmación",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				int rAdaptabilidad = evaluarYmostrarAdaptabilidad();
				int rInstabilidad = evaluarYmostrarInstabilidad();

				float promedio = (float) (rAdaptabilidad + rInstabilidad) / (float) 2;

				if (promedio == 0) {
					Evaluacion.getInstance().rPortabilidad = Resultado.Mala;
				} else if (promedio > 0 && promedio <= 1) {
					Evaluacion.getInstance().rPortabilidad = Resultado.Buena;
				} else {
					Evaluacion.getInstance().rPortabilidad = Resultado.Excelente;
				}

				lblEvPortabilidad
						.setText("Resultado de evaluación: " + Evaluacion.getInstance().rPortabilidad.toString());

				btnSiguiente.setEnabled(true);
			}
		}
		 
		
	}

	private int evaluarYmostrarAdaptabilidad() {

		int porcentaje = Integer.valueOf(txtAdaptabilidad.getText());
		int puntaje = 0;
		if (porcentaje >= 3) {
			puntaje = 2;
		} else if (porcentaje == 2) {
			puntaje = 1;
		}
		lblEvAdaptabilidad.setText("Puntaje: " + puntaje);
		return puntaje;

	}

	private int evaluarYmostrarInstabilidad() {

		int porcentaje = Integer.valueOf(txtInstabilidad.getText());
		int puntaje = 2;
		if (porcentaje >= 7) {
			puntaje = 0;
		} else if (porcentaje < 3 && porcentaje > 7) {
			puntaje = 1;
		}
		lblEvInstabilidad.setText("Puntaje: " + puntaje);
		return puntaje;

	}
	
	private void clearFrame() {
		txtAdaptabilidad.setText(EMPTY_STRING);
		txtInstabilidad.setText(EMPTY_STRING);
	}

}
