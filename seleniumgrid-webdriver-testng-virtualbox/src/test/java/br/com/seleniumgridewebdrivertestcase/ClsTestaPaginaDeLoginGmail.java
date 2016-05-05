package br.com.seleniumgridewebdrivertestcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.seleniumgridewebdriver.ClsEnumTipoDriver;
import br.com.seleniumgridewebdriverpaginaweb.ClsPaginaGmailValidaLogin;
import br.com.seleniumgridewebdriverpaginaweb.ClsPaginaTrabalheConosco;

public class ClsTestaPaginaDeLoginGmail 
{
	WebDriver driver;
	
		
	@BeforeClass 
	public void inicializarDriver() throws Exception 
	{ 
		// Atribuição da instância do Enum do Tipo Firefox 
		ClsEnumTipoDriver selecionadoTipoDriver = ClsEnumTipoDriver.FIREFOX; 
		
		// Atribuição das capacidades para usar o tipo driver Firefox 
		DesiredCapabilities capacidadesDesejadas = selecionadoTipoDriver.obterCapacidadesDesejadas(); 
				
		//linha de comando para usar uma maquina virtual do virtualbox.
		//driver = selecionadoTipoDriver.obterObjetoWebDriverRemoto( capacidadesDesejadas, Platform.LINUX, "http://192.168.1.15:4444/wd/hub"); 
		
        driver =  selecionadoTipoDriver.obterObjetoWebDriver(capacidadesDesejadas); 
		 // driver=  new FirefoxDriver(); 
	}
	
	@AfterClass 
	public void fecharDriver() 
	{
		if (null != driver) 
		     { 
			     driver.quit(); 
			 }
		}
	
	
	//@Parameters({ "contaEmail" }) 
	@Test 	
	public void testeEnviarNomeDaContaDoGmail() throws InterruptedException 
	{
		//Cenario de testes artefaro de teste, pagina de login do Gmail. 
		
		ClsPaginaGmailValidaLogin paginaDeLoginGmail = new ClsPaginaGmailValidaLogin( driver); 
		
		//Passo a passo de entrada de dados para testes.		
		// Preenche o campo nome
		
		paginaDeLoginGmail.preencherEmail(paginaDeLoginGmail.getEmailParamentro()); 		
		paginaDeLoginGmail.clickBotaoNext();		
		paginaDeLoginGmail.preencherSenha(paginaDeLoginGmail.getSenhaParamentro()); 		
		paginaDeLoginGmail.clickBotaoFazerLogin();
		
		
		
		
		// RESULTADOS
		//RESULTADOS DE QUE DEVERÃO SER ESPERADO NO FINAL DA EXECUÇÃO DO TESTES
		
		String msg = paginaDeLoginGmail.getNomeParametro();
		Assert.assertEquals(msg, "Wenderson Jose do Carmo!"); 
		
	   }

}
