package test.java;

import main.java.AmazonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class AmazonPageTests {


    private WebDriver driver;
    private static String baseUrl = "https://www.amazon.com/";


    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","bin/geckodriver_0_19_0/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get(baseUrl);

    }

    @Test
    public void test1() throws Exception {

        AmazonPage amazonLandingPage = new AmazonPage(driver);

       Boolean isLogoDisplayed=amazonLandingPage.getLogo();
        assertTrue(isLogoDisplayed);

    }


    @Test
    public void testChartIconIsDisplayed() throws Exception {

        AmazonPage amazonLamdingPage=new AmazonPage(driver);

        Boolean isChartIconDisplayed=amazonLamdingPage.getChartIcon();

                assertTrue(isChartIconDisplayed);
    }

    @AfterSuite
    void tearDown() {
        driver.quit();
    }
    }



