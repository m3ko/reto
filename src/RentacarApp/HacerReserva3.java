package RentacarApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import Modelo.vehiculos;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class HacerReserva3 {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void reservaHacer3(String carroceria, long diasRestantes) {

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

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);

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
		JLabel logo = new JLabel(logoIcon);
		logo.setBounds(0, 36, 430, 107);
		logo.setVerticalAlignment(SwingConstants.TOP);
		panel.add(logo);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 144, 430, 14);
		progressBar.setForeground(Color.MAGENTA);
		progressBar.setValue(60);
		panel.add(progressBar);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(Color.ORANGE);
		btnNext.setBackground(Color.GRAY);
		btnNext.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				RentacarApp.ConfirmaReserva.ReservaConfirmar(0, 0, null);
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

		JComboBox comboMarca = new JComboBox();
		comboMarca.setToolTipText("Seleccione");

		if (carroceria == null) {

			ArrayList<vehiculos> todasMarcas = Modelo.db.db_vehiculos.getMarcas();
			for (vehiculos vehiculos : todasMarcas) {
				comboMarca.addItem(vehiculos.getMarca());

			}
		} else if (carroceria != null) {

			ArrayList<vehiculos> todasMarcasFiltrado = Modelo.db.db_vehiculos.getMarcasFiltrado(carroceria);
			for (vehiculos vehiculos : todasMarcasFiltrado) {

				comboMarca.addItem(vehiculos.getMarca());

			}
		}

		comboMarca.setBounds(48, 220, 80, 21);
		panel.add(comboMarca);

		JComboBox comboModelo = new JComboBox();
		comboModelo.setBounds(48, 275, 80, 21);
		panel.add(comboModelo);

		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setForeground(Color.ORANGE);
		txtrDescripcion.setBackground(Color.GRAY);
		txtrDescripcion.setFont(new Font("DialogInput", Font.BOLD, 13));
		txtrDescripcion.setEditable(false);
		txtrDescripcion.setBounds(179, 179, 226, 212);
		panel.add(txtrDescripcion);

		txtrDescripcion.setText("\r\n \r\n Descripción del Vehículo:");

		JTextArea textPrecio = new JTextArea();
		textPrecio.setBounds(48, 330, 80, 22);
		panel.add(textPrecio);
		boolean defaultColor = true;
		System.out.println(diasRestantes);

		comboMarca.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				comboModelo.removeAllItems();
				textPrecio.removeAll();
				String marcaSeleccionada = comboMarca.getSelectedItem().toString();
				if (marcaSeleccionada != null) {
					long precioSeleccionado = 0;
					ArrayList<vehiculos> modeloPorMarca = Modelo.db.db_vehiculos.getModelos(marcaSeleccionada,
							carroceria);
					for (vehiculos modelos : modeloPorMarca) {
						comboModelo.addItem(modelos.getModelo());

					}
				}
				comboModelo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						textPrecio.removeAll();
						String marcaSeleccionada = comboMarca.getSelectedItem().toString();
						if (comboModelo.getSelectedItem() != null) {
							String modeloSeleccionado = comboModelo.getSelectedItem().toString();
							ArrayList<vehiculos> modeloPorMarca = Modelo.db.db_vehiculos.getModelos(marcaSeleccionada,
									carroceria);

							for (vehiculos vehiculos : modeloPorMarca) {
								if (vehiculos.getModelo().equals(modeloSeleccionado)) {
									int precio = vehiculos.getPrecio_alquiler();
									
									String aux = Integer.toString(precio);
									textPrecio.setText(aux);
									
									String codigo_vehiculo = vehiculos.getCodigo_vehiculo();
									String marca = vehiculos.getMarca();
									String modelo = vehiculos.getModelo();
									String tipo = vehiculos.getTipo();
									int año_fabricacion = vehiculos.getAño_fabricación();
									
									txtrDescripcion.removeAll();
									txtrDescripcion.setText("\r\n"+"\r\n"+" Descripción del vehiculo:\r\n"+"\r\n"+" Codigo del vehiculo: "+codigo_vehiculo +"\r\n"+" Marca: "+ marca +"\r\n"+" Modelo: "+ modelo +"\r\n"+" Tipo de Vehículo: "+ tipo +"\r\n"+" Año de Fabricación: "+ año_fabricacion);
									
								}
							}
						}

					}
				});

			}
		});

		// LABELS

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblMarca.setBounds(48, 195, 80, 14);
		panel.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblModelo.setBounds(48, 251, 80, 14);
		panel.add(lblModelo);

		JLabel lblPrecio = new JLabel("Precio/día:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblPrecio.setBounds(10, 306, 159, 14);
		panel.add(lblPrecio);

		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {

	}

	public static long calcularPrecioReal(long precioSeleccionado, long diasRestantes) {
		long precioFinal = 0;
		long aux = 0;

		precioFinal = precioSeleccionado * diasRestantes;
		return precioFinal;
	}

}
