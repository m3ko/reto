package test;



import org.junit.jupiter.api.Test;

import RentacarAppTrbj.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario para comprobar la carga correcta del xml.
 * @author Niko
 */
public class xmlTest {

    @Test
    public void testCargarXml() throws IOException {
        // Crea un archivo XML de prueba
        String testXmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<peticion>\n" +
                "    <id>12345</id>\n" +
                "    <dni>67890</dni>\n" +
                "</peticion>";
        File testXmlFile = new File("test.xml");
        try (FileWriter writer = new FileWriter(testXmlFile)) {
            writer.write(testXmlContent);
        }

        // Simular la carga del XML
        xml.cargarXml();

        // Verificar que los valores se han cargado correctamente
        assertTrue(xml.id.equals("12345"), "El id debería ser 12345");
        assertTrue(xml.dni.equals("67890"), "El dni debería ser 67890");

        // Verificar condiciones incorrectas 
        assertFalse(xml.id.equals("54321"), "El id no debería ser 54321");
        assertFalse(xml.dni.equals("09876"), "El dni no debería ser 09876");

        // Elimina el archivo de prueba después del test
        assertTrue(testXmlFile.delete(), "El archivo de prueba debería ser eliminado");
    }
}