package demoblazeTests;

import constants.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyAboutUsIsDisplayedTest() {
        Utils.waitInSeconds(1);
        this.homePage.scrollToAboutUs();
        Assert.assertTrue(homePage.isAboutUsDisplayed());
    }
}
