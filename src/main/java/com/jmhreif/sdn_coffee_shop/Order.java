package com.jmhreif.sdn_coffee_shop;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.time.LocalTime;

@Node
public class Order {
    @Id
    String transactionId;
    String orderNumber;
    LocalDate orderDate;
    LocalTime orderTime;

    @Relationship(value = "BOUGHT", direction = Relationship.Direction.INCOMING)
    Receipt receiptAndCustomer;
    @Relationship(value = "SOLD", direction = Relationship.Direction.INCOMING)
    Employee employee;

    public Order(String transactionId, String orderNumber, LocalDate orderDate, LocalTime orderTime) {
        this.transactionId = transactionId;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public Receipt getReceiptAndCustomer() {
        return receiptAndCustomer;
    }

    public void setReceiptAndCustomer(Receipt receiptAndCustomer) {
        this.receiptAndCustomer = receiptAndCustomer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
