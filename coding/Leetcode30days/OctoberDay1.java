class RecentCounter {

    Deque<Integer> dq;

    public RecentCounter() {
        dq = new LinkedList<>();
    }
    
    public int ping(int t) {
        while(!dq.isEmpty() && t - dq.getFirst() > 3000) dq.removeFirst();
        dq.addLast(t);
        return dq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
