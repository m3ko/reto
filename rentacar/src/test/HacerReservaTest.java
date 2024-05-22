package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import RentacarApp.HacerReserva;

/**
 * Un test unitario para comprobar si calcula correctamente los días que quedan.
 * 
 * @author Niko
 */
class HacerReservaTest {

	/**
	 * Coge dos fechas, lo transforma en milisegundas, y se resta. Lo que queda se
	 * transforma en días.
	 * 
	 * @throws ParseException excepción
	 */
	@Test
	public void testCalculoDiasRestantes() throws ParseException {
		String fecha1Str = "2024-05-15";
		String fecha2Str = "2024-05-17";

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");

		Date fecha1 = formatoDelTexto.parse(fecha1Str);
		Date fecha2 = formatoDelTexto.parse(fecha2Str);

		long mili1 = fecha1.getTime();
		long mili2 = fecha2.getTime();
		long mili3 = mili2 - mili1;

		long diasRestantes = (mili3 / 3600000) / 24;

		HacerReserva.diasQuedan = diasRestantes;

		//Si hace el calculo bién saltará el assertTrue, si no, el assertFalse
		assertTrue(diasRestantes == 2, "Los días restantes deben de ser 2");
        assertFalse(diasRestantes != 2, "Los días restantes no puede ser otro que dos");
	}
}
