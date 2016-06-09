package tjmg.pje.Relatorios;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	 
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	 
	public class ClsRelatorioDeExecucaoDosTestes
	{
	     
	    ExtentReports report;
	    ExtentTest logger;
	    WebDriver driver;
	     
	     
	    @Test
	    public void geradorDeRelatorios()
	    {
	    report=new ExtentReports("./Relatorios\\geradorDeRelatorios.html");
	  
	    logger=report.startTest("Gerador de Relatorios de execucao");
	    logger.log(LogStatus.INFO, "Iniciando o Sistema ");
	    logger.log(LogStatus.INFO, "Sistema em Execucao");
	    logger.log(LogStatus.PASS, "Testes Realizados com Sucesso");
	    logger.addScreenCapture("./Relatorios\\tela.png");
	    logger.assignAuthor("Wenderson Jose do Carmo"); 
	    logger.assignCategory("Testes de Regressao");
	    
	    logger.setDescription("Metodo que Valida a rotina de incluao de um novo processo no sistema PJe");
	    logger.getDescription();
	    
	    report.getClass();   
	    report.endTest(logger);
	    report.flush();
	   
	    }
	   

	}
