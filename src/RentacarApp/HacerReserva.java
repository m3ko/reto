package RentacarApp;

import javax.swing.JFrame;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.SwingConstants;



import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;

import java.time.LocalDate;
import java.util.Date;

import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;


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
				progressBar.setForeground(Color.MAGENTA);
				progressBar.setValue(25);
				panel.add(progressBar);
		
		JCalendar calendarRecogida = new JCalendar();
		calendarRecogida.setBorder(null);
		calendarRecogida.getDayChooser().getDayPanel().setForeground(Color.MAGENTA);
		calendarRecogida.getDayChooser().getDayPanel().setBorder(null);
		calendarRecogida.getDayChooser().setWeekOfYearVisible(false);
		calendarRecogida.getDayChooser().setWeekdayForeground(Color.BLACK);
		calendarRecogida.getDayChooser().setSundayForeground(Color.MAGENTA);
		calendarRecogida.getYearChooser().getSpinner().setBackground(Color.WHITE);
		calendarRecogida.getYearChooser().getSpinner().setForeground(Color.MAGENTA);
		calendarRecogida.getMonthChooser().getComboBox().setForeground(Color.MAGENTA);
		calendarRecogida.getMonthChooser().getComboBox().setBackground(Color.WHITE);
		calendarRecogida.getDayChooser().setBackground(Color.WHITE);
		calendarRecogida.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calendarRecogida.setDecorationBackgroundColor(Color.WHITE);
		calendarRecogida.setBounds(10, 236, 199, 175);
		panel.add(calendarRecogida);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JCalendar calendarEntrega = new JCalendar();
		calendarEntrega.setBorder(null);
		calendarEntrega.getDayChooser().getDayPanel().setBorder(null);
		calendarEntrega.getDayChooser().setWeekOfYearVisible(false);
		calendarEntrega.getDayChooser().setAlwaysFireDayProperty(true);
		calendarEntrega.getDayChooser().setWeekdayForeground(Color.BLACK);
		calendarEntrega.getDayChooser().setSundayForeground(Color.MAGENTA);
		calendarEntrega.getYearChooser().getSpinner().setForeground(Color.MAGENTA);
		calendarEntrega.getMonthChooser().getComboBox().setForeground(Color.MAGENTA);
		calendarEntrega.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calendarEntrega.getDayChooser().getDayPanel().setForeground(Color.MAGENTA);
		calendarEntrega.getDayChooser().setDecorationBackgroundColor(Color.WHITE);
		calendarEntrega.getDayChooser().setBackground(Color.WHITE);
		calendarEntrega.setBounds(219, 236, 199, 175);
		panel.add(calendarEntrega);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(Color.ORANGE);
		btnNext.setBackground(Color.GRAY);
		btnNext.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (calendarRecogida!=null && calendarEntrega!=null) {
					
					SimpleDateFormat ff=new SimpleDateFormat("YYYY-MM-dd");
					
					
					
					String date1 = ff.format(calendarRecogida.getDate());
					String date2 = ff.format(calendarEntrega.getDate());
					
					System.out.println(date1);
					System.out.println(date2);
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
					
					Date fecha1 = null;
					try {

					fecha1 = (Date) formatoDelTexto.parse(date1);

					} catch (ParseException ex) {

					ex.printStackTrace();

					}
					
					Date fecha2 = null;
					try {

					fecha2 = (Date) formatoDelTexto.parse(date2);

					} catch (ParseException ex) {

					ex.printStackTrace();

					}
					long mili1 = fecha1.getTime();
					long mili2 = fecha2.getTime();
					long mili3 = mili2-mili1;
					
					long diasRestantes = (mili3/3600000)/24;
					frame.dispose();
					
					System.out.println(diasRestantes+" dias quedan");

					
					
				}
				if (calendarEntrega!=null) {
					SimpleDateFormat ff=new SimpleDateFormat("YYYY-MM-dd");
					String date2 = ff.format(calendarEntrega.getDate());
					
					System.out.println(date2);
					
					RentacarApp.HacerReserva2.reservaHacer2();
					frame.dispose();
				}
				
			}
		});
		btnNext.setBounds(229, 421, 80, 21);
		panel.add(btnNext);
		
		JLabel lblNewLabel = new JLabel("Seleccione FECHA y HORA:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNewLabel.setBounds(121, 174, 193, 21);
		panel.add(lblNewLabel);
		
		JLabel lblFechaYHora = new JLabel("RECOGIDA");
		lblFechaYHora.setForeground(Color.MAGENTA);
		lblFechaYHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaYHora.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblFechaYHora.setBounds(10, 205, 101, 21);
		panel.add(lblFechaYHora);
		
		JLabel lblEntrega = new JLabel("ENTREGA");
		lblEntrega.setForeground(Color.MAGENTA);
		lblEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrega.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblEntrega.setBounds(219, 205, 101, 21);
		panel.add(lblEntrega);
		
		JComboBox hora2 = new JComboBox();
		hora2.setFont(new Font("DialogInput", Font.BOLD, 10));
		hora2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		hora2.setBounds(330, 205, 39, 21);
		String h2 = hora2.getSelectedItem().toString();
		int horaEntrega = Integer.parseInt(h2);
		panel.add(hora2);
		
		JComboBox min2 = new JComboBox();
		min2.setBackground(Color.WHITE);
		min2.setForeground(Color.MAGENTA);
		min2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		min2.setFont(new Font("DialogInput", Font.BOLD, 10));
		min2.setBounds(379, 205, 39, 21);
		String m2 = min2.getSelectedItem().toString();
		int minEntrega = Integer.parseInt(m2);
		panel.add(min2);
		
		
		
		JComboBox hora1 = new JComboBox();
		hora1.setForeground(Color.BLACK);
		hora1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		hora1.setFont(new Font("DialogInput", Font.BOLD, 10));
		hora1.setBounds(121, 205, 39, 21);
		String h1 = hora1.getSelectedItem().toString();
		int horaRecogida = Integer.parseInt(h1);
		panel.add(hora2);
		panel.add(hora1);
		
		JComboBox min1 = new JComboBox();
		min1.setForeground(Color.MAGENTA);
		min1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		min1.setFont(new Font("DialogInput", Font.BOLD, 10));
		min1.setBounds(170, 205, 39, 21);
		String m1 = min1.getSelectedItem().toString();
		int minRecogida = Integer.parseInt(m1);
		panel.add(min2);
		panel.add(min1);
		
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
		
		
		
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setBackground(Color.GRAY);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RentacarApp.App.SesionIniciada();
				frame.dispose();
			}
		});
		btnVolver.setBounds(121, 421, 80, 21);
		panel.add(btnVolver);
		boolean defaultColor = true;
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		
		
		
	}
	public static long calcularDiasRestantes(long mili3) {
		
		long diasRestantes=0;
		diasRestantes = (mili3/3600000)/24;
		return diasRestantes;
	}
	
	public static String guardarRecogida(int horaRecogida, int minRecogida, String fecha1) {
		
		String auxRecogida = fecha1 +" "+ horaRecogida +":"+ minRecogida;
		return auxRecogida;
	}
	
	public static String guardarEntrega(int horaEntrega, int minEntrega, String fecha2) {
		
		String auxEntrega = fecha2 +" "+ horaEntrega +":"+ minEntrega;
		return auxEntrega;
	}
   
}