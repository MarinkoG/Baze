/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author LJUBO
 */
public class UserDTO {

    private String personalIdNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String privilege;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String personalIdNumber, String firstName, String lastName, String username, String privilege) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdNumber = personalIdNumber;
        this.username = username;
        this.privilege = privilege;
    }

    public UserDTO(String personalIdNumber, String firstName, String lastName, String username, String password, String privilege) {
        this.personalIdNumber = personalIdNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.privilege = privilege;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
