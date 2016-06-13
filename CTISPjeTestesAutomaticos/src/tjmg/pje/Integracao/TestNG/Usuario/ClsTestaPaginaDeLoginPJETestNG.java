package tjmg.pje.Integracao.TestNG.Usuario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.tjmg.pje.Evidencias.ClsEvidenciaDeExecucaoDosTestes;
import br.com.tjmg.pje.Evidencias.ClsPrintScreenBase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.DisplayOrder;














import tjmg.pje.Integracao.RegraDeNegocio.JUnit.ClsPrintScreenShotsComJUnit;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaValidaLoginPJE;


public class ClsTestaPaginaDeLoginPJETestNG extends ClsPrintScreenBase
{
	
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
	ClsEvidenciaDeExecucaoDosTestes evidencias;
	
    
    ExtentReports report;
    ExtentTest logger;
    ExtentTest node;
    
    String result = "Falhou"; 
        
    
	//protected String recebeSite = "http://pjetreina.tjmg.jus.br/pje/login.seam?loginComCertificado=true";
	protected String recebeSite = "http://pjesup.intra.tjmg.gov.br/pje/login.seam";
	protected String retornaMensagem = "Os dados abaixo foram recuperados a partir da base de dados da Secretaria da Receita Federal do Brasil.!";
	
	
	@BeforeMethod
	public void inicializarDriver() throws Exception 
	{ 
		 driver = new  FirefoxDriver();  
		 paginaDeLogin  = new ClsPaginaValidaLoginPJE(driver);
		 
		 report=new ExtentReports("./Relatorios\\RelatorioDeExecucaoDeTestes.html",false);

		
				 	
	}
	
	@BeforeTest
	public void gerarRelatorioPrincipal()
	{
		ExtentReports extent = new ExtentReports("CTISPjeTestesAutomaticos",true);
		 
		 extent.assignProject("Projeto do PJe");
		 extent.getProjectName();
		 
		 report=new ExtentReports("./Relatorios\\ResultadoDosTestes.html");
			
		 logger=report.startTest("Inicio dos testes");	

		 logger.assignCategory("Testes de Regressao");
		 
		 //ExtentReports extent = new ExtentReports(file-path, false);
			  
		
		
		
	}
	
	@AfterMethod
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
	 * @throws Exception 
	 */
	
	@Test
	public void mTestaLoginNoSistemaPJEAssessor() throws InterruptedException, Exception 
	{
						
		logger=report.startTest("Teste do Login - Perfil Assessor");	
		
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);
		
