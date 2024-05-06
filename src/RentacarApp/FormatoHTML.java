package RentacarApp;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FormatoHTML extends Formatter {
	@Override
	public String format(LogRecord record) {
		String usu, cont;
		String linea = record.getMessage();
		String[] cachos;
		cachos = linea.split(";");
		usu = cachos[0];
		cont = cachos[1];
		return "<tr>\n" + "<td>" + usu + "</td>\n" + "<td>" + cont + "</td>\n"+ "</tr>\n";
	}

	@Override
	public String getHead(Handler h) {
		return "<html>\n <head>\n  <link href=\"./style.css\" rel=\"stylesheet\">\n </head>\n <body> \n <table>\n <tr>\n <th>Usuario</th>\n <th>Contraseña</th>\n </tr>\n";
	}

	@Override
	public String getTail(Handler h) {
		return " </table>\n </body>\n </html>\n";
	}
}
