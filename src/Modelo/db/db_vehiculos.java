package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Modelo.vehiculos;

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
				vehiculos marcas = new vehiculos(null, null, null, null, 0, 0, null);
				marcas.setMarca(marca);
				listaMarcas.add(marcas);
			}
		
			}catch (Exception e) {
			// TODO: handle exception
		}

			
		return listaMarcas;
	}
	
public static ArrayList<vehiculos> getMarcasFiltrado(String carroceria) {
		
		ArrayList<vehiculos> listaMarcasFiltrado = new ArrayList<vehiculos>();

		Connection connect = Modelo.db.db_connect.conexion();
		try {
			
			Statement st = connect.createStatement();
			String sql = "SELECT DISTINCT marca FROM `vehiculos` WHERE tipo='"+carroceria+"';";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				
				String marca = rs.getString("marca");
				vehiculos marcas = new vehiculos();
				marcas.setMarca(marca);
				listaMarcasFiltrado.add(marcas);
			}
		
			}catch (Exception e) {
			// TODO: handle exception
		}

			
		return listaMarcasFiltrado;
	}

public static ArrayList<vehiculos> getModelos(String marcaSeleccionada, String carroceria){

	ArrayList<vehiculos> listaModelos = new ArrayList<vehiculos>();

	Connection connect = Modelo.db.db_connect.conexion();
	try {
		
		Statement st = connect.createStatement();
		String sql = "SELECT * FROM `vehiculos` WHERE marca='"+marcaSeleccionada+"' AND tipo='"+carroceria+"' AND estado='disponible';";
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			
			String codigo_vehiculo = rs.getString("codigo_vehiculo");
			String marca = rs.getString("marca");
			String modelo = rs.getString("modelo");
			String tipo = rs.getString("tipo");
			int año_fabricacion = rs.getInt("año_fabricacion");
			int precio_alquiler = rs.getInt("precio_alquiler");
			String estado = rs.getString("estado");
			
			vehiculos modelos = new vehiculos(null, null, null, null, 0, 0, null);
			
			modelos.setCodigo_vehiculo(codigo_vehiculo);
			modelos.setMarca(marca);
			modelos.setModelo(modelo);
			modelos.setTipo(tipo);
			modelos.setAño_fabricación(año_fabricacion);
			modelos.setPrecio_alquiler(precio_alquiler);
			modelos.setEstado(estado);
			
			listaModelos.add(modelos);
		}
	
		}catch (Exception e) {
		// TODO: handle exception
	}
	
return listaModelos;
}}
