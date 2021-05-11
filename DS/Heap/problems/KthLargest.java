class Solution
{
  /**
  * Kth largest element , we will use min heap. We will keep on pushing our item so that smallest item will be on top.
  * 
  */
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        ArrayList<Integer> res = new ArrayList();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k)
                pq.remove();
        }
        while(!pq.isEmpty()){
            res.add(pq.remove());
            //pq.remove()
        }
        Collections.reverse(res);
        return res;
    }
}
