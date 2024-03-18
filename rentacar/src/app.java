

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		JLabel login = new JLabel("Login:");
		
	    // Crea un ImageIcon con la ruta al archivo GIF
	    ImageIcon logoIcon = new ImageIcon("ruta/al/RentACar.gif");

	    // Crea un JLabel para mostrar el logotipo
	    JLabel logo = new JLabel(logoIcon);
	    panel.add(logo);
		
	 //   JLabel logo = new JLabel(imageIcon);
		
		
		
		panel.add(login);
	//	panel.add(logo);
		frame.add(panel);
		
		
		
		
		
	}
	
	
}
