package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageNavigation {
	private WebDriver driver;
	private Integer indexExpediente = 2;
	private By menuLocator;
	private By applicationListLocator;
	
	public PageNavigation(WebDriver driver) {
		this.driver = driver;
		menuLocator = By.id("menucenter");
		applicationListLocator = By.xpath("//*[@id=\"menucenter\"]/a");
	}
	
	public void goToApplication(Integer index) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(menuLocator));
		List<WebElement> applicationList = driver.findElements(applicationListLocator);
		applicationList.get(index).click();
	}
	
	public void goToExpedientes() {
		goToApplication(indexExpediente);
	}	
}
