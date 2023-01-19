# JavaLite
The CMC project, where a Java is transformed in the readable format.
Program ::=
Block
Block ::=
{ Declarations | Statements return }
Declarations ::=
Declaration List | ε
Declarations can either be a List or be empty
Declaration List ::=
OneDeclaration+
A declaration list can either be a single declaration or a list of single declarations
OneDeclaration ::=
IntDeclaration |BooleanDeclaration|BooleanDeclaration
IdList ::=
(IntDeclaration|BooleanDeclaration|FunctionDeclaration)*
IntDeclaration ::=
int Identifier | int Identifier  AssignOperator value
BooleanDeclaration ::=
boolean Identifier  | boolean Identifier  AssignOperator value
FunctionDeclaration ::=
func Identifier (IdList) Block
Identifier  ::=
Letter (Letter | Digit)*
Statements ::=
OneStatement+
The program will throw a compiler error if there is no statement. Statements cannot be empty
OneStatement ::=
IdentifierStatement|
if  (Expression) Block | 
while (Expression) Block |
show (Expression) |
readIntMessage  (Expression) |
readBooleanMessage  (Expression) | 
ε
IdentifierStatement ::=
Identifier(ExpressionList)
ExpressionList ::=
Expression*


Expression  ::=
Primary (WordOperator Primary)*
Primary ::=
Identifier | 
IntegerLiteral |
BooleanLiteral | 
WordOperator Primary



WordOperator  ::=
AddOperator |MulOperator| BoolOperator
AddOperator  ::=
plus | minus
MulOperator ::=
multiply | divide | modulus
BoolOperator ::=
not | or | and | equals
AssignOperator ::=
is
IntegerLiteral ::=
Digit +
BooleanLiteral ::=
true | false
Letter ::= 
[a-z] | [A-Z]
Digit ::=
[0-9]

