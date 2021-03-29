import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Here we are having map or array to map character frequency. We will create max heap with character with max frequency at root.
 * We will pull top 2 frequency element and keep appening it to string. We will check last element in queue frequency and if it's
 * greater than 1 we will return empty string else we will append last character to result and return.
 */

public class OrganiseString {

    public String reorganizeString(String S) {


        Map<Character,Integer> counts = new HashMap<>();

        for(char c:S.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());

        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1){
            Character current = maxHeap.remove();
            Character next = maxHeap.remove();
            result.append(current);
            result.append(next);
            counts.put(current,counts.get(current)-1);
            counts.put(next,counts.get(next)-1);
            if(counts.get(current)>0)
                maxHeap.add(current);
            if(counts.get(next)>0)
                maxHeap.add(next);

        }

        if(!maxHeap.isEmpty()){
            Character last = maxHeap.remove();
            if(counts.get(last)>1)
                return "";
            else{
                result.append(last);
                return new String(result);
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {

    }
}
