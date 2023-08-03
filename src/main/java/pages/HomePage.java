package pages;

import constants.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@id=signin2']")
    private WebElement signupButton;

    //varianta css
//    @FindBy(id = "signin2")
//    private WebElement signupButton1;

    //sau
    //   @FindBy(css = "#signin2")
//    private WebElement signupButton2;


    @FindBy(xpath = "//a[@id='login2']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    private WebElement monitorsButton;

    @FindBy(xpath = "//b[contains(text(),'About Us')]")
    private WebElement aboutUsText;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clickLogInButton() {

        this.loginButton.click();
    }

    public void clickSignUpButton() {

        this.signupButton.click();
    }

    public boolean isAboutUsDisplayed() {
        return driver.findElement(By.xpath("//b[contains(text(),'About Us')]")).isDisplayed();
    }

    public boolean isSignUpButtonDisplayed() {
        return this.signupButton.isDisplayed();
    }

    public String welcomeLogInMessage() {
        return this.driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();
    }

    public void scrollToAboutUs() {
        Utils.scrollToElement(aboutUsText, driver);
    }


}
