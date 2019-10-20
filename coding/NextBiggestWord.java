import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void swap(char arr[],int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int n = w.length();
        char [] arr = w.toCharArray();
        int i = n-1;
        //iterate from right of string and find first character that is smaller than 
        //previous character
        
        while(i>0 && arr[i-1]>=arr[i])
            i--;
        
        //we will reach to first index only when all characters are in descending order
        //this means there can't be any greater string so it will return no answer
        if(i==0)
            return "no answer";
        else{
            //here we will traverse to find the next smallest character on right side of 
            //i-1
            int minInd = i;
            for(int j=i;j<n;j++)
            {
                if(arr[j] > arr[i-1] && arr[j] < arr[minInd] )
                {
                    minInd = j;
                }
            }
            //swap the next minimum character with character at i-1 th position
            swap(arr,i-1,minInd);
            //sort the array after i-1 position in ascending order
            Arrays.sort(arr,i,n);
        }
        String opStr = new String(arr);
        return opStr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
