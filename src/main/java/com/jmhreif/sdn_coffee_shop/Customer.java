package com.jmhreif.sdn_coffee_shop;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Customer {
    @Id
    String customerId;
    String customerName;
    String loyaltyId;

    public Customer(String customerId, String customerName, String loyaltyId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.loyaltyId = loyaltyId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLoyaltyId() {
        return loyaltyId;
    }

    public void setLoyaltyId(String loyaltyId) {
        this.loyaltyId = loyaltyId;
    }
}
