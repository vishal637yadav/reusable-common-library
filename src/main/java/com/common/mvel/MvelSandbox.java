package com.common.mvel;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.MVEL;

public class MvelSandbox {

  public static void main(String[] args) {
    System.out.println("-----------------MvelSandbox---------Start------------------------------");

    // 1. Set up a Map of variables to pass into our expression
    Map<String, Object> variables = new HashMap<>();
    variables.put("username", "JohnDoe");
    variables.put("age", 28);
    variables.put("isPremiumMember", true);

    // 2. Define a simple MVEL string expression
    // This expression checks if the user is over 18 and is a premium member
    String expression = "age > 18 && isPremiumMember == true";

    // 3. Evaluate the expression using MVEL.eval()
    // We pass both the expression and the Map of variables
    Boolean result = (Boolean) MVEL.eval(expression, variables);

    // 4. Print the result
    System.out.println("Expression: " + expression);
    System.out.println("Variables: " + variables);
    System.out.println("Result: " + result);

    // Let's try a dynamic string greeting
    String greetingExpression = "'Welcome, ' + username + '!'";
    String greetingResult = (String) MVEL.eval(greetingExpression, variables);
    System.out.println("Greeting: " + greetingResult);

    System.out.println("-----------------MvelSandbox-----------End------------------------------");
  }
}
