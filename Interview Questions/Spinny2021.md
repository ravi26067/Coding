# Round 1 (Coding)

Q1. https://leetcode.com/problems/permutations/

CODE:

``` java

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /*
        []
        [1]
        [2,1][1,2]
        [3,2,1][2,3,1][2,1,3][1,2,3][1,3,2][3,1,2]
        */
        List<List<Integer>> res = new ArrayList();
        Queue<List<Integer>> perm = new LinkedList();
        perm.add(new ArrayList());
        for(int curr:nums){
            int m = perm.size();
            for(int k=0; k < m;k++){
                List<Integer> oldperm = perm.poll();
                int n = oldperm.size();
                for(int i=0;i<=n;i++){
                    List<Integer> newperm = new ArrayList(oldperm);
                    newperm.add(i,curr);
                    //System.out.println();
                    if(newperm.size()==nums.length)
                        res.add(newperm);
                    else
                        perm.add(newperm);
                }
            }
        }
        return res;
    }
}

```


Q2. https://leetcode.com/problems/next-greater-element-i/

CODE :

``` java

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
        [1]
        [3,4,-1,-1];
        */
        int n1 = nums1.length;
        int n2 = nums2.length;
        int res[] = new int[n1];
        Map<Integer,Integer> mp = new HashMap();
        Stack<Integer> st = new Stack();
        for(int i = n2-1;i>=0;i--){
            if(i==n2-1){
                mp.put(nums2[i],-1);
                st.push(nums2[i]);
            }
            else{
                while(true){
                    if(st.isEmpty())
                        break;
                    Integer tmp = st.pop();
                    if(tmp>nums2[i]){
                        mp.put(nums2[i],tmp);
                        st.push(tmp);
                        st.push(nums2[i]);
                        break;
                    }
                }
                if(!mp.containsKey(nums2[i])){
                        mp.put(nums2[i],-1);
                        st.push(nums2[i]);
                }
            }
        }
        
        for(int i=0;i<n1;i++){
            res[i] = mp.get(nums1[i]);
        }
        return res;
    }
}

```
# Round 2 ( LLD)

Spinny Round-2

**1. What are the scenarios for these api methods**
GET , POST , PUT , PATCH

Answer: you can search on internet

**2. Given two table , print the OrderDate for Customer Antonio**

Orders

| OrderID	| CustomerID	| OrderDate	|
|:---------:|:-------------:|:---------:|
| 10308		| 2				| 1996-09-18|
| 10309		| 37			| 1996-09-19|
| 10310		| 77			| 1996-09-20|



Customers

|CustomerID	|	CustomerName							| ContactName		|	Country	|
|:---------:|:-----------------------------------------:|:-----------------:|:---------:|
|1			|	Alfreds Futterkiste						| Maria Anders		|	Germany	|
|2			|	Ana Trujillo Emparedados y helados		| Ana Trujillo		|	Mexico	|
|3			|	Antonio Moreno Taquería					| Antonio Moreno	|	Mexico	|


Answer: 
``` sql
SELECT OrderDate from orders join customers on orders.customerID=customers.customerId where customers.ContactName like 'Antonio%'

```

**3. Low Level Design** 

**Car Bidding system**

``` text

	Requirements
	--------------

	You will have a platform where you will have a list of cars on which bidding will be done.
	User(Dealer) who will place the highest bid will win the bid.
	Each user will have Wallet associated with them which contains some amount.They can place bid or may not place a bid bases on the wallet balance.
	Also when new bid comes for the car, the latest bid which will be placed by user, his that much amount will get freezed until the new bid comes.
	User should also be able to get the bid history.
	
	Extended Requirements
	---------------------
	User should also be able to get transaction history of the wallet

	Make a low level design and use case for this

	Main requiremet:
	------------------
	placeBid
	get BidHistory For User
	get Maximum Bid OnCar (amount)

```
