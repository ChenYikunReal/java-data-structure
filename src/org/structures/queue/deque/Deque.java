package org.structures.queue.deque;

import org.structures.queue.QueueException;
import org.structures.queue.QueueInterface;
import org.structures.queue.linked.LinkedNode;
import org.structures.stack.StackInterface;

/**
 * 双端队列的链实现<br/>
 * 队尾支持队列的入队、栈的入栈和出栈，队首只支持出队<br/>
 * Java不支持多继承，所以只能同时实现两个接口来实现多继承的效果
 * @param <T>
 */
public class Deque<T> implements StackInterface<T>, QueueInterface<T> {

    private final LinkedNode<T> head;

    private LinkedNode<T> rear;

    public Deque() {
        head = rear = new LinkedNode<>();
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
        // 获取队列头结点
        LinkedNode<T> headNode = head.getNext();
        T headElement = headNode.getData();
        head.setNext(headNode.getNext());
        if (headNode.getNext() == null) {
            rear = head;
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
    public void push(T element) {
        enQueue(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        LinkedNode<T> prev = head, popNode;
        while (prev.getNext() != rear) {
            prev = prev.getNext();
        }
        popNode = prev.getNext();
        prev.setNext(null);
        rear = prev;
        return popNode.getData();
    }

    @Override
    public T getTop() {
        if (isEmpty()) {
            throw new QueueException("队空");
        }
        return rear.getData();
    }

    @Override
    public boolean isEmpty() {
        return head == rear;
    }

}
