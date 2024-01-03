In Python, variables are used to store data values. They act as symbolic names that reference specific memory locations containing the data. When you assign a value to a variable, Python automatically allocates memory for that variable to hold the value.

### Variables:

- **Declaration and Assignment:** Unlike some languages, Python doesn't require explicit declaration of variables or their types. You can assign a value directly to a variable.

    ```python
    x = 5       # Here, 'x' is the variable holding the value 5
    name = "John"  # 'name' is a variable containing the string "John"
    ```

- **Variable Naming:** Variable names can include letters, numbers, and underscores, but they can't start with a number. Additionally, Python variables are case-sensitive.

    ```python
    my_var = 10
    My_Var = 20
    ```

- **Reassigning Variables:** You can change the value of a variable at any point in the code.

    ```python
    x = 5
    x = 10  # Reassigning the value of 'x'
    ```

### Data Types:

Python has various built-in data types:

1. **Numeric Types:**
    - **int:** Integers, whole numbers without decimals.
    - **float:** Floating-point numbers, numbers with decimals or in exponential form.
    - **complex:** Numbers with a real and imaginary part.

    ```python
    integer = 10
    floating = 3.14
    complex_num = 2 + 3j
    ```

2. **Strings:**
    - Ordered sequence of characters enclosed in single or double quotes.

    ```python
    name = "Alice"
    message = 'Hello, World!'
    ```

3. **Boolean:**
    - Represents one of two values: `True` or `False`.

    ```python
    is_valid = True
    has_error = False
    ```

4. **Lists:**
    - Ordered and mutable collections of items enclosed in square brackets `[]`.

    ```python
    numbers = [1, 2, 3, 4, 5]
    names = ['Alice', 'Bob', 'Charlie']
    ```

5. **Tuples:**
    - Ordered and immutable collections of items enclosed in parentheses `()`.

    ```python
    point = (10, 20)
    colors = ('red', 'green', 'blue')
    ```

6. **Dictionaries:**
    - Unordered collections of items stored as key-value pairs within curly braces `{}`.

    ```python
    person = {'name': 'Alice', 'age': 30, 'city': 'New York'}
    ```

Python's flexibility with variables and data types makes it easy to work with different kinds of data, allowing for dynamic and versatile programming. Understanding these fundamentals is crucial for effective coding and data manipulation in Python.

<div align="left" style="position: absolute;"><a href="basic_syntax.md"><button>Previous</button></a></div>
<div align="right" style="position: absolute;"><a href="variables.md"><button>Next</button></a></div>
