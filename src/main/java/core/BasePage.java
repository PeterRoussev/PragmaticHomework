package core;

import org.openqa.selenium.By;
import utils.Browser;

public abstract class BasePage {

    /**
     * Clicks on an WebElement, located by the locator provided as parameter.
     *
     * @param locator The locator for the WebElement you want to be clicked on.
     */
    protected void click(By locator) {
        Browser.driver.findElement(locator).click();
    }

    /**
     * Types text in a WebElement located by particular locator
     *
     * @param locator The locator of the WebElement you want to type in.
     * @param textToType the text that you want to be typed in the particular WebElement
     */
    protected static void type(By locator, String textToType) {
        Browser.driver.findElement(locator).sendKeys(textToType);
    }

    /**
     * Checks if a WebElement,located by particular locator,  is displayed.
     *
     * @param locator The locator of the WebElement that you want to be checked.
     * @return returns boolean tue or false
     */
    protected static boolean isDisplayed(By locator) {
        return !Browser.driver.findElements(locator).isEmpty();
    }

    /**
     * Gets the text from a WebElement located by particular locator.
     *
     * @param locator The locator of the WebElement which text you want to get.
     * @return The text from the located WebElement as a String.
     */
    protected static String getElementText(By locator) {
        return Browser.driver.findElement(locator).getText();
    }
}
