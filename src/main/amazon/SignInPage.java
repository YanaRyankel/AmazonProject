package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    WebDriver driver;

    private WebElement signInButton;
    private WebElement emailField;
    private WebElement continueButton;
    private WebElement passwordField;
    private WebElement signInSubmitButton;
    private WebElement alertMessage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        signInButton=driver.findElement(By.xpath("//a[@class='action-button'']"));
        emailField=driver.findElement(By.xpath("//input[@type='email']"));
        continueButton=driver.findElement(By.xpath("//input[@type='continue']"));
        passwordField=driver.findElement(By.xpath("//input[@type='password']"));
        signInSubmitButton=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
        alertMessage=driver.findElement(By.xpath("//h4[@class='a-alert-heading']"));

    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void addEmail(String email){
        emailField.sendKeys(email);
        continueButton.click();
    }

    public void addPassword(String wrongPassword){
        passwordField.sendKeys(wrongPassword);
        signInSubmitButton.click();
    }

    public Boolean getAlertMessage(){
       return alertMessage.isDisplayed();
    }

}
