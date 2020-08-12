class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if(rowIndex==0)
            return res;
        else{
            res.add(1);
            List<Integer> tmp = null;
            for(int i =2;i<=rowIndex;i++){
                //System.out.println("Size" + res.size());
                tmp = new ArrayList();
                tmp.add(1);
                for(int j=0;j<res.size()-1;j++){
                    int sum = res.get(j) + res.get(j+1);
                    tmp.add(sum);
                }
                tmp.add(1);
                res = tmp;
            }
            return res;
        }
    }
}
