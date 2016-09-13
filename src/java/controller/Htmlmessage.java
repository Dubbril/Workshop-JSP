package controller;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

class Htmlmessage {

    private MimeMultipart multipart;

    public Htmlmessage() {
        multipart = new MimeMultipart("related");
    }

    public MimeMultipart getMultipart() {
        return multipart;
    }

    public void addHtml(String htmlText) throws MessagingException {
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlText, "text/html; charset=utf-8");
        multipart.addBodyPart(messageBodyPart);
    }

    public void addImage(String filename, String embeddedName) throws MessagingException {
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<" + embeddedName + ">");
        multipart.addBodyPart(messageBodyPart);
    }

}
