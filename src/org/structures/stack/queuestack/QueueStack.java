package org.structures.stack.queuestack;

import org.structures.queue.QueueInterface;
import org.structures.queue.circular.CircularQueue;
import org.structures.stack.StackException;
import org.structures.stack.StackInterface;

/**
 * 两个队列实现一个栈
 * @param <T>
 */
public class QueueStack<T> implements StackInterface<T> {

    private QueueInterface<T> queueIn;

    private QueueInterface<T> queueOut;

    public QueueStack() {
        super();
        this.queueIn = new CircularQueue<T>();
        this.queueOut = new CircularQueue<T>();
    }

    public QueueStack(QueueInterface<T> queueIn, QueueInterface<T> queueOut) {
        super();
        this.queueIn = queueIn;
        this.queueOut = queueOut;
    }

    @Override
    public void push(T element) {
        while (!queueIn.isEmpty()) {
            queueOut.enQueue(queueIn.deQueue());
        }
        queueIn.enQueue(element);
        while (!queueOut.isEmpty()) {
            queueIn.enQueue(queueOut.deQueue());
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackException("栈空");
        }
        return queueIn.deQueue();
    }

    @Override
    public T getTop() {
        return queueIn.getHead();
    }

    @Override
    public boolean isEmpty() {
        return queueIn.isEmpty();
    }

}
