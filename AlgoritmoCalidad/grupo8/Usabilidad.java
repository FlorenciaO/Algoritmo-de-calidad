package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usabilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8887385168168186342L;
	
	private static final String EMPTY_STRING = "";
	private JTextField txtAtractivoPUsuario;
	private JCheckBox checkBox1 ;
	private JCheckBox checkBox2 ;
	private JCheckBox checkBox3 ;
	private JCheckBox checkBox4 ;
	private JCheckBox checkBox5 ;
	private JCheckBox checkBox6 ;
	private JButton btnEvaluar;
	private JLabel lblEvOperado;
	private JLabel lblEvEntendido;
	private JLabel lblEvUsabilidad;
	private JLabel lblEvCapAtractivoPUsuario;
	private JButton btnSiguiente;
	private JLabel lblDedicado;
	
	public Usabilidad(JFrame padre) {
		setTitle("Característica: Usabilidad");
		setSize(502, 487);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Capacidad del código de ser entendido");
		lbl1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl1.setBounds(10, 10, 474, 26);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Capacidad de ser operado (indique solo una opción)");
		lbl2.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl2.setBounds(10, 140, 474, 26);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Capacidad de ser atractivo para el usuario");
		lbl3.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl3.setBounds(10, 286, 474, 26);
		getContentPane().add(lbl3);
		
		JLabel lblPoseeAyuda = new JLabel("- Posee ayuda contextual sobre menús y botones de acción.");
		lblPoseeAyuda.setBounds(20, 48, 432, 16);
		getContentPane().add(lblPoseeAyuda);
		
		JLabel lblManualDe = new JLabel("- Manual de usuario incorporado al sistema como un menú");
		lblManualDe.setBounds(20, 76, 432, 16);
		getContentPane().add(lblManualDe);
		
		checkBox1 = new JCheckBox("");
		checkBox1.setBounds(464, 44, 25, 23);
		getContentPane().add(checkBox1);
		
		 checkBox2 = new JCheckBox("");
		checkBox2.setBounds(464, 72, 25, 23);
		getContentPane().add(checkBox2);
		
		 lblEvEntendido = new JLabel("");
		lblEvEntendido.setForeground(Color.RED);
		lblEvEntendido.setBounds(10, 112, 404, 16);
		getContentPane().add(lblEvEntendido);
		
		JLabel lblElUsuario = new JLabel("- El usuario requiere consultar a personal especializado.");
		lblElUsuario.setBounds(20, 170, 432, 16);
		getContentPane().add(lblElUsuario);
		
		JLabel lblElUsuario_1 = new JLabel("- El usuario requiere ayuda contextual y manual de uso.");
		lblElUsuario_1.setBounds(20, 198, 432, 16);
		getContentPane().add(lblElUsuario_1);
		
		JLabel lblElUsuario_2 = new JLabel("- El usuario opera el producto software sin asistencia.");
		lblElUsuario_2.setBounds(20, 226, 432, 16);
		getContentPane().add(lblElUsuario_2);
		
		 checkBox3 = new JCheckBox("");
		checkBox3.setBounds(464, 165, 25, 23);
		getContentPane().add(checkBox3);
		
		 checkBox4 = new JCheckBox("");
		checkBox4.setBounds(464, 196, 25, 23);
		getContentPane().add(checkBox4);
		
		 checkBox5 = new JCheckBox("");
		checkBox5.setBounds(464, 226, 25, 23);
		getContentPane().add(checkBox5);
		
		JLabel lblLosPasos = new JLabel("- Los pasos son distribuídos por categoría.");
		lblLosPasos.setBounds(20, 377, 432, 16);
		getContentPane().add(lblLosPasos);
		
		JLabel lblIndiqueLaCantidad = new JLabel("Indique la cantidad de pasos promedio para realizar una operación");
		lblIndiqueLaCantidad.setBounds(20, 317, 425, 16);
		getContentPane().add(lblIndiqueLaCantidad);
		
		txtAtractivoPUsuario = new JTextField();
		txtAtractivoPUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtAtractivoPUsuario);
			}
		});
		txtAtractivoPUsuario.setColumns(10);
		txtAtractivoPUsuario.setBounds(40, 345, 130, 26);
		getContentPane().add(txtAtractivoPUsuario);
		
		 checkBox6 = new JCheckBox("");
		checkBox6.setBounds(464, 375, 25, 23);
		getContentPane().add(checkBox6);
		
		 btnEvaluar = new JButton("Evaluar");
		 btnEvaluar.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		evaluar();
		 	}
		 });
		btnEvaluar.setBounds(6, 430, 117, 29);
		getContentPane().add(btnEvaluar);
		
		lblEvOperado = new JLabel("");
		lblEvOperado.setForeground(Color.RED);
		lblEvOperado.setBounds(10, 258, 404, 16);
		getContentPane().add(lblEvOperado);
		
		lblEvCapAtractivoPUsuario = new JLabel("");
		lblEvCapAtractivoPUsuario.setForeground(Color.RED);
		lblEvCapAtractivoPUsuario.setBounds(10, 405, 404, 16);
		getContentPane().add(lblEvCapAtractivoPUsuario);
		
		 lblEvUsabilidad = new JLabel("");
		lblEvUsabilidad.setForeground(Color.RED);
		lblEvUsabilidad.setBounds(125, 435, 251, 16);
		getContentPane().add(lblEvUsabilidad);
		
		 btnSiguiente = new JButton("Siguiente");
		 btnSiguiente.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		siguiente();
		 	}
		 });
		btnSiguiente.setToolTipText("Debe evaluar la característica antes de seguir");
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(379, 430, 117, 29);
		getContentPane().add(btnSiguiente);
		
		lblDedicado = new JLabel("dedicado.");
		lblDedicado.setBounds(20, 91, 432, 16);
		getContentPane().add(lblDedicado);
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
		new Portabilidad(this).setVisible(true);
	}

	private void evaluar() {
		if (txtAtractivoPUsuario.getText().equals(EMPTY_STRING)) {
			JOptionPane.showMessageDialog(this, "Debe responder todas las preguntas.", "Campos incompletos",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (JOptionPane.showConfirmDialog(this, "¿Está seguro de las respuestas?", "Confirmación",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				int rCapSerEntendido = evaluarYmostrarCapEntendido();
				int rCapSerOperado = evaluarYmostrarCapOperado();
				int rCapSerAtractivoPUsuario = evaluarYmostrarCapAtractivoPUsuario();

				float promedio = (float) (rCapSerEntendido + rCapSerOperado + rCapSerAtractivoPUsuario) / (float) 3;

				if (promedio == 0) {
					Evaluacion.getInstance().rUsabilidad = Resultado.Mala;
				} else if (promedio > 0 && promedio <= 1) {
					Evaluacion.getInstance().rUsabilidad = Resultado.Buena;
				} else {
					Evaluacion.getInstance().rUsabilidad = Resultado.Excelente;
				}

				lblEvUsabilidad
						.setText("Resultado de evaluación: " + Evaluacion.getInstance().rUsabilidad.toString());

				btnSiguiente.setEnabled(true);
			}
		}

	}

	private int evaluarYmostrarCapAtractivoPUsuario() {
		int promedioPasos = Integer.valueOf(txtAtractivoPUsuario.getText());
		int puntaje = 2;
		if( promedioPasos >= 6 || !checkBox6.isSelected()) {
			puntaje = 0;
		} else if(promedioPasos >= 3 && promedioPasos < 6) {
			puntaje = 1;
		}
		lblEvCapAtractivoPUsuario.setText("Puntaje: " + puntaje);
		return puntaje;
	}

	private int evaluarYmostrarCapOperado() {
		int puntaje = 0;
		if(checkBox5.isSelected()) {
			puntaje = 2;
		} else if(checkBox4.isSelected()) {
			puntaje = 1;
		}
		lblEvOperado.setText("Puntaje: " + puntaje);
		return puntaje;

	}

	private int evaluarYmostrarCapEntendido() {
		int puntaje = 1;
		if(!checkBox1.isSelected() && !checkBox2.isSelected()) {
			puntaje = 0;
		} else if(checkBox1.isSelected() && checkBox2.isSelected()) {
			puntaje = 2;
		}
		lblEvEntendido.setText("Puntaje: " + puntaje);
		return puntaje;

	}
	
	private void clearFrame() {
		checkBox1.setSelected(false);
		checkBox2.setSelected(false);
		checkBox3.setSelected(false);
		checkBox4.setSelected(false);
		checkBox5.setSelected(false);
		checkBox6.setSelected(false);
		txtAtractivoPUsuario.setText(EMPTY_STRING);
	}
}
