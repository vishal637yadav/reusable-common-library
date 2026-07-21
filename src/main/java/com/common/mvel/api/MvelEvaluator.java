package com.common.mvel.api;

import java.util.Map;

public interface MvelEvaluator {

  /** Executes a script using the provided variables. */
  Object execute(String expression, Map<String, Object> variables);

  /** Executes a script using both a context object and variables. */
  Object executeWithContext(String expression, Object context, Map<String, Object> variables);

  /** Pre-compiles and caches a script with specific strict typing rules. */
  void registerScript(String expression, boolean strictTyping);
}
