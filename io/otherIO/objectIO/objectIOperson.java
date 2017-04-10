package com.newer.io.otherIO.objectIO;

import java.io.Serializable;

/**
 * Created by json on 2017/2/23.
 */
public class objectIOperson implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int age;
    double weigh;
    Address address;

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public objectIOperson() {
    }

    public objectIOperson(String name, int age, double weigh) {
        this.name = name;
        this.age = age;
        this.weigh = weigh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeigh() {
        return weigh;
    }

    public void setWeigh(double weigh) {
        this.weigh = weigh;
    }

    @Override
    public String toString() {
        return "objectIOperson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weigh=" + weigh +
                '}';
    }
}
