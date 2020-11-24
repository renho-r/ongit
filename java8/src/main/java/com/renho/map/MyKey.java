package com.renho.map;

/**
 * @author renho
 * @since: 2019/10/30
 */
public class MyKey implements Comparable {

    private Integer value;

    public MyKey() {}

    public MyKey(Integer value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 12345;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return this.value - ((MyKey)o).value;
    }
}
