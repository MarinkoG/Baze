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
public class ProjectDTO {

    private int id;
    private String name;
    private String manager;
    private String client;
    private String startDate;
    private String completionDate;
    private Float price;

    public ProjectDTO() {
    }

    public ProjectDTO(int id, String name, String manager, String client, String startDate, String completionDate, Float price) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.client = client;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.price = price;
    }

    public ProjectDTO(String name, String manager, String client, String startDate, String completionDate, Float price) {
        this.name = name;
        this.manager = manager;
        this.client = client;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.price = price;
    }

    public String getManagerId() {
        return getManager().split(", ")[0];
    }

    public String getClientId() {
        return getClient().split(", ")[0];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
