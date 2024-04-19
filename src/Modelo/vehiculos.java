package Modelo;

public class vehiculos {

	public String codigo_vehiculo;
	public String marca;
	public String modelo;
	public String tipo;
	public String año_fabricación;
	public String precio_alquiler;
	public String estado;
	public vehiculos(String codigo_vehiculo, String marca, String modelo, String tipo, String año_fabricación,
			String precio_alquiler, String estado) {
		super();
		this.codigo_vehiculo = codigo_vehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.año_fabricación = año_fabricación;
		this.precio_alquiler = precio_alquiler;
		this.estado = estado;
	}
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
	public String getAño_fabricación() {
		return año_fabricación;
	}
	public void setAño_fabricación(String año_fabricación) {
		this.año_fabricación = año_fabricación;
	}
	public String getPrecio_alquiler() {
		return precio_alquiler;
	}
	public void setPrecio_alquiler(String precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public vehiculos() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "vehiculos [codigo_vehiculo=" + codigo_vehiculo + ", marca=" + marca + ", modelo=" + modelo + ", tipo="
				+ tipo + ", año_fabricación=" + año_fabricación + ", precio_alquiler=" + precio_alquiler + ", estado="
				+ estado + "]";
	}
	
	
	
	
	
}
