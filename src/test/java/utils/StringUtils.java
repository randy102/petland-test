package utils;

import java.util.UUID;

public class StringUtils {
    public static String rand(){
        return UUID.randomUUID().toString();
    }

    public static String randEmail(){
        String randString = rand();
        return randString + "@gmail.com";
    }
}
