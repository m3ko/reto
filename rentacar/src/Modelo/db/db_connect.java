package Modelo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connect {

	
	/**
	 * @author Niko
	 * @return devuelve la conexión a la BBDD 
	 */
	public static Connection conexion() {
		
		Connection con = null;
		
		try {
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentacar", "root", "");
			
		} catch (Exception e) {
			
			System.err.println("Ha fallado la conexión a la base de datos.");
			int error=01;
			logsError.errores.numErrores(error,null);
			// TODO: handle exception
		}
		
		
		
		return con;
		
		
		
	}
	
}
