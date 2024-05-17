package RentacarAppTrbj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modelo.cliente;
import Modelo.personas;
import RentacarApp.Login;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class GestionClientes {
	private static JTable table;
	private static JTextField textDni;
	private static JTextField textMail;
	private static JTextField textClaveP;
	private static JTextField textNumero;
	private static JTextField textContraseña;
	private static JTextField textApellido;
	private static JTextField textNombre;
	private static JTextField txtDni;

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
	 *         Clientes.
	 */
	public static void main(String[] args) {
		new GestionClientes();
	}

	public GestionClientes() {
		ClientesGestionar();
	}

	public static void ClientesGestionar() {

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

		modelo.addColumn("dni");
		modelo.addColumn("nombre");
		modelo.addColumn("apellido");
		modelo.addColumn("mail");
		modelo.addColumn("contraseña");
		modelo.addColumn("telefono");
		modelo.addColumn("clavePrivada");

		ArrayList<personas> listaClientes = Modelo.db.db_personas.getPersonas();

		for (personas personas : listaClientes) {
			if (personas.isRol() == true) {

				modelo.addRow(new Object[] { personas.getDni(), personas.getNombre(), personas.getApellido(),
						personas.getMail(), personas.getContraseña(), personas.getTelefono(),
						personas.getClavePrivada() });

			}
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
			public void actionPerformed(ActionEvent e) {

				int fila = tabla.getSelectedRow();

				String dni = tabla.getValueAt(fila, 0).toString();

				Modelo.db.db_personas.DeleteRowPersonas(dni);
				RentacarAppTrbj.GestionClientes.ClientesGestionar();

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

				ArrayList<cliente> guardarClientes = new ArrayList<>();

//			 for(Vector<Vector> v: modelo.getDataVector()) {
//				 String dni=(String) v.get(0).get(0).toString();
//				 System.out.println(dni);
//				 guardarPersonas.add(new cliente((String)v.get(0), (String)v.get(1), (String)v.get(2), (String)v.get(3), (String)v.get(4), (String)v.get(5), false, (Integer)v.get(6)));
//				 System.out.println(v.get(6));
//			 }
//				System.out.println(guardarPersonas);

				for (int i = 0; i < modelo.getRowCount(); i++) {

					cliente cliente = new cliente(null, null, null, null, null, null, false, 0);

					for (int z = 0; z < modelo.getColumnCount(); z++) {

						System.out.println(modelo.getValueAt(i, z));
						if (z == 0) {
							cliente.setDni(modelo.getValueAt(i, z).toString());
						} else if (z == 1) {
							cliente.setNombre(modelo.getValueAt(i, z).toString());
						} else if (z == 2) {
							cliente.setApellido(modelo.getValueAt(i, z).toString());
						} else if (z == 3) {
							cliente.setMail(modelo.getValueAt(i, z).toString());
						} else if (z == 4) {
							cliente.setContraseña(modelo.getValueAt(i, z).toString());
						} else if (z == 5) {
							cliente.setTelefono(modelo.getValueAt(i, z).toString());
						} else if (z == 6) {
							cliente.setTelefono(modelo.getValueAt(i, z).toString());
						} else if (z == 7) {
							cliente.setClavePrivada(Integer.parseInt(modelo.getValueAt(i, z).toString()));
						}
					}
					guardarClientes.add(cliente);
				}
				Modelo.db.db_personas.updateTablaClientes(guardarClientes);
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
		btnVolver.setBounds(499, 307, 91, 26);
		panel.add(btnVolver);

		JButton btnAñadir = new JButton("AÑADIR");

		btnAñadir.setForeground(Color.BLACK);
		btnAñadir.setFont(new Font("DialogInput", Font.BOLD, 8));
		btnAñadir.setBackground(Color.LIGHT_GRAY);
		btnAñadir.setBounds(499, 411, 91, 24);
		panel.add(btnAñadir);

		textDni = new JTextField();
		textDni.setBackground(Color.LIGHT_GRAY);
		textDni.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textDni.setBounds(10, 412, 72, 23);
		panel.add(textDni);
		textDni.setColumns(10);

		textMail = new JTextField();
		textMail.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textMail.setBackground(Color.LIGHT_GRAY);
		textMail.setBounds(216, 412, 69, 23);
		panel.add(textMail);
		textMail.setColumns(10);

		textClaveP = new JTextField();
		textClaveP.setText("RAND");
		textClaveP.setBackground(Color.RED);
		textClaveP.setEditable(false);
		textClaveP.setBounds(420, 412, 69, 23);
		panel.add(textClaveP);
		textClaveP.setColumns(10);

		textNumero = new JTextField();
		textNumero.setBackground(Color.LIGHT_GRAY);
		textNumero.setFont(new Font("Ebrima", Font.PLAIN, 10));
		textNumero.setBounds(352, 412, 69, 23);
		panel.add(textNumero);
		textNumero.setColumns(10);

		textContraseña = new JTextField();
		textContraseña.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textContraseña.setBackground(Color.LIGHT_GRAY);
		textContraseña.setBounds(284, 412, 69, 23);
		panel.add(textContraseña);
		textContraseña.setColumns(10);

		textApellido = new JTextField();
		textApellido.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textApellido.setBackground(Color.LIGHT_GRAY);
		textApellido.setBounds(148, 412, 69, 23);
		panel.add(textApellido);
		textApellido.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("DialogInput", Font.PLAIN, 10));
		textNombre.setBackground(Color.LIGHT_GRAY);
		textNombre.setBounds(80, 412, 69, 23);
		panel.add(textNombre);
		textNombre.setColumns(10);

		txtDni = new JTextField();
		txtDni.setText("DNI:");
		txtDni.setBounds(499, 251, 91, 23);
		panel.add(txtDni);
		txtDni.setColumns(10);

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

				String filtro = txtDni.getText();

				boolean encontrado = false;

				if (filtro.equals("all")) {
					for (personas personas : listaClientes) {
						modelo.addRow(new Object[] { personas.getDni(), personas.getNombre(), personas.getApellido(),
								personas.getMail(), personas.getContraseña(), personas.getTelefono(),
								personas.getClavePrivada() });
					}
				}
				for (personas personas : listaClientes) {

					if (personas.getDni().equals(filtro)) {

						modelo.addRow(new Object[] { personas.getDni(), personas.getNombre(), personas.getApellido(),
								personas.getMail(), personas.getContraseña(), personas.getTelefono(),
								personas.getClavePrivada() });
						encontrado = true;
					}
				}
				if (encontrado = false) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado un DNI coincidente en la base de datos!",
							"Warning", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("DialogInput", Font.BOLD, 9));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(499, 276, 91, 26);
		panel.add(btnBuscar);

		btnAñadir.addActionListener(new ActionListener() {
			/**
			 * @param e Si el usuario presiona el boton añadir, se añadirá a la tabla los
			 *          datos especificados por el usuario
			 */
			public void actionPerformed(ActionEvent e) {
				boolean editar = false;

				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				String contraseña = textContraseña.getText();
				String telefono = textNumero.getText();
				String claveP = textClaveP.getText();
				String mail = textMail.getText();
				String dni = textDni.getText();

				modelo.addRow(new Object[] { dni, nombre, apellido, mail, contraseña, telefono, claveP });

				boolean exito = Modelo.db.db_personas.añadirPersona(dni, nombre, apellido, contraseña, telefono, mail);
				if (exito == true) {
					GestionClientes.ClientesGestionar();

				} else {

					System.err.println("Ha fallado la insercion a la base de datos");
				}

			}
		});

		cerrarSesion.addActionListener(new ActionListener() {

			/**
			 * @param e Si el usuario presiona el botón cerrarSesion, se le cerrará la
			 *          sesión y volverá a la página de Login.
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
