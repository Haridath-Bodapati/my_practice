package com.test.jpmc;

public class CustomStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int top;

    public CustomStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public void push(T value) {
        ensureCapacity();
        elements[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow!");
        }
        T value = (T) elements[top];
        elements[top--] = null; // Avoid memory leak
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return (T) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void ensureCapacity() {
        if (top + 1 == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }
    
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Size: " + stack.size());        // 3

        System.out.println("Popped: " + stack.pop());       // 30
        System.out.println("Top element: " + stack.peek()); // 20
        System.out.println("Is empty: " + stack.isEmpty()); // false
    }
}
