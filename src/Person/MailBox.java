package Person;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 *
 * @author
 */
public class MailBox {

    String fromEmail;
    String password;

    public MailBox (String fromEmail, String password){
        this.fromEmail= fromEmail;
        this.password=password;
    }



    public void send(String toEmail, String pathAdr,String yourGreeting) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Homework ");
            MimeBodyPart messageBodyPart = new MimeBodyPart();

            //yourGreeting
            messageBodyPart.setText(yourGreeting);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            //attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(pathAdr);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);


            Transport.send(message);
            System.out.println("e-mail sended");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void receiveMail(){}

}