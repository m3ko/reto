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

import Modelo.cliente;
import Modelo.empresas;
import Modelo.personas;
import Modelo.vehiculos;
import RentacarApp.Login;
import javax.swing.JComboBox;

public class GestionVehiculos {
	private static JTable table;
	private static JTextField textCod_vehiculo;
	private static JTextField textTipo;
	private static JTextField textEstado;
	private static JTextField textPrecio;
	private static JTextField textAño;
	private static JTextField textModelo;
	private static JTextField textMarca;
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
	 * @author niko El usuario podra modificar, añadir o eliminar lineas de la tabla
	 *         Vehiculos.
	 */

	public static void VehiculosGestionar() {

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

		modelo.addColumn("codigo_vehiculo");
		modelo.addColumn("marca");
		modelo.addColumn("modelo");
		modelo.addColumn("tipo");
		modelo.addColumn("año_fabricación");
		modelo.addColumn("precio_alquiler");
		modelo.addColumn("estado");
		modelo.addColumn("cif_empresa");

		ArrayList<vehiculos> listaVehiculos = Modelo.db.db_vehiculos.getVehiculos();

		for (vehiculos vehiculos : listaVehiculos) {

			modelo.addRow(new Object[] { vehiculos.getCodigo_vehiculo(), vehiculos.getMarca(), vehiculos.getModelo(),
					vehiculos.getTipo(), vehiculos.getAño_fabricación(), vehiculos.getPrecio_alquiler(),
					vehiculos.getEstado(), vehiculos.getCif_empresa() });

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
			 * @param e Si el usuario presiona el botón eliminar, se eliminará la fila
			 *          seleccionada, también se reflejará en la BBDD.
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
			 * @param e Si el usuario presiona el botón Guardar, se guardará en Un ArrayList
			 *          los datos de la tabla, pasandolos a la clase updateTablaVehiculos
			 *          del fichero db_vehiculos.
			 */
			public void actionPerformed(ActionEvent e) {

				ArrayList<vehiculos> guardarVehiculos = new ArrayList<>();

				for (int i = 0; i < modelo.getRowCount(); i++) {

					vehiculos vehiculo = new vehiculos(null, null, null, null, 0, 0, null, null);

					for (int z = 0; z < modelo.getColumnCount(); z++) {

						System.out.println(modelo.getValueAt(i, z));
						if (z == 0) {
							vehiculo.setCodigo_vehiculo(modelo.getValueAt(i, z).toString());
						} else if (z == 1) {
							vehiculo.setMarca(modelo.getValueAt(i, z).toString());
						} else if (z == 2) {
							vehiculo.setModelo(modelo.getValueAt(i, z).toString());
						} else if (z == 3) {
							vehiculo.setTipo(modelo.getValueAt(i, z).toString());
						} else if (z == 4) {
							vehiculo.setAño_fabricación(Integer.parseInt(modelo.getValueAt(i, z).toString()));
						} else if (z == 5) {
							vehiculo.setPrecio_alquiler(Integer.parseInt(modelo.getValueAt(i, z).toString()));
						} else if (z == 6) {
							vehiculo.setEstado(modelo.getValueAt(i, z).toString());
						} else if (z == 7) {
							vehiculo.setCif_empresa(modelo.getValueAt(i, z).toString());
						}
					}
					guardarVehiculos.add(vehiculo);
				}
				Modelo.db.db_vehiculos.updateTablaVehiculos(guardarVehiculos);
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
			 * @param e Si el usuario presiona el botón volver, volvera a la anterior
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

		textCod_vehiculo = new JTextField();
		textCod_vehiculo.setText("");
		textCod_vehiculo.setBackground(Color.LIGHT_GRAY);
		textCod_vehiculo.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textCod_vehiculo.setBounds(10, 411, 59, 24);
		panel.add(textCod_vehiculo);
		textCod_vehiculo.setColumns(10);

		textTipo = new JTextField();
		textTipo.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textTipo.setBackground(Color.LIGHT_GRAY);
		textTipo.setBounds(184, 411, 59, 24);
		panel.add(textTipo);
		textTipo.setColumns(10);

		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setText("Disponible");
		textEstado.setBackground(Color.LIGHT_GRAY);
		textEstado.setBounds(355, 411, 59, 24);
		panel.add(textEstado);
		textEstado.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setBackground(Color.LIGHT_GRAY);
		textPrecio.setFont(new Font("Ebrima", Font.PLAIN, 10));
		textPrecio.setBounds(297, 411, 59, 24);
		panel.add(textPrecio);
		textPrecio.setColumns(10);

		textAño = new JTextField();
		textAño.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textAño.setBackground(Color.LIGHT_GRAY);
		textAño.setBounds(241, 411, 59, 24);
		panel.add(textAño);
		textAño.setColumns(10);

		textModelo = new JTextField();
		textModelo.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textModelo.setBackground(Color.LIGHT_GRAY);
		textModelo.setBounds(126, 411, 59, 24);
		panel.add(textModelo);
		textModelo.setColumns(10);

		textMarca = new JTextField();
		textMarca.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textMarca.setBackground(Color.LIGHT_GRAY);
		textMarca.setBounds(68, 411, 59, 24);
		panel.add(textMarca);
		textMarca.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setText("cod_vehiculo:");
		txtCodigo.setBounds(499, 251, 91, 23);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario pulsa el botón buscar. se aplicara el filtro a la
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
					for (vehiculos vehiculos : listaVehiculos) {

						modelo.addRow(new Object[] { vehiculos.getCodigo_vehiculo(), vehiculos.getMarca(),
								vehiculos.getModelo(), vehiculos.getTipo(), vehiculos.getAño_fabricación(),
								vehiculos.getPrecio_alquiler(), vehiculos.getEstado(), vehiculos.getCif_empresa() });

					}
				} else {

					for (vehiculos vehiculos : listaVehiculos) {
						if (vehiculos.getCodigo_vehiculo().equals(filtro)) {
							modelo.addRow(new Object[] { vehiculos.getCodigo_vehiculo(), vehiculos.getMarca(),
									vehiculos.getModelo(), vehiculos.getTipo(), vehiculos.getAño_fabricación(),
									vehiculos.getPrecio_alquiler(), vehiculos.getEstado(),
									vehiculos.getCif_empresa() });

							encontrado = true;
						}
					}

					if (encontrado = false) {
						JOptionPane.showMessageDialog(null,
								"No se ha encontrado un codigo_vehiculo coincidente en la base de datos!", "Warning",
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
		comboCIF.setBounds(411, 412, 78, 23);

		ArrayList<empresas> listaEmpresas = Modelo.db.db_empresas.getEmpresas();
		for (empresas empresas : listaEmpresas) {
			comboCIF.addItem(empresas.getCif());

		}
		comboCIF.setSelectedItem(0);

		panel.add(comboCIF);

		btnAñadir.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton añadir, se añadira una nueva fila a
			 *          la tabla con los datos epsecificados.
			 */
			public void actionPerformed(ActionEvent e) {
				boolean editar = false;

				String marca = textMarca.getText();
				String modeloAux = textModelo.getText();
				String año = textAño.getText();
				String precio = textPrecio.getText();
				String estado = textEstado.getText();
				String tipo = textTipo.getText();
				String cod_vehiculo = textCod_vehiculo.getText();
				String cif_empresa = comboCIF.getSelectedItem().toString();

				modelo.addRow(new Object[] { cod_vehiculo, marca, modelo, tipo, año, precio, estado, cif_empresa });

				boolean exito = Modelo.db.db_vehiculos.insertVehiculo(cod_vehiculo, marca, modeloAux, tipo, año, precio,
						estado, cif_empresa);

				if (exito == true) {
					GestionVehiculos.VehiculosGestionar();

				} else {

					System.err.println("Ha fallado la insercion a la base de datos");
				}

			}
		});

		cerrarSesion.addActionListener(new ActionListener() {

			/**
			 * @param e Si el usuario presiona el botón cerrarSesion, se le cerrará la
			 *          sesión y volverá a la ventana de Login
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
