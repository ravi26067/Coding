class Solution {
    /*
    * Here we have used the map to track the duplicates. Key will be file contents.
    * Value will be directory + file (same as we are printing in output)
    */
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmpRes = new ArrayList<>();
        Map<String,List<String>> mp = new HashMap<>();

        for(String s:paths){
            String [] str = s.split(" ");
            if(str.length>1){
                for(int i=1;i<str.length;i++){
                    //System.out.println("str[i]: " + str[i]);
                    str[i] = str[i].substring(0,str[i].length()-1);
                    String[] split = str[i].split("[(]");
                    //System.out.println(split[0]+ "  " + split[1]);

                    if(mp.containsKey(split[1])){
                        mp.get(split[1]).add(str[0]+ "/" + split[0]);
                    }else{
                        List<String> lst = new ArrayList<>();
                        lst.add(str[0]+ "/" + split[0]);
                        mp.put(split[1],lst);
                    }
                }
            }
        }
        for(Map.Entry et : mp.entrySet()){
            List<String> st = (List<String>) et.getValue();
            if(st.size()>1)
                res.add(st);
        }

        return res;
    }
}
