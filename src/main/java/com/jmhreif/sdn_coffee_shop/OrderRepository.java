package com.jmhreif.sdn_coffee_shop;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface OrderRepository extends Neo4jRepository<Order, String> {
    @Query("MATCH (o:Order)<-[rel]-(c:Customer), (o)<-[rel2]-(s:Staff) " +
            "RETURN * LIMIT 10;")
    List<Order> findTenOrders();
}
