package br.com.testcase.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import br.com.testecase.Object.ClsBaseDeDadosEmails;

public class ClsTestaContasDeEmails {
	
	
	private String  logindousuario;
	private String senhadousuario; 
	private String nomedousuario; 
	private WebElement btnEntrar; 
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
    
  public void ClsTestaContasDeEmails(String logindousuario, String senhadousuario)
  {
	  this.nomedousuario=logindousuario;
	  this.senhadousuario=senhadousuario;
  }
  
  
  
  @Test(dataProvider ="emails")
	public void ClsTestCaseLogin() throws InterruptedException
	{
		
      WebDriver driver = new  FirefoxDriver();
      
	  driver.get("https://www.google.com.br");
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Fazer login")).click();
		driver.findElement(By.id("Email")).sendKeys(logindousuario);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys(senhadousuario);
		driver.quit();
		
		
	}
 

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  
  @DataProvider(name="emails")
	public Object[][] baseDeDados()
	{
		Object[][] dados = new Object[3][2];
		
		dados[0][0] = "wjcarmo@gmail.com"; dados[0][1] = "toddy@2013";
		dados[1][0] = "wenderson.mastermaq@gmail.com"; dados[1][1] = "toddy@2016";
		dados[2][0] = "brenotoddy@gmail.com"; dados[2][1] = "toddy@2013";
		
		return dados ; 
	}
  
}
