package com.br.tecwend.BancoDeDados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.tjmg.pje.interfaces.ClsProcessoNoSistema;

public class ClsLerArquivoDeDados
{
	
	public ClsLerArquivoDeDados() 
	{
		super();
		this.arquivo = arquivo;
	}

	File arquivo = new File("C:\\CTIS\\Processos.txt"); 
	
	public List<String> ObterlistaDeProcessos()
	{
		List<String> listaDeProcessos = new ArrayList<String>();
	
		boolean existe = arquivo.exists();  
		
		try 
		{
			arquivo.createNewFile();
			arquivo.mkdir();
			
			File[] arquivos = arquivo.listFiles();
			
			FileReader ler = new FileReader(arquivo);
			
			BufferedReader br = new BufferedReader(ler);
			
			
			while(br.ready())
			{
				String linha =  br.readLine();
				System.out.println("coteudo "+linha);
				listaDeProcessos.add(linha);
				
			}
			return listaDeProcessos; 
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		return listaDeProcessos; 
		
	}
	
	
	

}
