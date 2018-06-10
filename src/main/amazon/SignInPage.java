package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    WebDriver driver;

    private WebElement signInLink;


    public SignInPage(WebDriver driver) {
        this.driver = driver;

    }

    public Boolean signInLinkIsDisplayed() {
        signInLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        return signInLink.isDisplayed();
    }

}
