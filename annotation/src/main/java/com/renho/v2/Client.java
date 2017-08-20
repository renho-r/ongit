package com.renho.v2;

import com.renho.v2.po.UserInfo;
import com.renho.v2.annotation.FormatAnnotation.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        List<Field> hasAnnotationFields = filterAnnotation(fields, Index.class);
        sortByAnnValue(hasAnnotationFields, Index.class);
        List<Object> indexList = getFormatIndex(hasAnnotationFields, Index.class, t);
        System.out.println(StringUtils.join(indexList.toArray(), "|"));
    }

    private List<Object> getFormatIndex(List<Field> hasAnnotationFields, Class<Index> iClass, Object obj) throws IllegalAccessException {
        List<Object> indexList = new ArrayList<>();
        for(Field f: hasAnnotationFields) {
            f.setAccessible( true );
            Index i = f.getAnnotation(iClass);
            indexList.add(f.get(obj));
        }
        return indexList;
    }

    private void sortByAnnValue(List<Field> hasAnnotationFields, Class<Index> clazz) {
        Collections.sort(hasAnnotationFields, new Comparator<Field>() {
            @Override
            public int compare(Field f1, Field f2) {
                Index index1 = f1.getAnnotation(clazz);
                Index index2 = f2.getAnnotation(clazz);
                return index1.value() - index2.value();
            }
        });
    }

    private List<Field> filterAnnotation(Field[] fields, Class clazz) {
        List<Field> filteredFields = new ArrayList<>();
        for(Field f: fields) {
            if(f.getAnnotationsByType(clazz).length > 0) {
                filteredFields.add(f);
            }
        }
        return filteredFields;
    }

}
