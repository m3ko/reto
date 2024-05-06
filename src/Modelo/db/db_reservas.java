package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.reservas;
import RentacarApp.HacerReserva3;
import RentacarApp.Pagar;

public class db_reservas {

	public static void hacerReserva() {
		String codigo_vehiculo = HacerReserva3.codigoVehiculoAux.toString();
		String dni_persona = Pagar.dniAux.toString();
		String cif_empresa = HacerReserva3.cifEmpresaAux.toString();
		int id_itinerario = Modelo.db.db_itinerarios.getId_itinerario();
		Connection con = Modelo.db.db_connect.conexion();
		System.out.println("se ha conectao");

		try {

			Statement st = con.createStatement();
			String sql = "INSERT INTO `reservas`(`dni`, `cif_empresa`, `codigo_vehiculo`, `id_itinerario`) VALUES ('"
					+ dni_persona + "', '" + cif_empresa + "', '" + codigo_vehiculo + "', '" + id_itinerario + "');";
			System.out.println(sql);
			st.execute(sql);
			System.out.println("sql funciona");

		} catch (SQLException e) {
			System.err.println("Ha fallado el metodo hacerReserva()");
		}
		Modelo.db.db_vehiculos.setVendido();

	}

	public static ArrayList<reservas> getReservas() {

		Connection connect = Modelo.db.db_connect.conexion();
		String mail = RentacarApp.Login.mailAux.toString();
		String dniAux = db_personas.getDni(mail);
		ArrayList<reservas> listaReservas = new ArrayList<>();
		try {

			Statement st = connect.createStatement();
			String sql = "SELECT id_reserva, id_itinerario FROM `reservas` WHERE dni='" + dniAux + "';";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id_reserva = rs.getInt("id_reserva");
				int id_itinerario = rs.getInt("id_itinerario");

				reservas reservas = new reservas(0, null, null, null, 0);

				reservas.setId_reserva(id_reserva);
				reservas.setId_itinerario(id_itinerario);
				listaReservas.add(reservas);

			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaReservas;
	}

}
