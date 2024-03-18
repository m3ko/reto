package Modelo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connect {

	
	public static Connection conexion() {
		
		Connection con = null;
		
		try {
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentacar", "root", "");
			
		} catch (Exception e) {
			
			System.err.println("Ha fallado la conexión a la base de datos.");
			// TODO: handle exception
		}
		
		
		
		return con;
		
		
		
	}
	
}
