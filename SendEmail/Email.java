package SendEmail;

public class Email {

    public static void main(String[] args) {
        String to_email = "...who_sends...@gmail.com"; // We write Email to whom we send
        String subject_email = "New letter?"; // Email Subject
        String mail_email = "Email Text"; // Email Text

        Send sslSender = new Send("..Your_Email....@gmail.com", "....your_password_of_mail....");
        sslSender.send(subject_email, mail_email, to_email);
        System.out.print("Email send");
    }

}
