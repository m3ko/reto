package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.personas;

public class db_personas {

	public static ArrayList<personas> getPersonas() {

		ArrayList<personas> listaPersonas = new ArrayList<personas>();

		Connection connect = Modelo.db.db_connect.conexion();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT * FROM `personas`;";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int rol = rs.getInt("rol");
				String mail = rs.getString("mail");
				String contraseña = rs.getString("contraseña");
				String telefono = rs.getString("telefono");
				int clavePrivada = rs.getInt("clavePrivada");

				personas persona = new personas(null, null, null, 0, null, null, null, 0);

				persona.setDni(dni);
				persona.setNombre(nombre);
				persona.setApellido(apellido);
				persona.setRol(rol);
				persona.setMail(mail);
				persona.setContraseña(contraseña);
				persona.setTelefono(telefono);
				persona.setClavePrivada(clavePrivada);

				listaPersonas.add(persona);
				System.out.println(listaPersonas);
			}

		} catch (Exception e) {

			// TODO: handle exception
			System.err.println("Ha fallado el metodo getPersonas() de la clase db_personas");
		}
		return listaPersonas;
	}

	public static boolean comprobarPersonas(String usuarioAux, String contraseñaAux) {

		boolean check = false;

		try {
			ArrayList<personas> listaPersonasAux = getPersonas();
			for (personas personas : listaPersonasAux) {
				if (personas.getMail().equals(usuarioAux) && personas.getContraseña().equals(contraseñaAux)) {

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
		}

		return check;
	}

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
		}

		return checkMail;
	}

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
		}

		return exito;

	}

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
		}

		return aux;
	}

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
		}
		return check;
	}

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
		}

		return check;
	}
}