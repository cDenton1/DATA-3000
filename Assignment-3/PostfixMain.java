public class PostfixMain {
  public static void main(String[] args) {
    // still need jOption pane
    PostfixCalculator calc = new PostfixCalculator();

    //  First expression
    String expression1 = "x y * z +";
    calc.setVariable("x", 5); 
    calc.setVariable("y", 3); 
    calc.setVariable("z", 4); 
    int result = calc.evaluatePostfixExpression(expression1);
    
    System.out.println("Result: " + result);
    calc.deleteAllVariables();

    // Second expression
    String expression2 = "a b + c *";
    calc.setVariable("a", 2); 
    calc.setVariable("b", 3); 
    calc.setVariable("c", 4); 
    result = calc.evaluatePostfixExpression(expression2);

    System.out.println("Result: " + result);
    calc.deleteAllVariables();

    // Third expression
    String expression3 = "m n * p -";
    calc.setVariable("m", 8); 
    calc.setVariable("n", 2); 
    calc.setVariable("p", 3); 
    result = calc.evaluatePostfixExpression(expression3);

    System.out.println("Result " + result);
    calc.deleteAllVariables();
  
    // Fourth expression
    String expression4 = "q r s * +";
    calc.setVariable("q", 7); 
    calc.setVariable("r", 3); 
    calc.setVariable("s", 2); 
    result = calc.evaluatePostfixExpression(expression4);

    System.out.println("Result " + result);
    calc.deleteAllVariables();

    // Fifth expression
    // WE NEED TO IMPLEMENT the NUMBER 4
    // String expression5 = "d e f * + 4 +";
    // calc.setVariable("d", 2); 
    // calc.setVariable("e", 3); 
    // calc.setVariable("f", 4);
    // result = calc.evaluatePostfixExpression(expression5);

    // System.out.println("Result: " + result);
    // calc.deleteAllVariables();
    
    // Sixth expression
    String expression6 = "g h i + * j /";
    calc.setVariable("g", 2); 
    calc.setVariable("h", 3); 
    calc.setVariable("i", 4);
    calc.setVariable("j", 5); 
    result = calc.evaluatePostfixExpression(expression6);

    System.out.println("Result: " + result);
    calc.deleteAllVariables();
    
    // Seventh expression
    String expression7 = "k l + m n + *";
    calc.setVariable("k", 2); 
    calc.setVariable("l", 3); 
    calc.setVariable("m", 4);
    calc.setVariable("n", 5); 
    result = calc.evaluatePostfixExpression(expression7);

    System.out.println("Result: " + result);
    calc.deleteAllVariables();
    
    // Eigth expression
    String expression8 = "o p / q r + * s +";
    calc.setVariable("o", 9); 
    calc.setVariable("p", 3); 
    calc.setVariable("q", 5); 
    calc.setVariable("r", 2); 
    calc.setVariable("s", 7); 
    result = calc.evaluatePostfixExpression(expression8);

    System.out.println("Result: " + result);
    calc.deleteAllVariables();
  }
}
