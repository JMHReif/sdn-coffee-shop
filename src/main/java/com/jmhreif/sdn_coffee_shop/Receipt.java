package com.jmhreif.sdn_coffee_shop;

import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
public class Receipt {
    @RelationshipId
    Long id;

    Double orderTotal;

    @TargetNode
    Customer customer;

    public Receipt(Double orderTotal, Customer customer) {
        this.orderTotal = orderTotal;
        this.customer = customer;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
