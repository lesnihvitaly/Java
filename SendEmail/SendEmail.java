package SendEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    String username_gmail;
    String password_gmail;
    Properties properties;

    public Send(String username_gmail, String password_gmail) {
        this.username_gmail = username_gmail;
        this.password_gmail = password_gmail;

        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    public void send(String subject_email, String text_email, String to_email){
        Session current_session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username_gmail, password_gmail);
            }
        });

        try {
            Message message = new MimeMessage(current_session);
            // Sender of the letter
            message.setFrom(new InternetAddress(username_gmail));
            // To whom we send the letter
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to_email));
            // Subject of the message
            message.setSubject(subject_email);
            // The text of the letter itself.
            message.setText(text_email);

            // we send the message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}