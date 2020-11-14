package org.structures.queue.sequential;

import org.structures.queue.QueueException;
import org.structures.queue.QueueInterface;

public class SequentialQueue<T> implements QueueInterface<T> {
    
    private final T[] queue;
    
    private final static int QUEUE_SIZE = 100;
    
    private int head;
    
    private int rear;
    
    @SuppressWarnings("unchecked")
    public SequentialQueue() {
        queue = (T[]) (new Object[QUEUE_SIZE]);
        head = -1;
        rear = -1;
    }

    @Override
    public void enQueue(T element) {
        if (rear >= QUEUE_SIZE-1) {
            throw new QueueException("队列满");
        }
        queue[++rear] = element;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new QueueException("队列空");
        }
        T t = queue[head+1];
        head++;
        return t;
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            throw new QueueException("队列空");
        }
        return queue[head+1];
    }

    @Override
    public boolean isEmpty() {
        return head == rear;
    }

}
