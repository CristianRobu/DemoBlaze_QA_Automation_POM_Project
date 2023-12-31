package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
   protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return  element.getText();
    }

    // Pentru a putea folosi variabilele de tip WebElement trebuie sa aplicam Page Factory
    // in constructorul fiecarei clase care declara WebElements


    //Conversie id si class catre css

    //Ex: id = 'login2' ==> #login2
    //Ex2: id = 'btn btn-primary' ==> #btn.btn-primary

    //Ex clase: class='signup2' ==> .signup2
    //Ex2 clase: class = 'btn btn-primary' ==> .btn.btn-primary

    //Ex xpath==> css
    //   //button[@type='login'] ==> button[type='login']
}
