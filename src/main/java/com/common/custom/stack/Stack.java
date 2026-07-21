package com.common.custom.stack;

public interface Stack<E> {
  void push(E data);

  E pop();

  E peek();

  boolean isEmpty();
}
