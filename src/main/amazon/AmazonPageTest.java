package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class AmazonPageTest {


    public static final String PRODUCT_NAME = "Star Wars: The Last Jedi Chewie and the Porgs";
    private static String baseUrl = "https://www.amazon.com/";
    private static WebDriver driver;

   // @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "bin/geckodriver_0_19_0/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get(baseUrl);

    }

 //   @AfterClass
    public static void tearDown() {
        driver.quit();
    }

  //  @Test
    public void test1() throws Exception {

        AmazonPage amazonLandingPage = new AmazonPage(driver);

        Boolean isLogoDisplayed = amazonLandingPage.getLogo();
   //     Assert.assertTrue(isLogoDisplayed);

    }

//    @Test
    public void testChartIconIsDisplayed() throws Exception {

        AmazonPage amazonLamdingPage = new AmazonPage(driver);

        Boolean isChartIconDisplayed = amazonLamdingPage.getChartIcon();

     //   Assert.assertTrue(isChartIconDisplayed);
    }

  //  @Test
    public void testSwitchToPage() {
        AmazonPage amazonLandingPage = new AmazonPage(driver);
        String actualUrl = amazonLandingPage.getUrl();
  //      Assert.assertEquals(actualUrl, "https://www.amazon.jobs/");
    }

 //   @Test
    public void findProduct() {
        AmazonPage amazonLandingPage = new AmazonPage(driver);
        ProductListPage productListPage = amazonLandingPage.searchProduct(PRODUCT_NAME);

        ProductPage productPage = productListPage.openProductPage(PRODUCT_NAME);
        String actualProductName = productPage.getProductTitle();

    //    Assert.assertEquals(PRODUCT_NAME, actualProductName);
    }

  //  @Test
    public void findBook() throws InterruptedException {
        AmazonPage amazonLandingPage = new AmazonPage(driver);
       amazonLandingPage.goToShopAllPage();
       ShopAllPage shopAllPage=new ShopAllPage(driver);
     //  Assert.assertTrue(shopAllPage.selectCheckbox());
    }
}

