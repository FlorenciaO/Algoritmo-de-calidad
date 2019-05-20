package grupo8;

import javax.swing.JFrame;

public class Funcionabilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5745267259821566766L;
	
	public Funcionabilidad(VentanaPrincipal ventanaPrincipal) {
		setTitle("Característica: Funcionabilidad");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(ventanaPrincipal);
	}

}
