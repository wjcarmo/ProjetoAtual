package br.com.tjmg.pje.interfaces;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface ClsInterfaceEstabeleceDriver {
	
	WebDriver obterObjetoWebDriver(DesiredCapabilities desiredCapabilities);
	
	WebDriver obterObjetoWebDriverRemoto(DesiredCapabilities desiredCapabilities, Platform  plataforma, String enderecoRemoto);
	
	DesiredCapabilities obterCapacidadesDesejadas();

}
