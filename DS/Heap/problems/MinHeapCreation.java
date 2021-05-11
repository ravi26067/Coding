class CheckConvert {
  
  /** 
  * This is the code for min heap creation from maxHeap or from normal heap.
  */

  public static void convertMax(int[] maxHeap) {

    //Write Your Code Here
    buildHeap(maxHeap,maxHeap.length);
  }

  private static void buildHeap(int[] maxHeap,int heapSize){
    for(int i=(heapSize-1)/2;i>=0;i--){
      minifyHeap(maxHeap,i,heapSize);
    }
  }

  private static void minifyHeap(int[] maxHeap,int index,int heapSize){
    int smallest = index;

    while(smallest < heapSize/2){
      int left = (2*index) + 1;
      int right = (2*index) + 2;
      if(left<heapSize && maxHeap[left]<maxHeap[index])
        smallest = left;
      if(right<heapSize && maxHeap[right]<maxHeap[smallest])
        smallest = right;

      if(smallest!=index){
        int temp = maxHeap[index];
        maxHeap[index] = maxHeap[smallest];
        maxHeap[smallest] = temp;
        index = smallest;
      }else{
        break;
      }
    }
  }

}
