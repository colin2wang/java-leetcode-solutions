package com.colin.leetcode;

public class NameFormatter {

    public static String captureName(String str) {
        char[] cs = str.toCharArray();
        int idx = 0;
        while (cs[idx] >= 48 && cs[idx] <= 57) {
            idx++;
        }
        cs[idx] -= 32;
        return String.valueOf(cs);
    }

    public static String getLengthString(String oriString, int length) {
        StringBuilder retString = new StringBuilder(oriString);
        if (oriString.length() == length) {
            return retString.toString();
        } else {
            for (int i = 0; i < length - oriString.length(); i++) {
                retString.insert(0, "0");
            }
        }
        return retString.toString();
    }

    public static void main(String[] args) {
        System.out.println(captureName("3sum"));
    }
}
