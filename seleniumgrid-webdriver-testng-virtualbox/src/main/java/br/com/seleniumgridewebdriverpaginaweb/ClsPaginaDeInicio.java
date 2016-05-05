package br.com.seleniumgridewebdriverpaginaweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClsPaginaDeInicio 
{
	@FindBy(how = How.ID, using = "conversor") 
	
	private WebElement menuOpcaoConversor; 
	
	@FindBy(how = How.ID, using = "temperatura") 
	
	private WebElement menuOpcaoConversorTemperatura; 
	
	private WebDriver driver; 
	
	public ClsPaginaDeInicio(WebDriver driver)
	{ 
		
		this.driver = driver; 
		
		PageFactory.initElements(driver, this); 
		
		this.driver.get("http://artigo.pe.hu");
	}
	
	public ClsPaginaDeConversorDeTemperatura irParaPaginaConversorTemperatura() 
	{
		Actions acoesAvancadasDeUsuario = new Actions(driver); 
		
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		
		acoesAvancadasDeUsuario.moveToElement(menuOpcaoConversor).perform(); 
		
		wait.until(ExpectedConditions.visibilityOf(menuOpcaoConversorTemperatura)); 
		
		acoesAvancadasDeUsuario.moveToElement(menuOpcaoConversorTemperatura).click().perform(); 
		
		return new ClsPaginaDeConversorDeTemperatura(driver); 
		
	}
	
	
		
}
