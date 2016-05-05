package br.com.seleniumgridewebdriverconversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ClsConversorDeTemperatura 
{
	private final static Integer SCALE = 6; 
	private static Double valor = null; 
		
	/**
	 * Atribui um BigDecimal que recebendo o valor de um Double e que ao final é lhe aplicado uma escala
	 * @param valor
	 * @return retorna o valor em Double
	 */
	
	public static Double aplicarScala(Double valor) 
	{
	  BigDecimal bd = new BigDecimal(valor).setScale(SCALE, RoundingMode.HALF_EVEN); 
	  
	  return bd.doubleValue(); 
	  
	 } 
	   	
	/**
	 * Conversão do valor de Celsius para Fahrenheit, Atribui o valor em Double convertida de uma String
	 * @param celsius
	 * @return Retorna uma String convertida de um valor Double onde lhe foi aplicado uma escala
	 */
	public static String celsiusParaFahrenheit(String celsius) 
	{ 
	   valor = Double.parseDouble(celsius); 
	   
	   return String.valueOf(aplicarScala(1.8 * valor + 32.0)); 
	 } 
		
	/**
	 *  Conversão do valor de Fahrenheit para Celsius, Atribui o valor em Double convertida de uma String 
	 * @param fahrenheit
	 * @return Retorna uma String convertida de um valor Double onde lhe foi aplicado uma escala 
	 */
	
	public static String fahrenheitParaCelsius(String fahrenheit) 
	{ 
	   valor = Double.parseDouble(fahrenheit); 
	   
	   return String.valueOf(aplicarScala((5.0 * (valor - 32.0) / 9.0))); 
	}

}
