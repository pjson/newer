package com.newer.io.otherIO.objectIO;

import java.io.Serializable;

/**
 * Created by json on 2017/2/25.
 */
public class Address implements Serializable{

    private String city;
    private String street;

    public Address() {
    }

    public Address(String city, String street) {
        super();
        this.city = city;
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street
     *            the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Address [" + (city != null ? "city=" + city + ", " : "") + (street != null ? "street=" + street : "")
                + "]";
    }
}
