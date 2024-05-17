package Modelo;

/**
 * @author Niko
 * 
 *         Constructor de vehiculos.
 */
public class vehiculos {

	public String codigo_vehiculo;
	public String marca;
	public String modelo;
	public String tipo;
	public int año_fabricación;
	public int precio_alquiler;
	public String estado;
	public String cif_empresa;

	public String getCodigo_vehiculo() {
		return codigo_vehiculo;
	}

	public void setCodigo_vehiculo(String codigo_vehiculo) {
		this.codigo_vehiculo = codigo_vehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAño_fabricación() {
		return año_fabricación;
	}

	public void setAño_fabricación(int año_fabricación) {
		this.año_fabricación = año_fabricación;
	}

	public int getPrecio_alquiler() {
		return precio_alquiler;
	}

	public void setPrecio_alquiler(int precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCif_empresa() {
		return cif_empresa;
	}

	public void setCif_empresa(String cif_empresa) {
		this.cif_empresa = cif_empresa;
	}

	public vehiculos(String codigo_vehiculo, String marca, String modelo, String tipo, int año_fabricación,
			int precio_alquiler, String estado, String cif_empresa) {
		super();
		this.codigo_vehiculo = codigo_vehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.año_fabricación = año_fabricación;
		this.precio_alquiler = precio_alquiler;
		this.estado = estado;
		this.cif_empresa = cif_empresa;
	}

	public vehiculos() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "vehiculos [codigo_vehiculo=" + codigo_vehiculo + ", marca=" + marca + ", modelo=" + modelo + ", tipo="
				+ tipo + ", año_fabricación=" + año_fabricación + ", precio_alquiler=" + precio_alquiler + ", estado="
				+ estado + ", cif_empresa=" + cif_empresa + "]";
	}
}