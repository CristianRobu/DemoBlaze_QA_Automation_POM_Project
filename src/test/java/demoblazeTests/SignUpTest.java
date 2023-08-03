package demoblazeTests;

import constants.Constants;
import constants.ErrorMessages;
import constants.Utils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    private SignUpPage signUpPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        this.signUpPage = new SignUpPage(driver);
    }

    @Test(priority = 1)
    public void signUpTest() {

        //Arrange
//        driver = new EdgeDriver();
//        driver.get(constants.Constants.URL);
//        driver.manage().window().maximize();

        //Act

        this.homePage.clickLogInButton();
        Utils.waitInSeconds(1);

        this.signUpPage.inputValidCredentials();
        Utils.waitInSeconds(1);


        //Assert
        String expectedMessage = Constants.SIGNUP_SUCCESSFUL_MESSAGE;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(expectedMessage, actualMessage);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);
        Utils.waitInSeconds(1);

    }

    @Test(priority = 2)
    public void signupButtonColourTest() {
        this.homePage.clickLogInButton();
        Utils.waitInSeconds(1);
        String expectedColor = Constants.BLUE_COLOR;
        String actualColor = this.signUpPage.getSignUpButtonColor();
        Assert.assertEquals(actualColor, expectedColor, ErrorMessages.SIGNUP_BUTTON_INCORRECT_COLOR);
        System.out.println(actualColor);
    }

    @Test
    public void signupIsDisplayedTest2() {

        this.homePage.clickLogInButton();
        Utils.waitInSeconds(1);
        String actualMessage = this.signUpPage.getSignupTitle();
        String expectedMessage = Constants.SIGN_UP;
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGNUP_BUTTON_INCORRECT_TEXT);
    }

    @Test
    public void signupIsDIsplayedTest() {
        this.homePage.clickLogInButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(this.signUpPage.isSignupButtonDisplayed(), ErrorMessages.SIGNUP_BUTTON_NOT_DISPLAYED);
    }

    @Test
    public void signupWithoutUserAndPassword() {
        this.homePage.clickLogInButton();
        Utils.waitInSeconds(1);
        this.signUpPage.clickSignupButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(driver);
        String expectedMessage = ErrorMessages.INCOMPLETE_USER_AND_PASS;
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.INCORRECT_ALERT_BOX_MESSAGE);

    }

    @Test
    public void signupUsingJustUsername() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        this.signUpPage.inputUsername();
        this.signUpPage.clickSignupButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(driver);
        String expectedMessage = ErrorMessages.INCOMPLETE_USER_AND_PASS;
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.INCORRECT_ALERT_BOX_MESSAGE);
    }

    @Test
    public void signupUsingJustPassword() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        this.signUpPage.inputPassword();
        this.signUpPage.clickSignupButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(driver);
        String expectedMessage = ErrorMessages.INCOMPLETE_USER_AND_PASS;
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.INCORRECT_ALERT_BOX_MESSAGE);

    }

    @Test
    public void signUpUsingSameCredentials() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        signUpPage.inputValidCredentials();
        signUpPage.clickSignupButton();
        Utils.waitInSeconds(1);
        String actualMessage = Constants.USERNAME_EXISTS_ALREADY;
        String expectedMessage = Utils.getAlertText(driver);
        Assert.assertEquals(actualMessage, expectedMessage);
        Utils.acceptAlert(driver);
        Utils.acceptAlert(driver);
    }

}
