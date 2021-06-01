public class Solution{

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        int n = products.length;
        int arr[] = new int[n];
        int len = searchWord.length();
        for(int i=1;i<len+1;i++){
            List<String> temp = new ArrayList<>();
            String substr = searchWord.substring(0,i);
            //System.out.println(substr);

            int cnt = 0;
            for(int j=0;j<products.length;j++){
                if(arr[j]==0){
                    if(products[j].startsWith(substr)){
                        temp.add(products[j]);
                        cnt++;
                        if(cnt==3)
                            break;
                    }else {
                        arr[j] = 1;
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {

        Solution sl = new Solution();
        String [] products = {"bags","baggage","banner","box","cloths"};
        String searchWord = "bags";

        List<List<String>> res = sl.suggestedProducts(products,searchWord);
        for(List<String>list : res){
            for(String str: list){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

}
