package com.br.tecwend.BancoDeDados;


import java.sql.DriverManager;
import java.sql.SQLException;

public class ClsConexaoBancoDeDados {
	
	/**
	 * Metodo de conexao com o banco de dados mysql, utilizando o JDBC, utiliza o Java.Sql.Conection
	 * @return 
	 * @throws SQLException 
	 */
	public static  java.sql.Connection getConnection()
	{
		try 
		{		
		   
			return DriverManager.getConnection("jdbc://localhost:3306/Tecwend", "root","" );
			
		} 
		catch (SQLException  e) 
		{
			
         System.out.println("ERRO..." + e);
		}

        return null;
		
		}
						
	
}
