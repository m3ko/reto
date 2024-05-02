package RentacarApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;

import Modelo.db.db_personas;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;

import RentacarApp.HacerReserva;
import RentacarApp.llamadas;

public class ConfirmaReserva {

	private static JTextField textMarca;
	private static JTextField textFHRecogida;
	private static JTextField textFHEntrega;
	private static JTextField textPrecioD;
	private static JTextField textPrecioT;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void ReservaConfirmar() {

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
		lblModelo.setBounds(216, 169, 166, 13);

		ImageIcon logoIcon = new ImageIcon("src/logo100.gif");
		JLabel logo = new JLabel(logoIcon);
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, 30);
		logo.setSize(430, 100);

		Color color = new Color(255, 204, 40);

		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		panel.add(logo);
		panel.add(lblModelo);

		frame.getContentPane().add(panel);
		
		// MENU

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(334, 0, 96, 31);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(Color.ORANGE);
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);
		mnNewMenu.setIcon(null);
		mnNewMenu.setSelectedIcon(new ImageIcon("C:\\Users\\1AW3-11\\Desktop\\rentacar\\src\\logoMenu.png"));
		mnNewMenu.setBackground(new Color(255, 215, 0));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);

		JButton cerrarSesion = new JButton("CERRAR SESION");
		mnNewMenu.add(cerrarSesion);
		cerrarSesion.setFont(new Font("DialogInput", Font.BOLD, 10));
		cerrarSesion.setBackground(Color.MAGENTA);
		cerrarSesion.setForeground(Color.RED);

		JButton cerrar = new JButton("");
		menuBar.add(cerrar);
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cerrar.setIcon(new ImageIcon("C:\\Users\\1AW3-11\\Desktop\\rentacar\\src\\cerrar.png"));
		cerrar.setForeground(Color.RED);
		cerrar.setFont(new Font("Corbel", Font.BOLD, 10));
		cerrar.setBackground(Color.MAGENTA);

		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.dispose();
				Login.main(null);

			}
		});

		// TEXTOS

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarca.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblMarca.setBounds(40, 170, 166, 13);
		panel.add(lblMarca);

		JLabel lblSeguro = new JLabel("Desea aplicar un Seguro?");
		lblSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeguro.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblSeguro.setBounds(50, 367, 181, 13);
		panel.add(lblSeguro);

		JLabel lblFHRecogida = new JLabel("Fecha y Hora recogida:");
		lblFHRecogida.setHorizontalAlignment(SwingConstants.LEFT);
		lblFHRecogida.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblFHRecogida.setBounds(40, 222, 166, 13);
		panel.add(lblFHRecogida);

		JLabel lblFHEntrega = new JLabel("Fecha y Hora entrega:");
		lblFHEntrega.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFHEntrega.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblFHEntrega.setBounds(226, 222, 156, 13);
		panel.add(lblFHEntrega);

		// TEXTOS A RELLENAR

		// MARCA

		textMarca = new JTextField(20);
		textMarca.setEditable(false);
		textMarca.setHorizontalAlignment(SwingConstants.CENTER);
		textMarca.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textMarca.setBounds(40, 193, 156, 19);
		String marca = RentacarApp.HacerReserva3.marcaAux.toString();
		textMarca.setText(marca);

		panel.add(textMarca);

		// MODELO

		JTextField textModelo = new JTextField(20);
		textModelo.setEditable(false);
		textModelo.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textModelo.setHorizontalAlignment(SwingConstants.CENTER);
		textModelo.setBounds(226, 192, 156, 19);
		String modelo = RentacarApp.HacerReserva3.modeloAux.toString();
		textModelo.setText(modelo);
		panel.add(textModelo);

		// FECHA RECOGIDA

		textFHRecogida = new JTextField(20);
		textFHRecogida.setEditable(false);
		textFHRecogida.setHorizontalAlignment(SwingConstants.CENTER);
		textFHRecogida.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textFHRecogida.setBounds(40, 243, 156, 19);
		String recogida = RentacarApp.HacerReserva.date1aux.toString() + " "
				+ RentacarApp.HacerReserva.hora1aux.toString() + ":" + RentacarApp.HacerReserva.min1aux.toString();
		textFHRecogida.setText(recogida);

		System.out.println(recogida);

		panel.add(textFHRecogida);

		// FECHA ENTREGA

		textFHEntrega = new JTextField(20);
		textFHEntrega.setEditable(false);
		textFHEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		textFHEntrega.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textFHEntrega.setBounds(226, 243, 156, 19);
		panel.add(textFHEntrega);
		String Entrega = RentacarApp.HacerReserva.date2aux.toString() + " "
				+ RentacarApp.HacerReserva.hora2aux.toString() + ":" + RentacarApp.HacerReserva.min2aux.toString();
		textFHEntrega.setText(Entrega);

		// PRECIO POR DIA

		textPrecioD = new JTextField(20);
		textPrecioD.setEditable(false);
		textPrecioD.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecioD.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textPrecioD.setBounds(40, 295, 156, 19);
		String aux = RentacarApp.HacerReserva3.precioAux.toString();

		int precioAux = Integer.parseInt(aux);
		String PrecioD = "" + precioAux;
		textPrecioD.setText(PrecioD);

		panel.add(textPrecioD);

		// PRECIO TOTAL

		textPrecioT = new JTextField(20);
		textPrecioT.setEditable(false);
		textPrecioT.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecioT.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textPrecioT.setBounds(226, 295, 156, 19);
		String diasAux = RentacarApp.HacerReserva.diasQuedan.toString();
		int diasQuedan = Integer.parseInt(diasAux);

		int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
		String añadirPrecio = "" + precioTotal;
		textPrecioT.setText(añadirPrecio);

		panel.add(textPrecioT);

		// RADIO BUTTONS

		JRadioButton radioSeguro = new JRadioButton("Sí");
		radioSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		radioSeguro.setBackground(Color.ORANGE);
		radioSeguro.setBounds(237, 363, 48, 23);
		panel.add(radioSeguro);
		
		JRadioButton radioAntigüedad = new JRadioButton("Sí");
		radioAntigüedad.setHorizontalAlignment(SwingConstants.LEFT);
		radioAntigüedad.setBackground(Color.ORANGE);
		radioAntigüedad.setBounds(237, 345, 48, 23);
		panel.add(radioAntigüedad);

		radioSeguro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (radioSeguro.isSelected() && radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux + 2 + 5;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				} else if (!radioSeguro.isSelected() && radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux + 5;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				} else if (radioSeguro.isSelected() && !radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux + 2;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				} else if (!radioSeguro.isSelected() && !radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				}

			}
		});

		

		radioAntigüedad.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (radioSeguro.isSelected() && radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux + 2 + 5;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				} else if (!radioSeguro.isSelected() && radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux + 5;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				} else if (radioSeguro.isSelected() && !radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux + 2;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				}else if (!radioSeguro.isSelected() && !radioAntigüedad.isSelected()) {
					textPrecioD.removeAll();
					int precioAux = Integer.parseInt(aux);
					precioAux = precioAux;
					String PrecioD = "" + precioAux;
					textPrecioD.setText(PrecioD);
					int precioTotal = Integer.parseInt(PrecioD) * diasQuedan;
					String añadirPrecio = "" + precioTotal;
					textPrecioT.setText(añadirPrecio);
				}

			}
		});

		// BOTONES

		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentacarApp.Pagar.ReservaPagar();
				frame.dispose();
			}
		});
		submit.setFont(new Font("DialogInput", Font.BOLD, 10));
		submit.setBounds(216, 410, 166, 21);
		submit.setBackground(Color.MAGENTA);
		submit.setForeground(Color.ORANGE);
		panel.add(submit);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerReserva2.reservaHacer2();
				frame.dispose();
			}
		});
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnVolver.setBackground(Color.MAGENTA);
		btnVolver.setBounds(40, 410, 166, 21);
		panel.add(btnVolver);

		JLabel lblPrecioD = new JLabel("Precio/día:");
		lblPrecioD.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioD.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblPrecioD.setBounds(40, 274, 156, 13);
		panel.add(lblPrecioD);

		JLabel lblPrecioT = new JLabel("Precio Total:");
		lblPrecioT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioT.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblPrecioT.setBounds(226, 272, 156, 13);
		panel.add(lblPrecioT);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setValue(75);
		progressBar.setForeground(Color.MAGENTA);
		progressBar.setBounds(0, 133, 430, 14);
		panel.add(progressBar);

		JLabel lblTCarnetDe = new JLabel("Tú carnet de conducir tiene\r\n\r\n");
		lblTCarnetDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblTCarnetDe.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblTCarnetDe.setBounds(50, 328, 254, 19);
		panel.add(lblTCarnetDe);

		JLabel lblCarnet2 = new JLabel("> 3 años de antigüedad?\r\n\r\n");
		lblCarnet2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarnet2.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblCarnet2.setBounds(50, 346, 254, 19);
		panel.add(lblCarnet2);

		frame.setUndecorated(true);
		frame.setVisible(true);

	}

}
