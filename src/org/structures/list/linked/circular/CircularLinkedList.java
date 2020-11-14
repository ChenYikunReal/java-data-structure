package org.structures.list.linked.circular;

import org.structures.list.ListException;
import org.structures.list.ListInterface;

/**
 * 保留头结点
 * @param <T>
 */
public class CircularLinkedList<T> implements ListInterface<T> {
    
    private CircularLinkedNode<T> first;
    
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int locate(T element) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T getElement(int i) throws ListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(int i, T element) throws ListException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T delete(int i) throws ListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

}
