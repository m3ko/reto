package RentacarApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modelo.db.db_personas;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;

import RentacarApp.HacerReserva;

public class ConfirmaReserva {
	
	private static JTextField textMarca;
	private static JTextField textFHRecogida;
	private static JTextField textFHEntrega;
	private static JTextField textPrecioD;
	private static JTextField textPrecioT;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void ReservaConfirmar(int horaRecogida, int minRecogida, String fecha1) {

		JFrame frame = new JFrame();

		frame.setSize(430, 457);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    frame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setBounds(216, 174, 166, 13);

		ImageIcon logoIcon = new ImageIcon("src/logoancho.gif");
		JLabel logo = new JLabel(logoIcon);
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, -27);
		logo.setSize(430, 184);

		Color color = new Color(255, 204, 40);

		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		panel.add(logo);
		panel.add(lblModelo);

		frame.getContentPane().add(panel);

		// TEXTOS

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarca.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblMarca.setBounds(40, 175, 166, 13);
		panel.add(lblMarca);

		JLabel lblSeguro = new JLabel("Desea aplicar un Seguro?");
		lblSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeguro.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblSeguro.setBounds(95, 372, 181, 13);
		panel.add(lblSeguro);

		JLabel lblFHRecogida = new JLabel("Fecha y Hora recogida:");
		lblFHRecogida.setHorizontalAlignment(SwingConstants.LEFT);
		lblFHRecogida.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblFHRecogida.setBounds(40, 227, 166, 13);
		panel.add(lblFHRecogida);

		JLabel lblFHEntrega = new JLabel("Fecha y Hora entrega:");
		lblFHEntrega.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFHEntrega.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblFHEntrega.setBounds(226, 227, 156, 13);
		panel.add(lblFHEntrega);

		// TEXTOS A RELLENAR

		textMarca = new JTextField(20);
		textMarca.setEditable(false);
		textMarca.setHorizontalAlignment(SwingConstants.CENTER);
		textMarca.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textMarca.setBounds(40, 198, 156, 19);
		panel.add(textMarca);

		textFHRecogida = new JTextField(20);
		textFHRecogida.setEditable(false);
		textFHRecogida.setHorizontalAlignment(SwingConstants.CENTER);
		textFHRecogida.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textFHRecogida.setBounds(40, 248, 156, 19);
		
		String recogida = RentacarApp.HacerReserva.guardarRecogida(horaRecogida, minRecogida, fecha1);
		textFHRecogida.setText(recogida);
		panel.add(textFHRecogida);

		textFHEntrega = new JTextField(20);
		textFHEntrega.setEditable(false);
		textFHEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		textFHEntrega.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textFHEntrega.setBounds(226, 248, 156, 19);
		panel.add(textFHEntrega);
		String Entrega = RentacarApp.HacerReserva.guardarEntrega(0, 0, null);
		textFHEntrega.setText(Entrega);

		textPrecioD = new JTextField(20);
		textPrecioD.setEditable(false);
		textPrecioD.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecioD.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textPrecioD.setBounds(40, 300, 156, 19);
		panel.add(textPrecioD);

		JTextField textModelo = new JTextField(20);
		textModelo.setEditable(false);
		textModelo.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textModelo.setHorizontalAlignment(SwingConstants.CENTER);
		textModelo.setBounds(226, 197, 156, 19);
		panel.add(textModelo);

		textPrecioT = new JTextField(20);
		textPrecioT.setEditable(false);
		textPrecioT.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecioT.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textPrecioT.setBounds(226, 300, 156, 19);
		panel.add(textPrecioT);

		// BOTONES

		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font("DialogInput", Font.BOLD, 10));
		submit.setBounds(216, 414, 166, 21);
		submit.setBackground(Color.MAGENTA);
		submit.setForeground(Color.ORANGE);
		panel.add(submit);

		

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnVolver.setBackground(Color.MAGENTA);
		btnVolver.setBounds(40, 414, 166, 21);
		panel.add(btnVolver);
		
		JLabel lblPrecioD = new JLabel("Precio/día:");
		lblPrecioD.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioD.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblPrecioD.setBounds(40, 279, 156, 13);
		panel.add(lblPrecioD);
		
		JLabel lblPrecioT = new JLabel("Precio Total:");
		lblPrecioT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioT.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblPrecioT.setBounds(226, 277, 156, 13);
		panel.add(lblPrecioT);
		
		JRadioButton radioAntigüedad = new JRadioButton("Sí");
		radioAntigüedad.setHorizontalAlignment(SwingConstants.LEFT);
		radioAntigüedad.setBackground(Color.ORANGE);
		radioAntigüedad.setBounds(282, 350, 48, 23);
		panel.add(radioAntigüedad);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setValue(75);
		progressBar.setForeground(Color.MAGENTA);
		progressBar.setBounds(0, 156, 430, 14);
		panel.add(progressBar);
		
		JLabel lblTCarnetDe = new JLabel("Tú carnet de conducir tiene\r\n\r\n");
		lblTCarnetDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblTCarnetDe.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblTCarnetDe.setBounds(95, 333, 254, 19);
		panel.add(lblTCarnetDe);
		
		JRadioButton radioSeguro = new JRadioButton("Sí");
		radioSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		radioSeguro.setBackground(Color.ORANGE);
		radioSeguro.setBounds(282, 368, 48, 23);
		panel.add(radioSeguro);
		
		JLabel lblCarnet2 = new JLabel("> 3 años de antigüedad?\r\n\r\n");
		lblCarnet2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarnet2.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblCarnet2.setBounds(95, 351, 254, 19);
		panel.add(lblCarnet2);

		frame.setUndecorated(true);
		frame.setVisible(true);

	}
	
}


