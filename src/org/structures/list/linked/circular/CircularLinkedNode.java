package org.structures.list.linked.circular;

public class CircularLinkedNode<T> {
    
    private T data;
    
    private CircularLinkedNode<T> next;
    
    public CircularLinkedNode() {
        this.data = null;
        this.next = null;
    }
    
    public CircularLinkedNode(T element) {
        this.data = element;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CircularLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(CircularLinkedNode<T> next) {
        this.next = next;
    }

}
