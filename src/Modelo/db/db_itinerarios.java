package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			System.err.println("Ha fallado el metodo getDni()");
		}
		
	return id_itinerario;	
	}
	
}
