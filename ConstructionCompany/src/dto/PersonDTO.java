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
public class PersonDTO {

    private String firstName;
    private String lastName;
    private String personalIdNumber;
    private String dateOfBirth;
    private AddressDTO address = null;
    private String phoneNumber;
    private String email;

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName, String personalId, String dateOfBirth, String phoneNumber, String email, AddressDTO address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdNumber = personalId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddressString() {
        if (address != null) {
            return address.getAddress();
        } else {
            return "";
        }
        
    }

    public AddressDTO getAddress() {
        return this.address;
    }
    
    public void setAddressString(String address) {
        String parts[] = address.split(", ");
        this.address = new AddressDTO(parts[0], parts[1], parts[2], parts[3]);
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
