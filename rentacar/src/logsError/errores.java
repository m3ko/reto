package logsError;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class errores {
	public static Logger logError;


	public static void erroreslog() {
		logError = Logger.getLogger("Logger");

		logError.setLevel(Level.WARNING);
		logError.setUseParentHandlers(false);
		Handler consoleHandler = new ConsoleHandler();
		Handler fileHandler = null;
		logError.addHandler(consoleHandler);
		consoleHandler.setLevel(Level.WARNING);
		try {
			fileHandler = new FileHandler(".\\logsErr\\errores.html", true);
			logError.addHandler(fileHandler);
			fileHandler.setFormatter(new logsError.formatoErr());
		} catch (SecurityException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
