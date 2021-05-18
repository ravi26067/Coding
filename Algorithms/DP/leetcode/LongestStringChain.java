class Solution {
    public int longestStrChain(String[] words) {
        //sort array with the length
        Arrays.sort(words,(a,b)-> a.length() - b.length());
        //res to store result 
        int res = 0;
        // Memozation so that we can reuse the result
        Map<String,Integer> memo = new HashMap();
        for(String word:words){
            memo.put(word,1);
            for(int i=0;i<word.length();i++){
                StringBuilder curr = new StringBuilder(word);
                //delete one character and search in map , if its present then we will increase 
                String next = curr.deleteCharAt(i).toString();
                if(memo.containsKey(next)){
                    memo.put(word,Math.max(memo.get(word),memo.get(next)+1));
                }
            }
            res = Math.max(res,memo.get(word));
        }
        return res;
    }
}
