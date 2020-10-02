import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class YahooLogInOut {

    WebDriver driver;

    @BeforeSuite
    private void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resourse/webdriver/MacOS/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
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
        verifySentMassage();

        Assert.assertEquals(verifySentMassage(), HideInfo.EMAIL);

    }

    private String verifySentMassage() {
        WebElement message = driver.findElement(By.linkText(HideInfo.EMAIL));
        return message.getText();


    }

    private void openSent() {
        WebElement button = driver.findElement(By.linkText("Sent"));
        button.click();
    }

    private void clickSend() {
        String id = "compose-send-button";
        WebElement button = driver.findElement(By.id(id));
        button.click();
    }

    private void typeMassage(String massage) {
        String linkTest = "Message body";
        WebElement mainTextField = driver.findElement(By.linkText(linkTest));
        mainTextField.sendKeys(massage);
    }

    private void typeSubject(String subject) {
        WebElement textField = driver.findElement(By.linkText("Subject"));
        textField.sendKeys(subject);
    }

    private void typeToWhom(String recipient) {
        WebElement textField = driver.findElement(By.id(" //input[@id='message-to-field']"));
        textField.sendKeys(recipient);
    }

    private void clickCompose() {
        WebElement button = driver.findElement(By.linkText("Compose"));
        button.click();
    }

    private void clickMail() {
        driver.findElement(By.linkText("Mail")).click();

    }


}




























