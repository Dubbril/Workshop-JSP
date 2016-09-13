package controller;

import java.io.UnsupportedEncodingException;
import java.util.Random;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
