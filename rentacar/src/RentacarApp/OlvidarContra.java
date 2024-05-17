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

public class OlvidarContra {
	private static JTextField textDNIOlv;
	private static JPasswordField textContraOlv2;
	private static JTextField textClavePrivada;
	private static JTextField textClavePriv;

	/**
	 * @wbp.parser.entryPoint
	 * @author niko El usuario podra restablecer su contraseña si la clave privada
	 *         coincide con la asignada al cliente.
	 */
	public static void contraOlvidar() {

		JFrame frame = new JFrame();

		frame.setSize(430, 457);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    frame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		JLabel lblMailOlv = new JLabel("Correo:");
		lblMailOlv.setHorizontalAlignment(SwingConstants.LEFT);
		lblMailOlv.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblMailOlv.setBounds(40, 234, 156, 13);
		JLabel lblNuevaContraseñaOlv = new JLabel("Nueva Contraseña:");
		lblNuevaContraseñaOlv.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNuevaContraseñaOlv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuevaContraseñaOlv.setBounds(212, 175, 166, 13);

		ImageIcon logoIcon = new ImageIcon("src/logoancho.gif");
		JLabel logo = new JLabel(logoIcon);
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, -27);
		logo.setSize(430, 184);

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);
		panel.add(logo);
		panel.add(lblMailOlv);
		panel.add(lblNuevaContraseñaOlv);

		frame.getContentPane().add(panel);

		// TEXTOS

		JLabel lblDniOlv = new JLabel("DNI/NIE:");
		lblDniOlv.setHorizontalAlignment(SwingConstants.LEFT);
		lblDniOlv.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblDniOlv.setBounds(40, 175, 166, 13);
		panel.add(lblDniOlv);

		JLabel lblVolverAEscribirOlv = new JLabel("Repite Contraseña:");
		lblVolverAEscribirOlv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVolverAEscribirOlv.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblVolverAEscribirOlv.setBounds(212, 234, 166, 13);
		panel.add(lblVolverAEscribirOlv);

		JLabel clavePriv = new JLabel("Clave Privada:");
		clavePriv.setHorizontalAlignment(SwingConstants.LEFT);
		clavePriv.setFont(new Font("DialogInput", Font.BOLD, 12));
		clavePriv.setBounds(40, 286, 156, 13);
		panel.add(clavePriv);

		// TEXTOS A RELLENAR

		textDNIOlv = new JTextField(20);
		textDNIOlv.setHorizontalAlignment(SwingConstants.LEFT);
		textDNIOlv.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textDNIOlv.setBounds(40, 198, 156, 19);
		panel.add(textDNIOlv);

		JTextField textMailOlv = new JTextField(20);
		textMailOlv.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textMailOlv.setHorizontalAlignment(SwingConstants.LEFT);
		textMailOlv.setBounds(40, 257, 156, 19);
		panel.add(textMailOlv);

		JPasswordField textContraOlv = new JPasswordField(20);
		textContraOlv.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textContraOlv.setHorizontalAlignment(SwingConstants.RIGHT);
		textContraOlv.setBounds(222, 198, 156, 19);
		panel.add(textContraOlv);

		textContraOlv2 = new JPasswordField(20);
		textContraOlv2.setHorizontalAlignment(SwingConstants.RIGHT);
		textContraOlv2.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textContraOlv2.setBounds(222, 257, 156, 19);
		panel.add(textContraOlv2);

		textClavePriv = new JTextField(20);
		textClavePriv.setHorizontalAlignment(SwingConstants.LEFT);
		textClavePriv.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textClavePriv.setBounds(40, 309, 156, 19);
		panel.add(textClavePriv);

		// BOTONES

		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font("DialogInput", Font.BOLD, 10));
		submit.setBounds(222, 308, 156, 21);
		submit.setBackground(Color.MAGENTA);
		submit.setForeground(Color.ORANGE);
		panel.add(submit);

		submit.addActionListener(new ActionListener() {
			/**
			 * @param e El usuario introducirá los datos necesarios y se verificará si
			 *          existen.
			 */
			public void actionPerformed(ActionEvent e) {

				String dniNew = textDNIOlv.getText();
				String mailNew = textMailOlv.getText();
				String contraNew = new String(textContraOlv.getPassword());
				String contra2 = new String(textContraOlv2.getPassword());
				String clavePrivada = new String(textClavePriv.getText());

				System.out.println(contraNew);
				System.out.println(contra2);

				boolean comprobDni = db_personas.comprobarDNI(dniNew);
				boolean comprobMail = db_personas.comprobarMail(mailNew);
				boolean comprobClave = db_personas.comprobClave(clavePrivada, dniNew);

				if (!(contraNew.equals(contra2))) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden!!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (comprobDni == false) {
					JOptionPane.showMessageDialog(null, "NO existe un Usuario con ese DNI!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (comprobMail == false) {
					JOptionPane.showMessageDialog(null, "NO existe un Usuario con ese Mail!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (comprobClave == true) {

					boolean cambiarContra = db_personas.cambiarContra(dniNew, contraNew);
					if (cambiarContra == true) {
						JOptionPane.showMessageDialog(null, "Contraseña restablecida con Exito!", "Warning",
								JOptionPane.WARNING_MESSAGE);

						Login.main(null);
						frame.dispose();
						// System.exit(0);
					}

				} else if (comprobClave == false) {

					JOptionPane.showMessageDialog(null,
							"La clave publica no coincide con esa Clave Privada!, vuelva a intentarlo", "Warning",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		});

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton volver, volverá a la ventana
			 *          anterior.
			 */
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnVolver.setBackground(Color.MAGENTA);
		btnVolver.setBounds(40, 357, 156, 21);
		panel.add(btnVolver);

		JLabel lblSiNoDispone = new JLabel("Si NO dispone de su clave privada,\r\nponte en contacto con nosotros!");
		lblSiNoDispone.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiNoDispone.setFont(new Font("DialogInput", Font.BOLD, 9));
		lblSiNoDispone.setBounds(10, 416, 410, 41);
		panel.add(lblSiNoDispone);

		frame.setUndecorated(true);
		frame.setVisible(true);

	}

}
