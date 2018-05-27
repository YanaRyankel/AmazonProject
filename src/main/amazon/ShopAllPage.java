package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopAllPage {
    WebDriver driver;
private WebElement checkbox;

    public ShopAllPage(WebDriver driver) {
        this.driver = driver;
        checkbox=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
    }

    public boolean selectCheckbox() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", checkbox);

        return checkbox.isDisplayed();
    }
}
