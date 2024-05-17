package RentacarApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import Modelo.db.db_personas;

import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;

public class App {
	/**
	 * @author Niko
	 * 
	 *         La cuenta cliente va a poder elegir la accion que quiera realizar.
	 */

	public static int reservaGestion;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void SesionIniciada() {

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
		JLabel logo = new JLabel(logoIcon);
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, 32);
		logo.setSize(430, 95);

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);
		panel.add(logo);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		boolean defaultColor = true;

		JButton hacerReserva = new JButton("HACER RESERVA");
		hacerReserva.addActionListener(new ActionListener() {
			/**
			 * @param e Si el cliente quiere realizar una reserva, le dirigira a la ventana
			 *          para iniciar el proceso.
			 */
			public void actionPerformed(ActionEvent e) {
				HacerReserva.reservaHacer();
				frame.dispose();
				App.reservaGestion = 0;
			}
		});

		hacerReserva.setSelectedIcon(new ImageIcon("C:\\Users\\1AW3-11\\Desktop\\rentacar\\src\\negro2.gif"));
		hacerReserva.setForeground(Color.BLACK);
		hacerReserva.setFont(new Font("DialogInput", Font.BOLD, 16));
		hacerReserva.setBackground(Color.ORANGE);
		hacerReserva.setBounds(10, 150, 410, 150);
		panel.add(hacerReserva);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.MAGENTA);
		progressBar.setValue(5);
		progressBar.setBounds(10, 136, 410, 14);
		panel.add(progressBar);

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
			 * @param e Si el usuario le da al boton de cerrar, se le cerrará el programa.
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
			 * @param e Si el usuario le da al boton de cerrar sesión, se le cerrará la
			 *          sesion y volverá a la ventana de Login.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.dispose();
				Login.main(null);

			}
		});

		JButton gestionarReserva = new JButton("GESTIONAR RESERVA");
		gestionarReserva.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton de gestionarReserva, se le dirigirá
			 *          a la venta para que pueda gestionar sus reservas anteriormente ya
			 *          realizadas.
			 */
			public void actionPerformed(ActionEvent e) {

				App.reservaGestion = 1;
				frame.dispose();
				GestionarReserva.reservaGestionar();

			}
		});
		gestionarReserva.setForeground(Color.BLACK);
		gestionarReserva.setFont(new Font("DialogInput", Font.BOLD, 16));
		gestionarReserva.setBackground(Color.ORANGE);
		gestionarReserva.setBounds(10, 297, 410, 150);
		panel.add(gestionarReserva);
		frame.setUndecorated(true);
		frame.setVisible(true);

	}

}