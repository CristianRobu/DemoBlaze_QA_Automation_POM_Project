package demoblazeTests;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;


public class BaseTest {
    protected WebDriver driver;

    protected HomePage homePage;


    @BeforeMethod
    public void setUp() {
       this.driver = new EdgeDriver();
       this.driver.get(Constants.URL);
       this.driver.manage().window().maximize();
       this.homePage= new HomePage(driver);


    }

    @AfterMethod
    public void closeDriver() {
  //      this.driver.close();
    }

    @Test
    public void goToWebsiteTest() {

    }



    // cum localizam un element de UI

    // 1. printr-un xPath - formula xpath: incepe cu // ca la comentariu
    //tag[@key='value'] "//a[@id='signin2']"
    //



    //TEMA : CAT MAI MULTE TESTE PT LOGIN/SIGNUP ( BONUS, DACA E SIGNUP ALBASTRU)
    // ASSERT NEGATIV PT LOGIN
    //3 TESTE
    //WRONG USERNAME, NO USERNAME, NO USER/NO PASS
    //la fel si pt sign up


}

