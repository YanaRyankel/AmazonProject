package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPage {

    WebDriver driver;


    //@FindBy(xpath="//tr[5]/td[2]")
    private WebElement amazonLogo;
    private WebElement chartIcon;
    private WebElement careersLink;
    private WebElement searchField;
    private WebElement searchButton;



    public AmazonPage(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);

        amazonLogo = driver.findElement(By.xpath("//input[@value='Go']"));
        chartIcon = driver.findElement(By.linkText("Careers"));
        careersLink = driver.findElement(By.linkText("Careers"));
        searchField=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchButton=driver.findElement(By.xpath("//input[ @value='Go']"));
        

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

}
