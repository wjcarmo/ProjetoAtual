package br.com.tjmg.pje.Evidencias;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;




public class ClsPrintScreenShotEvidenciaPositivasENegativas  extends TestListenerAdapter
{
	
	private WebDriver driver;
	
	
	@Override
    public void onTestFailure(ITestResult testResult)
    {
       super.onTestFailure(testResult);

       //O que colocarmos aqui será executado sempre que um teste falhar...
       //É aqui que vamos colocar o método para tirar um screenshot!
       try 
       {
    	   mPrintScreenEvidenciaNegativasEPossitivas();
       } 
       catch (IOException e) 
       {
		// TODO Auto-generated catch block
		e.printStackTrace();
       }
       
    }
	
	public void mPrintScreenEvidenciaNegativasEPossitivas() throws IOException
	{
	    
			// Criação do objeto do tipo FILE e tirando uma screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Salvando a screenshot. 
			FileUtils.copyFile(scrFile, new File("/CTISPjeTestesAutomaticos/Arquivo/ClsTestaIncluirNovoProcesso.png"));
					
	}

}
