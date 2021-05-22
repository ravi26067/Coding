// Java program to demonstrate working of
// an algorithm that finds an element in an
// array of infinite size

class Test
{
	// Simple binary search algorithm
	static int binarySearch(int arr[], int l, int r, int x)
	{
		if (r>=l)
		{
			int mid = l + (r - l)/2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				return binarySearch(arr, l, mid-1, x);
			return binarySearch(arr, mid+1, r, x);
		}
		return -1;
	}
	
	// Method takes an infinite size array and a key to be
	// searched and returns its position if found else -1.
	// We don't know size of arr[] and we can assume size to be
	// infinite in this function.
	// NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE
	// THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING
	static int findPos(int arr[],int key)
	{
		int h = 1;
      if(arr[h]==key)
        return 0;
      	int max = Integer.MAX_VALUE;
        while(arr[h]<key && h < max){
          System.out.println("h: " + h);
          h = 2*h;
        }

		// at this point we have updated low
		// and high indices, thus use binary
		// search between them
		return binarySearch(arr, h/2, h, key);
	}

	// Driver method to test the above function
	public static void main(String[] args)
	{
		int arr[] = new int[]{0, 0, 1, 1, 1, 1,
							1, 1, 1, 1, 1};
		int ans = findPos(arr,1);
		
		if (ans==-1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at index " + ans);
	}
}
