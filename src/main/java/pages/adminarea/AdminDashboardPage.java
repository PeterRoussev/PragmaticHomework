package pages.adminarea;


import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;


public class AdminDashboardPage extends BasePage {

    @FindBy(css = "div#content h1")
    private static WebElement dashboardHeading;

    @FindBy(xpath = "//div[@class='col-lg-3 col-md-3 col-sm-6'][2]//a")
    private static WebElement viewSalesBoard;

    @FindBy(id = "input-order-id")
    private static WebElement filterOrderID;

    @FindBy(id = "button-filter")
    private static WebElement filterButton;

    @FindBy(css = ".btn.btn-primary.dropdown-toggle")
    private static WebElement actionButton;

    @FindBy(css = ".fa.fa-pencil")
    private static WebElement editButton;

    @FindBy(id = "input-currency")
    private static WebElement currencyDropdownElement;

    @FindBy(id = "button-customer")
    private static WebElement editContinueButton;

    @FindBy(id = "button-save")
    private static WebElement editSaveButton;

    @FindBy(id = "button-cart")
    private static WebElement editContinueButton2;

    @FindBy(id = "button-payment-address")
    private static WebElement editContinueButton3;

    @FindBy(id = "button-shipping-address")
    private static WebElement editContinueButton4;

    @FindBy(css = "div.alert.alert-success.alert-dismissible")
    private static WebElement editConfirmationMessageField;

    static {
        PageFactory.initElements(Browser.driver, AdminDashboardPage.class);
    }

    /**
     * Asserts that the title of the Dashboard page equals the provided as parameter
     *
     * @param expectedDashboardTitle the expected dashboard page title as a String
     */
    public static void verifyDashboardTitle(String expectedDashboardTitle) {
        Assert.assertEquals(Browser.driver.getTitle(), expectedDashboardTitle);
    }

    /**
     * Asserts that the text of the heading in the Dashboard page
     * equals the provided as parameter
     *
     * @param expectedDashboardHeadingText the expected dashboard heading text
     * @param messageOnTestFailure the message that will appear in your test reports in case of failure
     */
    public static void verifyDashboardHeadingText(String expectedDashboardHeadingText, String messageOnTestFailure) {
        String actualDashboardHeadingText = dashboardHeading.getText();

        Assert.assertEquals(actualDashboardHeadingText, expectedDashboardHeadingText, messageOnTestFailure);
    }
    // Homework methods
    public static void viewSalesBoardPage(){
        viewSalesBoard.click();
    }

    /** Checking order id and customer name are as expected
     * @param orderID order id used in the search bar
     * @param expectedCustomerName Customer's name
     */
    public static void specificOrderCustomerVerification(String orderID, String expectedCustomerName){

        filterOrderID.sendKeys(orderID);
        filterButton.click();
        String actualCustomerName = Browser.driver.findElement(By.xpath("//td[text()="+orderID+"]/following-sibling::td")).getText();
        Assert.assertEquals(actualCustomerName, expectedCustomerName);
        filterOrderID.clear();
    }

    /** Trying to change the currency the product will be paid with
     * @param orderID you can find it on product order page
     */
    public static void editOrder(String orderID){
        filterOrderID.sendKeys(orderID);
        filterButton.click();
        actionButton.click();
        editButton.click();
        WebDriverWait wait = new WebDriverWait(Browser.driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(currencyDropdownElement));
        Select currencyDropdown = new Select(currencyDropdownElement);
        currencyDropdown.selectByValue("EUR");
        editContinueButton.click();
        editContinueButton2.click();
        editContinueButton3.click();
        editContinueButton4.click();
        editSaveButton.click();
        String confirmationText = editConfirmationMessageField.getText().trim();

        Assert.assertEquals(confirmationText.substring(0, confirmationText.length()-2), "Success: You have modified orders!");


    }
}
