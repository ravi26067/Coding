# Round 1

FK DEV PLANNER 
Problem Definition 
You have to design and implement a task planner system, It should contain following components: 
Task: A task should have the following details: 
1. Title 
2. Assignee 
3. Type 
4. Due date 
Types of Task: A task can be of following type with additional information apart from what is mentioned above 
1. Feature 
a. Feature summary 
b. Impact (Low, Moderate, High) 
c. Allowed Status (Open, In Progress, Testing, Deployed) 
2. Bug 
a. Severity (P0, P1, P2) 
b. Allowed Status (Open, In Progress, Fixed) 
3. Story 
a. Story Summary 
b. A story can have multiple Sub Tracks 
c. Allowed Status (Open, In Progress, Completed) 
Sub Track: A Sub Track can be created and attached to only an existing story in non completed status, A sub tracks can have following details, 
1. Title 
2. Allowed Status (Open, In Progress, Completed) 
3. Parent Task 
Sprint: A sprint is defined as a collection of tasks used to track progress. One task can be a part of only one sprint. Once the sprint is completed, we should not be able to add tasks in the sprint. A Sprint can have following details. 
1. Name 
2. Start Date 
3. End Date 
4. Allowed Status (Open, In Progress, Completed)



Expected Functionality to implement: 
1. Task 
a. Create a task of one of the following type - Feature, Bug, Story 
b. Change the status of the task 
Note: A Story can be marked as completed only if all its Sub Tracks are completed 
c. Change assignee of the task 
d. Display tasks assigned to a user categorised by task type 
2. Sub Track 
a. Add Sub Track to existing Story 
b. Change the status of the Sub Track 
3. Sprint 
a. Create a Sprint 
b. Add/Remove task to/from sprint 
c. Start and End the sprint 
d. Display sprint snapshot. This should display the tasks that are part of the sprint, and also display if they are delayed (Today > due_date) or on track (Today <= due_date). 
4. Transition in the status should be based on allowed transitions 
For Feature Task 
Open → In progress, In progress → Testing, 
Testing→ Deployed, In progress → Deployed 
For Bug 
Open → In Progress, In Progress → Fixed 
For Story 
Open → In Progress, In Progress → Completed 
For Sub Track 
Open → In Progress, In Progress → Completed 
5. Bonus Functionality (If time permits) 
On Display task assigned to user show the tasks in the following order 
- Task type: Story > Feature > Bug 
- If Task Type is same, Sort by Sprint Start Date, if in Sprint 
- If the Sprint Start Date is the same, Sort by Task Due Date. 
Example 
The examples below are just to understand the functionalities and may not necessarily be used in the same format as input to your driver program. 
Add task: Title: Create dashboard, assignee: Peter, Type: Feature, Due date: 24-07-2021, Feature summary: Create console for debugging, Impact: Low, Status: Open
Add task: Title: Fix mysql issue, assignee: Ryan, Type: Bug, Due date: 26-07-2021, Severity: P0, Status: Open 
Add task: Title: Create a microservice, assignee: Ryan, Type: Story, Due date: 22-07-2021, Story summary: Create new service.. , Status: Open 
Add Sub Track: Title: Development, Status: Open, ParentTask: Create a microservice Add Sub Track: Title: Testing, Status: Open, ParentTask: Create a microservice Add Sub Track: Title: Deployment, Status: Open, ParentTask: Create a microservice 
Create Sprint: Name: Sprint-1 
Add task to sprint: Sprint Name: Sprint-1, Task Title: Fix mysql issue Add task to sprint: Sprint Name: Sprint-1, Task Title: Create a microservice Sprint Start: Name: Sprint-1 
Change Status: Title: Create a microservice, Status: In Progress. Change Status: Title: Development, Status: In Progress. 
Complete Sprint: Name: Sprint-1 
Add task to sprint: Sprint Name: Sprint-1, Task Title: Create dashboard Note: This should fail as the sprint is already completed. 
Show tasks assigned to Ryan 
Task Type: Story 
Title: Create a microservice 
Sprint: Sprint-1 
Sub Track: 
Development 
Testing 
Deployment 
Task Type: Bug 
Title: Fix mysql issue 
Sprint: Sprint-1 
Show tasks assigned to Peter 
Task Type: Feature 
Title: Create dashboard 
Sprint: 
Note: This is task is not added in sprint 
Show Tasks in Sprint-1 
On track Tasks: 
Fix mysql issue 
Delayed Tasks: 
Create a microservice
Expectations 
1. Demoable code (very important). Functionalities mentioned above 2. Clean Interface design for the module. 
3. Clean internal design and implementation of the library and the application. 4. Functional completeness is a must. Bonus questions are good to have. 5. Extensibility 
6. Take care of Exception and Corner case handling. 
7. Test cases covering various cases are good to have. 
8. You are free to use the language of your choice. 
Guidelines 
1. Please make use of in memory data structures and do not use any external datastore for storage/querying. 
2. Input/Output can be from terminal or file or taken from some data structure inside the driver program whichever is convenient for you. It should be easy for the evaluator to give new input or change existing input and test new cases. 
3. You can look for API references online. 
4. You are free to use the language of your choice.
