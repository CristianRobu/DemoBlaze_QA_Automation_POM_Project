package constants;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    public static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }


    public static String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public static void scrollToElement(By elementBy, WebDriver driver) {
        WebElement element = driver.findElement(elementBy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static void scrollToElement(WebElement e, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);

    }
}