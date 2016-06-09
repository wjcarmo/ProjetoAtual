package br.com.ExecutorDosTestes;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.tjmg.pje.TodosOsTestes.ClsTodasAsClassesDeTestes;

public class ExecutaTodosOsMeusTestes {

	public static void main(String[] args) 
	{
		Result resultado = JUnitCore.runClasses(ClsTodasAsClassesDeTestes.class);
		
		System.out.println("Total de...: " + resultado.getRunCount() + " Testes Executado em " + resultado.getRunTime() + "ms" );
		
		System.out.println("Total de...: " + resultado.getIgnoreCount() + " Testes Ignorados");
		
		System.out.println("Total de...: " + resultado.getFailures().size() + " Falhas Encotradas ");
		
		for(Failure falhas : resultado.getFailures())
		{
			System.out.println(falhas.toString());
		}
		
		

	}

}
