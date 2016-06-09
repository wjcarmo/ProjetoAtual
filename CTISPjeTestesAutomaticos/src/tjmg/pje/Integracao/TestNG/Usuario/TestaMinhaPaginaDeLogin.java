package tjmg.pje.Integracao.TestNG.Usuario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tjmg.pje.Interface.Usuario.WebDriver.MinhaPaginaDeLogin;

public class TestaMinhaPaginaDeLogin
{
	
	private WebDriver drive;
	private String varNome = "Wenderson";
	private String varSenha= "123"; 
	protected String recebeSite = "http://localhost:8080/PaginaDeTestesWeb/FormLogin.html";
	
	
	
	@BeforeClass 
	public void inicializarDriver() throws Exception 
	{ 
	  drive = new  FirefoxDriver(); 		
     //System.setProperty("webdriver.chrome.driver", "C:\\CTIS\\chromedriver.exe");
	 //WebDriver  drive = new ChromeDriver();
	}
	
	@AfterClass 
	public void fecharDriver() 
	{
		if (null != drive) 
		     { 
			     drive.quit(); 
			 }
		}
	
	
	/**
	 * Caso de teste que irá testa a funcionalidade do requisito de Logar na Aplicação
	 * @throws InterruptedException
	 */
	
	@Test
	public void mTestaMinhaPaginaDeLogin() throws InterruptedException
	{

		// O cenario de Teste LOgin
		MinhaPaginaDeLogin login = new MinhaPaginaDeLogin(drive);
			    
		//Parametros de entrada para a realização dos testes
		login.setSiteParamentro(recebeSite);		
		login.preencherCPFCNPJ(varNome);
		login.preencherSenha(varSenha);
		login.clickBotaoEntrar();				
		
		//Validação dos dados de saida obtidos, conforme a especificação do Requisito Login.
		Assert.assertEquals(varNome, "Wenderson");
		Assert.assertEquals(varSenha, "123");
	}
	
	/**
	 * Caso de teste que irá testa a funcionalidade do requisito de Logar na Aplicação
	 * @throws InterruptedException
	 */
	
	@Test
	public void mTestaMinhaPaginaDeLoginDadosInvalidos() throws InterruptedException
	{
		
		// O cenario de Teste LOgin
		MinhaPaginaDeLogin login = new MinhaPaginaDeLogin(drive);
			    
		//Parametros de entrada para a realização dos testes
		login.setSiteParamentro(recebeSite);		
		login.preencherCPFCNPJ(varNome);
		login.preencherSenha(varSenha);
		login.clickBotaoEntrar();				
		
		//Validação dos dados de saida obtidos, conforme a especificação do Requisito Login.
		Assert.assertNotEquals(varNome, "Wenderson2");
		Assert.assertNotEquals(varSenha, "1234");
		
	}


}
