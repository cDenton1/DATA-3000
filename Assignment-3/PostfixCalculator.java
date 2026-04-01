
public class PostfixCalculator {

    BST<String, Integer> variableTree;  // instance variable, will figure out
    StackInterface<Integer> stack;
    
    public PostfixCalculator() {
        variableTree = new BST<>();
        stack = new StackOperations<>(50);
    }
    
    public int evaluatePostfixExpression (String expression) {
        
        System.out.println("Postfix expression: " + expression);
        String[] elements = expression.split(" "); // array here maybe

        for (int i = elements.length - 1; i >= 0; i--) {
            elements[i] = elements[i].trim();
            Integer value = variableTree.search(elements[i]); // search tree and grab value
            if (value != null) {
                // for (int j = 0; j < i; j++) {
                //     System.out.print("\t");
                // }
                System.out.println("||==> " + elements[i] + ":" + value);
            }
        } 

        for (String element : elements) {
            element = element.trim();
            Integer value = variableTree.search(element); // search tree and grab value
            if (value == null) {
                int var2 = stack.pop();
                int var1 = stack.pop();

                // rule switch
                int result = switch(element) {
                    case "+" -> var1 + var2;
                    case "-" -> var1 - var2;
                    case "*" -> var1 * var2;
                    case "/" -> var1 / var2;
                    default -> throw new IllegalArgumentException("Unknown Operation: " + element);
                };

                stack.push(result);

            } else {
                // int var = Integer.parseInt(element);
                // if (var == 4) {
                //     stack.push(var);
                // }
                // System.out.println(element + ": " + value);
                stack.push(value); // push number to stack
            }
        }
        
        int result = stack.pop();    
    
        if (!(stack.isEmpty())) {
            throw new IllegalArgumentException("The stack isn't empty, try again"); // Look at this error handling when we understand more
        } else {
            return result;
        }
    }
    
    public void setVariable (String key, int value) {
        variableTree.insert(key, value);
    }

    public void deleteAllVariables () {
        System.out.println("\nAll variables have been deleted.");
        variableTree.deleteAll();
    }
}

