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
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cerrar.setIcon(new ImageIcon(".\\src\\cerrar.png"));
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
		JLabel logo = new JLabel(logoIcon);
		logo.setBounds(0, 36, 430, 107);
		logo.setVerticalAlignment(SwingConstants.TOP);
		panel.add(logo);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		// NEXT

		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(Color.ORANGE);
		btnNext.setBackground(Color.GRAY);
		btnNext.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				RentacarApp.ConfirmaReserva.ReservaConfirmar();
			}
		});

		btnNext.setBounds(325, 409, 80, 21);
		panel.add(btnNext);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setBackground(Color.GRAY);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				RentacarApp.HacerReserva2.reservaHacer2();

			}
		});
		btnVolver.setBounds(235, 409, 80, 21);
		panel.add(btnVolver);

		// FILTROS en listas

		JComboBox comboId = new JComboBox();
		comboId.setToolTipText("Seleccione");
		comboId.addItem(" ");
		ArrayList<reservas> listaReservas = Modelo.db.db_reservas.getReservas();
		for (reservas reservas : listaReservas) {
			comboId.addItem(reservas.getId_reserva());
		}
		
		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setForeground(Color.ORANGE);
		txtrDescripcion.setBackground(Color.GRAY);
		txtrDescripcion.setFont(new Font("DialogInput", Font.BOLD, 13));
		txtrDescripcion.setEditable(false);
		txtrDescripcion.setBounds(179, 179, 226, 212);
		panel.add(txtrDescripcion);

		
		boolean defaultColor = true;
		
		
		comboId.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String aux = comboId.getSelectedItem().toString();
				int idReserva = Integer.parseInt(aux);
				int idItinerario = 0;
				Date fechaRecogida = null;
				Date fechaEntrega = null;
				
				String codigo_vehiculo ="";
				String marcaAux="";
				String modeloAux="";
				
				
				for (reservas reservas : listaReservas) {
					if (reservas.getId_reserva()==idReserva) {
						idItinerario = reservas.getId_itinerario();
					}
				}
				
				ArrayList<itinerarios>listaItinerarios=Modelo.db.db_itinerarios.getItinerarios(idItinerario);
				
				for (itinerarios itinerarios : listaItinerarios) {
					
					codigo_vehiculo=itinerarios.getCodigo_vehiculo();
					fechaRecogida=itinerarios.getFecha_recogida();
					fechaEntrega=itinerarios.getFecha_entrega();
				}
				
				ArrayList<vehiculos>listaVehiculos=Modelo.db.db_vehiculos.getVehiculos();
				
				for (vehiculos vehiculos : listaVehiculos) {
					
					if (vehiculos.getCodigo_vehiculo().equals(codigo_vehiculo)) {
						marcaAux=vehiculos.getMarca();
						modeloAux=vehiculos.getModelo();
						
						
					}
					
				}
				txtrDescripcion.removeAll();
				txtrDescripcion.setText("\r\n \r\n Detalles de la Reserva:"
				+"\r\n \r\n Código Vehiculo: "+codigo_vehiculo
				+"\r\n Marca: "+marcaAux
				+"\r\n Modelo: "+modeloAux
				+"\r\n Fecha Recogida: " +fechaRecogida.toString()
				+"\r\n Fecha Entrega: "+fechaEntrega.toString());
				

			}
		});
		

		comboId.setBounds(48, 220, 80, 21);
		panel.add(comboId);

		
		// ANTES DE FILTRAR

		// DESPUES DE FILTRAR

		// LABELS

		JLabel lblMarca = new JLabel("ID reserva:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblMarca.setBounds(10, 196, 159, 14);
		panel.add(lblMarca);

		JButton btnNewButton = new JButton("Cambiar Fechas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("DialogInput", Font.BOLD, 8));
		btnNewButton.setBounds(20, 251, 135, 21);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cambiar Vehículo");
		btnNewButton_1.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnNewButton_1.setBounds(20, 284, 135, 21);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancelar Reserva");
		btnNewButton_2.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(20, 315, 135, 21);
		panel.add(btnNewButton_2);

		frame.setUndecorated(true);
		frame.setVisible(true);
	}
}
