package com.renho;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static final List<String> DEL_LIST = new ArrayList();

    static {
        DEL_LIST.add("Date first seen");
        DEL_LIST.add("Summary:");
        DEL_LIST.add("Time window:");
        DEL_LIST.add("Total flows processed:");
        DEL_LIST.add("Sys:");
    }

    public static boolean isDel(String data) {
        for(String s: DEL_LIST) {
            if(data.startsWith(s)) {
                return true;
            }
        }
        return false;
    }

    private static final String RE = "(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\.\\d{3})" + //1017-06-08 21:53:46.000
            "\\s+" + //"    "
            "(\\d+\\.*\\d*)" +//15.000
            "\\s+" +//" "
            "(\\S+)" +//UDP
            "\\s+" +//"        "
            "(\\S+?)" +//"42.63.30.57:27058"
            "\\s+" +//" "
            "(\\S+?)" +//"->"
            "\\s+" +//"     "
            "(\\S+?)" +//1.62.137.211:60854
            "\\s+" +//"    "
            "([\\S]+\\s?\\w)" +//10000|10000 M|G
            "\\s+" +//"    "
            "([\\S]+\\s?\\w)" +//280000|280000 M|G
            "\\s*" +//"    "
            "(\\S*)";//"1"

    public static String format(String data) {
        String sp = "|";
        String backStr = "";
        Pattern p = Pattern.compile(RE);
        Matcher matcher = p.matcher(data);
        List<String> str = new ArrayList<>();
        if (matcher.find()) {
            matcher.group(0);
            for(int i=1; i<10; i++) {
                if(5 == i) {
                    continue;
                }
                str.add(matcher.group(i));
            }
            backStr = StringUtils.join(str, sp);
        } else {
            System.out.println("error:" + data);
            backStr = data;
        }
        return backStr;
    }
}
