package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageHome;
import pages.PageLogin;
import pages.PageNavigation;

public class Tests {	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://servidoraplicacion01.eastus2.cloudapp.azure.com/Evolution/");
	}
	
	@Test
	public void CrearTipoDireccionConInformacionBasica() {
		PageLogin pageLogin = new PageLogin(driver);
		PageHome pageHome = new PageHome(driver);
		PageNavigation pageNavigation = new PageNavigation(driver);
		pageLogin.login("gerenterrhh", "gerenterrhh");
//		pageHome.selectCompany("ASEINFO Costa Rica (Aseinfo)");
		pageNavigation.goToExpedientes();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
