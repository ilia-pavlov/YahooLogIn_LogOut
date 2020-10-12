import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.apache.logging.log4j.LogManager.getLogger;


public class BaseTest {

    private static Logger logger = getLogger(Services.class.getName());

    public WebDriver driver;

    @Parameters({"browser"})

    @BeforeTest
    public void setup(String browserType) {
        String osName = System.getProperty("os.name");


        if (osName.equalsIgnoreCase("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/macOS/gecko/geckodriver");

        logger.info("OS was chosen");
        logger.debug("Debug Message OS in progress");
        logger.error("Error message OS was not chosen");
        logger.trace("Trace message OS is NULL ");
        logger.warn("Warn message OS is in warn");
        logger.fatal("FATAL message program was crashed! ");

            if (browserType.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resourse/webdriver/macOS/chrome/chromedriver86");
                driver = new ChromeDriver();
            }
        }

        if (osName.contains("windows")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/win64/gecko/geckodriver.exe");
        }

        if (browserType.equals("FF")) {
            driver = new FirefoxDriver();
        }

       logger.debug("both drivers was launched");

        String email = HideInfo.EMAIL;
        String password = HideInfo.PASSWORD;


        openMainPage();
        //log.info("Main Page was open");
        singInFiled();
        typeEmail(email);
       // log.info ("Email was typed");
        clickButtonNext1();
        typePassword(password);
       // log.info("Password was typed");
        clickButtonNext1();
       // log.info ("login in was succeed, User in Email Box");
    }

    private void typePassword(String password) {
        String xpath = "//*[@id='login-passwd']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(password);
    }

    private void clickButtonNext1() {
        driver.findElement(By.id("login-signin")).click();

    }

    private void typeEmail(String email) {
        driver.findElement(By.id("login-username")).sendKeys(email);

    }

    private void singInFiled() {
        WebElement element = driver.findElement(By.linkText("Sign in"));
        element.click();
    }

    private void openMainPage() {
        driver.get("https://www.yahoo.com/");

    }


    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    static class Services {
    }
}

