package Modelo;

import java.io.Serializable;

/**
 * @author Niko
 * 
 *         Constructor de personas
 */
public abstract class personas implements Serializable {

	public String dni;
	public String nombre;
	public String apellido;
	public String mail;
	public String contraseña;
	public String telefono;
	public boolean rol;
	public int clavePrivada;

	public personas(String dni, String nombre, String apellido, String mail, String contraseña, String telefono,
			boolean rol, int clavePrivada) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.rol = rol;
		this.clavePrivada = clavePrivada;
	}

	public personas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public abstract boolean isRol();

	public void setRol(boolean rol) {
		this.rol = rol;
	}

	public int getClavePrivada() {
		return clavePrivada;
	}

	public void setClavePrivada(int clavePrivada) {
		this.clavePrivada = clavePrivada;
	}

	@Override
	public String toString() {
		return "personas [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", contraseña=" + contraseña + ", telefono=" + telefono + ", rol=" + rol + ", clavePrivada="
				+ clavePrivada + "]";
	}

}