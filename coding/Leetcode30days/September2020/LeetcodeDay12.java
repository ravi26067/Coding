class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        combinations(1, n, k, new LinkedList(), result);
        return result;
    }
    
    private void combinations(int start, int n, int k, LinkedList<Integer> list, List<List<Integer>> result) {
        if(n == 0 && list.size() == k) {
            result.add(new ArrayList(list));
            return;
        } 
        for(int i = start; i <= 9; i++) {
            list.add(i);
            combinations(i + 1, n - i, k, list, result);
            list.removeLast(); 
        }
    }
}