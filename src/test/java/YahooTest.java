import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.security.util.Password;

public class YahooLogInOut {

      WebDriver driver;

        @BeforeSuite
                private void setup() {
            System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/win 64/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        @AfterSuite
                private void afterSuit() {
        driver.close();
        }

            //1. go to open main page
            //2. "click" singIn
            //3. type valid email
            //4. "click" next 1
            //5. type valid password
            //6. "click" next 2


    @Test
    public void logIn() {
            String email = HideInfo.EMAIL;
            String password = HideInfo.PASSWORD;


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

    //in main page click Mail
    //click button Compose
    // type to whom
    // type Subject
    // type massage
    // click send
    //verify result




    @Test
    public void sendEmail() {
            String recipient = HideInfo.RECIPIENT;
            String subject = HideInfo.SUBJECT;
            String massage = HideInfo.MASSAGE;


            clickMail();
            clickCompose();
            typeToWhom(recipient);
            typeSubject(subject);
            typeMassage(massage);
            clickSend();
            openSent();
            verifySentMassage();  // how to verify resul that massage was send?





}

    private void verifySentMassage() {
            String element = HideInfo.RECIPIENT;
            WebElement page = driver.findElement(By.linkText(element));
            page.click();
    }

    private void openSent() {
            String element = "/html/body/div[1]/div/div[1]/div/div[2]/div/div[1]/nav/div/div[3]/div[1]/ul/li[5]/div/a/span[1]";
            WebElement button = driver.findElement(By.xpath(element));
            button.click();
    }

    private void clickSend() {
            String xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/button";
            WebElement button = driver.findElement(By.xpath(xpath));
            button.click();
    }

    private void typeMassage(String massage) {
            String xpath ="/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div/div[1]";
            WebElement mainTextField = driver.findElement(By.xpath(xpath));
            mainTextField.sendKeys(massage);
    }

    private void typeSubject(String subject) {
            String xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/div[3]/div/div/input";
            WebElement textField = driver.findElement(By.xpath(xpath));
            textField.sendKeys(subject);
    }

    private void typeToWhom(String recipient) {
            String xpath = "//*[@id=\"message-to-field\"]";
            WebElement textField = driver.findElement(By.xpath(xpath));
            textField.sendKeys(recipient);
    }

    private void clickCompose() {
            String element = "a.e_dRA";
            WebElement button = driver.findElement(By.cssSelector(element));
            button.click();
    }

    private void clickMail() {
            String xpath ="//*[@id=\"ybar-navigation-item-mail\"]";
            WebElement mail = driver.findElement(By.xpath(xpath));
            mail.click();

    }
    }
