package org.structures.queue.stackqueue;

import org.structures.queue.QueueInterface;
import org.structures.stack.SequentialStack;
import org.structures.stack.StackInterface;

/**
 * 使用两个栈实现队列
 * @param <T>
 */
public class StackQueue<T> implements QueueInterface<T> {

    private StackInterface<T> stackIn;

    private StackInterface<T> stackOut;

    public StackQueue() {
        super();
        stackIn = new SequentialStack<T>();
        stackOut = new SequentialStack<T>();
    }

    public StackQueue(StackInterface<T> stackIn, StackInterface<T> stackOut) {
        super();
        this.stackIn = stackIn;
        this.stackOut = stackOut;
    }

    @Override
    public void enQueue(T element) {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        stackIn.push(element);
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
    }

    @Override
    public T deQueue() {
        return stackIn.pop();
    }

    @Override
    public T getHead() {
        return stackIn.getTop();
    }

    @Override
    public boolean isEmpty() {
        return stackIn.isEmpty();
    }

}
