package RentacarAppTrbj;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modelo.empresas;
import Modelo.itinerarios;
import Modelo.personas;
import Modelo.reservas;
import Modelo.vehiculos;
import RentacarApp.Login;
import javax.swing.JComboBox;

public class GestionarReservas {
	private static JTable table;
	private static JTextField txtIdR;
	private static JTextField textIdR;

	/**
	 * @wbp.parser.entryPoint
	 * @author niko El usuario podra modificar, añadir o eliminar lineas de la tabla
	 *         Reservas.
	 */
	public static void ReservasGestionar() {

		// TODO Auto-generated method stub

		JFrame frame = new JFrame();

		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);

		ImageIcon logoIcon = new ImageIcon("src/logo100.gif");
		JLabel logo = new JLabel(new ImageIcon("C:\\Users\\1AW3-11\\eclipse-workspace\\rentacar\\src\\logo100.gif"));
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, 24);
		logo.setSize(599, 100);

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);
		panel.add(logo);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		boolean defaultColor = true;

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(Color.ORANGE);
		menuBar.setBounds(503, 0, 96, 26);
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
			 * Si el usuario presiona el boton cerrar, se cierra el programa.
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cerrar.setIcon(new ImageIcon("C:\\Users\\1AW3-11\\Desktop\\rentacar\\src\\cerrar.png"));
		cerrar.setForeground(Color.RED);
		cerrar.setFont(new Font("Corbel", Font.BOLD, 10));
		cerrar.setBackground(Color.MAGENTA);

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("ID_Reserva");
		modelo.addColumn("DNI");
		modelo.addColumn("CIF_empresa");
		modelo.addColumn("Codigo_Vehículo");
		modelo.addColumn("ID_itinerario");

		ArrayList<reservas> listaReservas = Modelo.db.db_reservas.getAllReservas();

		for (reservas reservas : listaReservas) {

			modelo.addRow(new Object[] { reservas.getId_reserva(), reservas.getDni_persona(), reservas.getCif_empresa(),
					reservas.getCod_vehiculo(), reservas.getId_itinerario() });

		}

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		scrollPane.setBounds(10, 134, 479, 279);
		JTable tabla = new JTable();
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla.setForeground(Color.ORANGE);
		tabla.setFont(new Font("DialogInput", Font.BOLD, 10));
		tabla.setBackground(Color.GRAY);
		tabla.setModel(modelo);

