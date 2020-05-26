package org.structures.list.linked.doublee;

import org.structures.list.ListException;
import org.structures.list.ListInterface;

public class DoubleLinkedList<T> implements ListInterface<T> {
    
    private DoubleLinkedNode<T> first;
    
    public DoubleLinkedList() {
        first = new DoubleLinkedNode<T>();
    }
    
    public DoubleLinkedList(T[] init) {
        first = new DoubleLinkedNode<T>();
        DoubleLinkedNode<T> rear = first;
        for (int i = 0; i < init.length; i++) {
            DoubleLinkedNode<T> node = new DoubleLinkedNode<>(init[i]);
            rear.setNext(node);
            node.setPrior(rear);
            rear = node;
        }
    }

    @Override
    public void printList() {
        DoubleLinkedNode<T> p = first.getNext();
        while(p != null) {
            System.out.println(p.getData() + " ");
            p = p.getNext();
        }
    }

    @Override
    public int length() {
        int length = 0;
        DoubleLinkedNode<T> p = first.getNext();
        while(p != null) {
            p = p.getNext();
            length++;
        }
        return length;
    }

    @Override
    public int locate(T element) {
        DoubleLinkedNode<T> p = first.getNext();
        int count = 1;
        if (element == null) {
            while (p != null) {
                if (p.getData() == null) {
                    return count;
                }
                p = p.getNext();
                count++;
            }
        } else {
            while (p != null) {
                if (p.getData().equals(element)) {
                    return count;
                }
                p = p.getNext();
                count++;
            }
        }
        return 0;
    }

    @Override
    public T getElement(int i) throws ListException {
        DoubleLinkedNode<T> p = first.getNext();
        int count = 1;
        while (p != null && count < i) {
            p = p.getNext();
            count++;
        }
        if (p == null) {
            throw new ListException("逻辑位置异常");
        }
        return p.getData();
    }

    @Override
    public void insert(int i, T element) throws ListException {
        DoubleLinkedNode<T> p = first;
        int count = 1;
        while (p != null && count < i) {
            p = p.getNext();
            count++;
        }
        if (p == null) {
            throw new ListException("插入位置异常");
        }
        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(element);
        node.setPrior(p);
        node.setNext(p.getNext());
        (p.getNext()).setPrior(node);
        p.setNext(node);
    }

    @Override
    public T delete(int i) throws ListException {
        DoubleLinkedNode<T> p = first.getNext();
        int count = 1;
        while (p != null && count < i-1) {
            p = p.getNext();
            count++;
        }
        if (p == null || p.getNext() == null) {
            throw new ListException("删除位置异常");
        }
        DoubleLinkedNode<T> q = p.getNext();
        T deleteNode = q.getData();
        (p.getPrior()).setNext(q);
        q.setPrior(p.getPrior());
        return deleteNode;
    }

    @Override
    public boolean isEmpty() {
        if (first.getNext() == null) {
            return true;
        }
        return false;
    }

}
