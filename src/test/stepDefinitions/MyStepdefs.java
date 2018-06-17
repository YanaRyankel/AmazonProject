package stepDefinitions;

import amazon.AmazonPage;
import amazon.ProductListPage;
import amazon.ProductPage;
import amazon.SignInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class MyStepdefs {

    public static final String PRODUCT_NAME = "Star Wars: The Last Jedi Chewie and the Porgs";
    private static String baseUrl = "https://www.amazon.com/";
    AmazonPage landingPage;
    ProductListPage productListPage;
    ProductPage productPage;
    SignInPage signInPage;


    public AmazonPage loadAmazonPage() {
        WebDriver driver = stepDefinitions.DriverSingleton.getDriver();
        driver.get(baseUrl);
        return new AmazonPage(driver);
    }

    @Given("^user opens amazon home page$")
    public void iOpenAmazonHomePage() throws Throwable {
        landingPage = loadAmazonPage();
    }

    @Then("^the logo is displayed$")
    public void theLogoIsDisplayed() throws Throwable {
        Boolean isLogoDisplayed = landingPage.getLogo();
        assertTrue(isLogoDisplayed);
    }


    @When("^I enter product name to search field$")
    public void iEnterProductNameToSearchField() throws Throwable {
        productListPage = landingPage.searchProduct(PRODUCT_NAME);
    }

    @Then("^I see list of product with searched name$")
    public void iSeeListOfProductWithSearchedName() throws Throwable {
        Boolean isTitleDisplayed = productListPage.isTitleDisplayed(PRODUCT_NAME);
        assertTrue(isTitleDisplayed);
    }


    @When("^user searches for \"([^\"]*)\"$")
    public void
    userSearchesFor(String productName) throws Throwable {
        productListPage = landingPage.searchProduct(productName);
    }

    @Then("^product \"([^\"]*)\" is displayed in the list$")
    public void productIsDisplayedInTheList(String productName) throws Throwable {
        Boolean isTitleDisplayed = productListPage.isTitleDisplayed(productName);
        assertTrue(isTitleDisplayed);

    }

    @When("^user press Cart button$")
    public void userPressCartButton() throws Throwable {
        signInPage = landingPage.clickOnCartButton();
    }

    @Then("^user can get to signIn page$")
    public void userCanGetToSignInPage() throws Throwable {
        Boolean isSignInTitleDisplayed = signInPage.isSignInTitleDisplayed();
        assertTrue(isSignInTitleDisplayed);
    }

    @When("^user clicks on Sign In link$")
    public void userClicksOnSignInLink() throws Throwable {
        signInPage.openSignInPage();
    }
}
