package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChromePage extends BasePage {
    public ChromePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(getAppiumFieldDecorator(), this);
    }

    //@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"" + "Chrome" + "\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chrome\")")
    @iOSXCUITFindBy(id = "Safari")
    private WebElement chromeOption;

    public void clickChromeButton() {
        chromeOption.click();
    }

}
