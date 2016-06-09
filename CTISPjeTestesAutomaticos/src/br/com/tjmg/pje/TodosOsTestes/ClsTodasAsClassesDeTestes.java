package br.com.tjmg.pje.TodosOsTestes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tjmg.pje.Integracao.RegraDeNegocio.JUnit.ClsTestaMinhaPaginaJUnit;
import tjmg.pje.Integracao.RegraDeNegocio.JUnit.ClsTestaPaginaDeLoginPJE;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	ClsTestaMinhaPaginaJUnit.class,
	ClsTestaPaginaDeLoginPJE.class,
	
	
})

public class ClsTodasAsClassesDeTestes 
{
	

}
