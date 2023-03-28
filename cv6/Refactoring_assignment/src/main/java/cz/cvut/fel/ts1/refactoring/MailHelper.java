package cz.cvut.fel.ts1.refactoring;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author balikm1
 */
public class MailHelper {
   DBManager dbmanager;

    public MailHelper(DBManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    public void createAndSendMail(String to, String subject, String body)
    {
        Mail mail = new Mail();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setBody(body);
        mail.setIsSent(false);
//        DBManager dbManager = new DBManager();
        this.dbmanager.saveMail(mail);

        if (!Configuration.isDebug) {
            (new Thread(() -> {
                sendMail(mail.getMailId());
            })).start();
        }
    }
    
    public void sendMail(int mailId)
    {
        try
        {
            // get entity
            Mail mail = this.dbmanager.findMail(mailId);
            if (mail == null) {
                return;
            }

            if (mail.isSent()) {
                return;
            }

            this.dbmanager.saveMail(mail);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
    }
    
}
