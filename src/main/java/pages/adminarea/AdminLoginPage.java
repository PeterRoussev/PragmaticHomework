package pages.adminarea;

import core.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminLoginPage extends BasePage {


    private static String url = "http://shop.pragmatic.bg/admin";

    private static final By USER_NAME_INPUT_FIELD = By.id("input-username");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn.btn-primary");
    private static final By LOGIN_VALIDATION_ERROR = By.cssSelector(".alert-danger");

    public static void goToAdminLoginPage() {
        Browser.driver.get(url);
    }

    /**
     * This method logs you into the admin area with the
     * provided credentials as parameters
     *
     * @param userName the username you would like to login with
     * @param password the password you would like to login with
     */
    public static void login(String userName, String password) {
        Browser.driver.findElement(USER_NAME_INPUT_FIELD).sendKeys(userName);
        Browser.driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        Browser.driver.findElement(LOGIN_BUTTON).click();
    }

    /**
     * Asserts if the expected validation message is contained when trying to login
     * with wrong credentials
     *
     * @param expectedValidationMessage the expected validation message
     * @param messageOnFailure the message that will appear in your reports in case of failure
     */
    public static void verifyValidationMessage(String expectedValidationMessage, String messageOnFailure) {
        String actualValidationMessage = Browser.driver.findElement(LOGIN_VALIDATION_ERROR).getText();
        Assert.assertTrue(actualValidationMessage.contains(expectedValidationMessage), messageOnFailure);
    }
    public static void verifyFailureMessage(String expectedMessage) {
        String actualValidationMessage = Browser.driver.findElement(LOGIN_VALIDATION_ERROR).getText();
        Assert.assertTrue(actualValidationMessage.contains(expectedMessage));
    }
}
