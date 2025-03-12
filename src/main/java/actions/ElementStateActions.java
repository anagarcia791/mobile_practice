package actions;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

/**
 * Contains wrapper for methods to validate state of elements:
 * Displayed, enabled, visible
 */
public class ElementStateActions {
    protected static final int DEFAULT_MILLIS = 250;
    protected static final int DEFAULT_IS_DISPLAYED_TIMEOUT = 30;

    /**
     * Checks whether an element is being displayed
     *
     * @param element : the element
     * @return true if the element is being displayed, false otherwise
     */
    public static boolean isElementDisplayed(WebElement element) {
        return isElementDisplayed(element, DEFAULT_IS_DISPLAYED_TIMEOUT);
    }

    /**
     * Check for element visibility with timeOut
     *
     * @param element        : Expected visible element
     * @param timeoutSeconds : Sets how long to wait for the element visibility
     * @return boolean true if element was displayed
     */
    public static boolean isElementDisplayed(WebElement element, int timeoutSeconds) {
        boolean displayed;
        try {
            WaitActions.getWait(Duration.ofSeconds(timeoutSeconds), Duration.ofMillis(DEFAULT_MILLIS))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            displayed = element.isDisplayed();
        } catch (NullPointerException | WebDriverException e) {
            displayed = false;
        }
        return displayed;
    }

}
