package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin {
	private WebDriver driver;
	private By userFieldLocator;
	private By passwordFieldLocator;
	private By loginButtonLocator;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userFieldLocator = By.name("txtUsername");
		passwordFieldLocator = By.name("txtPassword");
		loginButtonLocator = By.name("btnIniciarSesion"); 
	}
	
	public void login(String user, String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(userFieldLocator)); 
		WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldLocator));	
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));	
		userField.sendKeys(user);
		passwordField.sendKeys(pass);
		loginButton.click();
	}
}
