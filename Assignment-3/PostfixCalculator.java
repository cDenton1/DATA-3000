
public class PostfixCalculator {

    BST<String, Integer> variableTree;
    StackInterface<Integer> stack; 
    
    public PostfixCalculator() {
        // NOTE : You can't use the class name directly. You need to initialize it like a variable.
        variableTree = new BST<>(); // Initializes new BST from the BST class and calling it variableTree
        stack = new StackOperations<>(50); // Initializes new stack interface from the stack interface class and calling it stack.
    }
    
    public int evaluatePostfixExpression (String expression) {
        
        System.out.println("\nPostfix expression: " + expression);    // print the current expression
        String[] elements = expression.split(" "); // store elements from the expression in an array

        // reverse iterates through the expression
        for (int i = elements.length - 1; i >= 0; i--) {
            elements[i] = elements[i].trim();   // Removes the whitespace from the elements (aka the space in between each string element)
            Integer value = variableTree.search(elements[i]); // search tree and store related value
            if (value != null) {    // check if the value is null
                System.out.println("||==> " + elements[i] + ":" + value); // prints the variable and corresponding values
            }
        } 

        // iterates through each value within the expression 
        for (String element : elements) {
            Integer value = variableTree.search(element); // search tree and store the related value
            
            // if the value is null, then it's an operator and needs to be applied
            if (value == null) { 
                if (element.equals("4")) { // Check if the element is "4" (not the integer 4).
                    stack.push(4); // Pushes integer 4.
                }
                else {
                    // stack is LIFO - variable 1 is below variable 2
                    int var2 = stack.pop(); // pop variable 2 off the stack as it's above variable 1
                    int var1 = stack.pop(); // pop variable 1 off the stack after variable 2 adhering to the LIFO rules.

                    // rule switch - avoids long and unnecessary if else statements
                    int result = switch(element) {  // initialize result and store a value based on certain cases
                        case "+" -> var1 + var2;    // add variables if plus (+) operator
                        case "-" -> var1 - var2;    // subtract variables if subtraction (-) operatorif 
                        case "*" -> var1 * var2;    // multiply variables if string is (*) operator
                        case "/" -> var1 / var2;    // divide variables if the string is (/) operator
                        
                        // Catch any potential foreign operators or anything that falls through (very useful if we had user input).
                        default -> throw new IllegalArgumentException("Unknown Operation: " + element); 
                    };

                    stack.push(result); // push the calculated result
                }

            } else {
                stack.push(value); // push number to stack
            }
        }
        
        // pops value from top of stack and stores it
        int result = stack.pop();    

        // Checks if the stack is not empty, otherwise return the result of the postfix expression.
        if (!(stack.isEmpty())) {
            throw new IllegalStateException("Stack isn't empty");
        }
        return result; // returns final result of the expression
    }
    
    // insert variable and related value into the BST
    public void setVariable (String key, int value) {
        variableTree.insert(key, value);
    }

    // Delete all the nodes in the BST
    public void deleteAllVariables () {
        System.out.println("All variables have been deleted.");
        variableTree.deleteAll();
    }
}

