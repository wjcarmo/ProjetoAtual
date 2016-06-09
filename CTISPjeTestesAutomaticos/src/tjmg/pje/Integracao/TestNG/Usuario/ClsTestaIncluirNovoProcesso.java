package tjmg.pje.Integracao.TestNG.Usuario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.tjmg.pje.Evidencias.ClsPrintScreenBase;
import br.com.tjmg.pje.interfaces.ClsEnumTipoDriver;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaInclusaoDeUmProcesso;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaValidaLoginPJE;


public class ClsTestaIncluirNovoProcesso extends ClsPrintScreenBase
{
		
	protected static WebDriverWait wait;
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
	protected String recebeSite = "http://pjesup.intra.tjmg.gov.br/pje/login.seam";

	ExtentReports report;
	ExtentTest logger;
	String BROWSER; 
			
	
	@BeforeMethod
	public void inicializa() throws InterruptedException
	{
			// Atribuição da instância do Enum do Tipo Firefox 
			//ClsEnumTipoDriver selecionadoTipoDriver = ClsEnumTipoDriver.FIREFOX; 
			// Atribuição das capacidades para usar o tipo driver Firefox 
			//DesiredCapabilities capacidadesDesejadas = selecionadoTipoDriver.obterCapacidadesDesejadas(); 
							
			
			//linha de comando para usar uma maquina virtual do virtualbox.
			//driver = selecionadoTipoDriver.obterObjetoWebDriverRemoto( capacidadesDesejadas, Platform.LINUX, "http://192.168.1.15:4444/wd/hub"); 
			// driver =  selecionadoTipoDriver.obterObjetoWebDriver(capacidadesDesejadas); 	
		    
		
			driver = new  FirefoxDriver(); 			       
			
		  		//BROWSER DO IE
			    //System.setProperty("webdriver.ie.driver", "C://Apresentacao//WebDriver//CTISPjeTestesAutomaticos//Arquivo//IEDriverServer.exe"); 
			    //driver = new InternetExplorerDriver();
		      
		    	//BROWSER DO CHOMER
			    //System.setProperty("webdriver.chrome.driver", "C://Apresentacao//WebDriver//CTISPjeTestesAutomaticos//Arquivo//chromedriver.exe"); 
			    //driver = new ChromeDriver();
		
			    processo = new ClsPaginaInclusaoDeUmProcesso(driver);	
			    paginaDeLogin  = new ClsPaginaValidaLoginPJE(driver); 
			  
		
	}
	
	@AfterMethod
	public void fecharDriver() throws IOException 
	{	
		if (null != driver) 
		     { 
				driver.quit(); 
			  }
			
		}
	

	 @Test
	  public void mTestaIncluirUmNovoProcesso() throws InterruptedException, Exception 
	  {
			//Entrada de dados para teste		
			// Requisito para testes Pagina de Login do Sistema PJe	
		 
		    report=new ExtentReports("./Relatorios\\mTestaIncluirUmNovoProcesso.html");
	     
		    logger=report.startTest("Rotina de Incluir um novo processo");
		     
			paginaDeLogin.setSiteParamentro("http://pjetreina.tjmg.jus.br/pje/login.seam?loginComCertificado=true");
			//paginaDeLogin.setSiteParamentro("http://pjesup.intra.tjmg.gov.br/pje/login.seam");
			
			logger.log(LogStatus.INFO, "Browser Firefox iniciado ");
			
			paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJAdvogado);
			paginaDeLogin.preencherSenha(recebeSenha);
			paginaDeLogin.clickBotaoEntrar();
			
			logger.log(LogStatus.INFO, "Sistema PJe em Execução");
			
			logger.log(LogStatus.PASS, "Processo Incluido com Sucesso");
			
			report.endTest(logger);
		    report.flush();
			 
			
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
			Thread.sleep(5000);	
			
			processo.apply(driver);
			
			processo.BotaoAssinarPeticoes();
			Thread.sleep(3000);	
			
			processo.BotaoAssinarOk();
			Thread.sleep(3000);	
			
			//processo.BotaoErroOk();
			//Thread.sleep(3000);	
			
			processo.BotaoProcesso();	
			Thread.sleep(3000);	
				
			
			processo.BotaoProtocolar();	
			Thread.sleep(3000);
			
			
			// Cria um diretório "screenshots" na raiz do projeto
			new File("PrintEvidencias/").mkdirs();
			// Obtém um screenshot
			File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
			// Cria um arquivo dentro do diretório "PrintEvidencias"
		    FileUtils.copyFile(PJe, new File("./PrintEvidencias\\mTestaIncluirUmNovoProcesso-print.png"));
			
			 // report with snapshot
	      	String img = logger.addScreenCapture("C:\\Apresentacao\\WebDriver\\CTISPjeTestesAutomaticos\\PrintEvidencias\\mTestaIncluirUmNovoProcesso-print.png");
	    
	        logger.log(LogStatus.INFO, "Image", "Print da Tela: " + img);
			
		
			logger.log(LogStatus.PASS, "Processo Incluido com Sucesso");
			
			report.endTest(logger);
		    report.flush();
		    
										

	  }  
}
