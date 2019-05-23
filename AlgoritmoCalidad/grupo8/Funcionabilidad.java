package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Funcionabilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5745267259821566766L;
	private JTextField txtInteroperabilidad;
	private static final String EMPTY_STRING = "";
	
	private JCheckBox checkBox2;
	private JCheckBox checkBox1;
	private JCheckBox checkBox4;
	private JCheckBox checkBox3;
	private JCheckBox checkBox5;
	private JCheckBox checkBox6;
	private JCheckBox checkBox7;
	
	private JLabel lblEvInteroperabilidad;
	private JLabel lblEvSegAcceso;
	private JLabel lblEvExacResultados;
	private JLabel lblEvFuncionalidad;
	
	private JButton btnSiguiente;
	
	public Funcionabilidad(JFrame padre) {
		setTitle("Característica: Funcionabilidad");
		setSize(502, 531);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(null);
		
		JLabel lblInteroperabilidad = new JLabel("Interoperabilidad");
		lblInteroperabilidad.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblInteroperabilidad.setBounds(20, 20, 474, 26);
		getContentPane().add(lblInteroperabilidad);
		
		JLabel lblSeguridadDeAcceso = new JLabel("Seguridad de acceso");
		lblSeguridadDeAcceso.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblSeguridadDeAcceso.setBounds(20, 119, 474, 27);
		getContentPane().add(lblSeguridadDeAcceso);
		
		JLabel lblExactitudEnLos = new JLabel("Exactitud en los resultados");
		lblExactitudEnLos.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblExactitudEnLos.setBounds(20, 338, 474, 16);
		getContentPane().add(lblExactitudEnLos);
		
		JLabel lbl1 = new JLabel("- ¿Con cuántos sistemas se relaciona su producto software?");
		lbl1.setBounds(48, 58, 428, 16);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("- Mi software tiene inicio de sesión de usuarios");
		lbl2.setBounds(48, 158, 378, 16);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("- Mi software tiene ocultamiento de contraseña al ingresar");
		lbl3.setBounds(48, 186, 378, 16);
		getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("- Mi software exige contraseñas de al menos 8 caracteres");
		lbl4.setBounds(48, 215, 378, 16);
		getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("- Mi software tiene encriptación de contraseñas");
		lbl5.setBounds(48, 243, 378, 16);
		getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("- Mi software tiene caducidad de sesión por inactividad");
		lbl6.setBounds(48, 271, 378, 16);
		getContentPane().add(lbl6);
		
		JLabel lbl7 = new JLabel("después de 15 minutos");
		lbl7.setBounds(58, 287, 378, 16);
		getContentPane().add(lbl7);
		
		JLabel lbl8 = new JLabel("- Mi sistema proporciona resultados");
		lbl8.setBounds(48, 366, 378, 16);
		getContentPane().add(lbl8);
		
		JLabel lbl9 = new JLabel("- Mi sistema proporciona mensajes claros ante fallos");
		lbl9.setBounds(48, 392, 378, 16);
		getContentPane().add(lbl9);
		
		txtInteroperabilidad = new JTextField();
		txtInteroperabilidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtInteroperabilidad);
			}
		});
		txtInteroperabilidad.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtInteroperabilidad.setToolTipText("Ingrese cantidad total de sistemas con los que se relaciona su sistema");
		txtInteroperabilidad.setBounds(58, 86, 130, 26);
		getContentPane().add(txtInteroperabilidad);
		txtInteroperabilidad.setColumns(10);
		
		checkBox1 = new JCheckBox("");
		checkBox1.setBounds(435, 154, 28, 23);
		getContentPane().add(checkBox1);
		
		checkBox2 = new JCheckBox("");
		checkBox2.setBounds(435, 182, 28, 23);
		getContentPane().add(checkBox2);
		
		checkBox3 = new JCheckBox("");
		checkBox3.setBounds(435, 208, 28, 23);
		getContentPane().add(checkBox3);
		
		checkBox4 = new JCheckBox("");
		checkBox4.setBounds(435, 236, 28, 23);
		getContentPane().add(checkBox4);
		
		checkBox5 = new JCheckBox("");
		checkBox5.setBounds(435, 280, 28, 23);
		getContentPane().add(checkBox5);
		
		checkBox6 = new JCheckBox("");
		checkBox6.setBounds(435, 362, 28, 23);
		getContentPane().add(checkBox6);
		
		checkBox7 = new JCheckBox("");
		checkBox7.setBounds(435, 388, 28, 23);
		getContentPane().add(checkBox7);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluar();
			}
		});
		btnEvaluar.setBounds(6, 470, 117, 29);
		getContentPane().add(btnEvaluar);
		
		lblEvInteroperabilidad = new JLabel("");
		lblEvInteroperabilidad.setForeground(Color.RED);
		lblEvInteroperabilidad.setBounds(200, 91, 263, 16);
		getContentPane().add(lblEvInteroperabilidad);
		
		lblEvSegAcceso = new JLabel("");
		lblEvSegAcceso.setForeground(Color.RED);
		lblEvSegAcceso.setBounds(48, 315, 258, 16);
		getContentPane().add(lblEvSegAcceso);
		
		lblEvExacResultados = new JLabel("");
		lblEvExacResultados.setForeground(Color.RED);
		lblEvExacResultados.setBounds(48, 430, 236, 16);
		getContentPane().add(lblEvExacResultados);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setToolTipText("Debe evaluar la característica antes de seguir");
		btnSiguiente.setEnabled(false);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
			}
		});
		btnSiguiente.setBounds(377, 470, 117, 29);
		getContentPane().add(btnSiguiente);
		
		lblEvFuncionalidad = new JLabel("");
		lblEvFuncionalidad.setForeground(Color.RED);
		lblEvFuncionalidad.setBounds(125, 475, 251, 16);
		getContentPane().add(lblEvFuncionalidad);
		
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
		new Eficiencia(this).setVisible(true);
	}

	private void evaluar() {
		if (txtInteroperabilidad.getText().equals(EMPTY_STRING)) {
			JOptionPane.showMessageDialog(this, "Debe responder todas las preguntas.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
		} else {
			if (JOptionPane.showConfirmDialog(this, "¿Está seguro de las respuestas?", "Confirmación",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				int rInteroperabilidad = evaluarYmostrarInteroperabilidad();
				int rSegAcceso = evaluarYmostrarSegAcceso();
				int rExacResultados = evaluarYmostrarExactResultados();

				float promedio = (float) (rInteroperabilidad + rSegAcceso + rExacResultados) / (float) 3;

				if (promedio == 0) {
					Evaluacion.getInstance().rFuncionabilidad = Resultado.Mala;
				} else if (promedio > 0 && promedio <= 1) {
					Evaluacion.getInstance().rFuncionabilidad = Resultado.Buena;
				} else {
					Evaluacion.getInstance().rFuncionabilidad = Resultado.Excelente;
				}

				lblEvFuncionalidad
						.setText("Resultado de evaluación: " + Evaluacion.getInstance().rFuncionabilidad.toString());
				
				btnSiguiente.setEnabled(true);
			}
		}
	}

	private int evaluarYmostrarInteroperabilidad() {
		int cantSistemas = Integer.valueOf(txtInteroperabilidad.getText());
		int puntaje = cantSistemas == 0 ? 0 : cantSistemas == 1 ? 1 : 2;
		
		lblEvInteroperabilidad.setText("Puntaje: " + puntaje);

		return puntaje;
	}

	private int evaluarYmostrarSegAcceso() {
		int puntaje = 0;

		if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()
				&& checkBox5.isSelected()) {
			puntaje = 2;
		} else if (checkBox1.isSelected() && checkBox2.isSelected()) {
			puntaje = 1;
		}

		lblEvSegAcceso.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private int evaluarYmostrarExactResultados() {
		int puntaje;

		if (!checkBox6.isSelected()) {
			puntaje = 0;
		} else if (!checkBox7.isSelected()) {
			puntaje = 1;
		} else {
			puntaje = 2;
		}

		lblEvExacResultados.setText("Puntaje: " + puntaje);

		return puntaje;
	}

	private void clearFrame() {
		txtInteroperabilidad.setText(EMPTY_STRING);
		checkBox1.setSelected(false);
		checkBox2.setSelected(false);
		checkBox3.setSelected(false);
		checkBox4.setSelected(false);
		checkBox5.setSelected(false);
		checkBox6.setSelected(false);
		checkBox7.setSelected(false);
		lblEvExacResultados.setText(EMPTY_STRING);
		lblEvFuncionalidad.setText(EMPTY_STRING);
		lblEvInteroperabilidad.setText(EMPTY_STRING);
		lblEvSegAcceso.setText(EMPTY_STRING);
	}
}
