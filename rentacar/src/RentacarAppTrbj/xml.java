package RentacarAppTrbj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Modelo.itinerarios;
import RentacarApp.Login;
import javax.swing.ListSelectionModel;

public class xml {
	public static String dni;
	public static String id;

	/**
	 * @wbp.parser.entryPoint
	 * @author niko El usuario podrá importar un fichero XML y con ello, realizar
	 *         una reserva.
	 */
	public static void importarXml() {

		// TODO Auto-generated method stub

		JFrame frame = new JFrame();

		frame.setSize(430, 451);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);

		JLabel logo = new JLabel(new ImageIcon("C:\\Users\\1AW3-11\\eclipse-workspace\\rentacar\\src\\logoancho.gif"));
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setLocation(0, 25);
		logo.setSize(430, 200);

		Color color = new Color(255, 204, 40);

		panel.setBackground(color);
		panel.setLayout(null);
		panel.add(logo);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

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

		JLabel lblSeleccioneFicheroXml = new JLabel("   Seleccione fichero XML    -->");
		lblSeleccioneFicheroXml.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblSeleccioneFicheroXml.setBounds(10, 289, 304, 26);
		panel.add(lblSeleccioneFicheroXml);

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("id_itinerario");
		modelo.addColumn("dni");

		if (dni != null && id != null) {
			modelo.addRow(new Object[] { id, dni });
		}

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		scrollPane.setBounds(10, 243, 410, 36);
		JTable tabla = new JTable();
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla.setForeground(Color.ORANGE);
		tabla.setFont(new Font("DialogInput", Font.BOLD, 10));
		tabla.setBackground(Color.GRAY);
		tabla.setModel(modelo);
		scrollPane.setViewportView(tabla);

		JButton btnCargar = new JButton("CARGAR");
		btnCargar.setForeground(Color.ORANGE);
		btnCargar.addActionListener(new ActionListener() {
			/**
			 * @param e Al presiona el botón cargar, acciona la clase cargarXML().
			 */
			public void actionPerformed(ActionEvent e) {

				cargarXml();

			}
		});
		btnCargar.setBackground(Color.LIGHT_GRAY);
		btnCargar.setFont(new Font("DialogInput", Font.BOLD, 12));
		btnCargar.setBounds(299, 289, 96, 36);
		panel.add(btnCargar);

		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setForeground(Color.ORANGE);
		btnEnviar.addActionListener(new ActionListener() {
			/**
			 * @param e Al presionar el botón enviar, recoge los datos del fichero xml, vía
			 *          consultas a la BBDD recoge información necesaria, los introduce en
			 *          una variable y realiza la reserva vía una consulta a la BBDD.
			 */
			public void actionPerformed(ActionEvent e) {

				String cif = "";
				String codigo = "";
				String dni = modelo.getValueAt(0, 1).toString();
				String id = modelo.getValueAt(0, 0).toString();

				ArrayList<itinerarios> listaItinerarios = Modelo.db.db_itinerarios.getItinerarios(Integer.parseInt(id));

				for (itinerarios itinerarios : listaItinerarios) {
					cif = itinerarios.getCif_empresa();
					codigo = itinerarios.getCodigo_vehiculo();
				}

				boolean exito = Modelo.db.db_reservas.insertReserva(dni, cif, codigo, id);

				if (exito == true) {
					JOptionPane.showMessageDialog(null, "Reserva creada con exito!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					xml.importarXml();
				}
			}
		});
		btnEnviar.setFont(new Font("DialogInput", Font.BOLD, 12));
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setBounds(299, 335, 96, 36);
		panel.add(btnEnviar);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * @param e Al presionar el botón volver, volverá a la ventana anterior.
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AppTrabajador.SesionIniciadaTrabajador();
			}
		});
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 10));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(345, 415, 75, 26);
		panel.add(btnVolver);

		JLabel lblRealizarReserva = new JLabel("   Realizar reserva          -->");
		lblRealizarReserva.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblRealizarReserva.setBounds(10, 340, 304, 26);
		panel.add(lblRealizarReserva);

		cerrarSesion.addActionListener(new ActionListener() {

			/**
			 * @param e Al presiona el botón cerrar sesión, se cerrará la sesión y volverá a
			 *          la ventana Login.
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

	/**
	 * El usuario selecciona el fichero xml a leer, recoge datos y los introduce a
	 * variables y objetos.
	 */
	public static void cargarXml() {

		JFileChooser jf = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xml", "xml");
		jf.setFileFilter(filter);
		int seleccion = jf.showSaveDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = jf.getSelectedFile();
			try {

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				org.w3c.dom.Document doc = dBuilder.parse(fichero);
				String id = "";
				String dni = "";
				doc.getDocumentElement().normalize();
				NodeList nodoPeticion = doc.getElementsByTagName("peticion");

				for (int i = 0; i < nodoPeticion.getLength(); i++) {

					Node nNode = nodoPeticion.item(i);
					Element element = (Element) nNode;

					id = element.getElementsByTagName("id").item(0).getTextContent();
					dni = element.getElementsByTagName("dni").item(0).getTextContent();
					xml.dni = dni;
					xml.id = id;

				}

				xml.importarXml();

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}
}
