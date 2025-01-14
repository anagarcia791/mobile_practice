package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class BasePage {

    private final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected AppiumDriver driver;
    protected AppiumFieldDecorator appiumFieldDecorator;
    private final Duration TIMEOUT_DECORATOR = ofSeconds(5);

    public BasePage(AppiumDriver driver) {
        System.out.println("DRIVER EN BASE PAGE ???????? ---- " + driver);
        this.driver = driver;
        initAppiumFieldDecorator();
    }

    /**
     * Init Appium Field Decorator
     */
    private void initAppiumFieldDecorator() {
        appiumFieldDecorator = new AppiumFieldDecorator(driver, TIMEOUT_DECORATOR);
    }

    /**
     * In any constructor page, to init WebElements use:
     * PageFactory.initElements(getAppiumFieldDecorator(), this);
     *
     * @return appiumFieldDecorator
     */
    protected AppiumFieldDecorator getAppiumFieldDecorator() {
        return appiumFieldDecorator;
    }

    /**
     * Asks if the Driver is set, if not, you will get a false value.
     *
     * @return boolean
     */
    public boolean isDriverAvailable() {
        return this.driver != null;
    }

}