In Python, operators are symbols that perform operations on operands or values. They're classified into various categories based on the type of operation they perform. Here are the main types of operators in Python:

## 1. Arithmetic Operators:
These operators perform arithmetic operations like addition, subtraction, multiplication, division, etc.

- **Addition `+`:** Adds two operands.
- **Subtraction `-`:** Subtracts the right operand from the left operand.
- **Multiplication `*`:** Multiplies two operands.
- **Division `/`:** Divides the left operand by the right operand.
- **Floor Division `//`:** Returns the integer part of the division result.
- **Modulus `%`:** Returns the remainder of the division.
- **Exponentiation `**`:** Raises the left operand to the power of the right operand.

## 2. Comparison (Relational) Operators:
These operators compare the values on either side of the operator and determine the relationship between them.

- **Equal `==`:** Checks if two operands are equal.
- **Not Equal `!=`:** Checks if two operands are not equal.
- **Greater Than `>` and Less Than `<`:** Checks if the left operand is greater than or less than the right operand, respectively.
- **Greater Than or Equal To `>=` and Less Than or Equal To `<=`:** Checks if the left operand is greater than or equal to, or less than or equal to, the right operand, respectively.

## 3. Logical Operators:
These operators perform logical operations on Boolean values.

- **Logical AND `and`:** Returns `True` if both operands are `True`.
- **Logical OR `or`:** Returns `True` if either of the operands is `True`.
- **Logical NOT `not`:** Returns the opposite of the operand's Boolean value.

## 4. Assignment Operators:
These operators are used to assign values to variables.

- **Assignment `=`:** Assigns the value on the right to the variable on the left.
- **Addition Assignment `+=`, Subtraction Assignment `-=`, Multiplication Assignment `*=`, etc.:** Perform the operation and then assign the result to the variable.

## 5. Identity Operators:
These operators compare the memory locations of two objects.

- **`is`:** Returns `True` if both operands refer to the same object.
- **`is not`:** Returns `True` if both operands do not refer to the same object.

In Python, identity operators are used to compare the memory locations of two objects to determine whether they are the same object or not. Python has two identity operators: `is` and `is not`.

### 1. `is` Operator:
The `is` operator checks if two variables refer to the same object in memory.

- **Syntax:** `x is y`

```python
a = [1, 2, 3]
b = a  # Both 'a' and 'b' refer to the same list in memory

print(a is b)  # Output: True
print(a is not b)  # Output: False

c = [1, 2, 3]
print(a is c)  # Output: False (Different objects in memory)
```

### 2. `is not` Operator:
The `is not` operator checks if two variables do not refer to the same object in memory.

- **Syntax:** `x is not y`

```python
x = 5
y = 5

print(x is not y)  # Output: False (Same memory location for integer 5)

list1 = [1, 2, 3]
list2 = [1, 2, 3]

print(list1 is not list2)  # Output: True (Different objects in memory)
```


## 6. Membership Operators:
These operators test for membership in a sequence (e.g., strings, lists, tuples).

- **`in`:** Returns `True` if a value is present in the sequence.
- **`not in`:** Returns `True` if a value is not present in the sequence.

Membership operators in Python are used to test if a sequence (such as a string, list, tuple, or dictionary) contains a specific value. Python has two membership operators: `in` and `not in`.

### 1. `in` Operator:
The `in` operator checks if a value exists in a sequence.

- **Syntax:** `x in sequence`

#### Examples:
```python
my_list = [1, 2, 3, 4, 5]

print(3 in my_list)  # Output: True
print(6 in my_list)  # Output: False

my_string = "Hello, World!"

print('W' in my_string)  # Output: True
print('z' in my_string)  # Output: False

my_dict = {'a': 1, 'b': 2}

print('a' in my_dict)  # Output: True (checks keys in dictionaries)
print(2 in my_dict)    # Output: False (doesn't check values in dictionaries)
```

### 2. `not in` Operator:
The `not in` operator checks if a value does not exist in a sequence.

- **Syntax:** `x not in sequence`

#### Examples:
```python
my_list = [1, 2, 3, 4, 5]

print(3 not in my_list)  # Output: False
print(6 not in my_list)  # Output: True

my_string = "Hello, World!"

print('W' not in my_string)  # Output: False
print('z' not in my_string)  # Output: True

my_dict = {'a': 1, 'b': 2}

print('a' not in my_dict)  # Output: False
print(2 not in my_dict)    # Output: True
```

### Usage:
- Membership operators are commonly used to check if a value exists within a collection before performing operations on that collection.
- They are helpful in conditional statements, loops, and filtering elements from sequences.

### Note:
- For dictionaries, membership operators only check keys, not values.
- For strings, `in` and `not in` operators check for the presence or absence of substrings within the string.

Membership operators provide a convenient way to check for the presence or absence of elements within sequences or collections in Python. They play a significant role in controlling the flow of a program based on the existence of specific values within different data structures.

Understanding and using these operators effectively is essential for performing various operations and comparisons within Python code. They allow for concise and efficient manipulation of data and control flow in programs.

<div align="left" style="position: absolute;"><a href="variables.md"><button>Previous</button></a></div>
<div align="right" style="position: absolute;"><a href="control_structure.md"><button>Next</button></a></div>
