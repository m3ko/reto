package Modelo;

import java.sql.Date;

public class sugerencias {

	public int id_sugerencia; //auto-incremental
	public String nombre_persona;
	public String email;
	public Date fecha_creacion;
	public String descripcion;
	public sugerencias(int id_sugerencia, String nombre_persona, String email, Date fecha_creacion,
			String descripcion) {
		super();
		this.id_sugerencia = id_sugerencia;
		this.nombre_persona = nombre_persona;
		this.email = email;
		this.fecha_creacion = fecha_creacion;
		this.descripcion = descripcion;
	}
	public int getId_sugerencia() {
		return id_sugerencia;
	}
	public void setId_sugerencia(int id_sugerencia) {
		this.id_sugerencia = id_sugerencia;
	}
	public String getNombre_persona() {
		return nombre_persona;
	}
	public void setNombre_persona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public sugerencias() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "sugerencias [id_sugerencia=" + id_sugerencia + ", nombre_persona=" + nombre_persona + ", email=" + email
				+ ", fecha_creacion=" + fecha_creacion + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
