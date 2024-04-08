package Modelo;

public class personas {

	public String dni;
	public String nombre;
	public String apellido;
	public int rol;
	public String mail;
	public String contraseña;
	public String telefono;
	public int clavePrivada;
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
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
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
	public int getClavePrivada() {
		return clavePrivada;
	}
	public void setClavePrivada(int clavePrivada) {
		this.clavePrivada = clavePrivada;
	}
	public personas(String dni, String nombre, String apellido, int rol, String mail, String contraseña,
			String telefono, int clavePrivada) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.mail = mail;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.clavePrivada = clavePrivada;
	}
	public personas() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "personas [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" + rol + ", mail="
				+ mail + ", contraseña=" + contraseña + ", telefono=" + telefono + ", clavePrivada=" + clavePrivada
				+ "]";
	}
	
}
