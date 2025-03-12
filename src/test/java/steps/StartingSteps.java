package steps;


import config.SetFileProperty;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ChromePage;
import runner.TestContext;
import utils.ScenariosToBeRun;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


//branch for check later
public class StartingSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(StartingSteps.class);
    private static int scenariosToBeRun;
    private static final AtomicInteger numberOfScenario = new AtomicInteger(0);
    private final ThreadLocal<Integer> scenarios = new ThreadLocal<>();
    private static final String CLASSNAME = StartingSteps.class.getName() + "\t-\t";
    ChromePage chromePage;

    public StartingSteps(TestContext testContext) {
        super(testContext);
    }

    @Before(order = 0)
    public void setTotalScenarios() {
        //Setting number of scenarios to be run
        setScenariosToBeRun();
        logger.info("TOTAL OF SCENARIOS TO BE RUN: " + scenariosToBeRun);
        //Counter of scenarios executed
        setNumberOfScenarioExecuted();
    }

    @Before(order = 1)
    public void setUp() {
        System.out.println("SETUP");
        setConfigProperties(SetFileProperty.getConfigProperties());
        //logger.info("SCENARIOS " + scenarios.get());
        System.out.println("SCENARIOS ???????????????? " + scenarios.get());
        try {
            //Open appium once for 1 thread
            if (scenarios.get() >= 1) {
                AppiumDriver appiumDriver = DriverFactory.createDriver(getConfigProperties());
                setDriver(appiumDriver);

                //this.loginPage = new LoginPage(getDriver());

                //this.chromePage = new ChromePage(getDriver());
                appiumService = DriverFactory.getAppiumService();
            } else {
                System.out.println("tomo otro camino");
            }
            try {
                //boolean x = loginPage.isPasswordDisplayed();
                //System.out.println("result jojoj -------------------------" + x);

                //chromePage.clickChromeButton();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(CLASSNAME + "Exception while running Set up :" + ex.getMessage());
        }

    }


    /**
     * Sets total of scenarios to be run
     */
    private void setScenariosToBeRun() {
        scenariosToBeRun = ScenariosToBeRun.totalOfScenarios;
    }

    /**
     * Sets number of scenario executed
     */
    private void setNumberOfScenarioExecuted() {
        numberOfScenario.addAndGet(1);
        scenarios.set(numberOfScenario.get());
        logger.info("NUMBER OF SCENARIO TO BE RUN");
        logger.info(scenarios.get() + "");
    }


    @After(order = 1)
    public void tearDown(Scenario scenario) throws IOException {
        if (scenarios.get() >= 1) {
            ScenariosToBeRun.totalOfScenarios--;
            setScenariosToBeRun();
            //closeOneThreadSession();
            //Closing Appium server when the last scenario got run
            if (scenariosToBeRun == 0) {
                System.out.println(CLASSNAME + "Closing session OPCION 1 " + appiumService.getUrl().toString());
                getDriver().quit();
                logger.info("Driver quit");
                appiumService.stop();
                logger.info("Appium service stopped");
            }
        } else {
            closeSession();
        }
    }

//    private void closeOneThreadSession() {
//        int attempts = 1;
//        boolean appWasFinished = false;
//        try {
//            while (attempts > 0 && attempts <= 3) {
//                logger.info("Attempts to terminate the app: " + attempts);
//                appWasFinished = getDriver().terminateApp(packageName);
//                if (appWasFinished) {
//                    break;
//                } else {
//                    logger.info("Attempts to terminate the app: " + attempts);
//                    attempts += 1;
//                }
//            }
//            logger.info("App was successfully closed? " + appWasFinished);
//        } catch (WebDriverException e){
//            getDriver().closeApp();
//            logger.info("App was closed!");
//        }
//    }

    private void closeSession() {
        try {
            //getDriver().closeApp();
            getDriver().quit();
            System.out.println(CLASSNAME + "Closing session OPCION 2 " + appiumService.getUrl().toString());
            if (scenarios.get() >= 1) {
                System.out.println(CLASSNAME + "Closing session OPCION 3 " + appiumService.getUrl().toString());
                appiumService.stop();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
