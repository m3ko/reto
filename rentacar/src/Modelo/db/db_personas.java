package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.personas;

public class db_personas {

	
	public static ArrayList<personas> getPersonas(){
		
	ArrayList<personas> listaPersonas = new ArrayList<personas>();
	
	Connection con = Modelo.db.db_connect.conexion();
	try {
		
		
		Statement st = con.createStatement();
		String sql = "SELECT * FROM 'personas'";
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			
			String dni = rs.getString("dni");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int rol = rs.getInt("rol");
			String mail = rs.getString("mail");
			String contraseña = rs.getString("contraseña");
			String telefono = rs.getString("telefono");
			
			personas persona = new personas(null, null, null, 0, null, null, null);
			
			persona.setDni(dni);
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			persona.setRol(rol);
			persona.setMail(mail);
			persona.setContraseña(contraseña);
			persona.setTelefono(telefono);
			
			listaPersonas.add(persona);
		}
				
		
		
			} catch (Exception e) {
				
				// TODO: handle exception
				System.err.println("Ha fallado la clase getPersonas() de la clase db_personas");
		}
	return listaPersonas;
	}
	
	public static boolean comprobarPersonas(String usuarioAux, String contraseñaAux){
	
	boolean check = false;	
	
	ArrayList<personas> listaPersonas = new ArrayList<personas>();
	
	Connection con = Modelo.db.db_connect.conexion();
	
	try {
		
		
		Statement st = con.createStatement();
		String sql = "SELECT * FROM 'personas'";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("sql funciona");
		
		while (rs.next()) {
			
			String dni = rs.getString("dni");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int rol = rs.getInt("rol");
			String mail = rs.getString("mail");
			String contraseña = rs.getString("contraseña");
			String telefono = rs.getString("telefono");
			
			personas persona = new personas(null, null, null, 0, null, null, null);
			
			persona.setDni(dni);
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			persona.setRol(rol);
			persona.setMail(mail);
			persona.setContraseña(contraseña);
			persona.setTelefono(telefono);
			
			listaPersonas.add(persona);
			System.out.println(listaPersonas);
		}
			for (personas personas : listaPersonas) {
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
				System.err.println("Ha fallado la clase comprobarPersonas() de la clase db_personas");
		}
	
	return check;
	}
	
}