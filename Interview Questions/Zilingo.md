# Round 1: Problem Solving 

Suppose you are given N coordinates in a cartesian plane. You have to find k nearest points from origin.


example 1: 
[[30, 40], [5, 6], [4,5],[5,4], [0, 1]] and k = 2  
[50,...1]
  
  
ans: [[0,1], [4, 5]]


``` java
  
  
class Coordinates{

class Point{
	int x;
  int y;
}

class Distance{
	Double distance;
  Point point;
  

}
  
  [10, 15, 20]
  
  [10, 20]
  
  
  15,10
  
  
  
  List<Point> getNearestCoordinates(List<Point> coordinates,int k){
    PriorityQueue<Distance> queue = new PriorityQueue((a,b)-> b.distance - a.distance);
    List<Point> nearestCoordinates = new ArrayList();
  	int n = coordinates.size();
    List<Double> coordinateDistance = new ArrayList();
    for(int i=0;i<n;i++){
      Point point = coordinates.get(i);
      Double distance = Math.sqrt((point.x * point.x) + (point.y * point.y));
      coordinateDistance.add(distance);
      
      Distance pointDistance = new Distance();
      pointDistance.setDistance(distance);
      pointDistance.setPoint(point);
      
      if(queue.size()>=k && distance < queue.peek().distance ){
        queue.remove();
      }
      
      if(distance < queue.peek().distance)
      	queue.add(pointDistance);
    }
    
    while(!queue.isEmpty()){
      nearestCoordinates.add(queue.remove());
    }
    return nearestCoordinates;
    
  }

}

```



Q.2 Given a sorted array of integers and a target number. You have to find starting and end index of target number.

example 1: 
[1, 2, 3, 3, 3, 5, 6, 7] and targetNumber = 3

ans: [2, 4]


```
class Solution {
	
  int[] findIndexes(int arr[],int target){
  	
    int i=0;
    int j= arr.length;
    int mid = (i+j)/2;
    int res[] = new int[2];
    
    while(i<=mid && mid<=j ){
    	if(arr[mid] < target){
      		i=mid;
      }else if(arr[mid] > target){
      		j = mid;
      }
      else {
      	res[0] = findStart(arr,i,mid,target);
        res[1] = findEnd(arr,mid,j,target);
        break;
      }
    }
    
    }
    
    int findStart(int arr[],int i,int j, int target){
    	int min = j;
      int mid = (i+j)/2
      while(i<mid && mid<j && mid<min){
      	if()
      }
      
    }
    
    int findEnd(int arr[],int i,int j,int target){
    	int max = i;
    }
    
    
  }
 
}

```





















