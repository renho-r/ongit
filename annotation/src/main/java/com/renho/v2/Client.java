package com.renho.v2;

import com.renho.v2.po.UserInfo;
import com.renho.v2.annotation.FormatAnnotation.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author renho
 * @since: 2017/8/17
 */
public class Client {

    public static void main(String[] args) throws IllegalAccessException {
        Client client = new Client();
        UserInfo user = new UserInfo(100, "renho", "renho-addr");
        client.format(user);
    }

    private <T> void format(T t) throws IllegalAccessException {

        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        List<Field> fs = Stream.of(fields).filter(f -> f.getAnnotationsByType(Index.class).length > 0).collect(Collectors.toList());
        List<Object> indexList = Arrays.asList(new Object[fs.size()]);
        for(Field f: fs) {
            f.setAccessible( true );
            System.out.println(f.get(t));
            Index index = f.getAnnotation(Index.class);
            indexList.set(index.value()-1, f.get(t));
        }
        System.out.println(StringUtils.join(indexList.toArray(), "|"));
    }

}
