package com.common.mvel;

import com.common.mvel.api.MvelEvaluator;
import com.common.mvel.exception.ScriptCompilationException;
import com.common.mvel.exception.ScriptExecutionException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;

public class MvelScriptEngine implements MvelEvaluator {

  // Thread-safe cache to store compiled Abstract Syntax Trees (ASTs)
  private final ConcurrentHashMap<String, Serializable> cache = new ConcurrentHashMap<>();

  /**
   * Internal helper to retrieve or compile a script securely. Uses computeIfAbsent for atomic
   * check-and-compile operations.
   */
  private Serializable getOrCompile(String expression) {
    return cache.computeIfAbsent(expression, this::compileExpression);
  }

  /** Handles the actual compilation and wraps MVEL exceptions. */
  private Serializable compileExpression(String expression) {
    try {
      // By default, we compile without strict typing unless pre-registered
      return MVEL.compileExpression(expression);
    } catch (ScriptCompilationException e) {
      throw new ScriptCompilationException("Failed to compile MVEL expression: " + expression, e);
    }
  }

  @Override
  public void registerScript(String expression, boolean strictTyping) {
    try {
      ParserContext context = new ParserContext();
      context.setStrictTypeEnforcement(strictTyping);

      // You can also add standard imports here
      // context.addImport("Math", java.lang.Math.class);

      Serializable compiled = MVEL.compileExpression(expression, context);
      cache.put(expression, compiled);
    } catch (ScriptCompilationException e) {
      throw new ScriptCompilationException(
          "Failed to register and compile script with strict typing.", e);
    }
  }

  @Override
  public Object execute(String expression, Map<String, Object> variables) {
    Serializable compiledScript = getOrCompile(expression);
    try {
      // Executing in compiled mode is significantly faster for repeated executions
      return MVEL.executeExpression(compiledScript, variables);
    } catch (ScriptExecutionException e) {
      throw new ScriptExecutionException("Error executing script: " + expression, e);
    }
  }

  @Override
  public Object executeWithContext(
      String expression, Object context, Map<String, Object> variables) {
    Serializable compiledScript = getOrCompile(expression);
    try {
      // Injects both a context object (for property navigation) and a Map of variables
      return MVEL.executeExpression(compiledScript, context, variables);
    } catch (ScriptExecutionException e) {
      throw new ScriptExecutionException("Error executing script with context: " + expression, e);
    }
  }
}
