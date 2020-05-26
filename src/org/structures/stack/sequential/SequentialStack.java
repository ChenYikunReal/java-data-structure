package org.structures.stack.sequential;

import org.structures.stack.StackException;
import org.structures.stack.StackInterface;

public class SequentialStack<T> implements StackInterface<T> {
    
    /**
     * 顺序栈储存
     */
    private T[] stack;
    
    /**
     * 顺序栈容量
     */
    private final static int STACK_SIZE = 100;
    
    /**
     * 栈顶
     */
    private int top;

    @SuppressWarnings("unchecked")
    public SequentialStack() {
        stack = (T[])new Object[STACK_SIZE];
        top = -1;
    }
    
    @SuppressWarnings("unchecked")
    public SequentialStack(int size) {
        stack = (T[])new Object[size];
        top = -1;
    }
    
    @Override
    public void push(T element) {
        if (top == STACK_SIZE-1) {
            throw new StackException("栈满");
        }
        stack[++top] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackException("栈空");
        }
        T result = stack[top--];
        return result;
    }

    @Override
    public T getTop() {
        if (isEmpty()) {
            throw new StackException("栈空");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
       if (top == -1) {
           return true;
       }
        return false;
    }

}
