package com.youngman.crm.utils;

public class Utils {
    private Utils() {
    }

    public static String findPan(String gst) {
        return gst.substring(2,12);
    }
}
