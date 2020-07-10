package com.renho.map;

/**
<<<<<<< HEAD
 * @author renho
 * @since: 2019/10/30
 */
public class MyKey {
=======
 * @author: renho
 * @since: 1.0.0
 */
public class MyKey implements Comparable {

    private Integer value;

    public MyKey() {}

    public MyKey(Integer value) {
        this.value = value;
    }
>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23

    @Override
    public int hashCode() {
        return 12345;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
<<<<<<< HEAD
=======

    @Override
    public int compareTo(Object o) {
        return this.value - ((MyKey)o).value;
    }
>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23
}
