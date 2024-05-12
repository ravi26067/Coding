# Allen Machine Coding (Rejected)

## Machine Coding Problem: Deal Management System
You have an Admin who can create a deal and end a deal. Each deal will have a start time and end time. After the deal ends, nobody will be able to claim the deal item. Additionally, if the inventory is over, users will not be able to claim the deal. Design a system in Java to create and claim the deal. Use a database as well.

## Requirements
- The system should allow an Admin to create a deal with a specified start time, end time, and inventory count.
- Once a deal is created, users should be able to claim the deal item within the specified start and end time.
- After the end time of the deal, users should not be able to claim the deal item.
- If the inventory count becomes zero before the end time, users should not be able to claim the deal item.
- The system should use a database to store information about deals and inventory.

## Solution Approach
1. **Database Design**:
   - Design a database schema to store information about deals and inventory.
   - Tables:
     - `Deals`: Store deal information including deal ID, start time, end time, and inventory count.
     - `Inventory`: Store information about the available inventory.

2. **Java Classes**:
   - Create Java classes to represent the system entities like Deal and Inventory.
   - Implement methods for creating a deal, claiming a deal item, and checking deal availability.

3. **Integration**:
   - Integrate the Java application with the database using JDBC or an ORM framework like Hibernate.
   - Implement methods to interact with the database for CRUD operations related to deals and inventory.

4. **Testing**:
   - Write unit tests to validate the functionality of creating deals, claiming deal items, and handling edge cases like deal expiration and inventory exhaustion.
