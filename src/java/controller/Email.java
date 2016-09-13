package controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private Properties props;
    private String subject;
    private String toAddress;
    private String fromAddress;

    public Email() {
        this("localhost", "", "");
    }

    public Email(String host, String user, String password) {
        props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", host);
        props.setProperty("mail.user", user);
        props.setProperty("mail.password", password);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void send(String textMessage) throws MessagingException {
        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject, "UTF-8");
        message.setFrom(new InternetAddress(fromAddress));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
        message.setText(textMessage, "UTF-8");
        Transport.send(message);
    }

    public void send(Htmlmessage htmlMessage) throws MessagingException {
        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject, "UTF-8");
        message.setFrom(new InternetAddress(fromAddress));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
        message.setContent(htmlMessage.getMultipart());
        Transport.send(message);
    }
}