	    logger.log(LogStatus.INFO, "Iniciando o Sistema ");
	    
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJAssessorWellington);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();
		 
		logger.log(LogStatus.INFO, "Sistema em Execucao");
				
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 
		
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "WELLINGTON MARTINS COSTA");
		
				
		// Cria um diretório "screenshots" na raiz do projeto
		new File("PrintEvidencias/").mkdirs();
		// Obtém um screenshot
		File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
		// Cria um arquivo dentro do diretório "PrintEvidencias"
	    FileUtils.copyFile(PJe, new File("./PrintEvidencias\\mTestaLoginNoSistemaPJEAssessor-print.png"));
		
		 // report with snapshot
      	String img = logger.addScreenCapture("C:\\Apresentacao\\WebDriver\\CTISPjeTestesAutomaticos\\PrintEvidencias\\mTestaLoginNoSistemaPJEAssessor-print.png");
    
        logger.log(LogStatus.INFO, "Image", "Print da Tela: " + img);
       
		logger.log(LogStatus.PASS, "Testes Realizados com Sucesso");
		logger.assignAuthor("Wenderson Jose do Carmo"); 
		
		logger.assignCategory("Testes Exploratorios");
		  
		  
	    logger.setDescription("Metodo que Valida o login dos usuarios no sistema PJe");
	    logger.getDescription();
 
	 
	    report.getClass();   
	    report.endTest(logger);
	    report.flush();
		
	   }
	
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Magistrado no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 * @throws Exception 
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilMagistrado() throws InterruptedException, Exception 
	{
				
		//report=new ExtentReports("./Relatorios\\mTestaLoginNoSistemaPJEPerfilMagistrado.html");
		
		logger=report.startTest("Teste do Login - Perfil Magistrado");	
		
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);
		 logger.log(LogStatus.INFO, "Iniciando o Sistema ");
		 
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJMagistradoDelvan);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();
		
		logger.log(LogStatus.INFO, "Sistema em Execucao");
		
					
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 		
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "DELVAN BARCELOS JÚNIOR"); 
		
		// Cria um diretório "screenshots" na raiz do projeto
	 	new File("PrintEvidencias/").mkdirs();
	    // Obtém um screenshot
		File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
							
		// Cria um arquivo dentro do diretório "PrintEvidencias"
		FileUtils.copyFile(PJe, new File("./PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilMagistrado-print.png"));
					   
		 // report with snapshot
		 String img = logger.addScreenCapture("C:\\Apresentacao\\WebDriver\\CTISPjeTestesAutomaticos\\PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilMagistrado-print.png");
		 logger.log(LogStatus.INFO, "Image", "Print da Tela: " + img);
			
		
		logger.log(LogStatus.PASS, "Testes Realizados com Sucesso");
		logger.assignAuthor("Analista de Teste II"); 
		logger.assignCategory("Testes de Regressao");
		
		  
	    logger.setDescription("Metodo que Valida o login dos usuarios no sistema PJe");
	    logger.getDescription();
	    
	    report.getClass();   
	    report.endTest(logger);
	    report.flush();
		
	   }
	
		
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Público no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 * @throws Exception 
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilPublico() throws InterruptedException, Exception 
	{
		//report=new ExtentReports("./Relatorios\\mTestaLoginNoSistemaPJEPerfilPublico.html");	
		
		logger=report.startTest("Teste do Login - Perfil Publico");	
		 
		//Entrada de dados para teste
		paginaDeLogin.setSiteParamentro(recebeSite);
		logger.log(LogStatus.INFO, "Iniciando o Sistema ");
			
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJPublico);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();	
		
		logger.log(LogStatus.INFO, "Sistema em Execucao");
				
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 		
		Assert.assertNotEquals(paginaDeLogin.getSelectUsuarioLogado(), "Velorum Andromedae"); 
		
		
		
		// Cria um diretório "screenshots" na raiz do projeto
	 	new File("PrintEvidencias/").mkdirs();
	    // Obtém um screenshot
		File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
							
		// Cria um arquivo dentro do diretório "PrintEvidencias"
		FileUtils.copyFile(PJe, new File("./PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilPublico-print.png"));
					   
		 // report with snapshot
		 String img = logger.addScreenCapture("C:\\Apresentacao\\WebDriver\\CTISPjeTestesAutomaticos\\PrintEvidencias\\Passou-TestResult-mTestaLoginNoSistemaPJEAssessor-print.png");
		 logger.log(LogStatus.INFO, "Image", "Print da Tela: " + img);
		 
		 
		
		
		logger.log(LogStatus.PASS, "Testes Realizados com Sucesso");
		logger.assignAuthor("Analista de Teste I"); 
		logger.assignCategory("Testes de Regressao");
		
		  
	    logger.setDescription("Metodo que Valida o login dos usuarios no sistema PJe");
	    logger.getDescription();
	    
	    report.getClass();   
	    report.endTest(logger);
	    report.flush();
		
	   }
		
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Secretaría no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 * @throws Exception 
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilSecretaria() throws InterruptedException, Exception 
	{
		
		try 
		{
			//report=new ExtentReports("./Relatorios\\mTestaLoginNoSistemaPJEPerfilSecretaria.html");
			logger=report.startTest("Teste do Login - Perfil Magistrado");	
			
			//Entrada de dados para teste
			paginaDeLogin.setSiteParamentro(recebeSite);
			logger.log(LogStatus.INFO, "Iniciando o Sistema ");
				
			paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJSecretaria);
			paginaDeLogin.preencherSenha(recebeSenha);
			paginaDeLogin.clickBotaoEntrar();
			
			logger.log(LogStatus.INFO, "Sistema em Execucao");
			
			//Retorno esperado depois da realização dos testes
			// Verifica se são iguais, o resultado com o esperado 		
			
			Assert.assertNotEquals(paginaDeLogin.getSelectUsuarioLogado(), "Pegasi Puppis");
			//Assert.assertEquals(paginaDeLogin.recebeMensagem(), "Pegasi Puppis");
			
			
			// Cria um diretório "screenshots" na raiz do projeto
		 	new File("PrintEvidencias/").mkdirs();
		    // Obtém um screenshot
			File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
								
			// Cria um arquivo dentro do diretório "PrintEvidencias"
			FileUtils.copyFile(PJe, new File("./PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilSecretaria-print.png"));
						   
			 // report with snapshot
			 String img = logger.addScreenCapture("C:\\Apresentacao\\WebDriver\\CTISPjeTestesAutomaticos\\PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilSecretaria-print.png");
			 logger.log(LogStatus.INFO, "Image", "Print da Tela: " + img);
			
			logger.log(LogStatus.FAIL, "Falha no Login do usuario");
			logger.assignAuthor("Wenderson Jose do Carmo"); 
			logger.assignCategory("Testes de Regressao");
			
			  
		    logger.setDescription("Metodo que Valida o login dos usuarios no sistema PJe");
		    logger.getDescription();
		    
		    report.getClass();   
		    report.endTest(logger);
		    report.flush();
			
		} 
		catch (Exception e) 
		{
			// Cria um diretório "screenshots" na raiz do projeto
		 	new File("PrintEvidencias/").mkdirs();
		    // Obtém um screenshot
			File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
								
			// Cria um arquivo dentro do diretório "PrintEvidencias"
			FileUtils.copyFile(PJe, new File("./PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilSecretaria-print.png"));
						   
			 // report with snapshot
			 String img = logger.addScreenCapture("C:\\Apresentacao\\WebDriver\\CTISPjeTestesAutomaticos\\PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilSecretaria-print.png");
			 logger.log(LogStatus.INFO, "Image", "Print da Tela: " + e);
			
			logger.log(LogStatus.FAIL, "O Teste Falhou");
			
			logger.assignAuthor("Wenderson Jose do Carmo"); 
			
			logger.assignCategory("Testes de Regressao");
					
			  
		    logger.setDescription("Metodo que Valida o login dos usuários no sistema PJe");
		    logger.getDescription();
		    
		    report.getClass();   
		    report.endTest(logger);
		    report.flush();
			
			
		}
		
		
		
	   }
	
	/**
	 * Caso de testes que irá testar o login do usuário com o perfil de Advogado no sistema PJe
	 * @throws InterruptedException O sistema lança uma exceção caso o site esteja fora do ar.
	 * @throws Exception 
	 */
	@Test 	
	public void mTestaLoginNoSistemaPJEPerfilAdvogado() throws InterruptedException, Exception 
	{  
	
		logger=report.startTest("Teste do Login - Perfil Advogado");	
		logger.log(LogStatus.INFO, "Iniciando o Sistema ");
		
		paginaDeLogin.setSiteParamentro(recebeSite);
			
		//Entrada de dados para teste
		paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJAdvogadoAbdala);
		paginaDeLogin.preencherSenha(recebeSenha);
		paginaDeLogin.clickBotaoEntrar();
		
		logger.log(LogStatus.INFO, "Sistema em Execucao");
			
		//Retorno esperado depois da realização dos testes
		// Verifica se são iguais, o resultado com o esperado 
		Assert.assertEquals(paginaDeLogin.getSelectUsuarioLogado(), "ABDALA LOBO ANTUNES"); 
		
		// Cria um diretório "screenshots" na raiz do projeto
	 	new File("PrintEvidencias/").mkdirs();
	    // Obtém um screenshot
		File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
		// Cria um arquivo dentro do diretório "PrintEvidencias"
		FileUtils.copyFile(PJe, new File("./PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilAdvogado-print.png"));
	    // report with snapshot
		String img = logger.addScreenCapture("C:\\Apresentacao\\WebDriver\\CTISPjeTestesAutomaticos\\PrintEvidencias\\mTestaLoginNoSistemaPJEPerfilAdvogado-print.png");
		logger.log(LogStatus.INFO, "Image", "Print da Tela: " + img);
		
		logger.log(LogStatus.PASS, "Testes Realizados com Sucesso");
		logger.assignAuthor("Wenderson Jose do Carmo"); 
		logger.assignCategory("Testes de Regressao");
	  
	    logger.setDescription("Metodo que Valida o login dos usuarios no sistema PJe");
	    logger.getDescription();
	    
	    report.getClass();   
	    report.endTest(logger);
	    report.flush();
	}
	
	public void onTestSuccess(ITestResult result)
	{

		System.out.println("Log de Testes "+result.toString());
	}
	
	
	
	
	

}
