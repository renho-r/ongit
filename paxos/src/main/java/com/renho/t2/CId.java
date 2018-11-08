package com.renho.t2;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class CId {

    private Integer cid = 1;
    private CId() {

    }

    private static CId instance = new CId();

    public synchronized static Integer getCid() {
        return instance.cid++;
    }
}