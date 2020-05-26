package org.structures.queue.circular;

import org.structures.queue.QueueException;
import org.structures.queue.QueueInterface;

public class CircularQueue<T> implements QueueInterface<T> {
    
    private T[] queue;
    
    private final static int QUEUE_SIZE = 100;
    
    private int front;
    
    private int rear;
    
    @SuppressWarnings("unchecked")
    public CircularQueue() {
        queue = (T[]) (new Object[QUEUE_SIZE]);
        front = rear = 0;
    }
    
    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        queue = (T[]) (new Object[size]);
        front = rear = 0;
    }

    @Override
    public void enQueue(T element) {
        if ((rear+1)%QUEUE_SIZE == front) {
            throw new QueueException("队列满");
        }
        rear = (rear+1)%QUEUE_SIZE;
        queue[rear] = element;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new QueueException("队列空");
        }
        front = (front+1)%QUEUE_SIZE;
        T queueHead = queue[front];
        return queueHead;
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            throw new QueueException("队列空");
        }
        T element = queue[front+1];
        return element;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

}
