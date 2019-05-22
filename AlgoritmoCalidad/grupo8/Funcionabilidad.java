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

public class Funcionabilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5745267259821566766L;
	private JTextField txtInteroperabilidad;
	private JTextField txtExactitud;
	private static final String EMPTY_STRING = "";
	private Resultado resultado;
	
	public Funcionabilidad(VentanaPrincipal ventanaPrincipal) {
		setTitle("Característica: Funcionabilidad");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(ventanaPrincipal);
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
		
		JLabel lbl8 = new JLabel("- ¿Con cuántos sistemas se relaciona su producto software?");
		lbl8.setBounds(48, 366, 428, 16);
		getContentPane().add(lbl8);
		
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
		
		txtExactitud = new JTextField();
		txtExactitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				validarIngreso(e, txtExactitud);
			}
		});
		txtExactitud.setToolTipText("Ingrese cantidad total de sistemas con los que se relaciona su sistema");
		txtExactitud.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtExactitud.setColumns(10);
		txtExactitud.setBounds(48, 394, 130, 26);
		getContentPane().add(txtExactitud);
		
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
		
		JCheckBox checkBox1 = new JCheckBox("");
		checkBox1.setBounds(435, 154, 28, 23);
		getContentPane().add(checkBox1);
		
		JCheckBox checkBox2 = new JCheckBox("");
		checkBox2.setBounds(435, 182, 28, 23);
		getContentPane().add(checkBox2);
		
		JCheckBox checkBox3 = new JCheckBox("");
		checkBox3.setBounds(435, 208, 28, 23);
		getContentPane().add(checkBox3);
		
		JCheckBox checkBox4 = new JCheckBox("");
		checkBox4.setBounds(435, 236, 28, 23);
		getContentPane().add(checkBox4);
		
		JCheckBox checkBox5 = new JCheckBox("");
		checkBox5.setBounds(435, 280, 28, 23);
		getContentPane().add(checkBox5);
		
		JLabel lbl7 = new JLabel("después de 15 minutos");
		lbl7.setBounds(58, 287, 378, 16);
		getContentPane().add(lbl7);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluar();
			}
		});
		btnEvaluar.setBounds(20, 432, 117, 29);
		getContentPane().add(btnEvaluar);
		
		JLabel lblEvInteroperabilidad = new JLabel("");
		lblEvInteroperabilidad.setBounds(217, 91, 61, 16);
		getContentPane().add(lblEvInteroperabilidad);
		
		JLabel lblEvSegAcceso = new JLabel("");
		lblEvSegAcceso.setBounds(48, 315, 61, 16);
		getContentPane().add(lblEvSegAcceso);
		
		JLabel lblEvExacResultados = new JLabel("");
		lblEvExacResultados.setBounds(217, 400, 61, 16);
		getContentPane().add(lblEvExacResultados);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setToolTipText("Debe evaluar la característica antes de seguir");
		btnSiguiente.setEnabled(false);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
			}
		});
		btnSiguiente.setBounds(359, 432, 117, 29);
		getContentPane().add(btnSiguiente);
		
		JLabel lblEvFuncionalidad = new JLabel("");
		lblEvFuncionalidad.setBounds(149, 437, 61, 16);
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
		
	}
	
	private void evaluar() {
		
		
	}
}
