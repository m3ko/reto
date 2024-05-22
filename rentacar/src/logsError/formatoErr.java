package logsError;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class formatoErr extends Formatter {
	/**
	 * Clase destinada a ficheros log con formato HTML, aqui se le da el formato.
	 * 
	 * @author Niko
	 *
	 * 
	 */
	@Override
	public String format(LogRecord record) {
		String err, txt;
		String linea = record.getMessage();
		String[] cachos;
		cachos = linea.split(";");
		err = cachos[0];
		txt = cachos[1];
		return "<tr>\n" + "<td>" + err + "</td>\n" + "<td>" + txt + "</td>\n" + "</tr>\n";
	}

	@Override
	public String getHead(Handler h) {
		return "<html>\n <head>\n  <link href=\"./style.css\" rel=\"stylesheet\">\n </head>\n <body> \n <table>\n <tr>\n <th>Codigo</th>\n <th>Error</th>\n </tr>\n";
	}

	@Override
	public String getTail(Handler h) {
		return " </table>\n </body>\n </html>\n";
	}
}
