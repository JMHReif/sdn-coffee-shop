package com.jmhreif.sdn_coffee_shop;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

@Node
public class Employee {
    @Id
    String employeeId;
    String employeeName;
    LocalDate startDate;

    public Employee(String employeeId, String employeeName, LocalDate startDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.startDate = startDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
