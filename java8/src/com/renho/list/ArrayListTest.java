package com.renho.list;

<<<<<<< HEAD
=======
import java.lang.reflect.Field;
>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23
import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * @author renho
 * @since: 2019/11/6
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(0);
        list.add(1);
        list.add(2);
    }

=======
 * @author: renho
 * @since: 1.0.0
 */
public class ArrayListTest {

    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>();
        print(arr);
        System.out.println(arr);
        for (int i = 0; i < 30; i++) {
            arr.add(i);
            print(arr);
        }
        System.out.println(arr);

        List<Integer> b = new ArrayList<>();
        b.add(1);

        arr.retainAll(b);
        System.out.println(arr);
    }

    static void print(List list) throws Exception {
        Class c = list.getClass();
        //elementData ����ArrayList���ڵײ�洢���ݵ�����,
        //����ͨ���۲����鳤�ȵı仯��֤��������˵�����ݻ�����ȷ��
        Field f = c.getDeclaredField("elementData");
        //���ÿɷ���
        f.setAccessible(true);
        //�������
        Object[] elementData = (Object[])f.get(list);
        System.out.println("elementData.length:" + elementData.length + ", size:" + list.size());
    }
>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23
}
