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
public class EmployeeDTO extends PersonDTO {

    private String hourlyRate;
    private String salary;
    private String username;
    private String password;
    private String privilege;

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(String hourlyRate, String salary, String username, String firstName, String lastName, String personalId, String dateOfBirth, String phoneNumber, String email, AddressDTO address) {
        super(firstName, lastName, personalId, dateOfBirth, phoneNumber, email, address);
        this.hourlyRate = hourlyRate;
        this.salary = salary;
        this.username = username;
    }

    public EmployeeDTO(String hourlyRate, String salary, String username, String password, String privilege, String firstName, String lastName, String personalId, String dateOfBirth, String phoneNumber, String email, AddressDTO address) {
        super(firstName, lastName, personalId, dateOfBirth, phoneNumber, email, address);
        this.hourlyRate = hourlyRate;
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public boolean equals(EmployeeDTO employee) {
        boolean equal = false;
        try {
            if (this.getPersonalIdNumber().equals(employee.getPersonalIdNumber())
                    && this.getFirstName().equals(employee.getFirstName())
                    && this.getLastName().equals(employee.getLastName())
                    && this.getDateOfBirth().equals(employee.getDateOfBirth())
                    && this.getAddress().equals(employee.getAddress())
                    && this.getEmail().equals(employee.getEmail())
                    && this.getPhoneNumber().equals(employee.getPhoneNumber())
                    && this.getHourlyRate().equals(employee.getHourlyRate())
                    && this.getSalary().equals(employee.getSalary())) {
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

    }
}
