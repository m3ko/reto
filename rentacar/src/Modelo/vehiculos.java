package Modelo;

public class vehiculos {

	public String codigo_identificación;
	public String nombre;
	public String descripcion;
	public String particularidad;
	
	public vehiculos(String codigo_identificación, String nombre, String descripcion, String particularidad) {
		super();
		this.codigo_identificación = codigo_identificación;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.particularidad = particularidad;
	}
	public String getCodigo_identificación() {
		return codigo_identificación;
	}
	public void setCodigo_identificación(String codigo_identificación) {
		this.codigo_identificación = codigo_identificación;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getParticularidad() {
		return particularidad;
	}
	public void setParticularidad(String particularidad) {
		this.particularidad = particularidad;
	}
	public vehiculos() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "vehiculos [codigo_identificación=" + codigo_identificación + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", particularidad=" + particularidad + "]";
	}
	
	
	
	
}
