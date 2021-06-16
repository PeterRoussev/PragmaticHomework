package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

//Homework Class
public class ProductOrderPage extends BasePage {

    @FindBy(id="button-cart")
    private static WebElement buttonCart;

    @FindBy(xpath = "//*[@id='cart-total']/..")
    private static WebElement inTheBasket;

    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']//*[@class='fa fa-share']/..")
    private static WebElement checkoutButton;

    @FindBy(css = ".dropdown-menu.pull-right .text-left")
    private static WebElement productNameInBasketField;

    @FindBy(css = "div#content h1")
    private static WebElement ProductNameFromDetailsPage;

    static String productDetailsPageUrl = "http://shop.pragmatic.bg/index.php?route=product/product&path=24&product_id=29";
    static double detailsPagePrice;


    static {
        PageFactory.initElements(Browser.driver, ProductOrderPage.class);
    }
    public static void goToPage(){
        Browser.driver.get(productDetailsPageUrl);
    }
    public static void selectProductCheckBasket(){
        buttonCart.click();
        inTheBasket.click();
    }
    public static void collectPriceValue() {
        String text = Browser.driver.findElement(By.xpath("//div[@class='col-sm-4']//li[contains(text(), 'Tax')]")).getText();
        String text2 = text.substring(9);
        detailsPagePrice = Double.parseDouble(text2);
    }
    public static String collectProductNameInBasket(){
        return productNameInBasketField.getText();
    }
    public static String collectProductNameFromDetailsPage(){
        return ProductNameFromDetailsPage.getText();
    }
}
