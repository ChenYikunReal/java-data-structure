package org.structures.queue.linked;

public class LinkedNode<T> {
    
    private T data;
    
    private LinkedNode<T> next;
    
    public LinkedNode() {
        this.data = null;
        this.next = null;
    }
    
    public LinkedNode(T element) {
        this.data = element;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

}
