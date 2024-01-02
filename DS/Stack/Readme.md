### Stack Data Structure

A stack is a fundamental data structure in computer science that follows the Last In, First Out (LIFO) principle. This means that the last element added to the stack is the first one to be removed. Think of it like a stack of plates – you add a plate to the top and remove the topmost plate.

#### Operations:

- **Push:** Adds an element to the top of the stack.
- **Pop:** Removes the element from the top of the stack.
- **Peek or Top:** Returns the element at the top of the stack without removing it.
- **isEmpty:** Checks if the stack is empty.
- **size or count:** Returns the number of elements in the stack.

#### Implementation:

- Stacks can be implemented using arrays or linked lists.
- Array implementation is straightforward, but it has a fixed size. When the stack reaches its limit, you may need to resize the array.
- Linked list implementation is dynamic and allows for easy resizing but involves more memory overhead.

#### Applications:

- Function call management (call stack in recursion)
- Expression evaluation (e.g., infix to postfix conversion)
- Undo mechanisms in applications
- Backtracking algorithms
- Managing memory in certain algorithms (e.g., depth-first search)

#### Time Complexity:

- Push, Pop, Peek, isEmpty, and size operations generally have a constant time complexity of O(1).

#### Space Complexity:

- The space complexity is O(n), where n is the number of elements in the stack.

#### Example in Pseudocode (using array):

```plaintext
Stack: array of elements
Top: index of the top element (initially -1)

Push(element):
   Top++
   Stack[Top] = element

Pop():
   if isEmpty():
      return "Stack Underflow"
   else:
      element = Stack[Top]
      Top--
      return element

Peek():
   if isEmpty():
      return "Stack is empty"
   else:
      return Stack[Top]

isEmpty():
   return Top == -1

size():
   return Top + 1
```

Here's the pseudo-code for a stack implementation using dynamic memory with explanations:

```plaintext
# Stack Node Structure
---------------------
struct Node {
    data: integer
    next: Node pointer
}

# Stack Implementation
---------------------
struct Stack {
    top: Node pointer
}

# Initialization
---------------
Stack* initializeStack():
    newStack = allocate memory for Stack
    newStack.top = NULL
    return newStack

# Push operation
---------------
push(stack, element):
    newNode = allocate memory for Node  # Allocate memory for a new node
    newNode.data = element  # Set the data of the new node to the given element
    newNode.next = stack.top  # Point the new node to the current top of the stack
    stack.top = newNode  # Update the top of the stack to the new node

# Pop operation
--------------
pop(stack):
    if stack.top is NULL:
        print "Stack underflow"
        return NULL

    poppedNode = stack.top  # Retrieve the current top of the stack
    poppedElement = poppedNode.data  # Get the data of the top node
    stack.top = poppedNode.next  # Update the top of the stack to the next node
    free memory for poppedNode  # Free the memory occupied by the popped node
    return poppedElement

# Peek operation
---------------
peek(stack):
    if stack.top is NULL:
        print "Stack is empty"
        return NULL

    return stack.top.data  # Return the data of the top node without popping

# IsEmpty operation
-------------------
isEmpty(stack):
    return (stack.top == NULL)  # Check if the stack is empty based on the top pointer

# Size operation
----------------
size(stack):
    count = 0
    current = stack.top
    while current is not NULL:
        count++
        current = current.next
    return count

# PrintStack operation
-----------------------
printStack(stack):
    if stack.top is NULL:
        print "Stack is empty"
        return

    print "Stack:"
    current = stack.top
    while current is not NULL:
        print current.data
        current = current.next
    print "-------"
```

Explanation:

- **Node Structure:** Defines the structure for a node in the stack. Each node contains data and a pointer to the next node.
- **Stack Structure:** Defines the structure for the stack, with a pointer to the top node.
- **Initialization:** Initializes an empty stack by allocating memory for the stack and setting the top pointer to `NULL`.
- **Push Operation:** Adds a new node with the given element to the top of the stack.
- **Pop Operation:** Removes and returns the top element of the stack, handling underflow conditions.
- **Peek Operation:** Returns the top element of the stack without removing it, handling empty stack conditions.
- **IsEmpty Operation:** Checks if the stack is empty by verifying if the top pointer is `NULL`.
- **Size Operation:** Counts and returns the number of elements in the stack.
- **PrintStack Operation:** Prints the elements of the stack from top to bottom, handling the case where the stack is empty.

Stacks are an integral part of many algorithms and are used in a wide range of applications due to their simplicity and efficiency. They provide a structured way to manage data and control the flow of execution in various computational processes.


<div align="right" style="position: absolute; bottom: 10px; right: 10px;">
   <a href="https://google.com" style="color: transparent; text-decoration: none;">Next</a>
</div>
