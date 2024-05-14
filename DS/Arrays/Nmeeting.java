class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int count = 1;
        //create a 2d array for storing the start and end timings
        int [][]arr = new int[n][2];
        
        for (int i=0;i<n;i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        
        //sort based on the end time
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        
        int endTime = arr[0][1];
        for (int i=1;i<n;i++){
            // check if start time of next is greater than end of previous one, increment counter and update endtime.
            if (arr[i][0]>endTime){
                count++;
                endTime = arr[i][1];
            }
        }
        
        return count;
    }
}
