import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoxPage {
    private final WebDriver driver;

    public BoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCompose() {
        WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Compose')]"));
        button.click();
    }

    public void typeToWhom(String recipient) {
        WebElement textField = driver.findElement(By.xpath(" //input[@id='message-to-field']"));
        textField.sendKeys(recipient);
    }

    public void typeSubject(String subject) {
        WebElement textField = driver.findElement(By.cssSelector("input.q_T:nth-child(1)"));
        textField.sendKeys(subject);
    }

    public void typeMassage(String massage) {
        String linkTest = ".rte";                                                 //String linkTest = "Message body";
        WebElement mainTextField = driver.findElement(By.cssSelector(linkTest)); //(By.linkText(linkTest))
        mainTextField.sendKeys(massage);
    }

    public void clickSend() {
        WebElement button = driver.findElement(By.cssSelector(".q_Z2aVTcY")); //(By.linkText("Send"))
        button.click();
    }

    public void openSent() {
        WebElement button = driver.findElement(By.cssSelector(".Q_689y")); //(By.linkText("Sent"))
        button.click();
    }

    public String verifySentMassage() {
        WebElement message = driver.findElement(By.linkText(HideInfo.RECIPIENT));
        return message.getText();
    }
}

