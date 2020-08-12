package de.webeng.model;

import de.webeng.model.base.Name;

public class Staff {
    private Name staffName;
    private Double salary;

    public Staff(Name staffName, Double salary) {
        this.staffName = staffName;
        this.salary = salary;
    }

    public Name getStaffName() {
        return staffName;
    }

    public Double getSalary() {
        return salary;
    }
}
