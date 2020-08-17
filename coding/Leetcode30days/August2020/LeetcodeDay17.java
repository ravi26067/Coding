class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int ans = 1;
        int arr[] = new int[num_people];
        int i=0;
        while(true){
            if(ans < candies){
                arr[i % num_people] += ans;
                candies = candies - ans;
            }else{
                arr[i%num_people] += candies;
                break;
            }
            ans++;
            i++;
        }
        return arr;
    }
}
