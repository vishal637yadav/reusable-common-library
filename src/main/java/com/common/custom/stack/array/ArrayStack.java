package com.common.custom.stack.array;

import com.common.custom.stack.Stack;

public class ArrayStack<E> implements Stack<E> {
  private static final int DEFAULT_CAPACITY = 10;

  private final E[] data;
  private int size;

  @SuppressWarnings("unchecked")
  ArrayStack() {
    this.data = (E[]) new Object[DEFAULT_CAPACITY];
    this.size = -1;
  }

  @SuppressWarnings("unchecked")
  ArrayStack(int capacity) {
    this.data = (E[]) new Object[capacity];
    this.size = -1;
  }

  @Override
  public void push(E data) {
    if (size == this.data.length - 1) {
      throw new StackFullException();
    }
    this.data[++size] = data;
  }

  @Override
  public E pop() {
    if (size == -1) {
      throw new StackEmptyException();
    }
    E removedElement = data[size];
    size--;
    return removedElement;
  }

  @Override
  public E peek() {
    return data[size];
  }

  @Override
  public boolean isEmpty() {
    return size == -1;
  }
}
