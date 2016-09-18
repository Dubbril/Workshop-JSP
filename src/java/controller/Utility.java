package controller;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.mail.MessagingException;

class Utility {

    public static String convetThai(String text) {
        try {
            return new String(text.getBytes("ISO8859_1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    public static String randomText(int len) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        String code;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        code = sb.toString();
        return code;
    }

    static void sendMail(String from, String to, String subject, String body) {
        sendMail(from, to, "", "", subject, body);
    }

    public static void sendMail(String from, String to, String cc, String bcc, String subject, String body) {
        try {
            Email email = new Email();
            Htmlmessage msg = new Htmlmessage();
            msg.addHtml(body);
            email.setFromAddress(from);
            email.setToAddress(body);
            email.setSubject(subject);
            email.send(msg);
        } catch (MessagingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    static boolean isNumber(String string) {
        try {
            int d = Integer.parseInt(string);
        } catch (NumberFormatException ex) {

            return false;

        }
        return true;
    }
}
