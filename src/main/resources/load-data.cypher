CREATE CONSTRAINT IF NOT EXISTS FOR (c:Customer) REQUIRE c.customerId IS UNIQUE;
CREATE CONSTRAINT IF NOT EXISTS FOR (e:Employee) REQUIRE e.employeeId IS UNIQUE;
CREATE CONSTRAINT IF NOT EXISTS FOR (o:Order) REQUIRE o.orderId IS UNIQUE;

CREATE INDEX orderNodeKeyIndex FOR (o:Order) ON (o.orderNumber, o.orderDate, o.orderTime);

//Load customers
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/JMHReif/graph-demo-datasets/main/coffee-shop/customer.csv" AS row
MERGE (c:Customer {customerId: row.customer_id})
ON CREATE SET c.customerName = row.`customer_first-name`,
    c.email = row.customer_email,
    c.customerSince = row.customer_since,
    c.loyaltyId = row.loyalty_card_number
RETURN count(c);

//Load employees
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/JMHReif/graph-demo-datasets/main/coffee-shop/staff.csv" AS row
MERGE (e:Employee {employeeId: row.staff_id})
ON CREATE SET e.employeeName = row.first_name+" "+row.last_name,
    e.position = row.position,
    e.startDate = date(apoc.date.convertFormat(row.start_date, 'M/d/yyyy', 'iso_date'))
RETURN count(e);

//Load orders
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/JMHReif/graph-demo-datasets/main/coffee-shop/sales_receipts.csv" AS row
WITH row
CALL {
    MERGE (o:Order {orderNumber: row.transaction_id, orderDate: date(row.transaction_date), orderTime: localtime(row.transaction_time)})
    ON CREATE SET o.transactionId = randomUUID()
} IN TRANSACTIONS OF 100 ROWS
RETURN count(o);

//Load order employees
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/JMHReif/graph-demo-datasets/main/coffee-shop/sales_receipts.csv" AS row
MATCH (o:Order {orderNumber: row.transaction_id, orderDate: date(row.transaction_date), orderTime: localtime(row.transaction_time)})
WITH row, o
CALL {
    WITH row, o
    MERGE (e:Employee {employeeId: row.staff_id})
    MERGE (o)<-[r:SOLD]-(e)
} IN TRANSACTIONS OF 100 ROWS
RETURN count(o);

//Load order customers
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/JMHReif/graph-demo-datasets/main/coffee-shop/sales_receipts.csv" AS row
MATCH (o:Order {orderNumber: row.transaction_id, orderDate: date(row.transaction_date), orderTime: localtime(row.transaction_time)})
WITH row, o
CALL {
    WITH row, o
    MERGE (c:Customer {customerId: row.customer_id})
    MERGE (c)-[r:BOUGHT]->(o)
        ON CREATE SET r.orderTotal = toFloat(0.0)
} IN TRANSACTIONS OF 100 ROWS
RETURN count(o);

//Load order totals
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/JMHReif/graph-demo-datasets/main/coffee-shop/sales_receipts.csv" AS row
MATCH (c:Customer {customerId: row.customer_id})-[r:BOUGHT]->(o:Order {orderNumber: row.transaction_id, orderDate: date(row.transaction_date), orderTime: localtime(row.transaction_time)})
WITH row, o, r, c
CALL {
    WITH row, o, r, c
    SET r.orderTotal = r.orderTotal + toFloat(row.line_item_amount)
}
RETURN count(o);

// // Delete all relationships
// MATCH ()-[r]-()
// CALL { WITH r
// DELETE r
// } IN TRANSACTIONS OF 1000 ROWS;

// // Delete all nodes
// MATCH (n)
// CALL { WITH n
// DETACH DELETE n
// } IN TRANSACTIONS OF 1000 ROWS;