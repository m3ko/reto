package Modelo;

public class reservas {

	public int id_reserva; //auto-incremental
	public String dni_persona;
	public String nombre_empresa;
	public String nombre_vehiculo;
	public int id_itinerario;
	public reservas(int id_reserva, String dni_persona, String nombre_empresa, String nombre_vehiculo,
			int id_itinerario) {
		super();
		this.id_reserva = id_reserva;
		this.dni_persona = dni_persona;
		this.nombre_empresa = nombre_empresa;
		this.nombre_vehiculo = nombre_vehiculo;
		this.id_itinerario = id_itinerario;
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public String getDni_persona() {
		return dni_persona;
	}
	public void setDni_persona(String dni_persona) {
		this.dni_persona = dni_persona;
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
	public int getId_itinerario() {
		return id_itinerario;
	}
	public void setId_itinerario(int id_itinerario) {
		this.id_itinerario = id_itinerario;
	}
	public reservas() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "reservas [id_reserva=" + id_reserva + ", dni_persona=" + dni_persona + ", nombre_empresa="
				+ nombre_empresa + ", nombre_vehiculo=" + nombre_vehiculo + ", id_itinerario=" + id_itinerario + "]";
	}
	
	
	
}
