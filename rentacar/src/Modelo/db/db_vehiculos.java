package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.cliente;
import Modelo.vehiculos;
import RentacarApp.HacerReserva3;
import RentacarApp.Pagar;

/**
 * @author Niko
 * 
 *         Fichero destinado a hacer acciones dcestinadas a la tabla de la BBDD
 *         "vehiculos"
 * 
 */
public class db_vehiculos {

	/**
	 * @author Niko
	 * @return devuelve un arrayList de todos los vehiculos.
	 * 
	 *         Hace una consulta que recibe todos los vehiculos de la BBDD.
	 */
	public static ArrayList<vehiculos> getVehiculos() {

		ArrayList<vehiculos> listaVehiculos = new ArrayList<vehiculos>();

		Connection connect = Modelo.db.db_connect.conexion();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT * FROM `vehiculos`;";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String codigo_vehiculo = rs.getString("codigo_vehiculo");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String tipo = rs.getString("tipo");
				int año_fabricacion = rs.getInt("año_fabricacion");
				int precio_alquiler = rs.getInt("precio_alquiler");
				String estado = rs.getString("estado");
				String cif_empresa = rs.getString("cif_empresa");

				vehiculos vehiculos = new vehiculos(null, null, null, null, 0, 0, null, null);

				vehiculos.setCodigo_vehiculo(codigo_vehiculo);
				vehiculos.setMarca(marca);
				vehiculos.setModelo(modelo);
				vehiculos.setTipo(tipo);
				vehiculos.setAño_fabricación(año_fabricacion);
				vehiculos.setPrecio_alquiler(precio_alquiler);
				vehiculos.setEstado(estado);
				vehiculos.setCif_empresa(cif_empresa);

				listaVehiculos.add(vehiculos);
			}

		} catch (Exception e) {
			System.err.println("ha fallado el metodo getvehiculos()");
			String errTxt="ha fallado el metodo getvehiculos()";
			int err=34;
			logsError.errores.numErrores(err, errTxt);
		}

		return listaVehiculos;
	}

	/**
	 * @author Niko
	 * @return Devuelve un ArrayList que contiene las marcas de los vehiculos
	 *         disponibles.
	 * 
	 *         Se hace una consulta a la BBDD para que devuelva las marcas que estén
	 *         disponibles.
	 */
	public static ArrayList<vehiculos> getMarcas() {

		ArrayList<vehiculos> listaMarcas = new ArrayList<vehiculos>();

		Connection connect = Modelo.db.db_connect.conexion();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT DISTINCT marca FROM vehiculos WHERE estado='Disponible';";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String marca = rs.getString("marca");
				vehiculos marcas = new vehiculos(null, null, null, null, 0, 0, null, null);
				marcas.setMarca(marca);
				listaMarcas.add(marcas);
			}

		} catch (Exception e) {
			System.err.println("ha fallado el metodo getMarcas");
			String errTxt="ha fallado el metodo getvehiculos()";
			int err=35;
			logsError.errores.numErrores(err, errTxt);
		}

		return listaMarcas;
	}

	/**
	 * @author Niko
	 * @param carroceria tipo de coche escogido por el usuario.
	 * @return devuelve un ArrayList con las marcas filtradas por tipo de coche.
	 * 
	 *         Hace una consulta a la BBDD que recibe las marcas disponibles con el
	 *         filtro de tipo de coche que haya escogido el usuario.
	 */
	public static ArrayList<vehiculos> getMarcasFiltrado(String carroceria) {

		ArrayList<vehiculos> listaMarcasFiltrado = new ArrayList<vehiculos>();

		Connection connect = Modelo.db.db_connect.conexion();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT DISTINCT marca FROM `vehiculos` WHERE tipo='" + carroceria
					+ "' AND estado='disponible';";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String marca = rs.getString("marca");
				vehiculos marcas = new vehiculos();
				marcas.setMarca(marca);
				listaMarcasFiltrado.add(marcas);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("ha fallado el metodo getMarcasFiltrado");
			String errTxt="ha fallado el metodo getMarcasFiltrado";
			int err=36;
			logsError.errores.numErrores(err, errTxt);
		}

		return listaMarcasFiltrado;
	}

	/**
	 * @author Niko
	 * @param marcaSeleccionada marca ha escogido el usuario.
	 * @param carroceria        Tipo de coche que ha escogido el usuario.
	 * @return Devuelve un ArrayList que contiene los modelos que sean de la marca y
	 *         tipo escogidos.
	 * 
	 *         Hace una consulta a la BBDD que devuelve los Modelos de la marca y
	 *         tipo escogido por el cliente.
	 * 
	 */
	public static ArrayList<vehiculos> getModelos(String marcaSeleccionada, String carroceria) {

		ArrayList<vehiculos> listaModelos = new ArrayList<vehiculos>();

		Connection connect = Modelo.db.db_connect.conexion();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT * FROM `vehiculos` WHERE marca='" + marcaSeleccionada + "' AND tipo='" + carroceria
					+ "' AND estado='disponible';";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String codigo_vehiculo = rs.getString("codigo_vehiculo");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String tipo = rs.getString("tipo");
				int año_fabricacion = rs.getInt("año_fabricacion");
				int precio_alquiler = rs.getInt("precio_alquiler");
				String estado = rs.getString("estado");
				String cif_empresa = rs.getString("cif_empresa");

				vehiculos modelos = new vehiculos(null, null, null, null, 0, 0, null, null);

				modelos.setCodigo_vehiculo(codigo_vehiculo);
				modelos.setMarca(marca);
				modelos.setModelo(modelo);
				modelos.setTipo(tipo);
				modelos.setAño_fabricación(año_fabricacion);
				modelos.setPrecio_alquiler(precio_alquiler);
				modelos.setEstado(estado);
				modelos.setCif_empresa(cif_empresa);

				listaModelos.add(modelos);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("ha fallado el metodo getModelos");
			String errTxt="ha fallado el metodo getModelos";
			int err=37;
			logsError.errores.numErrores(err, errTxt);
		}

		return listaModelos;
	}

	/**
	 * @author Niko
	 * @param HacerReserva3.codigoVehiculoAux.toString()
	 * 
	 *                                                   Hace un update a la BBDD
	 *                                                   para establecer en
	 *                                                   "vendido" un vehículo que
	 *                                                   ha sido reservado.
	 */
	public static void setVendido() {

		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "UPDATE `vehiculos` SET `estado`='vendido' WHERE codigo_vehiculo='" + codigo_vehiculo + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo setVendido()");
			String errTxt="Ha fallado el metodo setVendido()";
			int err=38;
			logsError.errores.numErrores(err, errTxt);
		}

	}

	/**
	 * @author Niko
	 * @param RentacarApp.GestionarReserva.codVehiculoAnterior codigo vehiculo del
	 *                                                         vehiculo que contiene
	 *                                                         la reserva a
	 *                                                         cancelar.
	 * 
	 *                                                         Updatea la BBDD para
	 *                                                         que establezca en
	 *                                                         "Disponible" un coche
	 *                                                         cuya reserva haya
	 *                                                         sido cancelada por el
	 *                                                         usuario.
	 * 
	 */
	public static void setDisponible() {

		String codigo_vehiculo = RentacarApp.GestionarReserva.codVehiculoAnterior;
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectado");

		try {

			Statement st = con.createStatement();
			String sql = "UPDATE `vehiculos` SET `estado`='Disponible' WHERE codigo_vehiculo='" + codigo_vehiculo
					+ "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo setVendido()");
			String errTxt="Ha fallado el metodo setVendido()";
			int err=39;
			logsError.errores.numErrores(err, errTxt);
		}

	}

	/**
	 * @author Niko
	 * @param codigo_vehiculo codigo vehiculo a eliminar.
	 * 
	 *                        Hace un delete en la BBDD de un vehiculo que haya sido
	 *                        eliminado.
	 * 
	 * 
	 */
	public static void deleteVehiculo(String codigo_vehiculo) {

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "DELETE FROM `vehiculos` WHERE codigo_vehiculo='" + codigo_vehiculo + "';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo deleteVehiculo()");
			String errTxt="Ha fallado el metodo deleteVehiculo()";
			int err=40;
			logsError.errores.numErrores(err, errTxt);
		}

	}

	/**
	 * @author Niko
	 * @param codigo_vehiculo codigo de un vehiculo nuevo.
	 * @param marca           marca de un vehiculo nuevo.
	 * @param modelo          modelo de un vehiculo nuevo.
	 * @param tipo            tipo de un vehiculo nuevo.
	 * @param año_fabricacion año fabricacion de un vehiculo nuevo.
	 * @param precio_alquiler precio de un vehiculo nuevo.
	 * @param estado          el estado de un vehiculo nuevo.
	 * @param cif_empresa     la empresa que gestiona el vehiculo nuevo.
	 * @return Devuleve un boolean que refleja el exito de la operación.
	 * 
	 *         Hace un insert a la BBDD de un vehiculo nuevo especificado por un
	 *         trabajador en la tabla que contiene GestionVehiculos().
	 */
	public static boolean insertVehiculo(String codigo_vehiculo, String marca, String modelo, String tipo,
			String año_fabricacion, String precio_alquiler, String estado, String cif_empresa) {

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");
		boolean exito = false;
		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `vehiculos`(`codigo_vehiculo`, `marca`, `modelo`, `tipo`, `año_fabricacion`, `precio_alquiler`, `estado`, `cif_empresa`) VALUES ('"
					+ codigo_vehiculo + "','" + marca + "','" + modelo + "','" + tipo + "','" + año_fabricacion + "','"
					+ precio_alquiler + "','" + estado + "','" + cif_empresa + "')";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");
			exito = true;
		} catch (Exception e) {
			System.err.println("Ha fallado el metodo insertVehiculo()");
			String errTxt="Ha fallado el metodo insertVehiculo()";
			int err=41;
			logsError.errores.numErrores(err, errTxt);
		}
		return exito;
	}

	/**
	 * @author Niko
	 * @param listaVehiculos ArrayList que contiene todos los vehiculos de la tabla
	 *                       que contiene la ventana GestionVehiculos().
	 * 
	 *                       Hace un update de la tabla según las inserciones,
	 *                       eliminaciones o modificaciones de una tabla que
	 *                       contiene la ventana Gestionvehiculos().
	 */
	public static void updateTablaVehiculos(ArrayList<vehiculos> listaVehiculos) {

		Connection con = Modelo.db.db_connect.conexion();

		try {
			for (vehiculos vehiculo : listaVehiculos) {

				String codigo = vehiculo.getCodigo_vehiculo();
				String marca = vehiculo.getMarca();
				String modelo = vehiculo.getModelo();
				String tipo = vehiculo.getTipo();
				int año = vehiculo.getAño_fabricación();
				int precio = vehiculo.getPrecio_alquiler();
				String estado = vehiculo.getEstado();
				String cif = vehiculo.getCif_empresa();

				Statement st = con.createStatement();
				String sql = "UPDATE `vehiculos` SET `marca`='" + marca + "',`modelo`='" + modelo + "',`tipo`='" + tipo
						+ "',`año_fabricacion`='" + año + "',`precio_alquiler`='" + precio + "',`estado`='" + estado
						+ "',`cif_empresa`='" + cif + "' WHERE codigo_vehiculo='" + codigo + "';";
				st.execute(sql);
				System.out.println(sql);
			}

		} catch (SQLException e) {

			System.err.println("Ha fallado el metodo updateTablaVehiculos");
			String errTxt="Ha fallado el metodo updateTablaVehiculos";
			int err=42;
			logsError.errores.numErrores(err, errTxt);
		}

	}
}
