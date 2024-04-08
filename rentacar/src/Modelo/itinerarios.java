package Modelo;

import java.sql.Time;

public class itinerarios {

	public int id_itinerario; //auto-incremental
	public String nombre_empresa;
	public String nombre_vehiculo;
	public Time hora_recogida;
	public Time hora_entrega;
	public int aforo;
	
	public itinerarios(int id_itinerario, String nombre_empresa, String nombre_vehiculo, Time hora_recogida,
			Time hora_entrega, int aforo) {
		super();
		this.id_itinerario = id_itinerario;
		this.nombre_empresa = nombre_empresa;
		this.nombre_vehiculo = nombre_vehiculo;
		this.hora_recogida = hora_recogida;
		this.hora_entrega = hora_entrega;
		this.aforo = aforo;
	}
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
	public itinerarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "itinerarios [id_itinerario=" + id_itinerario + ", nombre_empresa=" + nombre_empresa
				+ ", nombre_vehiculo=" + nombre_vehiculo + ", hora_recogida=" + hora_recogida + ", hora_entrega="
				+ hora_entrega + ", aforo=" + aforo + "]";
	}
	
	
	
	
}
