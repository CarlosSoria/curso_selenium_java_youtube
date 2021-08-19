package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageHome {
	private WebDriver driver;
	private By companyListLocator;
	private By companySelectedSpanLocator;
	
	public PageHome(WebDriver driver) {
		this.driver = driver;
		companyListLocator = By.id("grupoCompaniaSelectorSpan");
		companySelectedSpanLocator = By.xpath("//*[@id=\"ddlGrupoCompaniaSelector\"]/li/a");	
	}
	
	public void selectCompany(String companyName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement companySelectedSpan = wait.until(ExpectedConditions.presenceOfElementLocated(companySelectedSpanLocator));
		WebElement companyListElement = wait.until(ExpectedConditions.presenceOfElementLocated(companyListLocator)); 
		List<WebElement> companies = companyListElement.findElements(By.tagName("li"));
		Boolean companyFound = false; 
		
		String companySelected = companySelectedSpan.getText().trim();
		
		System.out.println(companySelected);
		
		if (companySelected == companyName) {
			companyFound = true;
			System.out.println("Compa��a Igual");
		} else {			
			companyFound = false;
			System.out.println("Compa��a Difrente");
			for (WebElement companyElement : companies) {
				WebElement company = companyElement.findElement(By.tagName("a"));
				System.out.println("Compa��a: " + company.getText().trim());
				if (company.getText().trim() == companyName) {
					System.out.println("Econtr� compa��a");
					company.click();
					companyFound = true;
				}
			}
		}
		
		if (!companyFound) {
			Assert.fail("No se encontr� la compa��a: " + companyName + " para seleccionar");
		}
	}
}
