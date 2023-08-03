package pages;

import constants.Constants;
import constants.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement signUpField;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@onclick='register()']")
    private WebElement registerButton;


    public void inputValidCredentials() {
        this.signUpField.sendKeys(Constants.generateUsername());
        Utils.waitInSeconds(2);
        passwordField.sendKeys(Constants.PASSWORD);
        registerButton.click();
        Utils.waitInSeconds(1);
    }

    public boolean isSignupButtonDisplayed() {
        return this.driver.findElement(By.xpath("//button[@onclick='register()']")).isDisplayed();

    }

    public String getSignupTitle() {
        return this.driver.findElement(By.xpath("//h5[@id='signInModalLabel']")).getText();
    }

    public void clickSignupButton() {
        this.driver.findElement(By.xpath("//button[@onclick='register()']")).click();
    }

    public void inputUsername() {
        this.driver.findElement(By.xpath("//input[@id='sign-username']"))
                .sendKeys(Constants.generateUsername());
    }

    public void inputPassword() {
       passwordField.sendKeys(Constants.PASSWORD);
    }

    public String getSignUpButtonColor() {
        return driver.findElement(By.xpath("//button[@onclick='register()']"))
                .getCssValue("background-color");
    }

    public void inputGeneratedCredentials() {
        this.signUpField.sendKeys(Constants.generateUsername());
        this.passwordField.sendKeys(Constants.PASSWORD);
        this.registerButton.click();
    }
}
