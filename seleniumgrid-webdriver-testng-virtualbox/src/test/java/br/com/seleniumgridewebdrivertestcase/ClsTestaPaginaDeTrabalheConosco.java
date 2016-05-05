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
		// Atribuição da instância do Enum do Tipo Firefox 
		ClsEnumTipoDriver selecionadoTipoDriver = ClsEnumTipoDriver.FIREFOX; 
		
		// Atribuição das capacidades para usar o tipo driver Firefox 
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
	// Executa o método como teste 
	@Test 
	public void testeEnviarMensagemDeTrabalheConosco(String nomeParametro) 
	{
		ClsPaginaTrabalheConosco paginaTrabalheConosco = new ClsPaginaTrabalheConosco( driver); 
		// Preenche o campo nome 
		paginaTrabalheConosco.preencherNome(nomeParametro); 
		// Preenche o campo email 
		paginaTrabalheConosco.preencherEmail("wjcarmo@gmail.com"); 
		// Marca a opção do radio button 
		paginaTrabalheConosco.marcarRadioButtonSexoMasculino(); 
		// Marca a opção do checkbox 
		paginaTrabalheConosco.marcarCkeckBoxIdiomaIngles(); 
		// Seleciona a opção do select 
		paginaTrabalheConosco.selecionarVaga("Suporte de TI"); 
		// Escolhe o arquivo pdf
		paginaTrabalheConosco.selecionarArquivoCurriculo("/seleniumgrid-webdriver-testng-virtualbox/src/test/resources/Wenderson José do Carmo.pdf"); 
		// Clica no botão para enviar o formulário com as informações acima 
		paginaTrabalheConosco.enviarMensagemDeTrabalheConosco(); 
		// Retorna a mensagem informada na página conversor temperatura 
		
		String msg = paginaTrabalheConosco.obterMensagemAposEnvio();
		
		// Verifica se são iguais, o resultado com o esperado 
		
		Assert.assertEquals(msg, "Sucesso!"); 
		
	   }
}
