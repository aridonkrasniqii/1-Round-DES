package application;

import java.util.Arrays;
import java.util.Random;


import javafx.scene.control.Label;

public class EncProcessor {


    public static String String2Hex(String str) {
        StringBuffer sb = new StringBuffer();
        //Converting string to character array
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
        }
        String result = sb.toString();
        return result;
    }


    public static String hex2String(String arg) {

        String str = "";
        for (int i = 0; i < arg.length(); i += 2) {
            String s = arg.substring(i, (i + 2));
            int decimal = Integer.parseInt(s, 16);
            str = str + (char) decimal;
        }
        return str;
    }


    public static String fillString(String str) {
        char[] text = str.toCharArray();
        char[] arr = new char[16];
        Arrays.fill(arr, '0');

        for (int i = 0; i < text.length; i++) {
            arr[i] = text[i];
        }
        return new String(arr);
    }

    public static String[] formatStrings(String text) {

        int parts = text.length() / 16;


        String[] str = new String[parts + 1];
        for (int i = 0; i < str.length - 1; i++) {
            str[i] = text.substring(i * 16, i * 16 + 16);
        }

        int j = parts + 1;
        int added = text.length() - parts * 16;


        str[j - 1] = text.substring(parts * 16, parts * 16 + added);
        str[j - 1] = fillString(str[j - 1]);

        return str;
    }


    public static String removeFill(String a) {
        char[] b = new char[a.length()];
        b = a.toCharArray();
        boolean v = true;
        int count = b.length;

        for (int i = b.length - 1; i >= 0; i--) {
            if (b[i] == '0' && v) {
                count--;
            } else {
                v = false;
            }
        }

        a = "";

        for (int i = 0; i < count; i++) {
            a += b[i];
        }

        return a;
    }

    public static String getKey(String a) {

        Random r = new Random();
        char[] HexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        a = "";
        int random = 0;

        for (int i = 0; i < 16; i++) {
            random = r.nextInt(16);
            a = a + HexChars[random];
        }

        return a;
    }

    public static boolean ValidateString(String a) {

        if (a.length() != 16) {
            return false;
        }
        return true;
    }

    public static void Err(Label a) {
        a.setText("Invalid Key!");
    }

    public static void NoErr(Label a) {
        a.setText("");
    }


}