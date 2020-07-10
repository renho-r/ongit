package com.renho.bean.pojo;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Prototype {

    private Singleton singleton;
    private Prototype prototype;

    public Prototype() {}

    public Prototype(Singleton singleton) {
        this.singleton = singleton;
    }

    public Prototype(Prototype prototype) {
        this.prototype = prototype;
    }

    public Singleton getSingleton() {
        return singleton;
    }

    public void setSingleton(Singleton singleton) {
        this.singleton = singleton;
    }

    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }
}
