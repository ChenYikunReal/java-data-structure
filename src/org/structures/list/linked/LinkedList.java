package org.structures.list.linked;

import org.structures.list.ListException;
import org.structures.list.ListInterface;

public class LinkedList<T> implements ListInterface<T> {
    
    private LinkedNode<T> first;
    
    public LinkedList() {
        first = new LinkedNode<T>();
    }
    
    //头插法
//    public LinkedList(T[] init) {
//        first = new LinkedNode<T>();
//        for (int i = 0; i < init.length; i++) {
//            LinkedNode<T> node = new LinkedNode<>(init[i]);
//            node.setNext(first.getNext());
//            first.setNext(node);
//        }
//    }
    
    //尾插法
    public LinkedList(T[] init) {
        first = new LinkedNode<T>();
        LinkedNode<T> rear = first;
        for (int i = 0; i < init.length; i++) {
            LinkedNode<T> node = new LinkedNode<>(init[i]);
            rear.setNext(node);
            rear = node;
        }
    }

    @Override
    public void printList() {
        LinkedNode<T> p = first.getNext();
        while(p != null) {
            System.out.println(p.getData() + " ");
            p = p.getNext();
        }
    }

    @Override
    public int length() {
        int length = 0;
        LinkedNode<T> p = first.getNext();
        while(p != null) {
            p = p.getNext();
            length++;
        }
        return length;
    }

    @Override
    public int locate(T element) {
        LinkedNode<T> p = first.getNext();
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
        LinkedNode<T> p = first.getNext();
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
        LinkedNode<T> p = first;
        int count = 1;
        while (p != null && count < i) {
            p = p.getNext();
            count++;
        }
        if (p == null) {
            throw new ListException("插入位置异常");
        }
        LinkedNode<T> node = new LinkedNode<>(element);
        node.setNext(p.getNext());
        p.setNext(node);
    }

    @Override
    public T delete(int i) throws ListException {
        LinkedNode<T> p = first.getNext();
        int count = 1;
        while (p != null && count < i-1) {
            p = p.getNext();
            count++;
        }
        if (p == null || p.getNext() == null) {
            throw new ListException("删除位置异常");
        }
        LinkedNode<T> q = p.getNext();
        T deleteNode = q.getData();
        p.setNext(q.getNext());
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
