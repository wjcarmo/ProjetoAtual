package tjmg.pje.Integracao.RegraDeNegocio.JUnit;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaValidaLoginPJE;


public class ClsTestaPaginaDeLoginPJE 
{
	
	
	private WebDriver driver;
	protected String recebeCPFCNPJMagistrado = "54335562047"; 
	protected String recebeCPFCNPJSecretaria = "25555553072"; 
	protected String recebeCPFCNPJAdvogado   = "62163250350"; 
	protected String recebeCPFCNPJAssessor   = "54335562047"; 
	protected String recebeCPFCNPJPublico    = "22222222222"; 	
	protected String recebeCPFCNPJProcuradorGestor = "45832820606"; 
	protected String recebeCPFCNPJOficialJudiciário = "00601534662"; 
	protected String recebeCPFCNPJAdvogadoAbdala = "81540248615"; 
	protected String recebeCPFCNPJMagistradoDelvan = "38030861672"; 
	protected String recebeCPFCNPJAssessorWellington = "98728016653"; 	
	protected String recebeSenha="tjmg"; 
	
	ClsPaginaValidaLoginPJE paginaDeLogin;
	
	
	//protected String recebeSite = "http://pjetreina.tjmg.jus.br/pje/login.seam?loginComCertificado=true";
	protected String recebeSite = "http://pjesup.intra.tjmg.gov.br/pje/login.seam";
	protected String retornaMensagem = "Os dados abaixo foram recuperados a partir da base de dados da Secretaria da Receita Federal do Brasil.!";
		
	
	
	@Before
	public void inicializarDriver() throws Exception 
	{ 
		 driver = new  FirefoxDriver();  
		 paginaDeLogin  = new ClsPaginaValidaLoginPJE(driver); 
	}
	
	@After
	public void fecharDriver() 
	{
		if (null != driver) 
		     { 
			     driver.quit(); 
			 }
		}
		
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Assessor no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 */
	
	@Test
	public void mTestaLoginNoSistemaPJEAssessor() throws InterruptedException 
	{
				
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJAssessorWellington);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();
				
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 
		
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "WELLINGTON MARTINS COSTA"); 
		
	   }
	
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Magistrado no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilMagistrado() throws InterruptedException 
	{
		
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);	
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJMagistradoDelvan);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();
					
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 		
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "DELVAN BARCELOS JÚNIOR"); 
		
	   }
	
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Advogado no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilAdvogado() throws InterruptedException 
	{  
		
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJAdvogado);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();
	
		
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 		
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "Aquilae Cygni"); 
		
	   }
	
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Público no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilPublico() throws InterruptedException 
	{
				
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);	
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJPublico);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();	
				
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 		
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "Velorum Andromedae"); 
		
	   }
		
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Secretaría no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilSecretaria() throws InterruptedException 
	{
				
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJSecretaria);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();
			
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 		
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "Pegasi Puppis"); 
		
	   }
	
	
	

}
