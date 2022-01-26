package nl.alexdewaal66.novi.vessels.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Console {
    static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    static private String now() {
        Date date = new Date();
        return formatter.format(date);
    }

    static public void logv(String path) {
        System.out.println("➖➖ " + now() + " ➖➖ " + path);
    }

    static public void logv(String path, String... vars) {
        System.out.println("➖➖ " + now() + " ➖➖ " + path);
        for (String var : vars) {
            System.out.println("\t " + var);
        }
    }

    static public void logv(String path, String[]... pairs) {
        System.out.println("➖➖ " + now() + " ➖➖ " + path);
        for (String[] pair : pairs) {
            System.out.println("\t " + pair[0] + "=" + pair[1]);
        }
    }

    static public void logv(boolean condition, String path, String[]... pairs) {
        if (condition) {
            System.out.println("➖➖ " + now() + " ➖➖ " + path);
            for (String[] pair : pairs) {
                System.out.println("\t " + pair[0] + "=" + pair[1]);
            }
        }
    }

    static public String[] p(String var, Object value) {
        return new String[]{var, value.toString()};
    }

    static public boolean classCheck(Object item, String className) {
        return item.getClass().getSimpleName().equals(className);
    }
}
