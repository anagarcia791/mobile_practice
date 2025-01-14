package steps.setUp;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import pages.LoginPage;
import runner.TestContext;
import steps.BaseSteps;

public class SetUpSteps extends BaseSteps {

    private static final Logger logger = LoggerFactory.getLogger(SetUpSteps.class);

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    public SetUpSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("User unlock the cellphone")
    public void unlocksCellphone() {
        System.out.println("SET UP STEPS!!");
    }

    @Given("User tap Chrome button")
    public void tapChromeButton() {
        System.out.println("SEGUNDO STEP-------------------------");
        Assert.assertTrue(loginPage.tapNotifications(), "Dashboard not loaded");
    }

    @Given("otra cosa x")
    public void tapChromeButton2() {
        System.out.println("SEGUNDO STEP XXXXXX-------------------------");
        Assert.assertTrue( loginPage.otra(), "XXXX paila");
    }
//
//    @When("User type {string} in the searcher")
//    public void search(String elementToSearch) {
//        //TODO
//    }
//
//    @Then("User see a list of results")
//    public void getResultList() {
//        //TODO
//    }

}
