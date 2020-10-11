import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMail() {
        driver.findElement(By.linkText("Mail")).click();
    }
}
