package com.common.custom.stack.array;

import lombok.Getter;

@Getter
public class StackEmptyException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private static final String DEFAULT_MESSAGE = "Stack Already Empty Exception";
  private final String message;

  public StackEmptyException() {
    this.message = DEFAULT_MESSAGE;
  }
}
