package tjmg.pje.Integracao.TestNG.Usuario;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaInclusaoDeUmProcesso;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaValidaLoginPJE;

public class ClsTestaIncluirNovoProcesso
{

	
	private WebDriver driver;
	ClsPaginaInclusaoDeUmProcesso processo;
	ClsPaginaValidaLoginPJE paginaDeLogin;
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
		
	
	@BeforeMethod
	public void inicializa() throws InterruptedException
	{
		driver = new  FirefoxDriver(); 
		processo = new ClsPaginaInclusaoDeUmProcesso(driver);	
		paginaDeLogin  = new ClsPaginaValidaLoginPJE(driver); 
		
	}
	/*
	@AfterMethod
	public void fecharDriver() 
	{
		if (null != driver) 
		     { 
			     driver.quit(); 
			 }
		}
		*/

	 @Test
	  public void mTestaIncluirUmNovoProcesso() throws InterruptedException 
	  {
			//Entrada de dados para teste		
			// Requisito para testes Pagina de Login do Sistema PJe	
		 
			paginaDeLogin.setSiteParamentro("http://pjetreina.tjmg.jus.br/pje/login.seam?loginComCertificado=true");
			paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJAdvogado);
			paginaDeLogin.preencherSenha(recebeSenha);
			paginaDeLogin.clickBotaoEntrar();
				
			processo.clicarProcesso();
			
			Thread.sleep(3000);
							
			processo.clicarNovoProcesso();
			
			Thread.sleep(3000);
			
			processo.SelectSecao();
			Thread.sleep(3000);
			processo.SelectClasseJudicial();
			Thread.sleep(3000);
			processo.BotaoIncluirProcesso();
			Thread.sleep(3000);			
			processo.BotaoListaAssunto();
			Thread.sleep(3000);	
			processo.BotaoAdicionarPartes();
			Thread.sleep(3000);	
			processo.BotaoAdicionarPeticoes();
			Thread.sleep(3000);	
			processo.editarPeticoes();
			Thread.sleep(3000);	
			processo.BotaoSalvarPeticoes();			
			Thread.sleep(3000);	
			processo.BotaoAssinarPeticoes();
			Thread.sleep(3000);	
			processo.BotaoAssinarOk();
			
			
			
			
		
			
		   
							

	  }  
}
