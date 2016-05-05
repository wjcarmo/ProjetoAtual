package br.com.seleniumgridewebdrivertestcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;

import br.com.seleniumgridewebdriver.ClsEnumTipoDriver;
import br.com.seleniumgridewebdriverconversor.ClsConversorDeTemperatura;
import br.com.seleniumgridewebdriverpaginaweb.ClsPaginaDeConversorDeTemperatura;
import br.com.seleniumgridewebdriverpaginaweb.ClsPaginaDeInicio;

public class ClsTestaPaginaDeConversorDeTemperatura 
{
	private Select selectDe; 
	private Select selectPara; 
	private WebElement resultado; 
	private WebElement entrada; 
	private WebDriver driver; 
	private String resultadoValor; 
	private String resultadoCalculado; 
	
	@BeforeClass 
	public void inicializarDriver() throws Exception 
	{
		//System.setProperty("Webdriver.chrome.driver","/seleniumgrid-webdriver-testng-virtualbox/src/test/resources/seleniumgridewebdriver/chromedriver.exe");
		//driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		ClsEnumTipoDriver selecionadoTipoDriver = ClsEnumTipoDriver.FIREFOX; 
		DesiredCapabilities capacidadesDesejadas = selecionadoTipoDriver.obterCapacidadesDesejadas(); 
	
		//driver = selecionadoTipoDriver.obterObjetoWebDriverRemoto( capacidadesDesejadas, Platform.LINUX, "http://192.168.0.2:5555/wd/hub"); 
		
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
	
	@Parameters({ "entradaParametro" }) 
	// Executa o método como teste 
	@Test 
	public void testeCalcularConversorTemperatura(String entradaParametro) throws Exception 
	{ 
		// Este teste executa como se fosse passos de usuário 
		// Inicia a página inicial 
		
		ClsPaginaDeInicio paginaInicio = new ClsPaginaDeInicio(driver); 
		
		// Depois vai, da página inicial até a página Converso de Temperatura 
		
		ClsPaginaDeConversorDeTemperatura paginaConversorTemperatura = paginaInicio.irParaPaginaConversorTemperatura(); 
		
		// Estando na página Conversor de temperatura // Preencha o campo com o valor de entrada 
		
		paginaConversorTemperatura.preencherValorDeEntrada(entradaParametro); 
		
		// Atribui o valor de entrada a partir da referência do elemento html 
		
		entrada = paginaConversorTemperatura.obterValorDeEntrada(); 
		
		// Atribui a referência do elemento html 
		
		Select selectDe = paginaConversorTemperatura.obterSelectDeTemperatura(); 
		
		// Atribui a referência de outro elemento html 
		
		Select selectPara = paginaConversorTemperatura.obterSelectParaTemperatura(); 
		
		// Por fim, atribui do valor do resultado a partir da referência do // elemento html 
		
		resultado = paginaConversorTemperatura.obterResultadoTemperatura(); 
	}
	
	// Este teste só executa depois que o método 
	// testeCalcularConversorTemperatura executar, pois este teste depende da 
	// execução dele. 
	
	@Test(dependsOnMethods = { "testeCalcularConversorTemperatura" })
	public void testeCelsiusParaCelsius() 
	{
		// Esses dois primeiros métodos, selecionam a opção do elemento 
		// html Select que tiver com x texto vísivel na aplicação web. 
		
		selectDe.selectByVisibleText("Celsius [°C]"); 
		selectPara.selectByVisibleText("Celsius [°C]"); 
		
		// Verifica se são iguais, o resultado com o esperado (valor de entrada) 
		
		AssertJUnit.assertEquals(resultado.getAttribute("value"), entrada.getAttribute("value")); 
	}
	
	// Este teste só executa depois que o método 
	// testeCalcularConversorTemperatura executar, pois este teste depende da 
	// execução dele.
	
	@Test(dependsOnMethods = { "testeCalcularConversorTemperatura" }) 
	public void testeCelsiusParaFahrenheit() 
	{
		// Esses dois primeiros métodos, selecionam a opção do elemento 
		// html Select que tiver com x texto visível na aplicação web. 
		
		selectDe.selectByVisibleText("Celsius [°C]"); 
		selectPara.selectByVisibleText("Fahrenheit [°F]"); 
		
		// Atribui o valor do atributo value do elemento html 
		
		resultadoValor = resultado.getAttribute("value"); 
		
		// Atribui o resultado da conversão 
		
		resultadoCalculado = ClsConversorDeTemperatura.celsiusParaFahrenheit(entrada .getAttribute("value")); 
		
		// Verifica se são iguais, o resultado com o esperado 
		
		AssertJUnit.assertEquals(resultadoValor, resultadoCalculado); 
	} 
	
	// Este teste só executa depois que o método 
	// testeCalcularConversorTemperatura executar, pois este teste depende da 
	// execução dele. 
	
	@Test(dependsOnMethods = "testeCalcularConversorTemperatura") 
	public void testeFahrenheitParaCelsius() 
	{
		// Esses dois primeiros métodos, selecionam a opção do elemento 
		// html Select que tiver com x texto vísivel na aplicação web. 
		
		selectDe.selectByVisibleText("Fahrenheit [°F]"); 
		selectPara.selectByVisibleText("Celsius [°C]"); 
		
		// Atribui o valor do atributo value do elemento html 
		
		resultadoValor = resultado.getAttribute("value"); 
		
		// Atribui o resultado da conversão 
		
		resultadoCalculado = ClsConversorDeTemperatura.fahrenheitParaCelsius(entrada .getAttribute("value")); 
		
		// Verifica se são iguais, o resultado com o esperado 
		
		AssertJUnit.assertEquals(resultadoValor, resultadoCalculado); 
	} 
	
	// Este teste só executa depois que o método 
	// testeCalcularConversorTemperatura executar, pois este teste depende da 
	// execução dele.
	
	@Test(dependsOnMethods = { "testeCalcularConversorTemperatura" }) 
	public void testeFahrenheitParafahrenheit() 
	{ 
		// Esses dois primeiros métodos, selecionam a opção do elemento 
		// html Select que tiver com x texto visível na aplicação web. 
		
		selectDe.selectByVisibleText("Fahrenheit [°F]"); 
		selectPara.selectByVisibleText("Fahrenheit [°F]"); 
		
		// Verifica se são iguais, o resultado com o esperado (valor de entrada) 
		
		AssertJUnit.assertEquals(resultado.getAttribute("value"), entrada.getAttribute("value")); 
	}

	

}
