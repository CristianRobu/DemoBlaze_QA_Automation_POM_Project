package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement loginField;

    private @FindBy(xpath = "//input[@id='loginpassword']")
    WebElement passwordField;

    private @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement loginButton;


    public void inputValidCredentials() {
        this.loginField.sendKeys(Constants.USERNAME);
        this.passwordField.sendKeys(Constants.PASSWORD);
        this.loginButton.click();
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public void inputGeneratedUsername() {
        this.loginField.sendKeys(Constants.generateUsername());
    }

    public void inputPassword() {
        this.passwordField.sendKeys(Constants.PASSWORD);
    }

    public void fullLogIn() {
        inputGeneratedUsername();
        inputPassword();
        clickLoginButton();
    }
}
