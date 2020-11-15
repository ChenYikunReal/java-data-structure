package org.structures.list.linked.staticlist;

public class StaticLinkedListNode<T> {

    private int index;

    private int nextIndex;

    private T data;

    private boolean used;

    public StaticLinkedListNode() {}

    public StaticLinkedListNode(int index, int nextIndex, T data, boolean used) {
        this.index = index;
        this.nextIndex = nextIndex;
        this.data = data;
        this.used = used;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}
