package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    WebDriver driver;

    private WebElement signInLink;
    private WebElement signInTitle;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        signInLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(signInTitle));
    }

    public void openSignInPage(){
      signInLink.click();
    }

    public Boolean isSignInTitleDisplayed() {
        signInTitle= driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
        return signInTitle.isDisplayed();
    }

}
