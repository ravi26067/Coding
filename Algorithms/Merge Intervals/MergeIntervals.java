public class MergeIntervals{
  public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // TODO: Write your code here
        if(intervals.size()==1)
            return intervals;

        Collections.sort(intervals,(a,b)-> Integer.compare(a.start,b.start));

        Iterator<Interval> it = intervals.iterator();
        Interval interval = it.next();
        int start = interval.start;
        int end = interval.end;

        while (it.hasNext()){
            interval = it.next();
            if(end >= interval.start){
                end = Math.max(end,interval.end);
            }else {
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start,end));
        return mergedIntervals;
    }
  
  public static void main(String[] args) {


        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 5));
        input.add(new Interval(1, 4));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
  }
}
