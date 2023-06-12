package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseDriverClass;

// https://www.saucedemo.com/
public class LoginPage extends BaseDriverClass {

	@FindBy(xpath = "//input[@id='user-name']")
	@CacheLookup
	private WebElement usernameTextField;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[@id='login-button']")
	@CacheLookup
	private WebElement loginButton;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public void loginToSite(String username, String password) {
		waitUntilElementVisible(usernameTextField);
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

	public Boolean verifyOnLoginPage() {
		waitUntilElementVisible(usernameTextField);
		return usernameTextField.isDisplayed();
	}
}