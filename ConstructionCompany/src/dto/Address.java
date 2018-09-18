/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author mgrubljesic
 */
public class Address {

    private int id;
    private String city;
    private String street;
    private int zipCode;
    private int number;

    public Address() {
    }

    public Address(int id, String city, String street, int zipCode, int number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
    }

    public Address(String city, String street, int zipCode, int number) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return city + ", " + street + ", " + number + ", " + zipCode;

    }
}
