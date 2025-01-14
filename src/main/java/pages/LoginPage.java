package pages;

import actions.ElementStateActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(getAppiumFieldDecorator(), this);
    }

    @AndroidFindBy(id = "inputEditText")
    @iOSXCUITFindBy(id = "CompleteTextField")
    private WebElement passwordTextBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Menú')] | //android.widget.TextView[contains(@text,'Bienvenido')]")
    private WebElement menuTitle;
    @iOSXCUITFindBy(id = "CompleteTextField")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ingresa tu contraseña')]")
    protected WebElement passwordText;

    @AndroidFindBy(id = "header_menu_notifications")
    private WebElement notificationsBell;

    public boolean isPasswordDisplayed() {
        System.out.println("ESPERA 1 ");
        return ElementStateActions.isElementDisplayed(passwordTextBox);
    }

    public boolean tapNotifications() {
        System.out.println("ESPERA 2 ");
        return ElementStateActions.isElementDisplayed(passwordText);
    }

    public boolean otra() {
        System.out.println("ESPERA 3 ");
        return ElementStateActions.isElementDisplayed(menuTitle);
    }
}