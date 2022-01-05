package nl.alexdewaal66.novi.vessels.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Console {
    static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    static private String now() {
        Date date = new Date();
        return formatter.format(date);
    }

    static public void logv(String path, String ...vars) {
        System.out.println("➖➖ " + now() + " ➖➖ " + path);
        for(String var : vars) {
            System.out.println("\t " + var);
        }
   }
}
