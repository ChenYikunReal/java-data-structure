package org.structures.list.linked.circular;

import org.structures.list.ListException;
import org.structures.list.ListInterface;

/**
 * 保留头结点
 * @param <T>
 */
public class CircularLinkedList<T> implements ListInterface<T> {
    
    private final CircularLinkedNode<T> first;
    
    public CircularLinkedList() {
        first = new CircularLinkedNode<>();
        first.setNext(first);
    }
    
    public CircularLinkedList(T[] init) {
        first = new CircularLinkedNode<>();
        CircularLinkedNode<T> rear = first;
        for (T t : init) {
            CircularLinkedNode<T> node = new CircularLinkedNode<>(t);
            node.setNext(first);
            rear.setNext(node);
            rear = node;
        }
    }

    @Override
    public void printList() {
        CircularLinkedNode<T> temp = first;
        while (!temp.getNext().equals(first)) {
            temp = temp.getNext();
            System.out.println(temp.getData());
        }
    }

    @Override
    public int length() {
        CircularLinkedNode<T> temp = first;
        int counter = 0;
        while (!temp.getNext().equals(first)) {
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    @Override
    public int locate(T element) {
        CircularLinkedNode<T> temp = first;
        int counter = 0;
        boolean flag = false;
        while (!temp.getNext().equals(first)) {
            counter++;
            temp = temp.getNext();
            if (temp.getData().equals(element)) {
                flag = true;
                break;
            }
        }
        return flag ? counter : -1;
    }

    @Override
    public T getElement(int i) throws ListException {
        int length = length();
        if (i > length) {
            throw new IndexOutOfBoundsException("链表越界");
        }
        CircularLinkedNode<T> temp = first;
        for (int j = 0; j < i; j++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public void insert(int i, T element) throws ListException {
        int length = length();
        if (i > length) {
            throw new IndexOutOfBoundsException("链表越界");
        }
        CircularLinkedNode<T> temp = first, newNode = new CircularLinkedNode<>(element);
        for (int j = 0; j < i-1; j++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }

    @Override
    public T delete(int i) throws ListException {
        int length = length();
        if (i > length) {
            throw new IndexOutOfBoundsException("链表越界");
        }
        CircularLinkedNode<T> temp = first;
        for (int j = 0; j < i-1; j++) {
            temp = temp.getNext();
        }
        T deleteElement = temp.getNext().getData();
        temp.setNext(temp.getNext().getNext());
        return deleteElement;
    }

    @Override
    public boolean isEmpty() {
        return first.getNext().equals(first);
    }

}
