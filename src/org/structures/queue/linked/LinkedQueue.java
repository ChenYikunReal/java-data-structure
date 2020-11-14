package org.structures.queue.linked;

import org.structures.queue.QueueException;
import org.structures.queue.QueueInterface;

public class LinkedQueue<T> implements QueueInterface<T> {
    
    private final LinkedNode<T> front;
    
    private LinkedNode<T> rear;
    
    public LinkedQueue() {
        front = rear = new LinkedNode<>();
    }

    @Override
    public void enQueue(T element) {
        LinkedNode<T> node = new LinkedNode<>(element);
        rear.setNext(node);
        rear = node;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        //获取队列头结点
        LinkedNode<T> headNode = front.getNext();
        T headElement = headNode.getData();
        front.setNext(headNode.getNext());
        if (headNode.getNext() == null) {
            rear = front;
        }
        return headElement;
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        //获取队列头结点
        LinkedNode<T> headNode = front.getNext();
        return headNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

}
