public class ArrayProductExceptSelf {

    /**
     * Here we are doing this in constant space by using result array and storing left multiplication of ith element.
     * Then we are traversing this result array from last and for n-1th element we will get res[n-2] as product and for
     * the remaining ones we will have res[i-1]* product and we will update product each time by multiplying with nums[i]
     * @param nums
     * @return
     */

        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int res[] = new int[n];
            int product = 1;
            for(int i=0;i<n;i++){
                product *= nums[i];
                res[i] = product;
            }
            product = 1;
            for(int i = n-1;i>=0;i--){
                if(i==0){
                    res[i] = product;
                }else{
                    res[i] = res[i-1] * product;
                    product *= nums[i];
                }
            }
            return res;
        }
}
