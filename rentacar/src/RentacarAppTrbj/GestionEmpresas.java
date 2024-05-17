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
import Modelo.personas;
import Modelo.vehiculos;
import RentacarApp.Login;
import javax.swing.JComboBox;

public class GestionEmpresas {

	private static JTable table;
	private static JTextField txtCif;
	private static JTextField textCIF;
	private static JTextField textNombre;
	private static JTextField textDireccion;

	/**
	 * @wbp.parser.entryPoint
	 * @author niko El usuario podra modificar, añadir o eliminar lineas de la tabla
	 *         Empresas.
	 */
	public static void EmpresasGestionar() {

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

		modelo.addColumn("cif");
		modelo.addColumn("nombre");
		modelo.addColumn("direccion");

		ArrayList<empresas> listaEmpresas = Modelo.db.db_empresas.getEmpresas();

		for (empresas empresas : listaEmpresas) {

			modelo.addRow(new Object[] { empresas.getCif(), empresas.getNombre(), empresas.getDireccion() });

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

				ArrayList<empresas> guardarEmpresas = new ArrayList<>();

				for (int i = 0; i < modelo.getRowCount(); i++) {

					empresas empresa = new empresas(null, null, null);
					for (int z = 0; z < modelo.getColumnCount(); z++) {

						System.out.println(modelo.getValueAt(i, z));
						if (z == 0) {
							empresa.setCif(modelo.getValueAt(i, z).toString());
						} else if (z == 1) {
							empresa.setNombre(modelo.getValueAt(i, z).toString());
						} else if (z == 2) {
							empresa.setDireccion(modelo.getValueAt(i, z).toString());
						}
					}
					guardarEmpresas.add(empresa);
				}
				Modelo.db.db_empresas.updateTablaEmpresas(guardarEmpresas);

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

		txtCif = new JTextField();
		txtCif.setText("CIF:");
		txtCif.setBounds(499, 239, 91, 23);
		panel.add(txtCif);
		txtCif.setColumns(10);

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

				String filtro = txtCif.getText();

				boolean encontrado = false;

				if (filtro.equals("all")) {
					for (empresas empresas : listaEmpresas) {
						modelo.addRow(
								new Object[] { empresas.getCif(), empresas.getNombre(), empresas.getDireccion() });

					}

				} else {

					for (empresas empresas : listaEmpresas) {

						if (empresas.getCif().equals(filtro)) {

							modelo.addRow(
									new Object[] { empresas.getCif(), empresas.getNombre(), empresas.getDireccion() });
							encontrado = true;
						}
					}
					if (encontrado = false) {
						JOptionPane.showMessageDialog(null,
								"No se ha encontrado un CIF coincidente en la base de datos!", "Warning",
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

		textCIF = new JTextField();
		textCIF.setBounds(10, 412, 160, 23);
		panel.add(textCIF);
		textCIF.setColumns(10);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(169, 412, 160, 23);
		panel.add(textNombre);

		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(327, 411, 160, 24);
		panel.add(textDireccion);

		btnAñadir.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton añadir, se añadirá a la tabla los
			 *          datos especificados por el usuario
			 */
			public void actionPerformed(ActionEvent e) {
				boolean editar = false;

				String nombre = textCIF.getText();
				String direccion = textDireccion.getText();
				String cif = textCIF.getText();

				modelo.addRow(new Object[] { cif, nombre, direccion });

				boolean exito = Modelo.db.db_empresas.añadirEmpresa(cif, nombre, direccion);
				if (exito == true) {
					GestionEmpresas.EmpresasGestionar();

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
