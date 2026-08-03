package com.common.custom.stack.array;

import lombok.Getter;

@Getter
public class StackFullException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private static final String DEFAULT_MESSAGE = "Stack Already Full Exception";
  private final String message;

  public StackFullException() {
    this.message = DEFAULT_MESSAGE;
  }
}
