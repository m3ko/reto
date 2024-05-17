package Modelo.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import Modelo.cliente;
import Modelo.itinerarios;
import RentacarApp.ConfirmaReserva;
import RentacarApp.GestionarReserva;
import RentacarApp.HacerReserva;
import RentacarApp.HacerReserva3;

public class db_itinerarios {

	/**
	 * @author Niko 
	 * 
	 * Genera un nuevo Itinerario y la inserta en la BBDD Recibe datos
	 *         vía Objetos
	 *                 
	 * @param HacerReserva3.cifEmpresaAux
	 * @param HacerReserva3.codigoVehiculoAux
	 * @param HacerReserva.date1aux
	 * @param HacerReserva.date2aux
	 * @param HacerReserva.hora1aux
	 * @param HacerReserva.min1aux
	 * @param HacerReserva.hora2aux
	 * @param HacerReserva.min2aux
	 * @param ConfirmaReserva.precioTotalAux
	 * 
	 */
	public static void generarItinerario() {

		String cif_empresa = HacerReserva3.cifEmpresaAux.toString();
		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();
		String fecha_recogida = HacerReserva.date1aux.toString();
		String fecha_entrega = HacerReserva.date2aux.toString();
		String hora_recogida = HacerReserva.hora1aux.toString();
		String min_recogida = HacerReserva.min1aux.toString();
		String hora_entrega = HacerReserva.hora2aux.toString();
		String min_entrega = HacerReserva.min2aux.toString();
		int precio_total = ConfirmaReserva.precioTotalAux;
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `itinerarios`(`cif_empresa`, `codigo_vehiculo`, `fecha_entrega`, `fecha_recogida`, `hora_recogida`, `hora_entrega`, `precio_total`) VALUES ('"
					+ cif_empresa + "','" + codigo_vehiculo + "','" + fecha_entrega + "','" + fecha_recogida + "','"
					+ hora_recogida + ":" + min_recogida + ":00','" + hora_entrega + ":" + min_entrega + ":00','"
					+ precio_total + "')";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo generarItinerario()");
			int err=05;
			logsError.errores.numErrores(err, null);
		}
	}

	/**
	 * @author niko
	 * 
	 * Recibe el codigo de vehiculo vía objeto y busca el id_itinerario asociado.
	 * 
	 * @param HacerReserva3.codigoVehiculoAux
	 * @return Devuelve un id_itinerario
	 */
	public static int getId_itinerario() {
		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();

		int id_itinerario = 0;
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "SELECT id_itinerario FROM `itinerarios` WHERE codigo_vehiculo='" + codigo_vehiculo + "';";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {

				id_itinerario = rs.getInt("id_itinerario");

			}

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo getId_itinerario()");
			int err=06;
			logsError.errores.numErrores(err, null);
		}

