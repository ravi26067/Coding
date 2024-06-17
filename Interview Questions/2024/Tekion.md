# Tekion: Staff Software Engineer

## Round 1 (DS algo and Theory)

1. **Detail about ACID and BASE property. Explain about the Durability.**
   - ACID (Atomicity, Consistency, Isolation, Durability) properties ensure database transactions are reliable. Durability guarantees that once a transaction is committed, it will remain so even in case of a system failure.
   - BASE (Basically Available, Soft state, Eventually consistent) properties are often preferred in distributed systems where immediate consistency is sacrificed for availability and partition tolerance.

2. **Detail about CAP theorem. Focus on Consistency vs Availability.**
   - CAP theorem states that a distributed system cannot guarantee all three of Consistency, Availability, and Partition tolerance simultaneously. It emphasizes the trade-offs between maintaining strong consistency and ensuring high availability during network partitions.

3. **SOLID principle in detail.**
   - SOLID is a set of principles in object-oriented design:
     - **Single Responsibility Principle**: A class should have only one reason to change.
     - **Open/Closed Principle**: Classes should be open for extension but closed for modification.
     - **Liskov Substitution Principle**: Subtypes must be substitutable for their base types.
     - **Interface Segregation Principle**: Clients should not be forced to depend on interfaces they do not use.
     - **Dependency Inversion Principle**: High-level modules should not depend on low-level modules; both should depend on abstractions.

4. **Singleton design pattern along with implementation.**
   - Singleton pattern ensures a class has only one instance and provides a global point of access to it.
   - Example implementation in Java:
     ```java
     public class Singleton {
         private static Singleton instance;

         private Singleton() {}

         public static synchronized Singleton getInstance() {
             if (instance == null) {
                 instance = new Singleton();
             }
             return instance;
         }
     }
     ```

5. **Coding Question: Find out the username who have browsed the most number of times within a time frame of n seconds.**

   **Input:**
   ```json
   [
       ["946720100", "user1", "url1"],
       ["946720500", "user1", "url1"],
       ["946720100", "user2", "url2"],
       ["946720200", "user2", "url2"],
       ["946720900", "user1", "url1"],
       ["946720900", "user3", "url3"]
   ]
n = 300 (seconds)

Implement a solution to determine which username has the most browsing occurrences within the given time frame.