//		JTable tabla = new JTable(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column", "New column", "New column"
//			}
//		));
		scrollPane.setViewportView(tabla);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton guardar, los datos de la tabla se
			 *          alojan en un ArryList y los pasa a updateTablaItinerarios() en la
			 *          clase db_itinerarios
			 */
			public void actionPerformed(ActionEvent e) {

				ArrayList<reservas> guardarReservas = new ArrayList<>();

				for (int i = 0; i < modelo.getRowCount(); i++) {

					reservas reserva = new reservas(0, null, null, null, 0);

					for (int z = 0; z < modelo.getColumnCount(); z++) {

						System.out.println(modelo.getValueAt(i, z));
						if (z == 0) {
							reserva.setId_reserva(Integer.parseInt(modelo.getValueAt(i, z).toString()));
						} else if (z == 1) {
							reserva.setDni_persona(modelo.getValueAt(i, z).toString());
						} else if (z == 2) {
							reserva.setCod_vehiculo(modelo.getValueAt(i, z).toString());
						} else if (z == 3) {
							reserva.setCif_empresa(modelo.getValueAt(i, z).toString());
						} else if (z == 4) {
							reserva.setId_itinerario(Integer.parseInt(modelo.getValueAt(i, z).toString()));
						}
					}
					guardarReservas.add(reserva);
				}
				Modelo.db.db_reservas.updateTablaReservas(guardarReservas);

			}
		});
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setBackground(Color.GREEN);
		btnGuardar.setFont(new Font("DialogInput", Font.BOLD, 8));
		btnGuardar.setBounds(499, 134, 91, 25);
		panel.add(btnGuardar);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				AppTrabajador.SesionIniciadaTrabajador();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 9));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(499, 295, 91, 26);
		panel.add(btnVolver);

		JButton btnAñadir = new JButton("AÑADIR");

		btnAñadir.setForeground(Color.BLACK);
		btnAñadir.setFont(new Font("DialogInput", Font.BOLD, 8));
		btnAñadir.setBackground(Color.LIGHT_GRAY);
		btnAñadir.setBounds(499, 411, 91, 24);
		panel.add(btnAñadir);

		txtIdR = new JTextField();
		txtIdR.setText("Id Reserva:");
		txtIdR.setBounds(499, 239, 91, 23);
		panel.add(txtIdR);
		txtIdR.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			/**
			 * @param e
			 *
			 *          Si el usuario presiona el botón buscar, se añadirá el filtro a la
			 *          tabla.
			 */
			public void actionPerformed(ActionEvent e) {
				int aux = modelo.getRowCount();

				do {
					modelo.removeRow(0);
				} while (0 != modelo.getRowCount());

				String filtro = txtIdR.getText();

				boolean encontrado = false;

				if (filtro.equals("all")) {
					for (reservas reservas : listaReservas) {
						modelo.addRow(new Object[] { reservas.getId_reserva(), reservas.getDni_persona(),
								reservas.getCif_empresa(), reservas.getCod_vehiculo(), reservas.getId_itinerario() });

					}
				} else {

					for (reservas reservas : listaReservas) {

						if (reservas.getId_reserva() == Integer.parseInt(filtro)) {

							modelo.addRow(new Object[] { reservas.getId_reserva(), reservas.getDni_persona(),
									reservas.getCif_empresa(), reservas.getCod_vehiculo(),
									reservas.getId_itinerario() });
							encontrado = true;
						}
					}
					if (encontrado = false) {
						JOptionPane.showMessageDialog(null,
								"No se ha encontrado un ID coincidente en la base de datos!", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}

				}
			}
		});
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("DialogInput", Font.BOLD, 9));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(499, 264, 91, 26);
		panel.add(btnBuscar);

		textIdR = new JTextField();
		textIdR.setText("AUTO");
		textIdR.setFont(new Font("DialogInput", Font.BOLD, 10));
		textIdR.setColumns(10);
		textIdR.setBackground(Color.RED);
		textIdR.setBounds(10, 411, 96, 21);
		panel.add(textIdR);

		JComboBox comboDNI = new JComboBox();
		comboDNI.setBounds(106, 412, 95, 21);
		panel.add(comboDNI);

		ArrayList<personas> listaPersonas = Modelo.db.db_personas.getPersonas();
		for (personas personas : listaPersonas) {

			comboDNI.addItem(personas.getDni());

		}
		comboDNI.setSelectedIndex(0);

		JComboBox comboCIF = new JComboBox();
		comboCIF.setBounds(200, 412, 95, 21);
		panel.add(comboCIF);

		ArrayList<empresas> listaEmpresasAux = Modelo.db.db_empresas.getEmpresas();
		for (empresas empresas : listaEmpresasAux) {
			comboCIF.addItem(empresas.getCif());
		}
		comboCIF.setSelectedIndex(0);

		JComboBox comboCod = new JComboBox();
		comboCod.setBounds(295, 412, 102, 21);
		panel.add(comboCod);
		ArrayList<vehiculos> listaVehiculos = Modelo.db.db_vehiculos.getVehiculos();
		for (vehiculos vehiculos : listaVehiculos) {

			comboCod.addItem(vehiculos.getCodigo_vehiculo());

		}
		comboCod.setSelectedIndex(0);

		JComboBox comboIt = new JComboBox();
		comboIt.setBounds(394, 412, 95, 21);
		panel.add(comboIt);
		ArrayList<itinerarios> listaItinerarios = Modelo.db.db_itinerarios.getAllItinerarios();
		for (itinerarios itinerarios : listaItinerarios) {

			comboIt.addItem(itinerarios.getId_itinerario());

		}
		comboIt.setSelectedIndex(0);

		btnAñadir.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton añadir, se añadirá a la tabla los
			 *          datos especificados por el usuario
			 */
			public void actionPerformed(ActionEvent e) {
				boolean editar = false;

				String dni = comboDNI.getSelectedItem().toString();
				String cif = comboCIF.getSelectedItem().toString();
				String cod = comboCod.getSelectedItem().toString();
				String it = comboIt.getSelectedItem().toString();

				boolean exito = Modelo.db.db_reservas.insertReserva(dni, cif, cod, it);
				if (exito == true) {
					GestionarReservas.ReservasGestionar();

				} else {

					System.err.println("Ha fallado la insercion a la base de datos");
				}

			}
		});

		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.dispose();
				Login.main(null);

			}
		});
		frame.setUndecorated(true);
		frame.setVisible(true);

	}

}
