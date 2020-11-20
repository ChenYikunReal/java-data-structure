package org.structures.queue.deque.doubledeque;

import org.structures.list.linked.doublelist.DoubleLinkedNode;
import org.structures.queue.QueueException;
import org.structures.queue.linked.LinkedNode;

public class DoubleDeque<T> implements DoubleDequeInterface<T> {

    private final DoubleLinkedNode<T> head;

    private DoubleLinkedNode<T> rear;

    public DoubleDeque() {
        head = rear = new DoubleLinkedNode<>();
    }

    @Override
    public void headPush(T element) {
        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(element);
        node.setNext(head.getNext());
        if (!isEmpty()) {
            node.setNext(head.getNext());
        }
        head.setNext(node);
        node.setPrior(head);
        if (isEmpty()) {
            rear = node;
        }
    }

    @Override
    public T headPop() {
        return deQueue();
    }

    @Override
    public void rearPush(T element) {
        enQueue(element);
    }

    @Override
    public T rearPop() {
        DoubleLinkedNode<T> rearNode;
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        rearNode = rear;
        rear = rear.getPrior();
        rear.getNext().setPrior(null);
        rear.setNext(null);
        return rearNode.getData();
    }

    @Override
    public T getRear() {
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        return rear.getData();
    }

    @Override
    public void enQueue(T element) {
        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(element);
        node.setPrior(rear);
        rear.setNext(node);
        rear = node;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        // 获取队列头结点
        DoubleLinkedNode<T> headNode = head.getNext();
        headNode.setPrior(null);
        T headElement = headNode.getData();
        head.setNext(headNode.getNext());
        if (headNode.getNext() == null) {
            rear = head;
        } else {
            head.getNext().setPrior(head);
        }
        return headElement;
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        return head.getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return head == rear;
    }

}
