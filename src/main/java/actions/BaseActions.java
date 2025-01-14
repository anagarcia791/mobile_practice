package actions;

import driver.DriverFactory;
import org.openqa.selenium.Dimension;

/**
 * Contains wrapper for driver and basic elements.
 */
public class BaseActions {
    /**
     * Returns the height of the screen
     *
     * @return int
     */
    public int getScreenWidth() {
        return getScreenDimension().getWidth();
    }

    /**
     * Gets the screen dimensions
     *
     * @return Dimension
     */
    public Dimension getScreenDimension() {
        return DriverFactory.getDriver().manage().window().getSize();
    }
}
