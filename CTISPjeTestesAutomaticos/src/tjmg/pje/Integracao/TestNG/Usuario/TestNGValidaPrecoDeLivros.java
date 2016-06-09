package tjmg.pje.Integracao.TestNG.Usuario;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.tjmg.pje.Evidencias.ClsPrintScreenBase;


public class TestNGValidaPrecoDeLivros extends ClsPrintScreenBase
{
	@BeforeMethod
	public void abrePagina()
	{
		driver.get("http://www.lojaexemplodelivros.com.br");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testeComSucesso()
	{
		String nomeLivro = "[PRODUTO DE EXEMPLO] - A Cabe�a de Steve Jobs";
		WebElement linkLivroJobs = driver.findElement(By.linkText(nomeLivro));
		linkLivroJobs.click();
		wait.until(ExpectedConditions.titleContains(nomeLivro));
		String precoLivro = driver.findElement(By.id("product-price-45")).getText();
		assertEquals("R$634,90", precoLivro);
	}
	@Test
	public void testeComFalha()
	{
		String nomeLivro = "[PRODUTO DE EXEMPLO] - A Cabe�a de Steve Jobs";
		WebElement linkLivroJobs = driver.findElement(By.linkText(nomeLivro));
		linkLivroJobs.click();
		wait.until(ExpectedConditions.titleContains(nomeLivro));
		String precoLivro = driver.findElement(By.id("product-price-45")).getText();
		assertEquals("R$634,00", precoLivro);
	}

}
