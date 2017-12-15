package utils;

import java.text.SimpleDateFormat;

public class Log {
    private final static String LEVEL_DEBUG = "DEBG";
    private final static String LEVEL_INFO = "INFO";

    public static void d(String msg) {
        System.out.println(msg);
    }

    private static final void printFormat(String level, String tag, String msg) {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String TimeString = time.format(new java.util.Date());
        System.out.println(TimeString + " " + level + " " + tag + ": " + msg);
    }

    public static void d(String tag, String msg) {
        printFormat(LEVEL_DEBUG, tag, msg);
    }

    public static void i(String tag, String msg) {
        printFormat(LEVEL_INFO, tag, msg);
    }
}