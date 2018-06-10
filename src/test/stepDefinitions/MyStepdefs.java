package stepDefinitions;

import amazon.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class MyStepdefs {

    public static final String PRODUCT_NAME = "Star Wars: The Last Jedi Chewie and the Porgs";
    private static String baseUrl = "https://www.amazon.com/";
    AmazonPage landingPage;
    ProductListPage productListPage;
    ProductPage productPage;
    ShopAllPage shopAllPage;
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


    @When("^User press Shop All link$")
    public void userPressShopAllLink() throws Throwable {
        landingPage.goToShopAllPage();
    }

    @Then("^User see Shop All page$")
    public void userSeeShopAllPage() throws Throwable {
        String expectedUrl = "https://www.amazon.com/b/ref=bubbler_shop_all";
        String actualUrl = shopAllPage.getShopAllPageUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
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
        landingPage.clickOnCartButton();
    }

    @Then("^user can add \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userCanAddAnd(String email, String wrongPassword) throws Throwable {
        signInPage.clickSignIn();
        signInPage.addEmail(email);
        signInPage.addPassword(wrongPassword);
    }

    @Then("^user see alert message$")
    public void userIsSignedIn() throws Throwable {
        Boolean isAlertDisplayed = signInPage.getAlertMessage();
        assertTrue(isAlertDisplayed);
    }
}
