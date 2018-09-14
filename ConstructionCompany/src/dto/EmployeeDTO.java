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
public class EmployeeDTO extends PersonDTO{

    private String profession;
    private String hourlyRate;
    private String salary;
    private String bankAccount;
    private String username;
    private String password;
    private String privilege;

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(String profession, String hourlyRate, String salary, String bankAccount, String username, String firstName, String lastName, String personalId, String dateOfBirth, String address, String phoneNumber, String email) {
        super(firstName, lastName, personalId, dateOfBirth, address, phoneNumber, email);
        this.profession = profession;
        this.hourlyRate = hourlyRate;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.username = username;
    }

    public EmployeeDTO(String profession, String hourlyRate, String salary, String bankAccount, String username, String password, String privilege, String firstName, String lastName, String personalId, String dateOfBirth, String address, String phoneNumber, String email) {
        super(firstName, lastName, personalId, dateOfBirth, address, phoneNumber, email);
        this.profession = profession;
        this.hourlyRate = hourlyRate;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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
    
    
    
}
