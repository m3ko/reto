package RentacarApp;

import RentacarApp.HacerReserva;

public class llamadas {

	
	public static long calcularDiasRestantes(long mili3) {
		
		long diasRestantes=0;
		diasRestantes = (mili3/3600000)/24;
		return diasRestantes;
	}
	
	public static String guardarRecogida(int horaRecogida, int minRecogida, String date1) {
		
		String auxRecogida = date1 +" "+ horaRecogida +":"+ minRecogida;
		System.out.println(auxRecogida);
		return auxRecogida;
	}
	
	public static String guardarEntrega(int horaEntrega, int minEntrega, String date2) {
		
		String auxEntrega = date2 +" "+ horaEntrega +":"+ minEntrega;
		System.out.println(auxEntrega);
		return auxEntrega;
	}
	
	
}
