package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.vehiculos;
import RentacarApp.HacerReserva3;
import RentacarApp.Pagar;

public class db_vehiculos {

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
			// TODO: handle exception
		}

		return listaMarcas;
	}

	public static ArrayList<vehiculos> getMarcasFiltrado(String carroceria) {

		ArrayList<vehiculos> listaMarcasFiltrado = new ArrayList<vehiculos>();

		Connection connect = Modelo.db.db_connect.conexion();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT DISTINCT marca FROM `vehiculos` WHERE tipo='" + carroceria + "';";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String marca = rs.getString("marca");
				vehiculos marcas = new vehiculos();
				marcas.setMarca(marca);
				listaMarcasFiltrado.add(marcas);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaMarcasFiltrado;
	}

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
		}

		return listaModelos;
	}

	public static void setVendido() {

		
		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "UPDATE `vehiculos` SET `estado`='vendido' WHERE codigo_vehiculo='"+codigo_vehiculo+"';";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");


		} catch (Exception e) {
			System.err.println("Ha fallado el metodo setVendido()");
		}
		
	}

}
