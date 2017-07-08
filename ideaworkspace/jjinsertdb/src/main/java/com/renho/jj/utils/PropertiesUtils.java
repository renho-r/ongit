package com.renho.jj.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by renho on 2017/7/7.
 */
public class PropertiesUtils {

    public static final Properties INSTANCE = new Properties();;

    static {
        try {
            INSTANCE.load(new FileInputStream("etc/jjinsertdb.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
