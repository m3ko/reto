package Modelo;

import java.sql.Date;

public class update_historico {

	public int id_accion; //auto-incremental
	public String tabla_afectada;
	public Date fecha;
	public String datos_anteriores;
	public String datos_actualizados;
	public update_historico(int id_accion, String tabla_afectada, Date fecha, String datos_anteriores,
			String datos_actualizados) {
		super();
		this.id_accion = id_accion;
		this.tabla_afectada = tabla_afectada;
		this.fecha = fecha;
		this.datos_anteriores = datos_anteriores;
		this.datos_actualizados = datos_actualizados;
	}
	public int getId_accion() {
		return id_accion;
	}
	public void setId_accion(int id_accion) {
		this.id_accion = id_accion;
	}
	public String getTabla_afectada() {
		return tabla_afectada;
	}
	public void setTabla_afectada(String tabla_afectada) {
		this.tabla_afectada = tabla_afectada;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDatos_anteriores() {
		return datos_anteriores;
	}
	public void setDatos_anteriores(String datos_anteriores) {
		this.datos_anteriores = datos_anteriores;
	}
	public String getDatos_actualizados() {
		return datos_actualizados;
	}
	public void setDatos_actualizados(String datos_actualizados) {
		this.datos_actualizados = datos_actualizados;
	}
	public update_historico() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "update_historico [id_accion=" + id_accion + ", tabla_afectada=" + tabla_afectada + ", fecha=" + fecha
				+ ", datos_anteriores=" + datos_anteriores + ", datos_actualizados=" + datos_actualizados + "]";
	}
	
	
	
}
