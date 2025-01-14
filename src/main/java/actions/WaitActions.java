package actions;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

/**
 * Contains wrapper methods and functions that implement waits for elements.
 */
public class WaitActions {
    /**
     * This method create a FluentWait with default values:
     * TimeOut: Sets how long to wait for the evaluated condition to be true.
     * Polling: Sets how often the condition should be evaluated.
     *
     * @return AppiumFluentWait
     */
    public static AppiumFluentWait<AppiumDriver> getWait(Duration timeout, Duration polling) {
        return (AppiumFluentWait<AppiumDriver>) new AppiumFluentWait<>(DriverFactory.getDriver())
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class);
    }
}
