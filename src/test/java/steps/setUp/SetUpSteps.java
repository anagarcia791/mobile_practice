package steps.setUp;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.ChromePage;
import runner.TestContext;
import steps.BaseSteps;

public class SetUpSteps extends BaseSteps {

    private static final Logger logger = LoggerFactory.getLogger(SetUpSteps.class);

    ChromePage chromePage = new ChromePage(DriverFactory.getDriver());

    public SetUpSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("User unlock the cellphone")
    public void unlocksCellphone() {
        System.out.println("User unlock the cellphone");
    }

    @Given("User tap Chrome button")
    public void tapChromeButton() {
        System.out.println("SEGUNDO STEP-------------------------");
        chromePage.clickChromeButton();
    }

    @Given("otra cosa x")
    public void tapChromeButton2() {
        System.out.println("TERCER STEP-------------------------");
        chromePage.clickChromeButton();
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
