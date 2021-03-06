package org.structures.stack;

public class SequentialStack<T> implements StackInterface<T> {
    
    /**
     * 顺序栈储存
     */
    private final T[] stack;
    
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
        return stack[top--];
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
        return top == -1;
    }

}
