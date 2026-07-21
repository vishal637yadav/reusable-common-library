package com.common.custom.stack.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayStackTest {

  private ArrayStack<Integer> defaultStack;
  private ArrayStack<String> customStack;

  @BeforeEach
  void setUp() {
    defaultStack = new ArrayStack<>();
    customStack = new ArrayStack<>(3);
  }

  @Test
  @DisplayName("Initialization: Stack should be empty initially")
  void testInitialization() {
    assertTrue(defaultStack.isEmpty());
    assertTrue(customStack.isEmpty());
  }

  @Test
  @DisplayName("Push: Adding elements should increase stack size and change empty status")
  void testPush() {
    defaultStack.push(10);
    assertFalse(defaultStack.isEmpty());
    assertEquals(10, defaultStack.peek());
  }

  @Test
  @DisplayName("Push: Throw exception when pushing into a full stack")
  void testPushToFullStack() {
    customStack.push("A");
    customStack.push("B");
    customStack.push("C");

    assertThrows(StackFullException.class, () -> customStack.push("D"));
  }

  @Test
  @DisplayName("Pop: Remove and return the top element")
  void testPop() {
    defaultStack.push(5);
    defaultStack.push(15);

    assertEquals(15, defaultStack.pop());
    assertEquals(5, defaultStack.peek());

    assertEquals(5, defaultStack.pop());
    assertTrue(defaultStack.isEmpty());
  }

  @Test
  @DisplayName("Pop: Throw exception when popping from an empty stack")
  void testPopFromEmptyStack() {
    assertThrows(StackEmptyException.class, () -> defaultStack.pop());
  }

  @Test
  @DisplayName("Peek: View top element without removing it")
  void testPeek() {
    defaultStack.push(42);
    assertEquals(42, defaultStack.peek());
    assertFalse(defaultStack.isEmpty()); // Ensure it wasn't removed
  }

  @Test
  @DisplayName("Peek: Behavior on empty stack (Matches your current logic)")
  void testPeekOnEmptyStack() {
    // Note: Your current code will throw ArrayIndexOutOfBoundsException for size = -1
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> defaultStack.peek());
  }

  @Test
  @DisplayName("Integration: Sequential push and pop operations")
  void testSequentialPushPop() {
    customStack.push("First");
    customStack.push("Second");

    assertEquals("Second", customStack.pop());

    customStack.push("Third");

    assertEquals("Third", customStack.pop());
    assertEquals("First", customStack.pop());
    assertTrue(customStack.isEmpty());
  }
}
