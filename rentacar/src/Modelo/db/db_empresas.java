package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.cliente;
import Modelo.empresas;

public class db_empresas {

	/**
	 * Realiza una conexión a la BBDD y recoge informacion.
	 * @return Devuleve un ArrayList de todas las empresas.
	 * @author Niko
	 */
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
			int err=02;
			logsError.errores.numErrores(err, null);
		}
	
	
	return listaEmpresas;
	
	}
	
	/**
	 * @author Niko
	 * 
	 * Inserta una nueva empresa a la BBDD
	 * 
	 * @param cif variable que indique el cif de empresa
	 * @param nombre variable que indica el nombre de la empresa
	 * @param direccion variable que indica la direccion de la empresa.
	 * @return devuelve un boolean que refleja el exito de la operación.
	 */
	public static boolean añadirEmpresa(String cif, String nombre, String direccion) {

		boolean exito = false;

		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `empresas`(`cif_empresa`, `nombre_empresa`, `direccion`) VALUES ('"+cif+"','"+nombre+"','"+direccion+"')";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");
			exito = true;

		} catch (Exception e) {
			System.err.println("Ha fallado el metodo añadirEmpresa()");
			int err=03;
			logsError.errores.numErrores(err, null);
		}

		return exito;

	}
	/**
	 * @author Niko
	 * 
	 * Actualiza la base de datos de cara a las modificaciones, inserciones o eliminaciones de la tabla
	 * de Empresas en la ventana GestionEmpresas
	 * 
	 * @param listaEmpresas ArrayList de todas las empresas.
	 */
	public static void updateTablaEmpresas(ArrayList<empresas>listaEmpresas) {
		
Connection con = Modelo.db.db_connect.conexion();
		
		try {
			for (empresas empresa: listaEmpresas) {
				String cif=empresa.getCif();
				String nombre=empresa.getNombre();
				String direccion=empresa.getDireccion();
				
				Statement st = con.createStatement();
				String sql="UPDATE `empresas` SET `nombre_empresa`='"+nombre+"',`direccion`='"+direccion+"' WHERE cif_empresa='"+cif+"';";
				st.execute(sql);
				System.out.println(sql);
			}
			
			
		} catch (SQLException e) {
			
			System.err.println("Ha fallado el metodo updateTablaEmpresas");
			int err = 04;
			logsError.errores.numErrores(err, null);
		}
		
	}
	
}
