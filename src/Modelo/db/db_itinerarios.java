package Modelo.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import Modelo.itinerarios;
import RentacarApp.HacerReserva;
import RentacarApp.HacerReserva3;

public class db_itinerarios {

	public static void generarItinerario() {
		
		String cif_empresa = HacerReserva3.cifEmpresaAux.toString();
		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();
		String fecha_recogida = HacerReserva.date1aux.toString();
		String fecha_entrega = HacerReserva.date2aux.toString();
		String hora_recogida = HacerReserva.hora1aux.toString();
		String min_recogida = HacerReserva.min1aux.toString();
		String hora_entrega = HacerReserva.hora2aux.toString();
		String min_entrega = HacerReserva.min2aux.toString();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `itinerarios`(`cif_empresa`, `codigo_vehiculo`, `fecha_entrega`, `fecha_recogida`, `hora_recogida`, `hora_entrega`, `aforo`) VALUES ('"+cif_empresa+"','"+codigo_vehiculo+"','"+fecha_entrega+"','"+fecha_recogida+"','"+hora_recogida+":"+min_recogida+":00','"+hora_entrega+":"+min_entrega+":00','0')";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");


		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo generarItinerario()");
		}
	}
	
	public static int getId_itinerario() {
		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();
		
		int id_itinerario = 0;
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "SELECT id_itinerario FROM `itinerarios` WHERE codigo_vehiculo='"+codigo_vehiculo+"';";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {

				id_itinerario = rs.getInt("id_itinerario");

			}

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo getId_itinerario()");
		}
		
	return id_itinerario;	
	}
	
	public static ArrayList<itinerarios> getItinerarios(int aux){
		
		ArrayList<itinerarios> listaItinerarios = new ArrayList();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "SELECT * FROM `itinerarios` WHERE id_itinerario = '"+aux+"';";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql funciona");

			while (rs.next()) {
				
				int id_itinerario = rs.getInt("id_itinerario");
				String cif_empresa = rs.getString("cif_empresa");
				String codigo_vehiculo = rs.getString("codigo_vehiculo");
				Date fecha_entrega = rs.getDate("fecha_entrega");
				Date fecha_recogida = rs.getDate("fecha_recogida");
				Time Hora_recogida = rs.getTime("hora_recogida");
				Time Hora_entrega = rs.getTime("hora_entrega");
				int aforo = rs.getInt("aforo");
				
				itinerarios itinerarios = new itinerarios(0, null, null, null, null, null, null, 0);
				
				itinerarios.setId_itinerario(id_itinerario);
				itinerarios.setCif_empresa(cif_empresa);
				itinerarios.setCodigo_vehiculo(codigo_vehiculo);
				itinerarios.setFecha_entrega(fecha_entrega);
				itinerarios.setFecha_recogida(fecha_recogida);
				itinerarios.setHora_recogida(Hora_recogida);
				itinerarios.setHora_entrega(Hora_entrega);
				itinerarios.setAforo(aforo);
				
				listaItinerarios.add(itinerarios);
			}

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo getItinerarios()");
		}
		
		return listaItinerarios;
	}
	
}
