    /**
     * Here we are using hashmap to store frequency of word and we are using low[] array to check for 
	 * values lower than i. We will check for the condition that hth index should have atleast h element
	 * greater.
     */
class Solution {
    public int hIndex(int[] citations) {
        TreeMap<Integer,Integer> mp = new TreeMap();
        
        int n = citations.length;
        int low[] = new int[n];
        //int high[] = new int[n];
        
        
        for(int i=0;i<n;i++) {
        	if(mp.isEmpty())
        		mp.put(citations[i], 1);
        	else {
        		if(mp.containsKey(citations[i]))
        				mp.put(citations[i],mp.get(citations[i])+1);
        		else
        			mp.put(citations[i],1);
        	}
        }
        
        for(int i=0;i<n;i++) {
        	if(i==0)
        	{
        		if(mp.containsKey(i))
        			low[i] = mp.get(i);
        		else
        			low[i]=0;
        	}else {
        		if(mp.containsKey(i))
        			low[i] = mp.get(i) + low[i-1];
        		else
        			low[i] = low[i-1];
        	}
        }
        
        
        for(int i=0;i<n;i++)
            System.out.print(low[i] +" ");
        System.out.println();
        
        int ans =0;
        for(int i=0;i<n;i++){
            if(n-low[i]>=i+1 )
                ans = i+1;
        }
        
        return ans;
	}
}