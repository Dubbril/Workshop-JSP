package controller;

import java.io.UnsupportedEncodingException;

class Utility {

    public static String convetThai(String text) {
        try {
            return new String(text.getBytes("ISO8859_1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }
}
