package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.SearchSteps;
import utils.DriverFactory;
import utils.PropertyReader;

public abstract class BaseTest extends TestsData {

    private static WebDriver driver;
    SearchSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getUrl());
        steps = new SearchSteps();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }
}
