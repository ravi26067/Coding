class Solution
{
    //Function to return Breadth First Traversal of given graph.
    /** Take one queue and start from 0 position, and keep adding them into queue if not already visited. 
     *To keep track of visited note have an boolean array.
     */
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited [] = new boolean[V];
        //stack = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList();
        visited[0] = true;
        queue.add(0);

        while(!queue.isEmpty()){

            int k = queue.poll();

            result.add(k);

            Iterator<Integer> iterator = adj.get(k).listIterator();

            while(iterator.hasNext()){
                int n =iterator.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
        return result;

    }
}
