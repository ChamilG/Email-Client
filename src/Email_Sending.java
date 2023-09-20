import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Email_Sending {
   public static void sendMail(String recipient, String subject, String content) throws MessagingException {

       Properties props = new Properties();

       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");

       String myAccountEmail = "travellerfox5@gmail.com";
       String password = "fmexbdfjccjzyxmf";
       Session session = Session.getInstance(props, new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(myAccountEmail, password);
           }
       });
       //String emailContent = String.format("%s\n\n%s", subject, content);
       Message msg = prepareMessage(session, myAccountEmail, recipient, subject, content);
       //assert msg != null;
       Transport.send(msg);
       System.out.println("Success :)");
   }

   public static Message prepareMessage(Session session, String myAccountEmail, String recepient, String subject, String Content){
       try {
           MimeMessage msg = new MimeMessage(session);
           msg.setFrom(new InternetAddress(myAccountEmail));
           msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           msg.setSubject(subject);
         //  msg.setSentDate(new Date());
           msg.setText(Content);
           return msg;
       } catch (MessagingException e) {
           System.out.println("send failed, exception: " + e);
       }
       return null;
   }
}
