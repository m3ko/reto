package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.empresas;

public class db_empresas {

	public static ArrayList<empresas> getEmpresas (){
		
	ArrayList<empresas> listaEmpresas = new ArrayList<empresas>();
	
	Connection connect = Modelo.db.db_connect.conexion();
	
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT * FROM `empresas`;";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				
				String cif_empresa = rs.getString("cif_empresa");
				String nombre_empresa = rs.getString("nombre_empresa");
				String direccion = rs.getString("direccion");
				
				empresas empresas = new empresas(null, null, null);
				
				empresas.setCif(cif_empresa);
				empresas.setNombre(nombre_empresa);
				empresas.setDireccion(direccion);
				
				listaEmpresas.add(empresas);
			}
		} catch (Exception e) {
			System.err.println("ha fallado la glase getEmpresas()");
		}
	
	
	return listaEmpresas;
	
	}
	
}
