package Modelo;

/**
 * @author Niko
 * 
 *         Constructor de empresas
 * 
 */
public class empresas {

	public String nombre;
	public String cif;
	public String direccion;

	public empresas(String nombre, String cif, String direccion) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public empresas() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "empresas [nombre=" + nombre + ", cif=" + cif + ", direccion=" + direccion + "]";
	}

}
