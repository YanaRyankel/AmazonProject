import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Set;

public class DriverSingleton {

    private WebDriver driver;
    private static DriverSingleton instance = new DriverSingleton();

    private DriverSingleton(){
        System.setProperty("webdriver.gecko.driver", "bin/geckodriver_0_19_0/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
    };

    public static WebDriver getDriver(){
        return instance.driver;
    }
}
