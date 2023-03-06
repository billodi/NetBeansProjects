package model;

/**
 *
 * @author BILLODI
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class ForgetPass {

    public static boolean sent_or_not;
    public static String to_mail = "default"; //me forget pw eka request karana email eka mekata thama email eka yanne
    public static String recov_pin = "default pin"; //pin eka
    //oya dekama oya me palleha method eka run karanna kalin ForgetPass.to_mail = ehema kiyala set karalai palleha method eka run karnna 

    public static void fp() {

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");

        final String username = "forgetpasstest1234@gmail.com"; //oyage email eka(ee kiyanne mn pw eka reset karanna request ekak yawwahama mata me email eken thama code eka enne)
        final String password = "ezyinatitwjidnna"; //eke pw eka
        try {
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // -- Create a new message --
            Message msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to_mail, false));
            msg.setSubject("Heres Your Recovery Pin");
            msg.setText(recov_pin);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Message sent.");

            sent_or_not = true;
        } catch (MessagingException e) {
            sent_or_not = false;
            System.out.println("Error, Because: " + e);
        }
    }
}
