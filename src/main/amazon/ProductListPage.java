package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage {

    WebDriver driver;

    private WebElement title;

    public ProductListPage(WebDriver driver, String productTitle) {
        this.driver = driver;
        title=driver.findElement(By.xpath("//h2[ @data-attribute='"+productTitle+"']"));
    }

    public ProductPage openProductPage(String productTitle){
        title.click();
        return new ProductPage(driver);
    }


}
