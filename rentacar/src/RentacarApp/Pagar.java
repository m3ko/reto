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
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class Pagar {

	private static JTextField textDni;
	private static JTextField textMail;
	private static JTextField textNumero;
	private static JTextField textCVV;
	private static JTextField textTitular;
	public static Object dniAux;

	/**
	 * @wbp.parser.entryPoint
	 */
	/**
	 * @author Niko El usuario especificará los datos de pago, y se realizará la
	 *         reserva. Así actualizando la BBDD.
	 */
	public static void ReservaPagar() {

		JFrame frame = new JFrame();

		frame.setSize(430, 460);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    frame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		JLabel lblNombre = new JLabel("NOMBRE Y APELLIDOS DEL TITULAR");
		lblNombre.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(40, 223, 342, 13);

		ImageIcon logoIcon = new ImageIcon("src/logo100.gif");
		JLabel logo = new JLabel(logoIcon);
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, 30);
		logo.setSize(430, 100);

		Color color = new Color(255, 204, 40);

		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		panel.add(logo);
		panel.add(lblNombre);

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
			/**
			 * Si el usuario presiona el boton cerrar, se cierra el programa.
			 * 
			 * @param e
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.dispose();
				Login.main(null);

			}
		});

		// TEXTOS

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblDni.setBounds(40, 170, 156, 13);
		panel.add(lblDni);

		JLabel lblMail = new JLabel("MAIL:");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblMail.setBounds(226, 170, 156, 13);
		panel.add(lblMail);

		JLabel lblNumero = new JLabel("NUMERO TARJETA");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNumero.setBounds(140, 275, 156, 13);
		panel.add(lblNumero);

		// MAIL

		textMail = new JTextField(20);
		textMail.setEditable(false);
		textMail.setHorizontalAlignment(SwingConstants.CENTER);
		textMail.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textMail.setBounds(226, 193, 156, 19);
		String mail = Login.mailAux.toString();
		textMail.setText(mail);

		panel.add(textMail);

		// DNI

		textDni = new JTextField(20);
		textDni.setEditable(false);
		textDni.setHorizontalAlignment(SwingConstants.CENTER);
		textDni.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textDni.setBounds(40, 194, 156, 19);

		String dni = db_personas.getDni(mail);
		dniAux = dni;
		textDni.setText(dni);

		panel.add(textDni);

		// TEXTOS A RELLENAR

		// NOMBRE

		textTitular = new JTextField(20);
		textTitular.setHorizontalAlignment(SwingConstants.CENTER);
		textTitular.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textTitular.setBounds(40, 246, 342, 19);
		panel.add(textTitular);

		// NUMERO TARJETA

		textNumero = new JTextField(20);
		textNumero.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textNumero.setBounds(40, 298, 342, 19);
		panel.add(textNumero);

		// CVV

		textCVV = new JTextField(20);
		textCVV.setHorizontalAlignment(SwingConstants.CENTER);
		textCVV.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textCVV.setBounds(40, 350, 156, 19);

		panel.add(textCVV);

		// BOTONES

		JButton btnSubmit = new JButton("CONFIRMAR RESERVA");
		btnSubmit.addActionListener(new ActionListener() {
			/**
			 * @param e Al presionar el botón Confirmar reserva, volverá a la ventana App. Y
			 *          se harán las consultas necesarias para que la reserva se refleje en
			 *          la BBDD.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Reserva confirmada con exito!", "Warning",
						JOptionPane.WARNING_MESSAGE);
				Modelo.db.db_itinerarios.generarItinerario();
				Modelo.db.db_reservas.hacerReserva();

				RentacarApp.App.SesionIniciada();
				frame.dispose();
			}
		});
		btnSubmit.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnSubmit.setBounds(216, 397, 166, 21);
		btnSubmit.setBackground(Color.MAGENTA);
		btnSubmit.setForeground(Color.ORANGE);
		panel.add(btnSubmit);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * @param e Al presionar el botón Volver, le llevará a la ventana anterior.
			 */
			public void actionPerformed(ActionEvent e) {
				ConfirmaReserva.ReservaConfirmar();
				frame.dispose();
			}
		});
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnVolver.setBackground(Color.MAGENTA);
		btnVolver.setBounds(40, 397, 166, 21);
		panel.add(btnVolver);

		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setHorizontalAlignment(SwingConstants.CENTER);
		lblCVV.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblCVV.setBounds(40, 327, 156, 13);
		panel.add(lblCVV);

		JLabel lblFecha = new JLabel("FECHA CADUCIDAD");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblFecha.setBounds(216, 324, 166, 19);
		panel.add(lblFecha);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setValue(75);
		progressBar.setForeground(Color.MAGENTA);
		progressBar.setBounds(0, 133, 430, 14);
		panel.add(progressBar);

		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(323, 349, 11, 19);
		panel.add(lblNewLabel);

		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(334, 350, 48, 19);
		panel.add(yearChooser);

		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(226, 350, 93, 19);
		panel.add(monthChooser);

		frame.setUndecorated(true);
		frame.setVisible(true);

	}
}