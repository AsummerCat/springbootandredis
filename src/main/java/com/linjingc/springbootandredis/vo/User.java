package com.linjingc.springbootandredis.vo;


import java.io.Serializable;

/**
 * @author cxc
 * @date 2018/10/8 17:31
 */
public class User implements Serializable {

    private static final long serialVersionUID = -2752036156420701444L;
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
