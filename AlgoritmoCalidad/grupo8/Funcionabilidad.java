package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Funcionabilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5745267259821566766L;
	private JTextField txtInteroperabilidad;
	private JTextField txtExactitud;
	
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
		lblExactitudEnLos.setBounds(20, 329, 474, 16);
		getContentPane().add(lblExactitudEnLos);
		
		JLabel lbl1 = new JLabel("- ¿Con cuántos sistemas se relaciona su producto software?");
		lbl1.setBounds(48, 58, 428, 16);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("- Mi software tiene inicio de sesión de usuarios");
		lbl2.setBounds(48, 158, 378, 16);
		getContentPane().add(lbl2);
		
		JLabel label_1 = new JLabel("- ¿Con cuántos sistemas se relaciona su producto software?");
		label_1.setBounds(48, 357, 428, 16);
		getContentPane().add(label_1);
		
		txtInteroperabilidad = new JTextField();
		txtInteroperabilidad.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtInteroperabilidad.setToolTipText("Ingrese cantidad total de sistemas con los que se relaciona su sistema");
		txtInteroperabilidad.setBounds(58, 86, 130, 26);
		getContentPane().add(txtInteroperabilidad);
		txtInteroperabilidad.setColumns(10);
		
		txtExactitud = new JTextField();
		txtExactitud.setToolTipText("Ingrese cantidad total de sistemas con los que se relaciona su sistema");
		txtExactitud.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtExactitud.setColumns(10);
		txtExactitud.setBounds(48, 381, 130, 26);
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
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(435, 154, 28, 23);
		getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(435, 182, 28, 23);
		getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(435, 208, 28, 23);
		getContentPane().add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(435, 236, 28, 23);
		getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(435, 280, 28, 23);
		getContentPane().add(checkBox_4);
		
		JLabel lblDespusDe = new JLabel("después de 15 minutos");
		lblDespusDe.setBounds(58, 287, 378, 16);
		getContentPane().add(lblDespusDe);
	}
}
