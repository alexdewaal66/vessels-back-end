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
        System.out.println("\n➖➖ " + now() + " ➖➖ " + path);
    }

    static public void logv(String path, String... pairs) {
        logv(path);
        for (String pair : pairs) {
            System.out.println("\t " + pair);
        }
        System.out.println();
    }

    static public void logv(boolean condition, String path, String ... pairs) {
        if (condition) {
            logv(path, pairs);
        }
    }

    static public String pair(String var, Object value) {
        return var + "=" + value.toString();
    }

    static public boolean classCheck(Object item, String className) {
        return item.getClass().getSimpleName().equals(className);
    }

    static public boolean classCheck(Object item, Class claz) {
        return item.getClass().getSimpleName().equals(claz.getSimpleName());
    }
}
