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


## Round 2

``` java




create

POST employee/create

EmployeeDetails{
	Name
	Organisation
	Designation
	Id
	DOJ
	Desk No
}



PUT employee/update/{id}

EmployeeDetails{
	Name
	Organisation
	Designation
	DOJ
	Desk No
}

DELETE employee/delete/{id}

GET employee/{id}
EmployeeDetails

GET /employees
List<EmployeeDetails>





EmployeeController.java

EmployeeService employeeService;

@RequestMethod(RequestMethod.POST)
@Path("employee/create")
ResponseEnitty<> createNewEmploye(@RequestBody EmployeeDetails employee){
	return 
}


@RequestMethod(RequestMethod.PUT)
@Path("employee/update/{id}")
ResponseEnitty<> updateEmploye(@RequestBody EmployeeDetails employee){
	return 
}

@RequestMethod(RequestMethod.DELETe)
@Path("employee/delete/{id}")
ResponseEnitty<> deleteEmployee(){
	return 
}

@RequestMethod(RequestMethod.GET)
@Path("employee/{id}")
ResponseEnitty<> getEmployee(){
	return 
}


EmployeeDetails{
	Name
	Organisation
	Designation
	Id
	DOJ
	Desk No
}

EmployeeResponse {
	message;
	status;
	errorcode;
	success;
}

<create>
	<headers>create</headers>
	<body>
		<name>Ravi</name>
	</body>
</create>

<message>
	<headers>delete</headers>
	<body>
		<id>1107</id>
	</body>
</message>



EmployeeCronJob(){


	perform()

}

ProcessEmployeeMessages.java

readMessagesFromQueue(String messages){
	
}

deleteEmployee(String id){

}


createEmployee(EmployeeDetails employee){

}

EmployeeDetails convertToEmployee(String message){

}




EmployeeService.java


EmployeeResponse createEmployee(EmployeeDetails employee,boolean isKafka);

EmployeeResponse updateEmployee(String id),boolean isKafka;

EmployeeResponse deleteEmployee(String id,boolean isKafka);

EmployeeDetails getEmployee(String id);



SuccessResposne createEmployee(EmployeeDetails employee){

	EmployeeModel employeModel = modelService.create(EmployeeModel.class);
	employeModel.setName(employee.getName());
	...
	modelService.save(employeeModel)
}




```
