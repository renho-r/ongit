package com.renho.sax;

/**
 * @author renho
 * @since: 2017/10/12
 */
public class Field {

    private String id;
    private String name;
    private String length;
    private String nonull;
    private String index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getNonull() {
        return nonull;
    }

    public void setNonull(String nonull) {
        this.nonull = nonull;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
