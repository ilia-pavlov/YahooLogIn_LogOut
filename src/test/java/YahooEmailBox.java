import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoxPage;
import pages.MainPage;
import tests.BaseTest;

public class YahooEmailBox extends BaseTest {

    //1. in main page click Mail
    //2. in box page click Compose
    //3. type to whom
    //4. type Subject
    //5. type massage
    //6. click send
    //7. verify result


    @Test
    public void sendEmailToOneUser() {
        String recipient = HideInfo.RECIPIENT;
        String subject = HideInfo.SUBJECT;
        String massage = HideInfo.MASSAGE;

        MainPage mainPage = new MainPage(driver);
        mainPage.clickMail();

        BoxPage boxPage = new BoxPage(driver);
        boxPage.clickCompose();
        boxPage.typeToWhom(recipient);
        boxPage.typeSubject(subject);
        boxPage.typeMassage(massage);
        boxPage.clickSend();
        boxPage.openSent();

        Assert.assertEquals(boxPage.verifySentMassage(), HideInfo.EMAIL);
    }

    @Test
    public void sendEmailTo2Users() {
        String recipient = HideInfo.RECIPIENT;
        String subject = HideInfo.SUBJECT;
        String massage = HideInfo.MASSAGE;

        MainPage mainPage = new MainPage(driver);
        mainPage.clickMail();

        BoxPage boxPage = new BoxPage(driver);
        boxPage.clickCompose();
        boxPage.typeToWhom(recipient);
        boxPage.typeSubject(subject);
        boxPage.typeMassage(massage);
        boxPage.clickSend();
        boxPage.openSent();

        Assert.assertEquals(boxPage.verifySentMassage(), HideInfo.RECIPIENT);

    }
}

