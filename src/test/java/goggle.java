import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class goggle {

    WebDriver driver;

    @BeforeSuite
    private void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/win 64/geckodriver");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    private void afterSuite() {
        driver.quit();
    }


    //1. Go to main page
    //2. Type the search query
    //3. Submit the query
    //4. Verify that results page is displayed
    @Test
    public void test0001() {
        String queryForSearch = "Portnov Computer School";
        openMainPage();
        typeQuery(queryForSearch);
        submitQuery();
        waitForResultsStats();
        verifyResultsPage();
    }


    private void verifyResultsPage() {
        String resultStatsElementId = "result-stats";
        WebElement element = driver.findElement(By.id(resultStatsElementId));
        boolean isResultsDisplayed = element.isDisplayed();
        Assert.assertTrue(isResultsDisplayed);
    }


    private void waitForResultsStats() {
        By elementToWait = By.id("result-stats");
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(elementToWait);
        new WebDriverWait(driver, 10).until(condition);
    }

    private void submitQuery() {
        String selector = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.submit();
    }

    private void typeQuery(String queryForSearch) {
        String selector = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.sendKeys(queryForSearch);
    }

    private void openMainPage() {
        driver.get("https://google.com");
    }
}