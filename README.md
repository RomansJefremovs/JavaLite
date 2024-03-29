# JavaLite
Java lite is a language that brings the textual constraints to the syntax of the Java language, the language is made in such way that it can be written as a normal text.

 # Contex-free grammar of JavaLite #
|Nonterminal|Production rule|
|------------|-----|
|Program ::= |Block|
|Block ::= |{ Declarations **or** Statements return }|
|Declarations ::= |Declaration List **or** ε|
|Declaration List ::= |OneDeclaration+|
|OneDeclaration ::= |IntDeclaration **or** BooleanDeclaration **or** BooleanDeclaration|
|IdList ::= |(IntDeclaration **or** BooleanDeclaration **or** FunctionDeclaration)* |
|IntDeclaration ::= |int Identifier **or** int Identifier  AssignOperator value |
|BooleanDeclaration ::= |boolean Identifier  **or** boolean Identifier  AssignOperator value|
|FunctionDeclaration ::= |func Identifier (IdList) Block|
|Identifier  ::=| Letter (Letter **or** Digit)* |
|Statements ::= |OneStatement+|
|OneStatement ::= | IdentifierStatement **or** if  (Expression) Block **or**  while (Expression) Block **or** show (Expression) **or** readIntMessage  (Expression) **or** readBooleanMessage  (Expression) **or** ε |
|IdentifierStatement ::= | Identifier(ExpressionList)|
|ExpressionList ::= |Expression* |
|Expression  ::= | Primary (WordOperator Primary)* |
|Primary ::=| Identifier **or** IntegerLiteral **or** BooleanLiteral **or**  WordOperator Primary |
|WordOperator  ::= | AddOperator **or** MulOperator **or** BoolOperator |
|AddOperator  ::= |plus **or** minus |
|MulOperator ::= |multiply **or** divide **or** modulus |
|BoolOperator ::= |not **or** or **or** and **or** equals |
|AssignOperator ::= |is|
|IntegerLiteral ::= | Digit+|
|BooleanLiteral ::=| true **or** false |
|Letter ::= | [a-z] **or** [A-Z]|
|Digit ::= |[0-9]|

# Syntactic analysis #
Consists of two phases Scanning and Parsing, is responsible for evaluating the syntactic rules and producing the intermediate code represented by Abstract Syntax Tree.
## Scanning ##
 The scanner is responsible for breaking the source code down into a sequence of tokens, which are the basic building blocks of the language. The scanner uses regular expressions or other patterns to identify the tokens in the source code.

## Parsing ##
The parser is responsible for checking the syntax of the source code, ensuring that it follows the rules of the programming language. It does this by building a parse tree or abstract syntax tree (AST) from the tokens generated by the scanner. 
# Contextual analysis #
Given a parsed program, the purpose of contextual analysis is to check that the program conforms to the source language's contextual constraints, For a typical programming language (statically typed and with static bindings), contextual constraints consist of:
## Contextual constraints ##
A JavaLite exhibits nested block structure, since the blocks may be nested one
within another. Thus there may be many scope levels:
### Scope Rules ###

|Scope Rules|
|-----|
|A name (variable or function) may only be defined once at each scope level.|
|A name (variable or function) must be defined before it is used.|
|A name defined as a variable can’t be used as the function name in a function call.|
|A name defined as a function can’t be used as a variable.|
|A parameter to a function is treated as variable inside the scope of the function.|
|A name may be defined on different scope levels. Only the innermost definition is visible.|
|The left hand side of the “is” word operator must be a variable.|
|The number of arguments in a function call must be the same as the number of parameters in the function definition.|
|Only plus, minus, multiply, divide, modulus is allowed as a unary operator.|

### Type Rules ###
|Type Rules|
|-----|
| In expression A plus B , the A and B must be of the same type, result of the expression must be of the same type as operands|
| If the operator if the expression is assign operator, then the left hand side must be and identifier and right hand side must be the value or variable|
| Any variable declaration must be follow after the type declaration |
| Only integers and booleans are allowed as types|
| INTEGER (int) has a range of -32,768 to +32767 |

### Checker ###
The checker is responsible for checking the semantics of the source code, ensuring that it is semantically correct and making any necessary modifications to the AST. This may include type checking, variable declaration checks, and other checks to ensure that the program is well-formed and will execute correctly.    

# Run Time Organization #
JavaLite compiler uses Triangle Abstract Machine to generate the object code that can be executed by machine.
![image](https://user-images.githubusercontent.com/51113635/213461382-da30b760-5bc0-43eb-be20-205e40c9deac.png)
Triangle Abstract Machine  was designed specifically to support the implementation of high-level programming languages, and in particular the run-time organiz-
ation techniques.

# Code Generation #

## Code Template Document ##
|Phrase Class | Code Function | Code Template | Set of instructions | Comment|
|-------------|---------------|---------------|---------------------|--------|
| Program | run P | run[[C]] | execute C, HALT |       |
| Declaration | elaborate D | elaborate[[T is I]] | PUSH 1| expanding the stack to make space for any constants and variables declared| 
| Command | execute C | execute[[V is E]]| evaluate E, assign V| executes an instruction, updating variables, but without modifying the stack|
| Expression | evaluate E| evaluate[[E1 WordOperator E2]]| evaluate E1, evaluate E2, CALL p| evaluates an expression and pushes the result to the stack top |
| IntegerLiteral | fetch V | eveluate[[IntegerLiteral]]| LOADL v | where v is the value of the IntegerLiteral |

## Code generation algorithm ##
• For each AST concrete subclass A there is an encoding method, visitA. This
method has an argument that represents a phrase of class A. The implementation of
visitA is developed from the corresponding code template.

• Wherever a code template applies a code function to a subphrase, visit is applied to
that subphrase to generate the corresponding object code. Where the subphrase is a
value-or-variable-name, however,the fetch or assign operation is applied to the subphrase.

• Wherever a code template contains a target machine instruction, method
emit is called to append that instruction to the object program.
The encoding methods developed in this way cooperate to traverse the AST, generating the object program one instruction at a time.
Code generator simply traverses the AST in the order specified by the code templates.











