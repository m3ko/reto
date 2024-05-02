package Modelo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
