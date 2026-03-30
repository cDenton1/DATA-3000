// bare with me i am creating this file directly in github lol
// very rough idea and will clean up once i have access to an actual code editor

String expression = "x y * z +";
// being there is more i think we could just initialize them all first, then call the method for evaluating each

// i think this next part would be better in a function that can be called seperately but here is the logic for now

System.out.print(expression);
String[] elements = expression.split("\\s+"); // array here maybe

// expression also replaces the letter variables with numbers so maybe once split, we loop through it backwards replacing the letters with numbers
// using the like insert functions or whatever in arrays, idek if this makes any sense

// iterate through everything in the expression
for (String element : elements) {
  if (!(Integer.parseInt(element))) {
    int var2 = pop(/*stack, idk how to or anything is even needed here, probably*/);
    int var1 = pop(/*stack, idk how to or anything is even needed here, probably*/);
    
    // might be better way to check this from the expression but i cant think of it at the moment tbh
    if (element == "+") {
      int result = var1 + var2;
    } else if (element == "-") {
      int result = var1 - var2;
    } else if (element == "*") {
      int result = var1 * var2;
    } else {
      int result = var1 / var2;
    }
    push(result /*again idr lol, will probably need to fix*/);
  } else {
    push(element /*again idr lol, will probably need to fix*/);
  }
}

// now check if we are at the last item in the stack
int result = pop(/*stack, idk how to or anything is even needed here, probably*/);
if (isEmpty(/*stack, idk how to or anything is even needed here, probably*/)) {
  System.out.println("Result: " + result);
  System.out.println("All variables have been deleted");
  return;
} else {
  // idk but we would have a problem tbh lol
  // maybe some error handling or something
}
