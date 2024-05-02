package Modelo;

import java.sql.Date;
import java.sql.Time;

public class itinerarios {

	public int id_itinerario; //auto-incremental
	public String nombre_empresa;
	public String nombre_vehiculo;
	public Date fecha_recogida;
	public Date fecha_entrega;
	public Time hora_recogida;
	public Time hora_entrega;
	public int aforo;
	public int getId_itinerario() {
		return id_itinerario;
	}
	public void setId_itinerario(int id_itinerario) {
		this.id_itinerario = id_itinerario;
	}
	public String getNombre_empresa() {
		return nombre_empresa;
	}
	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
	public String getNombre_vehiculo() {
		return nombre_vehiculo;
	}
	public void setNombre_vehiculo(String nombre_vehiculo) {
		this.nombre_vehiculo = nombre_vehiculo;
	}
	public Date getFecha_recogida() {
		return fecha_recogida;
	}
	public void setFecha_recogida(Date fecha_recogida) {
		this.fecha_recogida = fecha_recogida;
	}
	public Date getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public Time getHora_recogida() {
		return hora_recogida;
	}
	public void setHora_recogida(Time hora_recogida) {
		this.hora_recogida = hora_recogida;
	}
	public Time getHora_entrega() {
		return hora_entrega;
	}
	public void setHora_entrega(Time hora_entrega) {
		this.hora_entrega = hora_entrega;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public itinerarios(int id_itinerario, String nombre_empresa, String nombre_vehiculo, Date fecha_recogida,
			Date fecha_entrega, Time hora_recogida, Time hora_entrega, int aforo) {
		super();
		this.id_itinerario = id_itinerario;
		this.nombre_empresa = nombre_empresa;
		this.nombre_vehiculo = nombre_vehiculo;
		this.fecha_recogida = fecha_recogida;
		this.fecha_entrega = fecha_entrega;
		this.hora_recogida = hora_recogida;
		this.hora_entrega = hora_entrega;
		this.aforo = aforo;
	}
	public itinerarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "itinerarios [id_itinerario=" + id_itinerario + ", nombre_empresa=" + nombre_empresa
				+ ", nombre_vehiculo=" + nombre_vehiculo + ", fecha_recogida=" + fecha_recogida + ", fecha_entrega="
				+ fecha_entrega + ", hora_recogida=" + hora_recogida + ", hora_entrega=" + hora_entrega + ", aforo="
				+ aforo + "]";
	}
	
	
	
	
	
	
}
