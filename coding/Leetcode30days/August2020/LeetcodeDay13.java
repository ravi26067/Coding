class CombinationIterator {

    Queue<String> queue;

    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList();
        combinations(characters, 0, "", combinationLength, queue);
    }

    public void combinations(String characters, int start, String soFar, int k, Queue<String> queue) {
        if (k == 0) {
            queue.add(soFar);
            return;
        }
        
        for(int i = start; i < characters.length(); i++) {
            combinations(characters, i + 1, soFar + characters.charAt(i), k - 1, queue);
        }
    }
    
    public String next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
