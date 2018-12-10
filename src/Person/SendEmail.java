package Person;


import Adjektiv.Deklination.Homework;
import Adjektiv.Deklination.WriteDatabase;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author
 */
public class SendEmail  {
Homework hw= new Homework();
WriteDatabase wr=new WriteDatabase();

    String filename =wr.homeworkAdr ; //dizin şeklinde

    public SendEmail() throws IOException {


    //String filename = "src/deneme/wordDokuman.doc";            //proje kaynak dosyası içindeki dizini


    }

    public void send(String student, String teacher) {
        final String username = "adjektivdeklination@gmail.com";
        final String password = "Adjektiv2018-"; //

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(teacher));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(student));
            message.setSubject("Your new Homework :");
            MimeBodyPart messageBodyPart = new MimeBodyPart();

            //Mesaj İçerik

            messageBodyPart.setText("Hello");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            //Ek Dosya
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);


            Transport.send(message);

            System.out.println("e-mail sended");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }}