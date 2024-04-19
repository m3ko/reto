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
import java.text.SimpleDateFormat;

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
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JRadioButtonMenuItem;

public class HacerReserva {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void reservaHacer() {

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
				progressBar.setForeground(new Color(112, 128, 144));
				progressBar.setValue(15);
				panel.add(progressBar);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 236, 199, 175);
		panel.add(calendar);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.setBounds(219, 236, 199, 175);
		panel.add(calendar_1);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (calendar!=null) {
					SimpleDateFormat ff=new SimpleDateFormat("YYYY-MM-dd");
					String date1 = ff.format(calendar.getDate());
					System.out.println(date1);
				}
				if (calendar_1!=null) {
					SimpleDateFormat ff=new SimpleDateFormat("YYYY-MM-dd");
					String date2 = ff.format(calendar_1.getDate());
					System.out.println(date2);
				}
			}
		});
		btnNext.setBounds(177, 421, 80, 21);
		panel.add(btnNext);
		
		JLabel lblNewLabel = new JLabel("Seleccione FECHA y HORA:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNewLabel.setBounds(121, 174, 193, 21);
		panel.add(lblNewLabel);
		
		JLabel lblFechaYHora = new JLabel("RECOGIDA");
		lblFechaYHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaYHora.setFont(new Font("DialogInput", Font.BOLD, 10));
		lblFechaYHora.setBounds(10, 205, 101, 21);
		panel.add(lblFechaYHora);
		
		JLabel lblEntrega = new JLabel("ENTREGA");
		lblEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrega.setFont(new Font("DialogInput", Font.BOLD, 10));
		lblEntrega.setBounds(219, 205, 101, 21);
		panel.add(lblEntrega);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("DialogInput", Font.BOLD, 10));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox.setBounds(330, 205, 39, 21);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1.setFont(new Font("DialogInput", Font.BOLD, 10));
		comboBox_1.setBounds(379, 205, 39, 21);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_2.setFont(new Font("DialogInput", Font.BOLD, 10));
		comboBox_2.setBounds(121, 205, 39, 21);
		panel.add(comboBox_2);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1.setFont(new Font("DialogInput", Font.BOLD, 10));
		comboBox_1_1.setBounds(170, 205, 39, 21);
		panel.add(comboBox_1_1);
		
		JLabel lblEntrega_1 = new JLabel(":");
		lblEntrega_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrega_1.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblEntrega_1.setBounds(153, 205, 25, 21);
		panel.add(lblEntrega_1);
		
		JLabel lblEntrega_1_1 = new JLabel(":");
		lblEntrega_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrega_1_1.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblEntrega_1_1.setBounds(362, 205, 25, 21);
		panel.add(lblEntrega_1_1);
		boolean defaultColor = true;
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		
		
		
	}
}