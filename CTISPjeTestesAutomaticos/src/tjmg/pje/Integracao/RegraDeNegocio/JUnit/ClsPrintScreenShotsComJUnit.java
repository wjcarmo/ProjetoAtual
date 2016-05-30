package tjmg.pje.Integracao.RegraDeNegocio.JUnit;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ClsPrintScreenShotsComJUnit extends TestWatcher  
{

	private WebDriver driver;
	
	
   @Override
   protected void failed(Throwable e, Description description)
   {
      String nomeClasse = description.getTestClass().getSimpleName();
      String nomeTeste = description.getMethodName();

      tiraScreenshot(nomeClasse, nomeTeste);
   }
      
   @Override
   protected void succeeded(Description description)
   {
      //O que colocarmos aqui ser� executado sempre que um teste passar...
      //Se colocarmos o m�todo de tirar screenshot aqui, teremos um
      //screenshot de cada teste que passou!
   }
 
   
   public void tiraScreenshot(String nomeClasse, String nomeTeste)  
   {
      try 
      {
         //Cria um diret�rio "screenshots" na raiz do projeto
         new File("screenshots/").mkdirs();

         //Obt�m um screenshot
         File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

         //Cria um arquivo dentro do diret�rio "screenshots", contendo
         //o nome da classe/m�todo de teste
         //Exemplo: "IncluirUsuarioTest-incluirComSucesso-screenshot.png"
         
         FileUtils.copyFile(screenshot, new File("screenshots/" + nomeClasse + "-" + nomeTeste + "-screenshot.png"));

      } 
      catch(Exception e) 
      {
      }
   }
   
}