		return id_itinerario;
	}

	/**
	 * @author Niko
	 * @param aux un id_itinerario
	 * @return devuelve un ArrayList de itinerarios con el mismo id.
	 */
	public static ArrayList<itinerarios> getItinerarios(int aux) {

		ArrayList<itinerarios> listaItinerarios = new ArrayList();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "SELECT * FROM `itinerarios` WHERE id_itinerario = '" + aux + "';";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {

				int id_itinerario = rs.getInt("id_itinerario");
				String cif_empresa = rs.getString("cif_empresa");
				String codigo_vehiculo = rs.getString("codigo_vehiculo");
				Date fecha_entrega = rs.getDate("fecha_entrega");
				Date fecha_recogida = rs.getDate("fecha_recogida");
				Time Hora_recogida = rs.getTime("hora_recogida");
				Time Hora_entrega = rs.getTime("hora_entrega");
				int precio_total = rs.getInt("precio_total");

				itinerarios itinerarios = new itinerarios(0, null, null, null, null, null, null, 0);

				itinerarios.setId_itinerario(id_itinerario);
				itinerarios.setCif_empresa(cif_empresa);
				itinerarios.setCodigo_vehiculo(codigo_vehiculo);
				itinerarios.setFecha_entrega(fecha_entrega);
				itinerarios.setFecha_recogida(fecha_recogida);
				itinerarios.setHora_recogida(Hora_recogida);
				itinerarios.setHora_entrega(Hora_entrega);
				itinerarios.setPrecio_total(precio_total);

				listaItinerarios.add(itinerarios);
			}

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo getItinerarios()");
			int err=07;
			logsError.errores.numErrores(err, null);
		}

		return listaItinerarios;
	}

	/**
	 * @author Niko
	 * 
	 * Actualiza la fechas y horas de un itinerario expecifico.
	 * 
	 * 
	 * @param HacerReserva.date1aux
	 * @param HacerReserva.date2aux
	 * @param HacerReserva.hora1aux
	 * @param HacerReserva.min1aux
	 * @param HacerReserva.hora2aux
	 * @param HacerReserva.min2au
	 * @param GestionarReserva.idItinerarioAux
	 * 
	 */
	public static void updateFechas() {

		String fecha_recogida = HacerReserva.date1aux.toString();
		String fecha_entrega = HacerReserva.date2aux.toString();
		String hora_recogida = HacerReserva.hora1aux.toString();
		String min_recogida = HacerReserva.min1aux.toString();
		String hora_entrega = HacerReserva.hora2aux.toString();
		String min_entrega = HacerReserva.min2aux.toString();
		int id_itinerario = GestionarReserva.idItinerarioAux;
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "UPDATE `itinerarios` SET `fecha_entrega`='" + fecha_entrega + "',`fecha_recogida`='"
					+ fecha_recogida + "',`hora_recogida`='" + hora_recogida + ":" + min_recogida
					+ ":00',`hora_entrega`='" + hora_entrega + ":" + min_entrega + ":00' WHERE id_itinerario='"
					+ id_itinerario + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo updateFechas()");
			int err=8;
			logsError.errores.numErrores(err, null);
		}

	}

	/**
	 * @author Niko
	 * 
	 * Actualiza el vehiculo de un itinerario.
	 * 
	 * @param GestionarReserva.idItinerarioAux
	 * @param RentacarApp.HacerReserva3.codigoVehiculoAux
	 * @param RentacarApp.HacerReserva3.cifEmpresaAux
	 * 
	 */
	public static void updateVehiculo() {

		int id_itinerario = GestionarReserva.idItinerarioAux;
		String codVehiculoAux = RentacarApp.HacerReserva3.codigoVehiculoAux.toString();
		String cifEmpresaAux = RentacarApp.HacerReserva3.cifEmpresaAux.toString();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "UPDATE `itinerarios` SET `codigo_vehiculo`='" + codVehiculoAux + "', `cif_empresa`='"
					+ cifEmpresaAux + "' WHERE id_itinerario='" + id_itinerario + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			
			System.err.println("Ha fallado el metodo db_itinerarios.updateVehiculo()");
			String errTxt="\"Ha fallado el metodo db_itinerarios.updateVehiculo()\"";
			int err=9;
			logsError.errores.numErrores(err, errTxt);
		}

	}

	/**
	 * @author Niko
	 * 
	 * Elimina un itinerario de la BBDD
	 * 
	 * @param GestionarReserva.idItinerarioAux
	 */
	public static void deleteItinerario() {

		int id_itinerario = GestionarReserva.idItinerarioAux;
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "DELETE FROM `itinerarios` WHERE id_itinerario='" + id_itinerario + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo db_itinerarios.deleteItinerario()");
			String errTxt="Ha fallado el metodo db_itinerarios.deleteItinerario()";
			int err=10;
			logsError.errores.numErrores(err, errTxt);
		}

	}

	/**
	 * @author Niko
	 * @return Devuelve un ArrayList que contiene todos los itinerarios
	 * 
	 * Hace una consulta a la BBDD para recibir todos los itinerarios
	 * 
	 */
	public static ArrayList<itinerarios> getAllItinerarios() {

		ArrayList<itinerarios> listaItinerarios = new ArrayList();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "SELECT * FROM `itinerarios`;";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {

				int id_itinerario = rs.getInt("id_itinerario");
				String cif_empresa = rs.getString("cif_empresa");
				String codigo_vehiculo = rs.getString("codigo_vehiculo");
				Date fecha_entrega = rs.getDate("fecha_entrega");
				Date fecha_recogida = rs.getDate("fecha_recogida");
				Time Hora_recogida = rs.getTime("hora_recogida");
				Time Hora_entrega = rs.getTime("hora_entrega");
				int precio_total = rs.getInt("precio_total");

				itinerarios itinerarios = new itinerarios(0, null, null, null, null, null, null, 0);

				itinerarios.setId_itinerario(id_itinerario);
				itinerarios.setCif_empresa(cif_empresa);
				itinerarios.setCodigo_vehiculo(codigo_vehiculo);
				itinerarios.setFecha_entrega(fecha_entrega);
				itinerarios.setFecha_recogida(fecha_recogida);
				itinerarios.setHora_recogida(Hora_recogida);
				itinerarios.setHora_entrega(Hora_entrega);
				itinerarios.setPrecio_total(precio_total);

				listaItinerarios.add(itinerarios);
			}

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo getItinerarios()");
			String errTxt="Ha fallado el metodo getItinerarios()";
			int err=11;
			logsError.errores.numErrores(err, errTxt);
			
		}

		return listaItinerarios;
	}

	/**
	 * @author Niko
	 * @param id
	 * @param cif_empresa
	 * @param codigo_vehiculo
	 * @param fecha_entrega
	 * @param fecha_recogida
	 * @param hora_entrega
	 * @param hora_recogida
	 * @param precio_total
	 * @return Devuelve un boolean que refleja el exito de la operación
	 * 
	 * Inserta un nuevo Itinerario en la BBDD
	 */
	public static boolean insertItinerario(String id, String cif_empresa, String codigo_vehiculo, String fecha_entrega,
			String fecha_recogida, String hora_entrega, String hora_recogida, String precio_total) {

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");
		boolean exito = false;

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `itinerarios`(`cif_empresa`, `codigo_vehiculo`, `fecha_entrega`, `fecha_recogida`, `hora_recogida`, `hora_entrega`, `precio_total`) VALUES ('"
					+ cif_empresa + "','" + codigo_vehiculo + "','" + fecha_entrega + "','" + fecha_recogida + "','"
					+ hora_recogida + ":00','" + hora_entrega + ":00','" + precio_total + "')";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo generarItinerario()");
			String errTxt="Ha fallado el metodo getItinerarios()";
			int err=12;
			logsError.errores.numErrores(err, errTxt);
		}

		return exito;

	}

	/**
	 * @author Niko
	 * @param guardarItinerarios
	 * 
	 * Actualiza la BBDD según las modificaciones, inserciones o eliminaciones de la tabla
	 * de la ventana de GestionItinerarios
	 */
	public static void updateTablaItinerarios(ArrayList<itinerarios> guardarItinerarios) {

		Connection con = Modelo.db.db_connect.conexion();

		try {
			for (itinerarios itinerario : guardarItinerarios) {

				int id_itinerario = itinerario.getId_itinerario();
				String cif_empresa = itinerario.getCif_empresa();
				String codigo_vehiculo = itinerario.getCodigo_vehiculo();
				String fecha_entrega = itinerario.getFecha_entrega().toString();
				String fecha_recogida = itinerario.getFecha_recogida().toString();
				String hora_entrega = itinerario.getHora_entrega().toString();
				String hora_recogida = itinerario.getHora_recogida().toString();
				int precio = itinerario.getPrecio_total();

				Statement st = con.createStatement();
				String sql = "UPDATE `itinerarios` SET `cif_empresa`='" + cif_empresa + ",`codigo_vehiculo`='"
						+ codigo_vehiculo + "',`fecha_entrega`='" + fecha_entrega + "',`fecha_recogida`='"
						+ fecha_recogida + "',`hora_recogida`='" + hora_recogida + "',`hora_entrega`='" + hora_entrega
						+ "',`precio_total`='" + precio + "' WHERE id_itinerario='" + id_itinerario + "';";
				st.execute(sql);
				System.out.println(sql);
			}

		} catch (SQLException e) {

			System.err.println("Ha fallado el metodo updateTablaClientes");
			String errTxt="Ha fallado el metodo updateTablaClientes";
			int err=13;
			logsError.errores.numErrores(err, errTxt);
		}

	}
}
