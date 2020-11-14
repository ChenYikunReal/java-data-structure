package org.structures.stack.linked;

import org.structures.stack.StackException;
import org.structures.stack.StackInterface;

public class LinkedStack<T> implements StackInterface<T> {
    
    private LinkedNode<T> top;
    
    public LinkedStack() {
        top = null;
    }

    @Override
    public void push(T element) {
        LinkedNode<T> node = new LinkedNode<>(element);
        node.setNext(top);
        top = node;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackException("栈空");
        }
        T top_node = top.getData();
        top = top.getNext();
        return top_node;
    }

    @Override
    public T getTop() {
        if (isEmpty()) {
            throw new StackException("栈空");
        }
        T top_node = top.getData();
        return top_node;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
