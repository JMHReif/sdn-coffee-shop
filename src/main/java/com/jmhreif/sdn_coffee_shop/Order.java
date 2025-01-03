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
    String orderId;
    LocalDate orderDate;
    LocalTime orderTime;
    String inStore;

    @Relationship(value = "BOUGHT", direction = Relationship.Direction.INCOMING)
    Receipt receiptAndCustomer;
    @Relationship(value = "SOLD", direction = Relationship.Direction.INCOMING)
    Staff staff;

    public Order(String transactionId,  String orderId, LocalDate orderDate, LocalTime orderTime, String inStore) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.inStore = inStore;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getInStore() {
        return inStore;
    }

    public void setInStore(String inStore) {
        this.inStore = inStore;
    }

    public Receipt getReceiptAndCustomer() {
        return receiptAndCustomer;
    }

    public void setReceiptAndCustomer(Receipt receiptAndCustomer) {
        this.receiptAndCustomer = receiptAndCustomer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
