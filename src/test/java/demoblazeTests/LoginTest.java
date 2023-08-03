package demoblazeTests;

import constants.Constants;
import constants.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LoginTest extends BaseTest {

    private LogInPage logInPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        this.logInPage=new LogInPage(this.driver);
    }

    @Test(priority = 1)
    public void loginTest() {
       this.homePage.clickLogInButton();
        Utils.waitInSeconds(1);
        this.driver.findElement(By.xpath("//input[@id='loginusername']"))
                .sendKeys(Constants.USERNAME);
        this.driver.findElement(By.xpath("//input[@id='loginpassword']"))
                .sendKeys(Constants.PASSWORD);
        this.driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
        Utils.waitInSeconds(1);
//        String actualMessage = driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();
//        String actualMessage = driver.findElement(By.id("nameofuser")).getText();
        String actualMessage = this.driver.findElement(By.cssSelector("#nameofuser")).getText();
        System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.contains(Constants.WELCOME_MESSAGE));
    }

    @Test(priority = 0)
    public void loginWithoutUsername() {
        this.homePage.clickLogInButton();
        Utils.waitInSeconds(1);
        this.driver.findElement(By.xpath("//input[@id='loginpassword']"))
                .sendKeys(Constants.PASSWORD);
        this.driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
        Utils.waitInSeconds(1);
        String message = this.driver.switchTo().alert().getText();
        Assert.assertTrue(message.contains(Constants.NO_USERNAME_LOGIN_ATTEMPT));
        System.out.println(message);

    }
}
