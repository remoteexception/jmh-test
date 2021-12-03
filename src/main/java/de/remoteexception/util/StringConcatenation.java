package de.remoteexception.util;

public class StringConcatenation {

    public static String joinViaConcat(String[] strings) {
        String result = "";
        for (String string : strings) {
            result = result.concat(string);
        }
        return result;
    }

    public static String joinViaPlus(String[] strings) {
        String result = "";
        for (String string : strings) {
            result += string;
        }
        return result;
    }

    public static String joinViaAppend(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }
        return result.toString();
    }
}
