package org.structures.list.linked.circular.doublecircular;


public class DoubleCircularLinkedNode<T> {

    private T data;

    private DoubleCircularLinkedNode<T> prev;

    private DoubleCircularLinkedNode<T> next;

    public DoubleCircularLinkedNode() {
        this.data = null;
        this.prev = null;
        this.next = null;
    }

    public DoubleCircularLinkedNode(T element) {
        this.data = element;
        this.prev = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleCircularLinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleCircularLinkedNode<T> prev) {
        this.prev = prev;
    }

    public DoubleCircularLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleCircularLinkedNode<T> next) {
        this.next = next;
    }

}
