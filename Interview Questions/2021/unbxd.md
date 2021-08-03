# Unbxd

## Round 1

### Q1. Write User authentication method 

``` java
class AuthUser{
	String username;
	String password;
}


id|password

uid - encrypted


@RestController
public String login(AuthUser user){	
	
	try{
		authorizeUser(user);
	}catch(Exception e){

	}

}


private authorizeUser(AuthUser user){
	
	String password = passwordUtil.getPasswordForUser(user.username);
	if(user.password.equals(password)){
	}

	//GarbageCollector.getGc().garbageCollection();

}

```
### Q2. Types of design pattern, why do we need them? Can we have multiple design pattern in same project? Implement one design pattern.

``` java
class GarbageCollector{
	
	private static GarbageCollector gc;

	private GarbageCollector(){
		gc = new GarbageCollector();
	}

	public static GarbageCollector getGc(){
		return gc;
	}

	public void garbageCollection(){
		//
	}
}
```

### Q3. Level order traversal of Binary Tree?

### Q4. Maximum sum subarray?
