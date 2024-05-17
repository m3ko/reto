package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.cliente;
import Modelo.reservas;
import RentacarApp.GestionarReserva;
import RentacarApp.HacerReserva3;
import RentacarApp.Pagar;

/**
 * @author Niko
 * 
 *         Todas estas clases son acciones dirigidas a la tabla de la BBDD
 *         "reservas".
 */
public class db_reservas {

	/**
	 * @author Niko
	 * 
	 * @param HacerReserva3.codigoVehiculoAux.toString();
	 * @param Pagar.dniAux.toString();
	 * @param HacerReserva3.cifEmpresaAux.toString();
	 * @param Modelo.db.db_itinerarios.getId_itinerario();
	 * 
	 *                                                     Recibe variables o datos
	 *                                                     vía objetos de otros
	 *                                                     ficheros con la intención
	 *                                                     de realizar una reserva
	 *                                                     con las opciones que el
	 *                                                     usuario ha ido
	 *                                                     escogiendo.
	 * 
	 */
	public static void hacerReserva() {
		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();
		String dni_persona = Pagar.dniAux.toString();
		String cif_empresa = HacerReserva3.cifEmpresaAux.toString();
		int id_itinerario = Modelo.db.db_itinerarios.getId_itinerario();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `reservas`(`dni`, `cif_empresa`, `codigo_vehiculo`, `id_itinerario`) VALUES ('"
					+ dni_persona + "', '" + cif_empresa + "', '" + codigo_vehiculo + "', '" + id_itinerario + "');";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo hacerReserva()");
			String errTxt="Ha fallado el metodo hacerReserva()";
			int err=27;
			logsError.errores.numErrores(err, errTxt);
		}
		Modelo.db.db_vehiculos.setVendido();

	}

