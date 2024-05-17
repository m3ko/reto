package RentacarApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Modelo.empresas;
import Modelo.itinerarios;
import Modelo.reservas;
import Modelo.vehiculos;

public class GestionarReserva {
	/**
	 * @wbp.parser.entryPoint
	 */

	public static int idItinerarioAux;
	public static String codVehiculoAnterior;
	public static int idReservaAux;

	/**
	 * @wbp.parser.entryPoint
	 * @author Niko
	 * 
	 *         El usuario podrá modificar o eliminar las reservas ya realizadas
	 *         anteriormente.
	 */
	public static void reservaGestionar() {

		// TODO Auto-generated method stub

		JFrame frame = new JFrame();

		frame.setSize(430, 457);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);

		ImageIcon logoIcon = new ImageIcon("src/logo100.gif");

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);

		// MENU

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("DialogInput", Font.PLAIN, 12));
		menuBar.setBounds(334, 0, 96, 31);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(Color.ORANGE);
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("Menú");
		mnNewMenu.setFont(new Font("DialogInput", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		mnNewMenu.setIcon(null);
		mnNewMenu.setSelectedIcon(new ImageIcon(".\\src\\logoMenu.png"));
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
			 * @param e Si el usuario presiona el boton cerrar, se le cerrará el programa.
			 */
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cerrar.setIcon(new ImageIcon(".\\src\\cerrar.png"));
		cerrar.setForeground(Color.RED);
		cerrar.setFont(new Font("Corbel", Font.BOLD, 10));
		cerrar.setBackground(Color.MAGENTA);

		cerrarSesion.addActionListener(new ActionListener() {

			/**
			 * @param e Si el usuario presiona el boton cerrarSesion, se le cerrará la
			 *          sesión y volvera a la ventana de Login.
			 */

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.dispose();
				Login.main(null);

			}
		});
		JLabel logo = new JLabel(logoIcon);
		logo.setBounds(0, 36, 430, 107);
		logo.setVerticalAlignment(SwingConstants.TOP);
		panel.add(logo);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setBackground(Color.GRAY);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el botón volver, volverá a la anterior
			 *          ventana.
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				RentacarApp.App.SesionIniciada();

			}
		});
		btnVolver.setBounds(20, 345, 135, 21);
		panel.add(btnVolver);

		// FILTROS en listas

		JComboBox comboId = new JComboBox();
		comboId.setBackground(Color.WHITE);
		comboId.setToolTipText("Seleccione");
		comboId.addItem("0");
		ArrayList<reservas> listaReservas = Modelo.db.db_reservas.getReservas();
		for (reservas reservas : listaReservas) {
			comboId.addItem(reservas.getId_reserva());
		}
		// comboId.setSelectedIndex();

		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setForeground(Color.ORANGE);
		txtrDescripcion.setBackground(Color.GRAY);
		txtrDescripcion.setFont(new Font("DialogInput", Font.BOLD, 13));
		txtrDescripcion.setEditable(false);
		txtrDescripcion.setBounds(179, 179, 226, 212);
		panel.add(txtrDescripcion);

		boolean defaultColor = true;

		comboId.addActionListener(new ActionListener() {

			/**
			 * @param e El usuario al seleccionar una reserva valida se actualizarán las
			 *          demás listas, acorde a la base de datos. Con todas las opciones
			 *          seleccionadas, se le proyectará una descripción de dicha reserva.
			 */
			public void actionPerformed(ActionEvent e) {

				if (comboId.getSelectedItem().toString() == "0") {
					txtrDescripcion.removeAll();
					txtrDescripcion.setText(" ");
					JOptionPane.showMessageDialog(null, "Debe de seleccionar una reserva valida!", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else if (comboId.getSelectedItem().toString() != "0") {

					String aux = comboId.getSelectedItem().toString();
					int idReserva = Integer.parseInt(aux);
					int idItinerario = 0;
					Date fechaRecogida = null;
					Date fechaEntrega = null;

					String codigo_vehiculo = "";
					String marcaAux = "";
					String modeloAux = "";

					for (reservas reservas : listaReservas) {
						if (reservas.getId_reserva() == idReserva) {
							idItinerario = reservas.getId_itinerario();
						}
					}

					ArrayList<itinerarios> listaItinerarios = Modelo.db.db_itinerarios.getItinerarios(idItinerario);

					for (itinerarios itinerarios : listaItinerarios) {

						codigo_vehiculo = itinerarios.getCodigo_vehiculo();
						codVehiculoAnterior = codigo_vehiculo;
						fechaRecogida = itinerarios.getFecha_recogida();
						fechaEntrega = itinerarios.getFecha_entrega();
						GestionarReserva.idItinerarioAux = itinerarios.getId_itinerario();
					}

					ArrayList<vehiculos> listaVehiculos = Modelo.db.db_vehiculos.getVehiculos();

					for (vehiculos vehiculos : listaVehiculos) {

						if (vehiculos.getCodigo_vehiculo().equals(codigo_vehiculo)) {
							marcaAux = vehiculos.getMarca();
							modeloAux = vehiculos.getModelo();

						}

					}
					txtrDescripcion.removeAll();
					txtrDescripcion.setText(
							"\r\n \r\n Detalles de la Reserva:" + "\r\n \r\n Código Vehiculo: " + codigo_vehiculo
									+ "\r\n Marca: " + marcaAux + "\r\n Modelo: " + modeloAux + "\r\n Fecha Recogida: "
									+ fechaRecogida.toString() + "\r\n Fecha Entrega: " + fechaEntrega.toString());

				}
			}
		});

		comboId.setBounds(20, 203, 135, 21);
		panel.add(comboId);

		// ANTES DE FILTRAR

		// DESPUES DE FILTRAR

		// LABELS

		JLabel lblMarca = new JLabel("ID reserva:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblMarca.setBounds(20, 179, 135, 14);
		panel.add(lblMarca);

		JButton btnCambiarFechas = new JButton("Cambiar Fechas");
		btnCambiarFechas.setBackground(Color.WHITE);
		btnCambiarFechas.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario selecciona esta opción. Podrá modificar las fechas de
			 *          la reserva, llevandole a la ventana de seleccion de fechas.
			 */
			public void actionPerformed(ActionEvent e) {
				if (comboId.getSelectedItem().toString() == "0") {
					JOptionPane.showMessageDialog(null, "knnijn", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					RentacarApp.HacerReserva.reservaHacer();
					frame.dispose();
				}
			}
		});
		btnCambiarFechas.setFont(new Font("DialogInput", Font.BOLD, 9));
		btnCambiarFechas.setBounds(20, 250, 135, 21);
		panel.add(btnCambiarFechas);

		JButton btnCambiarVehiculos = new JButton("Cambiar Vehículo");
		btnCambiarVehiculos.setBackground(Color.WHITE);
		btnCambiarVehiculos.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario selecciona esta opción, modificará el vehículo
			 *          escogido, llevandole a las ventanas de selección de vehículo.
			 */
			public void actionPerformed(ActionEvent e) {
				if (comboId.getSelectedItem().toString() == "0") {
					JOptionPane.showMessageDialog(null, "Debe de seleccionar una reserva primero!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					HacerReserva2.reservaHacer2();
					frame.dispose();
				}
			}
		});
		btnCambiarVehiculos.setFont(new Font("DialogInput", Font.BOLD, 9));
		btnCambiarVehiculos.setBounds(20, 283, 135, 21);
		panel.add(btnCambiarVehiculos);

		JButton btnCancelar = new JButton("Cancelar Reserva");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			/**
			 * @param e El usuario al seleccionar la opción de cancelar, se le borrará la
			 *          reserva. Así, actualizando la BBDD.
			 *
			 */
			public void actionPerformed(ActionEvent e) {

				if (comboId.getSelectedItem().toString() == "0") {
					JOptionPane.showMessageDialog(null, "Debe de seleccionar una reserva primero!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Modelo.db.db_reservas.deleteReserva();
					Modelo.db.db_itinerarios.deleteItinerario();

					Modelo.db.db_vehiculos.setDisponible();
					JOptionPane.showMessageDialog(null, "Reserva cancelada con exito!", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					GestionarReserva.reservaGestionar();
				}
			}
		});
		btnCancelar.setFont(new Font("DialogInput", Font.BOLD, 9));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(20, 314, 135, 21);
		panel.add(btnCancelar);

		frame.setUndecorated(true);
		frame.setVisible(true);
	}
}
