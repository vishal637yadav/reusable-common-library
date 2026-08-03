package com.common.mvel.exception;

/** Exception thrown when a script fails to compile within the MvelScriptEngine. */
public class ScriptExecutionException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new ScriptExecutionException with the specified detail message.
   *
   * @param message the detail message.
   */
  public ScriptExecutionException(String message) {
    super(message);
  }

  /**
   * Constructs a new ScriptExecutionException with the specified detail message and cause.
   *
   * @param message the detail message.
   * @param cause the underlying cause of the compilation failure (usually an MVEL exception).
   */
  public ScriptExecutionException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new ScriptExecutionException with the specified cause.
   *
   * @param cause the underlying cause of the compilation failure.
   */
  public ScriptExecutionException(Throwable cause) {
    super(cause);
  }
}
