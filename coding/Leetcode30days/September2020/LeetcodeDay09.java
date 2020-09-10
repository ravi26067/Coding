class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("[.]");
        String[] arr2 = version2.split("[.]");
        String tmp1 = "";
        String tmp2 = "";
        int l1 = arr1.length;
        int l2 = arr2.length;
        int i=0,j=0;
        
        //System.out.println(i + " " + j + " " + l1 + " " + l2);
        
        while(i<l1 && i<l2 && arr1[i].equals(arr2[i])){
            //System.out.println("hello");
            i++;
        }
        while(i<l1 && i<l2){
            //System.out.println("hey" + i);
            int m1 = Integer. parseInt(arr1[i]);
            int m2 = Integer. parseInt(arr2[i]);
            
            if(m1>m2)
                return 1;
            else if(m2>m1)
                return -1;
            
            i++;
        }
        if(i<l1){
            while(i<l1){
                int m1 = Integer. parseInt(arr1[i]);
                if(m1>0)
                    return 1;
                i++;
            }
            
        }else{
            while(i<l2){
                int m1 = Integer. parseInt(arr2[i]);
                if(m1>0)
                    return -1;
                i++;
            }
        }
        
        
        return 0;
    }
}