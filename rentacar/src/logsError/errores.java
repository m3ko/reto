package logsError;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class errores {

	public static void numErrores(int numErr, String errTxt) {
		
		
		
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(
					new FileWriter(".\\logsErr\\logsfallos.txt", true));
			while (numErr != 00) {
				if (numErr == 01) {
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"Error: \"Ha fallado la conexión a la base de datos.\""+"\r\n");

				} else if (numErr == 02) {
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"Error: \"ha fallado la glase getEmpresas()\"");

				} else if (numErr == 03) {
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"Error: \"Ha fallado el metodo añadirEmpresa()\"");

				} else if(numErr==04){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"Error: \"Ha fallado el metodo updateTablaEmpresas\"");
					

				}else if(numErr==05){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"Error: \"Ha fallado el metodo generarItinerario()\"");
					

				}else if(numErr==06){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"Error: \"Ha fallado el metodo getId_itinerario()\"");
					

				}else if(numErr==07){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"\"Ha fallado el metodo getItinerarios()\"");
					

				}else if(numErr==8){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+"Error: \"Ha fallado el metodo updateFechas()\"");
					

				}else if(numErr==9){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==10){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==11){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==12){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==13){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==14){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==15){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==16){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==17){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==18){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==19){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==20){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==22){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==23){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==24){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==25){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==26){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==27){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==28){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==29){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==30){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==31){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==32){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==33){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==34){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==35){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==36){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==37){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==38){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==39){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==40){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==41){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}else if(numErr==42){
					bw.write("Fecha:"+ dateTime.format(formatters)+"\r\n"+errTxt);
					

				}
				bw.close();}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
