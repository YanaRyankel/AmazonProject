package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    WebDriver driver;

    private WebElement title;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        title = driver.findElement(By.xpath("//span[@id='productTitle']"));
    }

    public String getProductTitle(){
        return title.getText();
    }

}
