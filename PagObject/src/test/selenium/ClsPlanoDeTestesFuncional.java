package test.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import test.funcional.ClsConfiguracoesDoSelenium;
import test.funcional.ClsPaginaInicialDoSistema;
import test.funcional.ClsRealizaLoginNaAplicacao;



public class ClsPlanoDeTestesFuncional {
	
	protected static ClsConfiguracoesDoSelenium config = new ClsConfiguracoesDoSelenium();
	protected ClsRealizaLoginNaAplicacao PaginaLogin;
	protected ClsPaginaInicialDoSistema PaginaInicial;
		
	
	@BeforeMethod
	public static void setUpBeforeClass() throws Exception {
		
		config.getSiteApp();
	}

	@AfterMethod
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testLoginDeAlunos() {
		config.getSiteApp();
		
		
		
	}

}
