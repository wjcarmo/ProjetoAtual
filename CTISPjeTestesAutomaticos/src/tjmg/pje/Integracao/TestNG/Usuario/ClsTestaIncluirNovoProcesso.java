package tjmg.pje.Integracao.TestNG.Usuario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import br.com.tjmg.pje.Evidencias.ClsPrintScreenShotEvidenciaPositivasENegativas;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaInclusaoDeUmProcesso;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaValidaLoginPJE;

@Listeners(ClsPrintScreenShotEvidenciaPositivasENegativas.class)
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
	
	@AfterMethod
	public void fecharDriver() throws IOException 
	{
		if (null != driver) 
		     { 
				mPrintScreenEvidenciaNegativasEPossitivas();
				driver.quit(); 
			     
			 }
		}
	
	public void mPrintScreenEvidenciaNegativasEPossitivas() throws IOException
	{
	    
			// Criação do objeto do tipo FILE e tirando uma screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Salvando a screenshot. 
			FileUtils.copyFile(scrFile, new File("/CTISPjeTestesAutomaticos/Arquivo/ClsTestaIncluirNovoProcesso.png"));
					
	}
	

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
			
			Thread.sleep(1000);
							
			processo.clicarNovoProcesso();
			
			Thread.sleep(1000);
			
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
						
			processo.btnAdicionarPartesAtivo();
			Thread.sleep(3000);	
			
			processo.DigitarCPFCNPJPartesAtivo();
			Thread.sleep(3000);
					
			
			processo.btnPesquisarCPFCNPJ();
			Thread.sleep(3000);
			
			
			processo.btnConfirmarCPFCNPJ();
			Thread.sleep(3000);
			  
			
			processo.btnInserirAtivo();
			Thread.sleep(3000);	
			
			processo.btnInserirCPFCNPJAtivo();
			Thread.sleep(3000);
			
			processo.btnAdicionarPartesPassivo();
			Thread.sleep(3000);		
			
			processo.DigitarCPFCNPJPartesPassivo();
			Thread.sleep(3000);	
			
			processo.btnPesquisarCPFCNPJ();
			Thread.sleep(3000);	
			
			processo.SelectDocumento();
			Thread.sleep(3000);	
			
			processo.editarNomeAlcunha();
			Thread.sleep(3000);	
			
			processo.btnConfirmarDocumentoPassivo();
			Thread.sleep(3000);
					
			processo.btnEnderecos();
			Thread.sleep(3000);
			
			processo.btnEnderecoDesconhecido();
			Thread.sleep(3000);
							
			processo.btnInserirReu();
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
			Thread.sleep(3000);	
			
			//processo.BotaoErroOk();
			//Thread.sleep(3000);	
			
			processo.BotaoProcesso();	
			Thread.sleep(3000);	
			
			processo.BotaoProtocolar();	
			Thread.sleep(5000);	
										

	  }  
}