	/**
	 * @author Niko
	 * @param RentacarApp.Login.mailAux.toString();
	 * @param RentacarApp.Login.mailAux.toString();
	 * 
	 * @return Devuelve un ArrayList con las reservas que tiene una usuario en
	 *         concreto.
	 * 
	 *         Hace una consulta para que devuelva las reservas y el itinerarios de
	 *         cada que tiene un usuario.
	 */
	public static ArrayList<reservas> getReservas() {

		Connection connect = Modelo.db.db_connect.conexion();
		String mail = RentacarApp.Login.mailAux.toString();
		String dniAux = db_personas.getDni(mail);
		ArrayList<reservas> listaReservas = new ArrayList<>();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT id_reserva, id_itinerario FROM `reservas` WHERE dni='" + dniAux + "';";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id_reserva = rs.getInt("id_reserva");
				int id_itinerario = rs.getInt("id_itinerario");

				reservas reservas = new reservas(0, null, null, null, 0);

				reservas.setId_reserva(id_reserva);
				reservas.setId_itinerario(id_itinerario);
				listaReservas.add(reservas);

			}
		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo getReservas()");
			String errTxt="Ha fallado el metodo getReservas()";
			int err=28;
			logsError.errores.numErrores(err, errTxt);
		}
		return listaReservas;
	}

	/**
	 * @author Niko
	 * @param GestionarReserva.idItinerarioAux;                       id_itinerario
	 *                                                                de una reserva
	 * @param RentacarApp.HacerReserva3.cifEmpresaAux.toString()      cif de una
	 *                                                                empresa
	 * @param RentacarApp.HacerReserva3.codigoVehiculoAux.toString(); codigo_vehiculo
	 *                                                                a updatear
	 * 
	 *                                                                Hace un update
	 *                                                                en la tabla
	 *                                                                reserva para
	 *                                                                cuando el
	 *                                                                usuario
	 *                                                                modifique su
	 *                                                                reserva y
	 *                                                                cambia el
	 *                                                                vehiculo
	 *                                                                anteriormente
	 *                                                                escogido.
	 */
	public static void updateReservaVehiculo() {

		int id_itinerario = GestionarReserva.idItinerarioAux;
		String cifEmpresaAux = RentacarApp.HacerReserva3.cifEmpresaAux.toString();
		String codVehiculoAux = RentacarApp.HacerReserva3.codigoVehiculoAux.toString();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "UPDATE `reservas` SET `codigo_vehiculo`='" + codVehiculoAux + "', `cif_empresa`='"
					+ cifEmpresaAux + "' WHERE id_itinerario='" + id_itinerario + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo db_reservas.updateVehiculo()");
			String errTxt="Ha fallado el metodo db_reservas.updateVehiculo()";
			int err=29;
			logsError.errores.numErrores(err, errTxt);
		}

	}

	/**
	 * @author Niko
	 * @param GestionarReserva.idItinerarioAux; id itinerarios de una reserva.
	 * 
	 *                                          Hace un delete en la BBDD de una
	 *                                          reserva con id_itinerario en
	 *                                          especifico.
	 */
	public static void deleteReserva() {

		int id_itinerario = GestionarReserva.idItinerarioAux;
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "DELETE FROM `reservas` WHERE id_itinerario='" + id_itinerario + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo db_reservas.deleteReserva()");
			String errTxt="Ha fallado el metodo db_reservas.deleteReserva()";
			int err=30;
			logsError.errores.numErrores(err, errTxt);
		}

	}

	/**
	 * @param dni dni de una persona
	 * @param cif cif de una empresa
	 * @param cod codigo del vehiculo
	 * @param it  itinerario escogido por el usuario
	 * @return devuleve un boolean que refleje el exito de la operación
	 * 
	 *         Hace un insert de una Reserva nueva.
	 */
	public static boolean insertReserva(String dni, String cif, String cod, String it) {
		boolean exito = false;

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `reservas`(`dni`, `cif_empresa`, `codigo_vehiculo`, `id_itinerario`) VALUES ('"
					+ dni + "','" + cif + "','" + cod + "','" + it + "')";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");
			exito = true;

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo db_reservas.insertReserva()");
			String errTxt="Ha fallado el metodo db_reservas.insertReserva()";
			int err=31;
			logsError.errores.numErrores(err, errTxt);
		}
		return exito;
	}

	/**
	 * @author Niko
	 * @return devuelve un ArrayList que contiene todas las reservas. Hace una
	 *         consulta para que devuelva todas las reservas disponibles.
	 */
	public static ArrayList<reservas> getAllReservas() {

		Connection connect = Modelo.db.db_connect.conexion();
		ArrayList<reservas> listaReservas = new ArrayList<>();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT * FROM `reservas`";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id_reserva = rs.getInt("id_reserva");
				String dni = rs.getString("dni");
				String cif_empresa = rs.getString("cif_empresa");
				String codigo_vehiculo = rs.getString("codigo_vehiculo");
				int id_itinerario = rs.getInt("id_itinerario");

				reservas reservas = new reservas(0, null, null, null, 0);

				reservas.setId_reserva(id_reserva);
				reservas.setDni_persona(dni);
				reservas.setCif_empresa(cif_empresa);
				reservas.setCod_vehiculo(codigo_vehiculo);
				reservas.setId_itinerario(id_itinerario);
				listaReservas.add(reservas);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("ha fallado el metodo getAllReservas()");
			String errTxt="ha fallado el metodo getAllReservas()";
			int err=32;
			logsError.errores.numErrores(err, errTxt);
		}
		return listaReservas;
	}

	/**
	 * @author Niko
	 * @param listaReservas ArrayList que contiene los datos de la tabla que
	 *                      contiene la ventana de GestionarReservas()
	 * 
	 *                      Updatea la tabla Reservas según inserciones,
	 *                      eliminaciones o modificaciones realizadas en la tabla
	 *                      que contiene la ventana de GestionarReservas.
	 */
	public static void updateTablaReservas(ArrayList<reservas> listaReservas) {

		Connection con = Modelo.db.db_connect.conexion();

		try {
			for (reservas reserva : listaReservas) {
				int idR = reserva.getId_reserva();
				String dni = reserva.getDni_persona();
				String cif = reserva.getCif_empresa();
				String codigo = reserva.getCod_vehiculo();
				int idI = reserva.getId_itinerario();

				Statement st = con.createStatement();
				String sql = "UPDATE `reservas` SET `dni`='" + dni + "',`cif_empresa`='" + cif + "',`codigo_vehiculo`='"
						+ codigo + "',`id_itinerario`='" + idI + "' WHERE id_reserva='" + idR + "';";
				st.execute(sql);
				System.out.println(sql);
			}

		} catch (SQLException e) {

			System.err.println("Ha fallado el metodo updateTablaReservas");
			String errTxt="Ha fallado el metodo updateTablaReservas";
			int err=33;
			logsError.errores.numErrores(err, errTxt);
		}

	}
}
