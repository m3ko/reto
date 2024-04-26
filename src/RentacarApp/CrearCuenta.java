package RentacarApp;

import java.awt.Color;
import java.awt.Font;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCuenta {
	private static JTextField textDNI;
	private static JTextField textNombre;
	private static JTextField textApellido;
	private static JTextField textTelefono;
	private static JPasswordField textContra2;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void cuentaCrear() {

		JFrame frame = new JFrame();

		frame.setSize(430, 457);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    frame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		JLabel lblMail = new JLabel("Correo:");
		lblMail.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setBounds(216, 174, 166, 13);
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña.setBounds(216, 226, 166, 13);

		ImageIcon logoIcon = new ImageIcon("src/logoancho.gif");
		JLabel logo = new JLabel(logoIcon);
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, -27);
		logo.setSize(430, 184);

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);
		panel.add(logo);
		panel.add(lblMail);
		panel.add(lblContraseña);

		frame.getContentPane().add(panel);

		// TEXTOS

		JLabel lblDni = new JLabel("DNI/NIE:");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblDni.setBounds(40, 175, 166, 13);
		panel.add(lblDni);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblTelefono.setBounds(40, 331, 166, 13);
		panel.add(lblTelefono);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNombre.setBounds(40, 227, 142, 13);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblApellido.setBounds(40, 279, 166, 13);
		panel.add(lblApellido);

		JLabel lblVolverAEscribir = new JLabel("Repite Contraseña:");
		lblVolverAEscribir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVolverAEscribir.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblVolverAEscribir.setBounds(220, 278, 166, 13);
		panel.add(lblVolverAEscribir);

		JLabel lblEmpiezaAViajar = new JLabel("Empieza a viajar!");
		lblEmpiezaAViajar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpiezaAViajar.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblEmpiezaAViajar.setBounds(216, 331, 166, 13);
		panel.add(lblEmpiezaAViajar);

		// TEXTOS A RELLENAR

		textDNI = new JTextField(20);
		textDNI.setHorizontalAlignment(SwingConstants.CENTER);
		textDNI.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textDNI.setBounds(40, 198, 156, 19);
		panel.add(textDNI);

		textNombre = new JTextField(20);
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textNombre.setBounds(40, 248, 156, 19);
		panel.add(textNombre);

		textApellido = new JTextField(20);
		textApellido.setHorizontalAlignment(SwingConstants.CENTER);
		textApellido.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textApellido.setBounds(40, 302, 156, 19);
		panel.add(textApellido);

		textTelefono = new JTextField(20);
		textTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefono.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textTelefono.setBounds(40, 354, 156, 19);
		panel.add(textTelefono);

		JTextField textMail = new JTextField(20);
		textMail.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textMail.setHorizontalAlignment(SwingConstants.CENTER);
		textMail.setBounds(226, 197, 156, 19);
		panel.add(textMail);

		JPasswordField textContra = new JPasswordField(20);
		textContra.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textContra.setHorizontalAlignment(SwingConstants.CENTER);
		textContra.setBounds(226, 247, 156, 19);
		panel.add(textContra);

		textContra2 = new JPasswordField(20);
		textContra2.setHorizontalAlignment(SwingConstants.CENTER);
		textContra2.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textContra2.setBounds(226, 302, 156, 19);
		panel.add(textContra2);

		// BOTONES

		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font("DialogInput", Font.BOLD, 10));
		submit.setBounds(216, 352, 166, 21);
		submit.setBackground(Color.MAGENTA);
		submit.setForeground(Color.ORANGE);
		panel.add(submit);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String dniNew = textDNI.getText();
				String nombreNew = textNombre.getText();
				String apellidoNew = textApellido.getText();
				String telefonoNew = textTelefono.getText();
				String mailNew = textMail.getText();
				String contraNew = new String(textContra.getPassword());
				String contra2 = new String(textContra2.getPassword());

				System.out.println(contraNew);
				System.out.println(contra2);

				boolean comprobDni = db_personas.comprobarDNI(dniNew);
				boolean comprobMail = db_personas.comprobarMail(mailNew);

				if (!(contraNew.equals(contra2))) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden!!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (comprobDni == true) {
					JOptionPane.showMessageDialog(null,
							"Ya existe un Usuario con ese DNI!" + "/r/n"
									+ "Suplantar la identidad de alguien es un delito :(",
							"Warning", JOptionPane.WARNING_MESSAGE);
				} else if (comprobMail == true) {
					JOptionPane.showMessageDialog(null, "Ya existe un Usuario con ese Mail", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					boolean exito = db_personas.añadirPersona(dniNew, nombreNew, apellidoNew, contraNew, telefonoNew,
							mailNew);
					if (exito == true) {
						JOptionPane.showMessageDialog(null, "Usuario creado con exito!");
						Login.main(null);
						int auxClave = db_personas.getClave(dniNew);
						JOptionPane.showMessageDialog(null,
								"Se te ha asignado una ClavePrivada: " + auxClave
										+ ", Apúntala, la necesitarás si olvidas tu contraseña!!",
								"Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

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
		btnVolver.setBounds(216, 383, 166, 21);
		panel.add(btnVolver);

		frame.setUndecorated(true);
		frame.setVisible(true);

	}
}
