class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastIndex[S.charAt(i) - 'a'] = i;

        List<Integer> result = new ArrayList();
        int j = 0, subStrStart = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, lastIndex[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - subStrStart + 1);
                subStrStart = i + 1;
            }
        }

        return result;
    }
}