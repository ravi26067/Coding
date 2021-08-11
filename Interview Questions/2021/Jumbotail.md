# Round 1
## Coding

nums = [100,4,200,1,3,2] 
Ans : 4



[100,4,200,1,3,2]


1,2,3,4,100,200 

 nums = [-1,5,1,9,6,0]
Ans : 3





M X N

Int x = 5;
i=0;
j=N-1
while(i<M)
{
	while(j>=0){
	if(arr[i][j]==x)
	Return true;
	Else{
		if(arr[i][j]<x){
			i++;
		}else{
			j--;
}
}
}
}

Return false;


## LLD & HLD

``` java 
Requirements:

1. Search foods,restraunts
2. Adding items to cart
3. Placing the order for item
4. Order track
5. Rate the order

Account{
	String username;
	String password;
}

User{
	String name;
	phoneno;
	email;
	Address address;
	Account account;
	String cartId;
}


Address{
	streetnamae;
	pincode;
}


Restraunt{
	id;
	name;
	List<Dish> dishes;
	Address address;
	Rating rating;
}


Rating{

}

Dish{
	name;
	price;
	List<String> ingredients;
}


AbstractCartOrder{
	id;
	String customerId;
	List<CartEntries> entries;
	totalItems;
	String restrauntId;
	totalPrice;
}

Cart extends AbstractCartOrder{

	addCartItem(Dish dish, Integer qty);
	showCart();
	deleteCartItem();
	updateCart();
}

CartEntries{
	Dish dish;
	Integer qty;
}

Order extends AbstractCartOrder{
	OrderStatus status;
	Integer deilveryTime;

	updateOrderStatus(){
	}
}

OrderStatus{
	PLACED,
	PAYMENT_PENDING,
	CANCELLED,
	COMPLETED,
	ACCEPTED_BY_RESTRAUNT,
}

UserService{
	registerUSer();
	getUserById(String id);
}

```



