package br.com.seleniumgridewebdrivertestcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.seleniumgridewebdriver.ClsEnumTipoDriver;
import br.com.seleniumgridewebdriverpaginaweb.ClsPaginaGmailValidaLogin;
import br.com.tjmg.pje.validalogin.ClsPaginaInicialPJEValidaLogin;

public class ClsTestaPaginaInicialPjeLogin 
{
	
	
	protected WebElement varMsn; 
	protected String CPFCNPJ =  "11111111111";
	protected String senhaParamentro = "tjmg";
	protected String siteParamentro = "http://pjetreina.tjmg.jus.br/pje/login.seam?loginComCertificado=true";
	protected String retornaMsn = "Os dados abaixo foram recuperados a partir da base de dados da Secretaria da Receita Federal do Brasil.";
	
	
	
	private WebDriver driver; 
	ClsPaginaInicialPJEValidaLogin CT_ValidaLoginTJE = new ClsPaginaInicialPJEValidaLogin();
	
	@BeforeClass 
	public void inicializarDriver() throws Exception 
	{ 		
		// Atribuição da instância do Enum do Tipo Firefox 
				ClsEnumTipoDriver selecionadoTipoDriver = ClsEnumTipoDriver.CHROME; 
				
				// Atribuição das capacidades para usar o tipo driver Firefox 
				DesiredCapabilities capacidadesDesejadas = selecionadoTipoDriver.obterCapacidadesDesejadas(); 
				
				
				//linha de comando para usar uma maquina virtual do virtualbox.
				//driver = selecionadoTipoDriver.obterObjetoWebDriverRemoto( capacidadesDesejadas, Platform.LINUX, "http://192.168.1.15:4444/wd/hub"); 
				
		        driver =  selecionadoTipoDriver.obterObjetoWebDriver(capacidadesDesejadas); 
	}
	
 
	public void fecharDriver() 
	{
		if (null != CT_ValidaLoginTJE.getDriver()) 
		     { 
				CT_ValidaLoginTJE.getDriver().quit(); 
			 }
		}
	
	
	//@Parameters({ "contaEmail" }) 
	@Test 	
	public void mTestaLoginaDeUsuariosPje() throws InterruptedException 
	{
	
	   try
	   {
			ClsPaginaInicialPJEValidaLogin paginaDeLoginPJE = new ClsPaginaInicialPJEValidaLogin( driver);
		
		//Passo a passo de entrada de dados para testes.		
		// Preenche o campo nome
		// Preenche o campo email 
		
		    paginaDeLoginPJE.setsiteParamentro(siteParamentro);
			paginaDeLoginPJE.preencherCPFCNPJ(CPFCNPJ); 			
		    paginaDeLoginPJE.preencherSenha(senhaParamentro); 		
	        paginaDeLoginPJE.clickBotaoEntrar();
		
		    //String msg = paginaDeLoginPJE.getRetornaMsn();
		
		    // Verifica se são iguais, o resultado com o esperado 
		
		 //   Assert.assertEquals(msg,paginaDeLoginPJE.getretornaMsn());
		
	   }
	   catch(Exception e)
	   {
		 e.toString();  
	   }
		
	   }
}
