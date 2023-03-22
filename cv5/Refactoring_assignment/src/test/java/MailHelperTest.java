import cz.cvut.fel.ts1.refactoring.Mail;
import cz.cvut.fel.ts1.refactoring.MailHelper;
import org.junit.jupiter.api.Test;

public class MailHelperTest {
    @Test
    public void createAndSendMailTest(String to, String subject, String body) {
        Mail mail = new Mail();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setBody(body);
        mail.setIsSent(true);
        MailHelper.sendMail(mail.getMailId());
    }

    @Test
    public void createAndSendMailWithNull() {
    }

    @Test
    @ParametrizedTest (name = "{index} => mailId={0}")
    public void sendMailTest(){
        Mail mail = new Mail();
        mail.setMailId(1);
        mail.setTo("to");
        mail.setSubject("subject");
        mail.setBody("body");
        mail.setIsSent(true);
        MailHelper.sendMail(mail.getMailId());
    }
}
