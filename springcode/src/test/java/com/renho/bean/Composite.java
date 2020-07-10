package com.renho.bean;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Composite {

    private Composite composite;

    public Composite() {}

    public Composite(Composite composite) {
        this.composite = composite;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(Composite composite) {
        this.composite = composite;
    }
}
