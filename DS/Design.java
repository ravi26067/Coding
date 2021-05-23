

class LRUCache {
    
    class Node{
    int key;
    int val;
    Node prev;
    Node next;
      
    /* 
    *   create a map name "cache" which stores key and node data. Node is address of doubly ll node.
    */
    public Node(int k,int v){
        key = k;
        val = v;
        }
    }

    Map<Integer,Node> cache;
    Node head = null;
    Node tail = null;
    int size;
    
    public LRUCache(int capacity) {
        cache = new HashMap();
        size = capacity;
    }
    
    /*
    * remove node from DLL
    */
    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        if(prev!=null)
            prev.next = next;
        else
            head = next;
        
        if(next!=null)
            next.prev = prev;
        else
            tail = prev;
    }
    
    /*
    * put node on the top(head) of DLL
    */
    private void putOnTop(Node node){
        
        node.next = head;
        node.prev = null;
        
        if(head!=null)
            head.prev = node;
        
        head = node;
        
        if(tail==null)
            tail = node;
        
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
            putOnTop(node);
            return node.val;
        }else
            return -1;
    }
    
    
    
    public void put(int key, int value) {
        //System.out.println("put b size: "+ cache.size());
        
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            removeNode(node);
            putOnTop(node);
            
        }else{
            
            if(cache.size()>=size){
                cache.remove(tail.key);
                removeNode(tail);
            }
            Node node = new Node(key,value);
            putOnTop(node);
            cache.put(key,node);
        }
        
        //System.out.println("put a size: "+ cache.size());
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
