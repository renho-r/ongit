package com.renho;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public String getAge();

    public void setAge(String age);

    public void helloWorld();

    public void helloWorld(String str);

    public void getTelephone();
}
