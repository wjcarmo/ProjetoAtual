package br.com.seleniumgridewebdrivertestcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.seleniumgridewebdriver.ClsEnumTipoDriver;
import br.com.seleniumgridewebdriverpaginaweb.ClsPaginaTrabalheConosco;

public class ClsTestaPaginaDeTrabalheConosco 
{
	
	WebDriver driver; 
	
	@BeforeClass 
	public void inicializarDriver() throws Exception 
	{ 
		// Atribui��o da inst�ncia do Enum do Tipo Firefox 
		ClsEnumTipoDriver selecionadoTipoDriver = ClsEnumTipoDriver.FIREFOX; 
		
		// Atribui��o das capacidades para usar o tipo driver Firefox 
		DesiredCapabilities capacidadesDesejadas = selecionadoTipoDriver.obterCapacidadesDesejadas(); 
		
		
		//linha de comando para usar uma maquina virtual do virtualbox.
		//driver = selecionadoTipoDriver.obterObjetoWebDriverRemoto( capacidadesDesejadas, Platform.LINUX, "http://192.168.1.15:4444/wd/hub"); 
		
        driver =  selecionadoTipoDriver.obterObjetoWebDriver(capacidadesDesejadas);  
	}
	
	@AfterClass 
	public void fecharDriver() 
	{
		if (null != driver) 
		     { 
			     driver.quit(); 
			 }
		} 
	
	
	
	
	@Parameters({ "nomeParametro" }) 
	// Executa o m�todo como teste 
	@Test 
	public void testeEnviarMensagemDeTrabalheConosco(String nomeParametro) 
	{
		ClsPaginaTrabalheConosco paginaTrabalheConosco = new ClsPaginaTrabalheConosco( driver); 
		// Preenche o campo nome 
		paginaTrabalheConosco.preencherNome(nomeParametro); 
		// Preenche o campo email 
		paginaTrabalheConosco.preencherEmail("wjcarmo@gmail.com"); 
		// Marca a op��o do radio button 
		paginaTrabalheConosco.marcarRadioButtonSexoMasculino(); 
		// Marca a op��o do checkbox 
		paginaTrabalheConosco.marcarCkeckBoxIdiomaIngles(); 
		// Seleciona a op��o do select 
		paginaTrabalheConosco.selecionarVaga("Suporte de TI"); 
		// Escolhe o arquivo pdf
		paginaTrabalheConosco.selecionarArquivoCurriculo("/seleniumgrid-webdriver-testng-virtualbox/src/test/resources/Wenderson Jos� do Carmo.pdf"); 
		// Clica no bot�o para enviar o formul�rio com as informa��es acima 
		paginaTrabalheConosco.enviarMensagemDeTrabalheConosco(); 
		// Retorna a mensagem informada na p�gina conversor temperatura 
		
		String msg = paginaTrabalheConosco.obterMensagemAposEnvio();
		
		// Verifica se s�o iguais, o resultado com o esperado 
		
		Assert.assertEquals(msg, "Sucesso!"); 
		
	   }
}
