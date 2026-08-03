package com.common.mvel.exception;

import java.io.Serial;

/** Exception thrown when a script fails to compile within the MvelScriptEngine. */
public class ScriptCompilationException extends RuntimeException {
  @Serial private static final long serialVersionUID = 1L;

  /**
   * Constructs a new ScriptCompilationException with the specified detail message.
   *
   * @param message the detail message.
   */
  public ScriptCompilationException(String message) {
    super(message);
  }

  /**
   * Constructs a new ScriptCompilationException with the specified detail message and cause.
   *
   * @param message the detail message.
   * @param cause the underlying cause of the compilation failure (usually an MVEL exception).
   */
  public ScriptCompilationException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new ScriptCompilationException with the specified cause.
   *
   * @param cause the underlying cause of the compilation failure.
   */
  public ScriptCompilationException(Throwable cause) {
    super(cause);
  }
}
