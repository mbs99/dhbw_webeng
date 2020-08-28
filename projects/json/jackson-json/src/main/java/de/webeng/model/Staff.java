package de.webeng.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Staff {
    private String firstname;
    private String lastname;
    private String nickname;
    private Double salary;

    public Staff(
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("salary") Double salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public Double getSalary() {
        return salary;
    }
}
