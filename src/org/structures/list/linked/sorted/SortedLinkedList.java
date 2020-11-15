package org.structures.list.linked.sorted;

import org.structures.list.ListException;
import org.structures.list.linked.LinkedNode;

import java.util.Arrays;

public class SortedLinkedList<T extends Comparable<? super T>> implements SortedLinkedListInterface<T> {

    private int length;

    private final LinkedNode<T> first;

    public SortedLinkedList() {
        this.first = new LinkedNode<T>();
        this.length = 0;
    }

    public SortedLinkedList(T[] init) {
        this.length = init.length;
        this.first = new LinkedNode<T>();
        Arrays.sort(init);
        LinkedNode<T> rear = first;
        for (T t : init) {
            LinkedNode<T> node = new LinkedNode<>(t);
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
    public void insert(T element) throws ListException {
        LinkedNode<T> p = first.getNext(), newNode = new LinkedNode<>(element);
        boolean flag = false;
        while (p.getNext() != null) {
            if (p.getData().compareTo(element) < 0 && p.getNext().getData().compareTo(element) >= 0) {
                newNode.setNext(p.getNext());
                p.setNext(newNode);
                flag = true;
                break;
            }
            p = p.getNext();
        }
        length++;
        if (!flag) {
            p.setNext(newNode);
        }
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
        length--;
        return deleteNode;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

}
