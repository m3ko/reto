package Modelo;

import java.io.Serializable;

/**
 * @author Niko
 * 
 *         Constructor de Cliente
 * 
 */
public class cliente extends personas implements Serializable {

	public cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public cliente(String dni, String nombre, String apellido, String mail, String contraseña, String telefono,
			boolean rol, int clavePrivada) {
		super(dni, nombre, apellido, mail, contraseña, telefono, rol, clavePrivada);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRol() {

		return false;
	}

}
