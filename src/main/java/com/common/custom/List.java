package com.common.custom;

public interface List<E> {

  void add(E element);

  boolean isEmpty();

  int size();

  E get(int index);

  void add(int index, E element);

  boolean contains(Object o);

  E set(int index, E element);

  E remove(int index);

  void clear();
}
