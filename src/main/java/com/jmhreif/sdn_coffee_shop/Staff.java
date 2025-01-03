package com.jmhreif.sdn_coffee_shop;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

@Node
public class Staff {
    @Id
    String staffId;
    String firstName;
    String lastName;
    LocalDate startDate;

    public Staff(String staffId, String firstName, String lastName, LocalDate startDate) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
