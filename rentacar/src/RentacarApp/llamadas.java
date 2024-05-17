package RentacarApp;

import RentacarApp.HacerReserva;

/**
 * @author Niko
 * 
 *         Ventana destinada a guardar algunos valores.
 * 
 */
public class llamadas {

	/**
	 * @param mili3 suma de los milisegundos que la cantidad de dias que tiene la
	 *              reserva
	 * @return devuelve un long de la cantidad de días que tiene la reserva
	 */
	public static long calcularDiasRestantes(long mili3) {

		long diasRestantes = 0;
		diasRestantes = (mili3 / 3600000) / 24;
		return diasRestantes;
	}

	/**
	 * @param horaRecogida
	 * @param minRecogida
	 * @param date1
	 * @return devuelve un String con la hora y fecha formateado corretamente.
	 */
	public static String guardarRecogida(int horaRecogida, int minRecogida, String date1) {

		String auxRecogida = date1 + " " + horaRecogida + ":" + minRecogida;
		System.out.println(auxRecogida);
		return auxRecogida;
	}

	/**
	 * @param horaEntrega
	 * @param minEntrega
	 * @param date2
	 * @return devuelve un String con la fecha y hora formateado correctamente
	 */
	public static String guardarEntrega(int horaEntrega, int minEntrega, String date2) {

		String auxEntrega = date2 + " " + horaEntrega + ":" + minEntrega;
		System.out.println(auxEntrega);
		return auxEntrega;
	}

}
