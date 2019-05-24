package grupo8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Usabilidad extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8887385168168186342L;
	
	public Usabilidad() {
		setTitle("Característica: Usabilidad");
		setSize(502, 487);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Tolerancia a fallos");
		lbl1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl1.setBounds(10, 10, 474, 26);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Tolerancia a fallos");
		lbl2.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl2.setBounds(10, 154, 474, 26);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Tolerancia a fallos");
		lbl3.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lbl3.setBounds(10, 305, 474, 26);
		getContentPane().add(lbl3);
	}

}
