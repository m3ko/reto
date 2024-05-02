package RentacarApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

public class HacerReserva2 {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void reservaHacer2() {

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
		mnNewMenu.setSelectedIcon(new ImageIcon(".\\src\\logoMenu.png"));
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
				cerrar.setIcon(new ImageIcon(".\\src\\cerrar.png"));
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
				progressBar.setValue(35);
				panel.add(progressBar);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(Color.ORANGE);
		btnNext.setBackground(Color.GRAY);
		btnNext.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					RentacarApp.HacerReserva3.reservaHacer3(null, 0);
					frame.dispose();
			
				}
			}
		);
		btnNext.setBounds(291, 369, 80, 21);
		panel.add(btnNext);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.ORANGE);
		btnVolver.setBackground(Color.GRAY);
		btnVolver.setFont(new Font("DialogInput", Font.BOLD, 11));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RentacarApp.HacerReserva.reservaHacer();
				frame.dispose();
			}
		});
		btnVolver.setBounds(291, 400, 80, 21);
		panel.add(btnVolver);
		
		String carroceria = null;
		
		JButton compactButton = new JButton("COMPACTO");
		compactButton.setIcon(new ImageIcon(".\\src\\compacto (1).jpg"));
		compactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "compacto";
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				frame.dispose();
			}
		});
		compactButton.setBounds(30, 203, 112, 57);
		panel.add(compactButton);
		
		JButton coupeButton = new JButton("COUPÉ");
		coupeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "coupe";
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				frame.dispose();
			}
		});
		coupeButton.setIcon(new ImageIcon(".\\src\\coupe (1).jpg"));
		coupeButton.setBounds(152, 203, 112, 57);
		panel.add(coupeButton);
		
		JButton sedanButton = new JButton("SEDÁN");
		sedanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "sedan";
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				frame.dispose();
			}
		});
		sedanButton.setIcon(new ImageIcon(".\\src\\sedan1 (1).jpg"));
		sedanButton.setBounds(274, 203, 112, 57);
		panel.add(sedanButton);
		
		JButton hibridoButton = new JButton("HÍBRIDO");
		hibridoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "hibrido";
				frame.dispose();
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				
			}
		});
		hibridoButton.setIcon(new ImageIcon(".\\src\\hibrido (1).jpeg"));
		hibridoButton.setBounds(152, 286, 112, 57);
		panel.add(hibridoButton);
		
		JButton deportivoButton = new JButton("DEPORTIVO");
		deportivoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "deportivo";
				frame.dispose();
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				
			}
		});
		deportivoButton.setIcon(new ImageIcon(".\\src\\deportivo (1).jpg"));
		deportivoButton.setBounds(30, 286, 112, 57);
		panel.add(deportivoButton);
		
		JButton suvButton = new JButton("SUV");
		suvButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "suv";
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				frame.dispose();
			}
		});
		suvButton.setIcon(new ImageIcon(".\\src\\suv (1).jpeg"));
		suvButton.setBounds(274, 286, 112, 57);
		panel.add(suvButton);
		
		JButton camionetaButton = new JButton("CAMIONETA");
		camionetaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "camioneta";
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				frame.dispose();
			}
		});
		camionetaButton.setIcon(new ImageIcon(".\\src\\camioneta (1).png"));
		camionetaButton.setBounds(30, 369, 112, 57);
		panel.add(camionetaButton);
		
		JButton minivanButton = new JButton("MINIVAN");
		minivanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carroceria = "minivan";
				RentacarApp.HacerReserva3.reservaHacer3(carroceria, 0);
				frame.dispose();
			}
		});
		minivanButton.setIcon(new ImageIcon(".\\src\\minivan (1).jpeg"));
		minivanButton.setBounds(152, 369, 112, 57);
		panel.add(minivanButton);
		
		JLabel lblCompact = new JLabel("COMPACTO");
		lblCompact.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompact.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblCompact.setBounds(30, 168, 112, 36);
		panel.add(lblCompact);
		
		JLabel lblCoupe = new JLabel("COUPÉ");
		lblCoupe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupe.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblCoupe.setBounds(152, 168, 112, 36);
		panel.add(lblCoupe);
		
		JLabel lblSedan = new JLabel("SEDÁN");
		lblSedan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSedan.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblSedan.setBounds(274, 168, 112, 36);
		panel.add(lblSedan);
		
		JLabel lblDeportivo = new JLabel("DEPORTIVO");
		lblDeportivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeportivo.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblDeportivo.setBounds(30, 257, 112, 31);
		panel.add(lblDeportivo);
		
		JLabel lblHibrido = new JLabel("HÍBRIDO");
		lblHibrido.setHorizontalAlignment(SwingConstants.CENTER);
		lblHibrido.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblHibrido.setBounds(152, 257, 112, 31);
		panel.add(lblHibrido);
		
		JLabel lblSuv = new JLabel("SUV");
		lblSuv.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuv.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblSuv.setBounds(274, 257, 112, 31);
		panel.add(lblSuv);
		
		JLabel lblCamioneta = new JLabel("CAMIONETA");
		lblCamioneta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamioneta.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblCamioneta.setBounds(30, 343, 112, 31);
		panel.add(lblCamioneta);
		
		JLabel lblMinivan = new JLabel("MINIVAN");
		lblMinivan.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinivan.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblMinivan.setBounds(152, 343, 112, 31);
		panel.add(lblMinivan);
		boolean defaultColor = true;
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		
		
		
	}
}
