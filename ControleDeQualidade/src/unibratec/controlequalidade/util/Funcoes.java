package unibratec.controlequalidade.util;

import java.util.Calendar;
import java.util.Date;

public class Funcoes {

	// Método que retorna o resultado da subtração de duas datas
	public static long subtrairDiasDataCalendar(Calendar primeiraDataCalendar, Calendar seundaDataCalendar){

		Date primeiraDataDate = primeiraDataCalendar.getTime();     
		Date segundaDataDate = seundaDataCalendar.getTime();     
		
		long resultado = segundaDataDate.getTime() - primeiraDataDate.getTime();     
		
		System.out.println("Diferenca em dias: " + (resultado/1000/60/60/24));     

		return resultado/1000/60/60/24;
	}
	
}
