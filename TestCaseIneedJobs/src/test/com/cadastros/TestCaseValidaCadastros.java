package test.com.cadastros;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCaseValidaCadastros {
	
	private static WebDriver drive;
	
	@BeforeClass
	public  static void setUpTest()
	{
		drive = new FirefoxDriver();
		drive.get("https://mail.google.com");
		
		
	}
	
	@AfterClass
	public static void teaDowTest()
	{
		drive.quit();
	}
	
	@Test
	public void testCaseRetornoDeSelecaoEstado()
	{
		
	}
	
	@Test
	public void testCaseTestaBotaoEnviar()
	{
		
	}
	
	@Test
	public int testCaseCalculaNumeros(int a, int b)
	{
		int soma = a + b;
		return soma;
	}
	
	@Test
	public void testCaseGmail()
	{
		AssertJUnit.assertEquals("Gmail",drive.getTitle());
	}
	
	@Test
	public void testCaseLoginGmail()
	{
		
		WebElement elemento = drive.findElement(By.id("Email"));
		elemento.sendKeys("wjcarmo@gmail.com");
		
		elemento = drive.findElement(By.id("Passwd"));
		
		elemento.sendKeys("toddy@2013");
		
		drive.findElement(By.id("signIn")).click();		
		
		
		AssertJUnit.assertEquals("Gmail",drive.getTitle());
	}
	

}
