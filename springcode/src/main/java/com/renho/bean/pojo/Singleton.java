package com.renho.bean.pojo;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Singleton {

    private Singleton singleton;
    private Prototype prototype;

    public Singleton() {}

    public Singleton(Singleton singleton) {
        this.singleton = singleton;
    }

    public Singleton(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }

    public Singleton getSingleton() {
        return singleton;
    }

    public void setSingleton(Singleton singleton) {
        this.singleton = singleton;
    }
}
