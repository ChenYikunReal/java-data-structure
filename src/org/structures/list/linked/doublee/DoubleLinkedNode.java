package org.structures.list.linked.doublee;

public class DoubleLinkedNode<T> {
    
    private T data;
    
    private DoubleLinkedNode<T> next;
    
    private DoubleLinkedNode<T> prior;
    
    public DoubleLinkedNode() {
        this.data = null;
        this.next = null;
        this.prior = null;
    }
    
    public DoubleLinkedNode(T element) {
        this.data = element;
        this.next = null;
        this.prior = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode<T> next) {
        this.next = next;
    }

    public DoubleLinkedNode<T> getPrior() {
        return prior;
    }

    public void setPrior(DoubleLinkedNode<T> prior) {
        this.prior = prior;
    }

}
