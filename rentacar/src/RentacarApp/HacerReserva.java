package RentacarApp;

import javax.swing.JFrame;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Externalizable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

import Modelo.vehiculos;

public class HacerReserva {

	public static Object date1aux;
	public static Object date2aux;
	public static Object hora1aux;
	public static Object hora2aux;
	public static Object min1aux;
	public static Object min2aux;

	public static Object diasQuedan;

	/**
	 * @wbp.parser.entryPoint
	 * @author Niko El usuario Seleccionará las fechas y horas de recogida y entrega
	 *         del vehículo.
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
			/**
			 * Si el usuario presiona el boton cerrar, se cierra el programa.
			 * 
			 * @param e
			 */
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

		// HORA Y MIN

		JComboBox hora2 = new JComboBox();
		hora2.setFont(new Font("DialogInput", Font.BOLD, 10));
		hora2.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		hora2.setSelectedIndex(0);
		hora2.setBounds(330, 205, 39, 21);
		panel.add(hora2);
		hora2aux = 00;
		hora2.addActionListener(new ActionListener() {

			/**
			 * @param e El usuario al escoger la hora, se guardará la hora seleccionada en
			 *          un objeto (hora2Aux)
			 */
			public void actionPerformed(ActionEvent e) {

				String h2 = hora2.getSelectedItem().toString();
				int horaEntrega = Integer.parseInt(h2);

				HacerReserva.hora2aux = h2;

			}
		});

		JComboBox min2 = new JComboBox();
		min2.setBackground(Color.WHITE);
		min2.setForeground(Color.MAGENTA);
		min2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		min2.setSelectedIndex(0);
		min2.setFont(new Font("DialogInput", Font.BOLD, 10));
		min2.setBounds(379, 205, 39, 21);
		panel.add(min2);
		min2aux = 00;
		min2.addActionListener(new ActionListener() {
			/**
			 * @param e El usuario al escoger el minuto, se guardará el minuto seleccionada
			 *          en una objeto (min2Aux)
			 */
			public void actionPerformed(ActionEvent e) {

				String m2 = min2.getSelectedItem().toString();
				int minEntrega = Integer.parseInt(m2);

				HacerReserva.min2aux = m2;

			}
		});

		JComboBox hora1 = new JComboBox();
		hora1.setForeground(Color.BLACK);
		hora1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		hora1.setSelectedIndex(0);
		hora1.setFont(new Font("DialogInput", Font.BOLD, 10));
		hora1.setBounds(121, 205, 39, 21);
		panel.add(hora1);
		hora1aux = 00;
		hora1.addActionListener(new ActionListener() {
			/**
			 * @param e El usuario al escoger la hora, se guardará la hora seleccionada en
			 *          un objeto (hora1Aux).
			 */
			public void actionPerformed(ActionEvent e) {

				String h1 = hora1.getSelectedItem().toString();
				int horaRecogida = Integer.parseInt(h1);

				HacerReserva.hora1aux = h1;

			}
		});

		JComboBox min1 = new JComboBox();
		min1.setForeground(Color.MAGENTA);
		min1.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		min1.setSelectedIndex(0);
		min1.setFont(new Font("DialogInput", Font.BOLD, 10));
		min1.setBounds(170, 205, 39, 21);
		panel.add(min1);
		min1aux = 00;
		min1.addActionListener(new ActionListener() {
			/**
			 * @param e El usuario al escoger el minuto, se guardará la hora seleccionada en
			 *          una Objeto (min1Aux)
			 */
			public void actionPerformed(ActionEvent e) {

				String m1 = min1.getSelectedItem().toString();
				int minRecogida = Integer.parseInt(m1);

				HacerReserva.min1aux = m1;

			}
		});

		SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");

		Date todayDate = new Date();

		String fechaActual = ff.format(todayDate);
		date1aux = fechaActual;
		date2aux = fechaActual;

		// RECOGER DATOS FECHAS

		btnNext.addActionListener(new ActionListener() {
			/**
			 * @param e El usuario al querer avanzar, se verificará si las fechas y horas
			 *          son validas. Es decir: Si la fecha de entrega es anterior a la de
			 *          recogida, tendrá que corregirlo. Si alguna de las fechas y horas
			 *          seleccionadas es anterior a la del momento, tendrá que corregirlo Si
			 *          está todo bien, se guardaran las fechas en objetos (date1aux &
			 *          date2aux).
			 */
			public void actionPerformed(ActionEvent e) {

				if (calendarRecogida != null && calendarEntrega != null) {

					String date1 = ff.format(calendarRecogida.getDate());
					String date2 = ff.format(calendarEntrega.getDate());

					HacerReserva.date1aux = date1;
					HacerReserva.date2aux = date2;

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

//CALCULOS DE LOS DIAS RESTANTES
					long mili0 = System.currentTimeMillis();
					long mili1 = fecha1.getTime();
					long mili2 = fecha2.getTime();
					long mili3 = mili2 - mili1;

					long diasRestantes = (mili3 / 3600000) / 24;

					HacerReserva.diasQuedan = diasRestantes;

					System.out.println(diasRestantes + " dias quedan");

					if (mili1 < mili0 || mili2 < mili0) {
						JOptionPane.showMessageDialog(null,
								"Las fechas y horas elegidas no pueden ser anteriores a la actual!", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else if (mili1 > mili2) {
						JOptionPane.showMessageDialog(null,
								"La fecha de Entrega no puede ser anterior a la de la Recogida!", "Warning",
								JOptionPane.WARNING_MESSAGE);

					} else if (mili1 == mili2) {
						JOptionPane.showMessageDialog(null,
								"Las fechas y hora de Recogida y Entrega no pueden ser iguales!", "Warning",
								JOptionPane.WARNING_MESSAGE);

					} else if (App.reservaGestion == 1) {

						Modelo.db.db_itinerarios.updateFechas();
						JOptionPane.showMessageDialog(null,
								"Las fechas y horas se han actualizado con exito! /r/n AVISO: Se te va a cobrar o devolver la diferencia de dias.",
								"Warning", JOptionPane.WARNING_MESSAGE);
						RentacarApp.GestionarReserva.reservaGestionar();
						frame.dispose();

					} else {
						HacerReserva2.reservaHacer2();
						frame.dispose();
					}

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

		// ENVIAR DATOS A LLAMADA

		// BOTON VOLVER

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setBackground(Color.GRAY);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * @param e Al seleccionar el botón volver, volverá a la ventana anterior.
			 */
			public void actionPerformed(ActionEvent e) {
				if (RentacarApp.App.reservaGestion == 1) {
					RentacarApp.GestionarReserva.reservaGestionar();
				} else {
					RentacarApp.App.SesionIniciada();
					frame.dispose();
				}
			}
		});
		btnVolver.setBounds(121, 421, 80, 21);
		panel.add(btnVolver);
		boolean defaultColor = true;

		frame.setUndecorated(true);
		frame.setVisible(true);
	}

}