class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(flights.length==0) return -1;
        
        HashMap<Integer, List<int []>> graph = new HashMap<>();
        
        for(int[] flight: flights){
            
            if(!graph.containsKey(flight[0])){
                graph.put(flight[0], new ArrayList<int[]>());
            }
            
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        
        PriorityQueue<Node> q = new PriorityQueue<Node>((a,b) -> (a.cost - b.cost));
        
        q.add(new Node(src, 0, -1));
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
            
            if(curr.city == dst){
                return curr.cost;
            }
            
            if(curr.stop<K){
                List<int []> nexts = graph.getOrDefault(curr.city, new ArrayList<int[]>());
                
                for(int[] next: nexts){
                    q.add(new Node(next[0], curr.cost+next[1], curr.stop+1));
                }
            }
        }
        
        return -1;
    }
}

class Node {
    int city;
    int cost;
    int stop;
    
    public Node(int city, int cost, int stop){
        this.city = city;
        this.cost = cost;
        this.stop = stop;
    }
}