package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import org.junit.Before;
import org.junit.Test;

import RentacarApp.HacerReserva3;
import Modelo.vehiculos;

/**
 * 
 * Test unitario para comprobar que se meten datos en el comboBox despúes de
 * filtrar.
 * 
 * @author Niko
 */
public class HacerReserva3Test {
	private JComboBox<String> comboMarca;
	private JComboBox<String> comboModelo;
	private JTextArea textPrecio;
	private JTextArea txtrDescripcion;

	@Before
	public void setUp() {
		comboMarca = new JComboBox<>();
		comboModelo = new JComboBox<>();
		textPrecio = new JTextArea();
		txtrDescripcion = new JTextArea();

		// se simula el añadir marcas a un comboBox
		comboMarca.addItem("Toyota");
		comboMarca.addItem("Honda");
		comboModelo.addItem("Corolla");
		comboModelo.addItem("Civic");
	}

	@Test
	public void testMarcaSeleccionadaActualizaModelos() {
		// se simula elegir una marca
		comboMarca.setSelectedItem("Toyota");

		ArrayList<vehiculos> modelosPorMarca = new ArrayList<>();
		vehiculos vehiculo = new vehiculos("1", "Toyota", "Corolla", "Sedan", 2020, 50, "Disponible", "123ABC");
		modelosPorMarca.add(vehiculo);

		
		comboModelo.removeAllItems();
		for (vehiculos vehiculos : modelosPorMarca) {
			comboModelo.addItem(vehiculos.getModelo());
		}

		// si se actualiza el comboModelo == bien
		// si no se actualiza             == mal

		assertTrue(comboModelo.getItemCount() > 0);
		assertFalse(comboModelo.getItemCount() == 0);
	}
}
