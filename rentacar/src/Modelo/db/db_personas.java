package Modelo.db;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Modelo.cliente;
import Modelo.personas;
import Modelo.trabajador;

public class db_personas implements Serializable {

	/**
	 * @author Niko
	 * @return Devuelve un ArrayList con todas las personas
	 * Hace una consulta a la BBDD para que devuelva todas las personas y aprovecha para escribir
	 * el ArrayList en un fichero binario.
	 * Si la BBDD no está disponible, devuelve el ArrayList pero recogiendo los datos del fichero Binario.
	 */
	
	/**
	 * Si la base de datos no esta disponible, lee el fichero binario y coge datos de este.
	 * @return devuelve un ArrayList con datos recogidos del fichero binario.
	 */
	public static ArrayList<personas> getPersonas()  {

		ArrayList<personas> listaPersonas = new ArrayList<personas>();
		personas p = null;
		Connection connect = Modelo.db.db_connect.conexion();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT * FROM `personas`;";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String mail = rs.getString("mail");
				String contraseña = rs.getString("contraseña");
				String telefono = rs.getString("telefono");
				boolean rol = rs.getBoolean("rol");
				int clavePrivada = rs.getInt("clavePrivada");

				
				if (rol==false) {
					p= new cliente(dni, nombre, apellido, mail, contraseña, telefono, rol, clavePrivada);
					
				}else {
					
					p= new trabajador(dni, nombre, apellido, mail, contraseña, telefono, rol, clavePrivada);
				}
				listaPersonas.add(p);
				
				
				System.out.println(listaPersonas);
			}
			try {
				/**
				 * Lineas que aprovecha la consulta para insertar datos en el fichero binario.
				 */
				
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("personas.bin")));
					oos.writeObject(listaPersonas);
				} catch (IOException e) {
					
					e.printStackTrace();
					String errTxt="Ha fallado la creacion del fichero binario";
					int err=14;
					logsError.errores.numErrores(err, errTxt);
				}
			

		} catch (Exception e) {
			
			// TODO: handle exception
			System.err.println("Ha fallado el metodo getPersonas() de la clase db_personas, se procede a leer fichero binario");
			String errTxt="Ha fallado el metodo getPersonas() de la clase db_personas, se procede a leer fichero binario";
			int err=15;
			logsError.errores.numErrores(err, errTxt);
			
			try {
				/**
				 * Lineas para que si la BBDD no está disponible, que coja datos necesario del fichero binario
				 */
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("personas.bin")));
				listaPersonas = (ArrayList<personas>) ois.readObject();
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				String errTxtaux="ha fallado la lectura del fichero binario";
				int erraux=16;
				logsError.errores.numErrores(err, errTxtaux);
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		return listaPersonas;
	}

	/**
	 * @author Niko
	 * @param usuarioAux email de usuario que desea iniciar sesión.
	 * @param contraseñaAux contraseña del usuario que desea iniciar sesión
	 * @return devuelve un boolean reflejando si el usuario lleva esa contraseña o no
	 * 
	 * Hace una consulta a la BBDD para verificar si la contraseña pertenece al usuario
	 * especificado
	 */
	public static boolean comprobarPersonas(String usuarioAux, String contraseñaAux) {

		boolean check = false;

		try {
			ArrayList<personas> listaPersonasAux = getPersonas();
			for (personas personas : listaPersonasAux) {
				if (personas.getMail().equals(usuarioAux) && personas.getContraseña().equals(contraseñaAux)) {
					if (personas.isRol()==true) {
						RentacarApp.Login.rolAux = true;
					}else {
						RentacarApp.Login.rolAux = false;
					}
					check = true;
					break;
				}

				else {

					check = false;

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Ha fallado comprobarPersonas() de la clase db_personas");
			String errTxt="Ha fallado comprobarPersonas() de la clase db_personas";
			int err=17;
			logsError.errores.numErrores(err, errTxt);
		}

		return check;
	}

	/**
	 * @author Niko
	 * @param dniNew el DNI con el que un usuario quiere registrarse
	 * @return devuelve un boolean reflejando si ese DNI existe en la BBDD o no
	 * 
	 * Hace una consulta en la BBDD para comprobar si el DNI ya existe o no.
	 */
	public static boolean comprobarDNI(String dniNew) {

		boolean checkDNI = false;

		try {

			ArrayList<personas> listaPersonasAux = getPersonas();
			System.out.println(listaPersonasAux);
			for (personas personas : listaPersonasAux) {
				if (personas.getDni().equals(dniNew)) {
					System.out.println(dniNew);
					checkDNI = true;
				}
				System.out.println(checkDNI);
			}

		} catch (Exception e) {

			// TODO: handle exception
			System.err.println("Ha fallado el metodo comprobarDNI() de la clase db_personas");
			String errTxt="Ha fallado el metodo comprobarDNI() de la clase db_personas";
			int err=18;
			logsError.errores.numErrores(err, errTxt);
		}

		return checkDNI;
	}

	public static boolean comprobarMail(String mailNew) {

		boolean checkMail = false;
		try {

			ArrayList<personas> listaPersonasAux = getPersonas();
			for (personas personas : listaPersonasAux) {
				if (personas.getMail().equals(mailNew)) {
					System.out.println(personas);
					System.out.println(mailNew);
					checkMail = true;
					break;
				}
			}

		} catch (Exception e) {

			// TODO: handle exception
			System.err.println("Ha fallado el metodo comprobarMail() de la clase db_personas");
			String errTxt="Ha fallado el metodo comprobarMail() de la clase db_personas";
			int err=19;
			logsError.errores.numErrores(err, errTxt);
		}

		return checkMail;
	}

	/**
	 * @author Niko
	 * @param dniNew Dni de persona a registrarse
	 * @param nombreNew nombre de persona a registrarse
	 * @param apellidoNew apellido de persona a registrarse
	 * @param contraNew contraseña de persona a registrarse
	 * @param telefonoNew telefono de persona a registrarse
	 * @param mailNew mail de persona a registrarse
	 * @return devuelve un boolean reflejandoel exito de la operación
	 * 
	 * Hace un insert en la BBDD de una persona recién registrada
	 */
	public static boolean añadirPersona(String dniNew, String nombreNew, String apellidoNew, String contraNew,
			String telefonoNew, String mailNew) {

		boolean exito = false;

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `personas`(`dni`, `nombre`, `apellido`, `rol`, `mail`, `contraseña`, `telefono`, `clavePrivada`) VALUES ('"
					+ dniNew + "','" + nombreNew + "','" + apellidoNew + "','0','" + mailNew + "','" + contraNew + "','"
					+ telefonoNew + "', LPAD(FLOOR(RAND() * 1000000), 6, '0'));";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");
			exito = true;

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo añadirPersona()");
			String errTxt="Ha fallado el metodo añadirPersona()";
			int err=20;
			logsError.errores.numErrores(err, errTxt);
		}

		return exito;

	}

	/**
	 * @author Niko
	 * @param dniNew dni de una persona
	 * @return devuelve la clavePrivada de la persona especificada.
	 * 
	 * Hace una consulta para que devuelva la claveprivada de una persona en especifico
	 */
	public static int getClave(String dniNew) {

		int aux = 0;

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "SELECT clavePrivada FROM `personas` WHERE dni='" + dniNew + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {

				aux = rs.getInt("clavePrivada");

			}

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo getClave()");
			String errTxt="Ha fallado el metodo getClave()";
			int err=21;
			logsError.errores.numErrores(err, errTxt);
		}

		return aux;
	}

	/**
	 * @author Niko
	 * @param clavePrivada clavePrivada de una persona en especifico
	 * @param dniNew dni de una persona en especifico
	 * @return devuelve un boolean que refleja el exito de la operación
	 * 
	 * Comprueba mediante una consulta si la clavePrivada pertenece a la persona
	 * especificada
	 * 
	 */ 
	public static boolean comprobClave(String clavePrivada, String dniNew) {
		boolean check = false;

		Connection con = Modelo.db.db_connect.conexion();

		try {

			Statement st = con.createStatement();
			String sql = "SELECT * FROM `personas` WHERE dni='" + dniNew + "' AND clavePrivada='" + clavePrivada + "';";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {

				check = true;

			}

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo comprobClave()");
			String errTxt="Ha fallado el metodo comprobClave()";
			int err=22;
			logsError.errores.numErrores(err, errTxt);
		}
		return check;
	}

	/**
	 * @author Niko
	 * @param dniNew dni de una persona especificada
	 * @param contraNew nueva contraseña de una persona que ha querido restablecer su contraseña
	 * @return Devuelve un boolean que refleja el exito de la operación
	 * 
	 * Hace un update para restablecer la contraseña de un usuario.
	 */
	public static boolean cambiarContra(String dniNew, String contraNew) {
		boolean check = false;

		Connection con = Modelo.db.db_connect.conexion();

		try {

			Statement st = con.createStatement();
			String sql = "UPDATE `personas` SET `contraseña`='" + contraNew + "' WHERE dni='" + dniNew + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");
			check = true;
			
			

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo cambiarContra()");
			String errTxt="Ha fallado el metodo cambiarContra()";
			int err=23;
			logsError.errores.numErrores(err, errTxt);
		}

		return check;
	}
	
	/**
	 * @author Niko
	 * @param mail mail de un usuario
	 * @return decuelve el dni que pertenece a ese mail.
	 * Hace una consulta a la BBDD para obtener el dni mediante un email.
	 */
	public static String getDni(String mail) {

		String aux = "";

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "SELECT dni FROM `personas` WHERE mail = '"+mail+"';";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {

				aux = rs.getString("dni");

			}

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo getDni()");
			String errTxt="Ha fallado el metodo getDni()";
			int err=24;
			logsError.errores.numErrores(err, errTxt);
		}

		return aux;
	}
	
	
	//TABLAS
	
	
	/**
	 * @author Niko
	 * @param dni dni de una persona
	 * 
	 * Elimina las personas que se han eliminado en la tabla de la ventana GestionClientes();
	 */
	public static void DeleteRowPersonas(String dni) {
		
		Connection con = Modelo.db.db_connect.conexion();
		
		try {
			
			Statement st = con.createStatement();
			String sql="DELETE FROM `personas` WHERE dni='"+dni+"';";
			st.execute(sql);
			
		} catch (SQLException e) {
			
			System.err.println("Ha fallado el metodo DeleteRowPersonas");
			String errTxt="Ha fallado el metodo DeleteRowPersonas";
			int err=25;
			logsError.errores.numErrores(err, errTxt);
		}
		
	}
	
	/**
	 * @author Niko
	 * @param listaClientes ArrayList de los datos que contiene la tabla de la ventana GestionClientes().
	 * 
	 * Hace un update en la BBDD dependiendo de la inserciones, eliminaciones o modificaciones
	 * de la tabla que contiene la ventana GestionClientes().
	 */
	public static void updateTablaClientes(ArrayList<cliente> listaClientes) {
		
Connection con = Modelo.db.db_connect.conexion();
		
		try {
			for (cliente cliente : listaClientes) {
				String dni = cliente.getDni();
				String nombre=cliente.getNombre();
				String apellido=cliente.getApellido();
				String mail=cliente.getMail();
				String contraseña=cliente.getContraseña();
				String telefono = cliente.getTelefono();
				int claveP=cliente.getClavePrivada();
				
				Statement st = con.createStatement();
				String sql="UPDATE `personas` SET `nombre`='"+nombre+"',`apellido`='"+apellido+"',`mail`='"+mail+"',`contraseña`='"+contraseña+"',`telefono`='"+telefono+"' WHERE dni='"+dni+"';";
				st.execute(sql);
				System.out.println(sql);
			}
			
			
		} catch (SQLException e) {
			
			System.err.println("Ha fallado el metodo updateTablaClientes");
			String errTxt="Ha fallado el metodo updateTablaClientes";
			int err=26;
			logsError.errores.numErrores(err, errTxt);
		}
		
		
	}
}