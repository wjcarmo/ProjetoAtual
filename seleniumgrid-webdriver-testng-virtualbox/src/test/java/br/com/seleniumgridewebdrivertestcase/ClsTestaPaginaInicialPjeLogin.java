package br.com.seleniumgridewebdrivertestcase;

import org.openqa.selenium.WebDriver;
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
	
	private WebDriver driver; 
	ClsPaginaInicialPJEValidaLogin CT_ValidaLoginTJE = new ClsPaginaInicialPJEValidaLogin();
	
	@BeforeClass 
	public void inicializarDriver() throws Exception 
	{ 
		// Atribuição da instância do Enum do Tipo Firefox 
		//ClsEnumTipoDriver selecionadoTipoDriver = ClsEnumTipoDriver.FIREFOX; 
		
		// Atribuição das capacidades para usar o tipo driver Firefox 
		//DesiredCapabilities capacidadesDesejadas = selecionadoTipoDriver.obterCapacidadesDesejadas(); 
		
		//linha de comando para usar uma maquina virtual do virtualbox.
		//driver = selecionadoTipoDriver.obterObjetoWebDriverRemoto( capacidadesDesejadas, Platform.LINUX, "http://192.168.1.15:4444/wd/hub"); 
		//CT_ValidaLoginTJE.setDriver(new FirefoxDriver());
		//CT_ValidaLoginTJE.setDriver(selecionadoTipoDriver.obterObjetoWebDriver(capacidadesDesejadas));  
		
		driver = new FirefoxDriver();
	}
	
	@AfterClass 
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
		ClsPaginaInicialPJEValidaLogin paginaDeLoginPJE = new ClsPaginaInicialPJEValidaLogin( driver);
	   try
	   {
		 
		
		//Passo a passo de entrada de dados para testes.		
		// Preenche o campo nome
		// Preenche o campo email 
		
		    paginaDeLoginPJE.setsiteParamentro(paginaDeLoginPJE.getSiteParamentro());
			paginaDeLoginPJE.preencherCPFCNPJ(paginaDeLoginPJE.getCPFCNPJParametro()); 			
		    paginaDeLoginPJE.preencherSenha(paginaDeLoginPJE.getSenhaParamentro()); 		
	        paginaDeLoginPJE.clickBotaoEntrar();
		
		    String msg = paginaDeLoginPJE.getRetornaMsn();
		
		    // Verifica se são iguais, o resultado com o esperado 
		
		    Assert.assertEquals(msg,paginaDeLoginPJE.getretornaMsn());
		
	   }
	   catch(Exception e)
	   {
		 e.toString();  
	   }
		
	   }
}
