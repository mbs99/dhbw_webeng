package de.webeng.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class Company {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Staff> staff;

    public Company() {

    }

    @Override
    public String toString() {
        return "Company{" +
                "staff=" + staff +
                '}';
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
