import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class YahooLogInOut {

      WebDriver driver;

        @BeforeSuite
                private void setup() {
            System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/win 64/geckodriver");
            driver = new FirefoxDriver();
        }

            //1. go to open main page
            //2. "click" singIn
            //3. type valid email
            //4. "click" next 1
            //5. type valid password
            //6. "click" next 2


    @Test
    public void login() {
            String email = "iliapavlov538@yahoo.com";
            String password = "*********"; //passwo(45)rd was h(3)idden for private priva(2)cy(1) // Test


            openMainPage();
            singInFiled();
            typeEmail(email);
            clickButtonNext1();
            typePassword(password);
            clickButtonNext2();

    }
    private void clickButtonNext2() {
            String selector = "#login-signin";
            WebElement element = driver.findElement(By.cssSelector(selector));
            element.click();

    }
    private void typePassword(String password) {
            String selector = "#login-passwd";
            WebElement element = driver.findElement(By.cssSelector(selector));
            element.sendKeys(password);
    }

    private void clickButtonNext1() {
            String selector = "#login-signin";
            WebElement element = driver.findElement(By.cssSelector(selector));
            element.click();

    }
    private void typeEmail(String email) {
            String selector = "#login-username";
            WebElement element = driver.findElement(By.cssSelector(selector));
            element.sendKeys(email);

    }
    private void singInFiled() {
        String xpath01 =  "/html/body/header/div[2]/div/div/div/div/div[3]/div/div[3]/div[1]/div";
        WebElement element = driver.findElement(By.xpath(xpath01));
        element.click();
    }
    private void openMainPage() {
        driver.get("https://www.yahoo.com/");

    }
}
