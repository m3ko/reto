package Modelo;

import java.sql.Date;

public class delete_historico {

	public int id_acción;
	public String tabla_afectada;
	public Date fecha;
	public String datos_anteriores;
	
	
	
	public delete_historico(int id_acción, String tabla_afectada, Date fecha, String datos_anteriores) {
		super();
		this.id_acción = id_acción;
		this.tabla_afectada = tabla_afectada;
		this.fecha = fecha;
		this.datos_anteriores = datos_anteriores;
	}
	public int getId_acción() {
		return id_acción;
	}
	public void setId_acción(int id_acción) {
		this.id_acción = id_acción;
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
	public delete_historico() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "delete_historico [id_acción=" + id_acción + ", tabla_afectada=" + tabla_afectada + ", fecha=" + fecha
				+ ", datos_anteriores=" + datos_anteriores + "]";
	}
	
	
	
	
}
