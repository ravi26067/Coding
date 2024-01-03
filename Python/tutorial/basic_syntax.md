### 1. Statements and Indentation:
- Python uses indentation to define code blocks, unlike many other languages that use curly braces or keywords like `begin` and `end`.
- Blocks of code are indicated by the same level of indentation.
- Indentation is typically done using four spaces, but it's important to be consistent.

Example:
```python
if condition:
    # This block is indented and executes if the condition is True
    statement_1
    statement_2
else:
    # This block is also indented and executes if the condition is False
    statement_3
    statement_4
# The code outside the if-else block is not indented
statement_5
```

### 2. Comments:
- Comments are used to explain code and are ignored by the interpreter.
- They begin with the `#` symbol and can be on a line by themselves or after code.
  
Example:
```python
# This is a single-line comment

"""
This is a
multi-line comment
"""
```

### 3. Variables and Assignments:
- Variables are created by assigning a value to them using the `=` operator.
- Python is dynamically typed, so you don’t need to declare the variable type explicitly.

Example:
```python
x = 5  # Assigning the value 5 to the variable x
name = "Alice"  # Assigning the string "Alice" to the variable name
```

### 4. Keywords and Identifiers:
- Python has reserved words (keywords) that can't be used as variable names because they have special meanings in the language.
- Identifiers are names given to entities like variables, functions, classes, etc.
- They must start with a letter (a-z, A-Z) or an underscore (_) and can be followed by letters, digits, or underscores.

Example:
```python
# Valid identifiers
variable_name = 10
_name = "John"

# Invalid identifier (using a keyword)
class = "Python"  # 'class' is a keyword and cannot be used as an identifier
```

### 5. Lines and Indentation:
- Python uses newline to terminate statements.
- Multiple statements on the same line can be separated by a semicolon (`;`), but this is discouraged for readability.

Example:
```python
a = 5; b = 10  # Two statements on the same line
```

Understanding and practicing these fundamental elements will lay a strong foundation for writing Python code. The emphasis on indentation encourages readability and forces a consistent coding style, which is a significant aspect of Python's syntax.

<div align="right" style="position: absolute; bottom: 10px; right: 10px;">
   <a href="https://github.com/ravi26067/Coding/blob/master/Python/tutorial/basic_syntax.md" style="color: transparent; text-decoration: none;">Next</a>
</div>
