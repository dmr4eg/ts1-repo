import cz.cvut.fel.ts1.refactoring.DBManager;
import cz.cvut.fel.ts1.refactoring.Mail;
import cz.cvut.fel.ts1.refactoring.MailHelper;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MailHelperTest {
    @Test
    public void sendMail_Neco_Neco(){
        DBManager mockedDBManager = mock(DBManager.class);
        MailHelper mailHelper = new MailHelper(mockedDBManager);
        int mailId = 1;
        Mail mailToReturn = null;
        when(mockedDBManager.findMail(anyInt())).thenReturn(mailToReturn);
        mailHelper.sendMail(mailId);

        verify(mockedDBManager,times(1)).findMail(mailId);
        verify(mockedDBManager,times(0)).saveMail(mailToReturn);

    }



}
