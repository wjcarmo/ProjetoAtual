package br.com.tjmg.pje.Evidencias;

import java.io.File;
import java.time.DayOfWeek;
import java.util.GregorianCalendar;

import javafx.scene.chart.PieChart.Data;

import org.apache.commons.io.FileUtils;
import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ClsEvidenciaDeExecucaoDosTestes  extends TestListenerAdapter
{
	private String status;
	 
    ExtentReports report;
    ExtentTest logger;
    public String print; 
    
    
	@Override
	public void onTestFailure(ITestResult tr)
	{
		super.onTestFailure(tr);
		
		String nomeClasse = tr.getClass().getSimpleName();
		String nomeTeste = tr.getMethod().getMethodName();
		this.status = "Falhou";
		
		tiraPrintScreen(nomeClasse, nomeTeste,status);
	}
	
	
	@Override
	public void onTestSuccess(ITestResult tr) 
	{
		super.onTestSuccess(tr);
				
		String nomeClasse = tr.getClass().getSimpleName();
		String nomeTeste = tr.getMethod().getMethodName();
		this.status = "Passou";
		
		tiraPrintScreen(nomeClasse, nomeTeste, status);
		

		
		
		
		
	}
	

	public String tiraPrintScreen(String nomeClasse, String nomeTeste, String resultado)
	{
		try
	{
	
			// Cria um diretório "screenshots" na raiz do projeto
			new File("PrintEvidencias/").mkdirs();
			// Obtém um screenshot
			File PJe = ((TakesScreenshot) ClsPrintScreenBase.getDriver()).getScreenshotAs(OutputType.FILE);
			
			// Cria um arquivo dentro do diretório "PrintEvidencias"
		    FileUtils.copyFile(PJe, new File("PrintEvidencias/" +status +"-"+ nomeClasse + "-" + nomeTeste +"-print.png"));
		   
		      print = logger.addScreenCapture("PrintEvidencias/" +status +"-"+ nomeClasse + "-" + nomeTeste +"-print.png");
		    
		} 
		
		catch (Exception e)
		{
			
		}
		return print;
	}

}
