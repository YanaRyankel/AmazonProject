package amazon;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;


public class AmazonPage {

    WebDriver driver;



    private WebElement amazonLogo;
    private WebElement chartIcon;
    private WebElement careersLink;
    private WebElement searchField;
    private WebElement searchButton;
    private WebElement shopAllLink;
    private WebElement cartButton;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;


        amazonLogo = driver.findElement(By.xpath("//input[@value='Go']"));
        chartIcon = driver.findElement(By.linkText("Careers"));
        careersLink = driver.findElement(By.linkText("Careers"));
        searchField=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchButton=driver.findElement(By.xpath("//input[ @value='Go']"));
        shopAllLink=driver.findElement(By.xpath("//a[contains(text(),'Shop all')]"));
        cartButton=driver.findElement(By.xpath("//*[@id='nav-cart']"));
    }


    public boolean getLogo() {
        return amazonLogo.isDisplayed();
    }


    public boolean getChartIcon() {
        return chartIcon.isDisplayed();
    }

    public String getUrl() {
        return null;
    }

    public ProductListPage searchProduct(String  productTitle) {
        searchField.sendKeys(productTitle);
        searchButton.click();
        return new ProductListPage(driver, productTitle);
    }

    public ShopAllPage goToShopAllPage()  {
       shopAllLink.click();
        String expectedUrl="https://www.amazon.com/b/ref=bubbler_shop_all";
return new ShopAllPage(driver);

    }

    public SignInPage clickOnCartButton(){
            cartButton.click();
            return new SignInPage(driver);
    }

}
