package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void startMailServer() {
        app.mailHelper().start();
    }

    @Test
    public void testRegistration() throws IOException, InterruptedException, MessagingException {
        long now = System.currentTimeMillis();
        String email = "user@localhost.localdomain" + now;
        String user = "user" + now;
        String password = "password";
        String realname = "Ismail";
        //app.james().createUser(user,password);
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mailHelper().waitForMail(0, 10000);
        //List<MailMessage> mailMessages = app.james().waitForMail(user,password,10000 );
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password, realname);
        assertTrue(app.newSession().login(password, user));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mailHelper().stop();
    }
}