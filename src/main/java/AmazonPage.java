package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;


    //@FindBy(xpath="//tr[5]/td[2]")
    private WebElement amazonLogo;
    private WebElement chartIcon;


    public AmazonPage(WebDriver driver){
        this.driver=driver;
//        PageFactory.initElements(driver, this);

        amazonLogo = driver.findElement(By.xpath("//input[@value='Go']"));
        chartIcon=driver.findElement(By.linkText("Careers"));
    }



    public boolean getLogo() {
        return amazonLogo.isDisplayed();
    }


    public boolean getChartIcon(){return chartIcon.isDisplayed();}


}
