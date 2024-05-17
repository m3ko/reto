package Modelo;

import java.io.Serializable;

/**
 * @author Niko
 * 
 *         Constructor de trabajador que extiende de personas.
 * 
 */
public class trabajador extends personas implements Serializable {

	public trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public trabajador(String dni, String nombre, String apellido, String mail, String contraseña, String telefono,
			boolean rol, int clavePrivada) {
		super(dni, nombre, apellido, mail, contraseña, telefono, rol, clavePrivada);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRol() {

		return true;
	}
}
