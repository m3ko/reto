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
import javax.swing.JToggleButton;


public class Login {

  public static void main(String[] args) {
    // TODO Auto-generated method stub


    JFrame frame = new JFrame();
    
    frame.setSize(430, 457);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setDefaultLookAndFeelDecorated(true);
    frame.setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    JLabel login = new JLabel("Usuario:");
    login.setFont(new Font("DialogInput", Font.BOLD, 12));
    login.setHorizontalAlignment(SwingConstants.CENTER);
    login.setBounds(122, 175, 166, 13);
    JLabel password = new JLabel("Contraseña:");
    password.setFont(new Font("DialogInput", Font.BOLD, 12));
    password.setHorizontalAlignment(SwingConstants.CENTER);
    password.setBounds(122, 227, 166, 13);

    JButton submit = new JButton("SUBMIT");
    submit.setFont(new Font("DialogInput", Font.BOLD, 10));
    submit.setBounds(122, 286, 166, 21);
    submit.setBackground(Color.MAGENTA);
    submit.setForeground(Color.ORANGE);

    JLabel crearCuenta = new JLabel("No tienes una cuenta?");
    crearCuenta.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 8));
    crearCuenta.setBounds(122, 317, 166, 13);
    panel.add(crearCuenta);
    
    
    
    JLabel olvidarContra = new JLabel("Has olvidado tu contraseña?");
    olvidarContra.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 8));
    olvidarContra.setBounds(122, 329, 166, 13);
    panel.add(olvidarContra);
    
    
    
    olvidarContra.addMouseListener(new MouseAdapter() {
    	
    	@Override
        public void mouseClicked(MouseEvent e) {
    		System.out.println(" you clicked me");
    		OlvidarContra.contraOlvidar();
    		frame.dispose();
            
        }
    	
	});
    
    crearCuenta.addMouseListener(new MouseAdapter() {
    	
    	@Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(" you clicked me");
            CrearCuenta.cuentaCrear();
            frame.dispose();
            
        }
    	
	});
    
    
    
    JTextField usuario = new JTextField(20);
    usuario.setFont(new Font("DialogInput", Font.PLAIN, 10));
    usuario.setHorizontalAlignment(SwingConstants.CENTER);
    usuario.setBounds(122, 198, 166, 19);
    JPasswordField contraseña = new JPasswordField(20);
    contraseña.setFont(new Font("DialogInput", Font.PLAIN, 10));
    contraseña.setHorizontalAlignment(SwingConstants.CENTER);
    contraseña.setBounds(122, 250, 166, 19);


    submit.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String usuarioAux = usuario.getText();
        String contraseñaAux = contraseña.getText();
        boolean r=	db_personas.comprobarPersonas(usuarioAux, contraseñaAux);
        if (r == true) {
		
        	System.out.println("Inicio de sesion exitosa");
        	App.SesionIniciada();
        	frame.dispose();
		}
        else if (r == false){
        	System.out.println("Usuario o contraseña incorrectos");
        	JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos","Warning",JOptionPane.WARNING_MESSAGE);
        	
        }
        
        System.out.println(usuarioAux);
        System.out.println(contraseñaAux);
        
        
      }
    });

      ImageIcon logoIcon = new ImageIcon("src/logoancho.gif");
      JLabel logo = new JLabel(logoIcon);
      logo.setVerticalAlignment(SwingConstants.TOP);
      logo.setLocation(0, -12);
      logo.setSize(416,184);

      Color color = new Color(255,204,40);

      panel.setBackground(color);
      panel.setLayout(null);
      panel.add(logo);
      panel.add(login);
      panel.add(usuario);
      panel.add(password);
      panel.add(contraseña);

      panel.add(submit);

    frame.getContentPane().add(panel);
    
    JButton cerrar = new JButton("");
    cerrar.setIcon(new ImageIcon("C:\\Users\\1AW3-11\\Desktop\\rentacar\\src\\cerrar.png"));
    cerrar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.exit(0);
    	}
    });
    cerrar.setForeground(Color.RED);
    cerrar.setFont(new Font("Corbel", Font.BOLD, 10));
    cerrar.setBackground(Color.MAGENTA);
    cerrar.setBounds(392, 419, 28, 28);
    panel.add(cerrar);
    frame.setUndecorated(true);
    frame.setVisible(true);
    
  }
}