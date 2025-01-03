package com.jmhreif.sdn_coffee_shop;

import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
public class Receipt {
    @RelationshipId
    String id;

    Integer itemsInOrder;
    Double orderTotal;

    @TargetNode
    Customer customer;

    public Receipt(Double orderTotal, Integer itemsInOrder, Customer customer) {
        this.orderTotal = orderTotal;
        this.itemsInOrder = itemsInOrder;
        this.customer = customer;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getItemsInOrder() {
        return itemsInOrder;
    }

    public void setItemsInOrder(Integer itemsInOrder) {
        this.itemsInOrder = itemsInOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
