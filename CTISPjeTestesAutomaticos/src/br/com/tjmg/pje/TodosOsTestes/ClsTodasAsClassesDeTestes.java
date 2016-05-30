package br.com.tjmg.pje.TodosOsTestes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tjmg.pje.Integracao.RegraDeNegocio.JUnit.ClsTestaMinhaPaginaJUnit;
import tjmg.pje.Integracao.RegraDeNegocio.JUnit.ClsTestaPaginaDeLoginPJE;
import tjmg.pje.Integracao.TestNG.Usuario.ClsTestaIncluirNovoProcesso;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaInclusaoDeUmProcesso;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	ClsTestaMinhaPaginaJUnit.class,
	ClsTestaPaginaDeLoginPJE.class,
	ClsPaginaInclusaoDeUmProcesso.class,
	ClsTestaIncluirNovoProcesso.class
	
	
	
})

public class ClsTodasAsClassesDeTestes 
{
	

}
