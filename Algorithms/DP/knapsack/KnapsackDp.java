import java.io.*;

public class KnapsackDp {
    
    
    int max(int a,int b){
        return a>b?a:b;
    }
	
    
    public int knapsack(int W,int w[],int v[],int n){
        
        //base condition
        if(n==0||W==0)
            return 0;
        
        //if last element weight is greater than total weight
        if(w[n-1]>W)
            return knapsack(W,w,v,n-1);
        else{
            return max(v[n-1]+knapsack(W-w[n-1],w,v,n-1),knapsack(W,w,v,n-1));
        }
    }
    
	public static void main (String[] args) {
	    KnapsackDp obj = new KnapsackDp();
	    int []w = {10,20,30};
	    int []v = {60,100,120};
	    int maxval = obj.knapsack(50,w,v,3);
		System.out.println("Maximum possible value:" + maxval);
	}
}
