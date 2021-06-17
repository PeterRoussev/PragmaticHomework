package com.bdd.BDDProductOrder;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.frontend.ProductOrderPage;
import utils.Browser;

/**
 * Testing shop.pragmatic.com
 */
public class ProductOrderTest {

    String productName1;

    @Before
    public void setup(){
        Browser.setup();
    }

    @After
    public void quit(){
        Browser.quit();
    }

    @Given("The user is on product details page")
    public void the_user_is_on_product_details_page() {
        ProductOrderPage.goToPage();
        productName1 = ProductOrderPage.collectProductNameFromDetailsPage();
    }

    @When("Choosing the product it appears in the cart")
    public void choosing_the_product_it_appears_in_the_cart() {
        ProductOrderPage.selectProductCheckBasket();
    }

    @Then("Verify the name of the product is {string}")
    public void verify_the_name_of_the_product_is_the_same(String productName) {
       Assert.assertEquals(productName1, productName);
    }
}
