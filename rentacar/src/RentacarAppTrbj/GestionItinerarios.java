package RentacarAppTrbj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modelo.cliente;
import Modelo.empresas;
import Modelo.itinerarios;
import Modelo.personas;
import Modelo.vehiculos;
import RentacarApp.Login;

public class GestionItinerarios {
	private static JTable table;
	private static JTextField textId_itinerario;
	private static JTextField textFechaEntrega;
	private static JTextField textHoraEntrega;
	private static JTextField textHoraRecogida;
	private static JTextField textFechaRecogida;
	private static JTextField textCodigo;
	private static JTextField textPrecio;
	private static JTextField txtCodigo;

	public static String dniEditar;
	public static String nombreEditar;
	public static String apellidoEditar;
	public static String mailEditar;
	public static String contraseñaEditar;
	public static String telefonoEditar;
	public static String claveEditar;
	public static int lineaAux;

	/**
	 * @wbp.parser.entryPoint
	 * @author niko El usuario podrá modificar, añadir o eliminar lineas de la tabla
	 *         Itinerarios.
	 */
	public static void ItinerariosGestionar() {

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
		JLabel logo = new JLabel(new ImageIcon("src\\logo100.gif"));
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
		mnNewMenu.setSelectedIcon(new ImageIcon("src\\logoMenu.png"));
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
		cerrar.setIcon(new ImageIcon("src\\cerrar.png"));
		cerrar.setForeground(Color.RED);
		cerrar.setFont(new Font("Corbel", Font.BOLD, 10));
		cerrar.setBackground(Color.MAGENTA);

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Id_itinerario");
		modelo.addColumn("cif_empresa");
		modelo.addColumn("codigo_vehiculo");
		modelo.addColumn("fecha_entrega");
		modelo.addColumn("fecha_recogida");
		modelo.addColumn("hora_entrega");
		modelo.addColumn("hora_recogida");
		modelo.addColumn("precio_total");

		ArrayList<itinerarios> listaItinerarios = Modelo.db.db_itinerarios.getAllItinerarios();

		for (itinerarios itinerarios : listaItinerarios) {
			modelo.addRow(new Object[] { itinerarios.id_itinerario, itinerarios.cif_empresa,
					itinerarios.codigo_vehiculo, itinerarios.fecha_entrega, itinerarios.fecha_recogida,
					itinerarios.hora_entrega, itinerarios.hora_recogida, itinerarios.precio_total });
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

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("DialogInput", Font.BOLD, 7));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(Color.RED);
		btnEliminar.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton Cerrar, se cerrará el programa
			 */
			public void actionPerformed(ActionEvent e) {

				int fila = tabla.getSelectedRow();

				String codigo_vehiculo = tabla.getValueAt(fila, 0).toString();

				Modelo.db.db_vehiculos.deleteVehiculo(codigo_vehiculo);
				RentacarAppTrbj.GestionVehiculos.VehiculosGestionar();

			}
		});
		btnEliminar.setBounds(499, 169, 91, 26);
		panel.add(btnEliminar);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton guardar, los datos de la tabla se
			 *          alojan en un ArryList y los pasa a updateTablaItinerarios() en la
			 *          clase db_itinerarios
			 */
			public void actionPerformed(ActionEvent e) {

				ArrayList<itinerarios> guardarItinerarios = new ArrayList<>();

				for (int i = 0; i < modelo.getRowCount(); i++) {

					itinerarios itinerario = new itinerarios(0, null, null, null, null, null, null, 0);

					for (int z = 0; z < modelo.getColumnCount(); z++) {

						System.out.println(modelo.getValueAt(i, z));
						if (z == 0) {
							itinerario.setId_itinerario(Integer.parseInt((modelo.getValueAt(i, z).toString())));
						} else if (z == 1) {
							itinerario.setCif_empresa((modelo.getValueAt(i, z).toString()));
						} else if (z == 2) {
							itinerario.setCodigo_vehiculo((modelo.getValueAt(i, z).toString()));
						} else if (z == 3) {
							itinerario.setFecha_entrega((Date) (modelo.getValueAt(i, z)));
						} else if (z == 4) {
							itinerario.setFecha_recogida((Date) (modelo.getValueAt(i, z)));
						} else if (z == 5) {
							itinerario.setHora_entrega((Time) (modelo.getValueAt(i, z)));
						} else if (z == 6) {
							itinerario.setHora_recogida((Time) (modelo.getValueAt(i, z)));
						} else if (z == 7) {
							itinerario.setPrecio_total(Integer.parseInt((modelo.getValueAt(i, z).toString())));
						}
					}
					guardarItinerarios.add(itinerario);
				}
				Modelo.db.db_itinerarios.updateTablaItinerarios(guardarItinerarios);

			}
		});
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setBackground(Color.GREEN);
		btnGuardar.setFont(new Font("DialogInput", Font.BOLD, 8));
		btnGuardar.setBounds(499, 134, 91, 25);
		panel.add(btnGuardar);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el botón volver, volverá a la anterior
			 *          ventana.
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				AppTrabajador.SesionIniciadaTrabajador();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 9));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(499, 307, 91, 26);
		panel.add(btnVolver);

		JButton btnAñadir = new JButton("AÑADIR");

		btnAñadir.setForeground(Color.BLACK);
		btnAñadir.setFont(new Font("DialogInput", Font.BOLD, 8));
		btnAñadir.setBackground(Color.LIGHT_GRAY);
		btnAñadir.setBounds(499, 411, 91, 24);
		panel.add(btnAñadir);

		textId_itinerario = new JTextField();
		textId_itinerario.setText("");
		textId_itinerario.setBackground(Color.LIGHT_GRAY);
		textId_itinerario.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textId_itinerario.setBounds(10, 411, 59, 24);
		panel.add(textId_itinerario);
		textId_itinerario.setColumns(10);

		textFechaEntrega = new JTextField();
		textFechaEntrega.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textFechaEntrega.setBackground(Color.LIGHT_GRAY);
		textFechaEntrega.setBounds(200, 411, 59, 24);
		panel.add(textFechaEntrega);
		textFechaEntrega.setColumns(10);

		textHoraEntrega = new JTextField();
		textHoraEntrega.setBackground(Color.LIGHT_GRAY);
		textHoraEntrega.setBounds(371, 411, 59, 24);
		panel.add(textHoraEntrega);
		textHoraEntrega.setColumns(10);

		textHoraRecogida = new JTextField();
		textHoraRecogida.setBackground(Color.LIGHT_GRAY);
		textHoraRecogida.setFont(new Font("Ebrima", Font.PLAIN, 10));
		textHoraRecogida.setBounds(313, 411, 59, 24);
		panel.add(textHoraRecogida);
		textHoraRecogida.setColumns(10);

		textFechaRecogida = new JTextField();
		textFechaRecogida.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textFechaRecogida.setBackground(Color.LIGHT_GRAY);
		textFechaRecogida.setBounds(257, 411, 59, 24);
		panel.add(textFechaRecogida);
		textFechaRecogida.setColumns(10);

		textCodigo = new JTextField();
		textCodigo.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textCodigo.setBackground(Color.LIGHT_GRAY);
		textCodigo.setBounds(142, 411, 59, 24);
		panel.add(textCodigo);
		textCodigo.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textPrecio.setBackground(Color.LIGHT_GRAY);
		textPrecio.setBounds(430, 411, 59, 24);
		panel.add(textPrecio);
		textPrecio.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setText("ID:");
		txtCodigo.setBounds(499, 251, 91, 23);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

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

				String filtro = txtCodigo.getText();

				boolean encontrado = false;

				if (filtro.equals("all")) {
					for (itinerarios itinerarios : listaItinerarios) {
						modelo.addRow(new Object[] { itinerarios.id_itinerario, itinerarios.cif_empresa,
								itinerarios.codigo_vehiculo, itinerarios.fecha_entrega, itinerarios.fecha_recogida,
								itinerarios.hora_entrega, itinerarios.hora_recogida, itinerarios.precio_total });

					}
				} else {

					for (itinerarios itinerarios : listaItinerarios) {
						if (itinerarios.getId_itinerario() == Integer.parseInt(filtro)) {
							modelo.addRow(new Object[] { itinerarios.id_itinerario, itinerarios.cif_empresa,
									itinerarios.codigo_vehiculo, itinerarios.fecha_entrega, itinerarios.fecha_recogida,
									itinerarios.hora_entrega, itinerarios.hora_recogida, itinerarios.precio_total });

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
		btnBuscar.setBounds(499, 276, 91, 26);
		panel.add(btnBuscar);

		JComboBox comboCIF = new JComboBox();
		comboCIF.setBounds(66, 412, 78, 23);

		ArrayList<empresas> listaEmpresas = Modelo.db.db_empresas.getEmpresas();
		for (empresas empresas : listaEmpresas) {
			comboCIF.addItem(empresas.getCif());

		}
		comboCIF.setSelectedItem(0);

		panel.add(comboCIF);

		btnAñadir.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton añadir, se añadirá a la tabla los
			 *          datos especificados por el usuario
			 */
			public void actionPerformed(ActionEvent e) {
				boolean editar = false;

				String precio = textPrecio.getText();
				String codigo = textCodigo.getText();
				String fechaRecogida = textFechaRecogida.getText();
				String horaRecogida = textHoraRecogida.getText();
				String horaEntrega = textHoraEntrega.getText();
				String fechaEntrega = textFechaEntrega.getText();
				String id = textId_itinerario.getText();
				String cif_empresa = comboCIF.getSelectedItem().toString();

				modelo.addRow(new Object[] { id, cif_empresa, codigo, fechaEntrega, fechaRecogida, horaEntrega,
						horaRecogida, precio });

				boolean exito = Modelo.db.db_itinerarios.insertItinerario(id, cif_empresa, codigo, horaEntrega,
						fechaRecogida, horaEntrega, horaRecogida, precio);

				if (exito == true) {
					GestionItinerarios.ItinerariosGestionar();

				} else {

					System.err.println("Ha fallado la insercion a la base de datos");
				}

			}
		});

		cerrarSesion.addActionListener(new ActionListener() {

			/**
			 * @param e Si el usuario presiona el botón cerrarSesion, se le cerrará sesión y
			 *          volverá a la ventana de Login.
			 * 
			 */
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
