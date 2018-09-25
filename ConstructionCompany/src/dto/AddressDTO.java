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
public class AddressDTO {

    private int id = -1;
    private String city;
    private String street;
    private String zipCode;
    private String houseNumber;

    public AddressDTO() {
    }

    public AddressDTO(int id, String city, String street, String zipCode, String houseNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
    }

    public AddressDTO(String city, String street, String zipCode, String houseNumber) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddress() {
        return this.city + ", " + this.street + ", " + this.zipCode + ", " + this.houseNumber;
    }

    public boolean equals(AddressDTO address) {
        try {
            if (this.getAddress() == null && address == null) {
                return true;
            } else if (this.getCity().equals(address.getCity())
                    && this.getStreet().equals(address.getStreet())
                    && this.getHouseNumber().equals(address.getHouseNumber())
                    && this.getZipCode().equals(address.getZipCode())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }
}
