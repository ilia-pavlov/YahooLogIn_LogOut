package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utilites.Log;


public class BaseTest {

    public WebDriver driver;

    @Parameters({"browser"})

    @BeforeTest
    public void setup(String browserType) {
        Log.startLog("");

        String osName = System.getProperty("os.name");
        if (osName.equalsIgnoreCase("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/macOS/gecko/geckodriver");

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

        String email = HideInfo.EMAIL;
        String password = HideInfo.PASSWORD;


        openMainPage();
        singInFiled();
        typeEmail(email);
        clickButtonNext1();
        Log.info("email was typed");
        typePassword(password);
        clickButtonNext1();
        Log.info("User logged!!");

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
        Log.endLog("");
        driver.quit();
    }

    }


