package de.webeng.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Company {

    private List<Staff> staff;

    public Company(@JsonProperty("staff") List<Staff> staff) {
        this.staff = staff;
    }

    public List<Staff> getStaff() {
        return staff;
    }
}
