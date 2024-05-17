package RentacarAppTrbj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import RentacarApp.App;
import RentacarApp.GestionarReserva;
import RentacarApp.HacerReserva;
import RentacarApp.Login;

public class AppTrabajador {

	/**
	 * @wbp.parser.entryPoint
	 */

	/**
	 * @author niko Ventana destinada a Trabajadores. Este, podra seleccionar la
	 *         tabla a Editar o Importar un fichero xml.
	 */
	public static void SesionIniciadaTrabajador() {

		// TODO Auto-generated method stub

		JFrame frame = new JFrame();

		frame.setSize(430, 457);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);

		ImageIcon logoIcon = new ImageIcon("src/logo100.gif");
		JLabel logo = new JLabel(new ImageIcon("C:\\Users\\1AW3-11\\eclipse-workspace\\rentacar\\src\\logoancho.gif"));
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, 25);
		logo.setSize(430, 200);

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);
		panel.add(logo);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		boolean defaultColor = true;

		JButton GstClientes = new JButton("CLIENTES");
		GstClientes.addActionListener(new ActionListener() {
			/**
			 * @param e Si se presiona este boton, se le llevará a la ventana para modificar
			 *          la tabla Clientes.
			 */
			public void actionPerformed(ActionEvent e) {

				new GestionClientes();
				frame.dispose();

			}
		});

		GstClientes.setSelectedIcon(new ImageIcon("C:\\Users\\1AW3-11\\Desktop\\rentacar\\src\\negro2.gif"));
		GstClientes.setForeground(Color.BLACK);
		GstClientes.setFont(new Font("DialogInput", Font.BOLD, 14));
		GstClientes.setBackground(Color.ORANGE);
		GstClientes.setBounds(29, 281, 118, 69);
		panel.add(GstClientes);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(Color.ORANGE);
		menuBar.setBounds(334, 0, 96, 26);
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
			/**
			 * @param e Si se selecciona el boton cerrar, se cerrará el programa.
			 */
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

		JButton GstEmpresas = new JButton("EMPRESAS");
		GstEmpresas.addActionListener(new ActionListener() {
			/**
			 * @param e Si se presiona este boton, se le llevará a la ventana para modificar
			 *          la tabla Empresas.
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				GestionEmpresas.EmpresasGestionar();

			}
		});
		GstEmpresas.setForeground(Color.BLACK);
		GstEmpresas.setFont(new Font("DialogInput", Font.BOLD, 14));
		GstEmpresas.setBackground(Color.ORANGE);
		GstEmpresas.setBounds(157, 281, 118, 69);
		panel.add(GstEmpresas);

		JButton GstVehiculos = new JButton("VEHÍCULOS");
		GstVehiculos.addActionListener(new ActionListener() {
			/**
			 * @param e Si se presiona este boton, se le llevará a la ventana para modificar
			 *          la tabla Vehiculos.
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestionVehiculos.VehiculosGestionar();
			}
		});
		GstVehiculos.setForeground(Color.BLACK);
		GstVehiculos.setFont(new Font("DialogInput", Font.BOLD, 14));
		GstVehiculos.setBackground(Color.ORANGE);
		GstVehiculos.setBounds(285, 281, 118, 69);
		panel.add(GstVehiculos);

		JButton GstItinerarios = new JButton("ITINERARIOS");
		GstItinerarios.addActionListener(new ActionListener() {
			/**
			 * @param e Si se presiona este boton, se le llevará a la ventana para modificar
			 *          la tabla Itinerarios.
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				GestionItinerarios.ItinerariosGestionar();

			}
		});
		GstItinerarios.setForeground(Color.BLACK);
		GstItinerarios.setFont(new Font("DialogInput", Font.BOLD, 12));
		GstItinerarios.setBackground(Color.ORANGE);
		GstItinerarios.setBounds(29, 360, 118, 69);
		panel.add(GstItinerarios);

		JButton GstReservas = new JButton("RESERVAS");
		GstReservas.addActionListener(new ActionListener() {
			/**
			 * @param e Si se presiona este boton, se le llevará a la ventana para modificar
			 *          la tabla Reservas.
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestionarReservas.ReservasGestionar();
			}
		});
		GstReservas.setForeground(Color.BLACK);
		GstReservas.setFont(new Font("DialogInput", Font.BOLD, 14));
		GstReservas.setBackground(Color.ORANGE);
		GstReservas.setBounds(157, 360, 118, 69);
		panel.add(GstReservas);

		JLabel lblNewLabel = new JLabel("Seleccione la tabla con la que desea operar");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 235, 410, 26);
		panel.add(lblNewLabel);

		JButton XML = new JButton("Importar XML");
		XML.addActionListener(new ActionListener() {
			/**
			 * @param e Si se presiona este boton, se le llevará a la ventana para Importar
			 *          un fichero xml.
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				xml.importarXml();

			}
		});
		XML.setForeground(Color.BLACK);
		XML.setFont(new Font("DialogInput", Font.BOLD, 10));
		XML.setBackground(Color.ORANGE);
		XML.setBounds(285, 360, 118, 69);
		panel.add(XML);
		frame.setUndecorated(true);
		frame.setVisible(true);

	}

}