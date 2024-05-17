package Modelo;

/**
 * @author Niko
 * 
 *         Constructor de reservas
 */
public class reservas {

	public int id_reserva; // auto-incremental
	public String dni_persona;
	public String cif_empresa;
	public String cod_vehiculo;
	public int id_itinerario;

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

	public String getCif_empresa() {
		return cif_empresa;
	}

	public void setCif_empresa(String cif_empresa) {
		this.cif_empresa = cif_empresa;
	}

	public String getCod_vehiculo() {
		return cod_vehiculo;
	}

	public void setCod_vehiculo(String cod_vehiculo) {
		this.cod_vehiculo = cod_vehiculo;
	}

	public int getId_itinerario() {
		return id_itinerario;
	}

	public void setId_itinerario(int id_itinerario) {
		this.id_itinerario = id_itinerario;
	}

	public reservas(int id_reserva, String dni_persona, String cif_empresa, String cod_vehiculo, int id_itinerario) {
		super();
		this.id_reserva = id_reserva;
		this.dni_persona = dni_persona;
		this.cif_empresa = cif_empresa;
		this.cod_vehiculo = cod_vehiculo;
		this.id_itinerario = id_itinerario;
	}

	public reservas() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "reservas [id_reserva=" + id_reserva + ", dni_persona=" + dni_persona + ", cif_empresa=" + cif_empresa
				+ ", cod_vehiculo=" + cod_vehiculo + ", id_itinerario=" + id_itinerario + "]";
	}

}
