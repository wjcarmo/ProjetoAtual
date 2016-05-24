package br.com.testcase.Page;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.testecase.Object.ClsBaseDeDadosEmails;

@RunWith(Parameterized.class)
public class ClsTestCaseLogin 
{
	
	private String  logindousuario;
	private String senhadousuario; 
	private String nomedousuario; 
	private String resultado;
	private WebElement btnEntrar; 
	
	
	 public void ClsTestCaseLogin(String logindousuario, String senhadousuario, String resultadodousuario)
	  {
		  this.nomedousuario=logindousuario;
		  this.senhadousuario=senhadousuario;
		  this.resultado=resultadodousuario;
	  }

	 @Test
	 public void mTestaLoginContaGmail() throws InterruptedException
	 {
		 WebDriver driver = new  FirefoxDriver();
	      
		  driver.get("https://www.google.com.br");
			
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Fazer login")).click();
			driver.findElement(By.id("Email")).sendKeys(logindousuario);
			
			Thread.sleep(5000);
			
			driver.findElement(By.id("next")).click();
			driver.findElement(By.id("Passwd")).sendKeys(senhadousuario);
			
			//assertEquals(resultado,driver.findElement(By.id("Passwd")).sendKeys(senhadousuario); );
			driver.quit();
	 }
	 
	 
	 public static Collection<Object[]> Dados()
	 {
		 return Arrays.asList(new Object[][]{
				 { "wjcarmo@gmail.com","toddy@2013","Wenderson José do Carmo"},
				 { "wenderson.mastermaq@gmail.com","toddy@2013","Wenderson José do Carmo"}} );
	 }
	
	
	
	
	
   
}
