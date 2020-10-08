import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver; //  how to fix = driver is null?
                            //it's not allow me write more IF for Windows settings.


    @BeforeSuite
    public void setup(String browserType) {
        String osName = System.getProperty("os.name");

        if (osName.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/macOS/gecko/geckodriver");
            driver = new FirefoxDriver();

        if (browserType.equals("Chrome"))
            System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/macOS/chrome/chromedriver85");
            driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    //1. open main page
    //2. click singIn
    //3. type valid email
    //4. click next
    //5. type valid password
    //6. click next

    @BeforeTest
    public void logIn() {
        String email = HideInfo.EMAIL;
        String password = HideInfo.PASSWORD;


        openMainPage();
        singInFiled();
        typeEmail(email);
        clickButtonNext1();
        typePassword(password);
        clickButtonNext1();
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
}
