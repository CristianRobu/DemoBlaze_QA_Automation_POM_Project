package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    //TODO: Move cartButton and method in HomePage

    @FindBy(css = "#cartur")
    private WebElement cartButton;

    @FindBy(css = "button[data-target='#orderModal']")
    private WebElement placeOrderButton;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButton() {
        clickElement(cartButton);
    }

    public void clickPlaceOrderButton() {
        clickElement(placeOrderButton);
    }

}
