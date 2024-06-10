import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // Node class to represent each node in the doubly linked list
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        // Constructor to initialize a node with key and value
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Map to store key-value pairs, where key is the cache key and value is the corresponding node
    Map<Integer, Node> cache;
    Node head; // Head of the doubly linked list (most recently used)
    Node tail; // Tail of the doubly linked list (least recently used)
    int size;  // Maximum capacity of the cache

    // Constructor to initialize the LRUCache with a given capacity
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        size = capacity;
        head = null;
        tail = null;
    }
    
    // Method to get the value of a key from the cache
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            deleteNode(node);  // Delete the node from its current position
            putOnTop(node);    // Put the node on top (most recently used)
            return node.val;   // Return the value of the node
        } else {
            return -1;  // Key not found in the cache
        }
    }
    
    // Method to put a key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;   // Update the value of the existing node
            deleteNode(node);   // Delete the node from its current position
            putOnTop(node);     // Put the node on top (most recently used)
        } else {
            if (cache.size() >= size) {
                cache.remove(tail.key); // Remove the least recently used node from the cache
                deleteNode(tail);       // Delete the least recently used node from the linked list
            }
            Node node = new Node(key, value); // Create a new node with the given key and value
            node.next = head;   // Set the next pointer of the new node to the current head
            node.prev = null;   // Set the prev pointer of the new node to null
            if (head != null) {
                head.prev = node; // Update the prev pointer of the current head to point to the new node
            }
            head = node;         // Update the head pointer to point to the new node
            if (tail == null) {
                tail = node;     // If the tail is null (i.e., the list is empty), update the tail pointer
            }
            cache.put(key, node); // Put the new node into the cache
        }
    }

    // Method to put a node on top of the doubly linked list (most recently used)
    public void putOnTop(Node node) {
        node.next = head;   // Set the next pointer of the node to the current head
        node.prev = null;   // Set the prev pointer of the node to null
        if (head != null) {
            head.prev = node; // Update the prev pointer of the current head to point to the node
        }
        head = node;         // Update the head pointer to point to the node
        if (tail == null) {
            tail = node;     // If the tail is null (i.e., the list is empty), update the tail pointer
        }
    }

    // Method to delete a node from the doubly linked list
    public void deleteNode(Node node) {
        Node prev = node.prev; // Get the prev pointer of the node
        Node next = node.next; // Get the next pointer of the node

        // Update the next pointer of the previous node to skip over the current node
        if (prev != null) {
            prev.next = next;
        } else {
            head = next; // If the node is the head, update the head pointer
        }

        // Update the prev pointer of the next node to skip back to the previous node
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev; // If the node is the tail, update the tail pointer
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
