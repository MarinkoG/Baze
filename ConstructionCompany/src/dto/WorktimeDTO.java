/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author LJUBO
 */
public class WorktimeDTO {
    private String Date;
    private String personalIdNumber;
    private Float workHours;

    public WorktimeDTO() {
    }

    public WorktimeDTO( Float workHours, String personalIdNumber, String Date) {
        this.Date = Date;
        this.personalIdNumber = personalIdNumber;
        this.workHours = workHours;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    public Float getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Float workHours) {
        this.workHours = workHours;
    }

            
    
}
