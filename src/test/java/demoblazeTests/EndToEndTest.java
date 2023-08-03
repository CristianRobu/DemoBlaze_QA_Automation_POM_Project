package demoblazeTests;

import constants.Constants;
import constants.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LogInPage;
import pages.MonitorsPage;
import pages.ProductPage;


public class EndToEndTest extends BaseTest{

private LogInPage logInPage;
    private MonitorsPage monitorsPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        monitorsPage = new MonitorsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        logInPage = new LogInPage(driver);
    }

    @Test
    public void endToEndFlowTest() {
        homePage.clickLogInButton();
        Utils.waitInSeconds(1);
        this.logInPage.fullLogIn();
        Utils.waitInSeconds(1);
//        String actualMessage = driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();
//        String actualMessage = driver.findElement(By.id("nameofuser")).getText();
        String actualMessage = this.driver.findElement(By.cssSelector("#nameofuser")).getText();
       System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.contains(Constants.WELCOME_MESSAGE));
 //       homePage.clickMonitorsButton();
        Utils.waitInSeconds(1);
        monitorsPage.clickAsusMonitorLink();
        Utils.waitInSeconds(1);
        productPage.clickAddToCartButton();
        Assert.assertEquals(Utils.getAlertText(driver), Constants.PRODUCT_ADDED_TEXT,
                "The alert text box is incorrect");
        Utils.acceptAlert(driver);
        Utils.waitInSeconds(1);
        cartPage.clickCartButton();
        Utils.waitInSeconds(1);
        cartPage.clickPlaceOrderButton();
        Utils.waitInSeconds(1);


    }
}
