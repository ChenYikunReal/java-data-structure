package org.structures.list.linked.staticlist;

import org.structures.list.ListException;
import org.structures.list.ListInterface;

// TODO 没写完呜呜呜呜 先鸽着
public class StaticLinkedList<T> implements ListInterface<T> {

    private final int size;

    private final StaticLinkedListNode<T>[] list;

    private int length;

    private int firstIndex;

    @SuppressWarnings("unchecked")
    public StaticLinkedList(int size) {
        this.size = size;
        this.list = (StaticLinkedListNode<T>[])new StaticLinkedListNode[size];
        for (int i = 0; i < size; i++) {
            list[i] = new StaticLinkedListNode<T>(i, (i+1)%size, null, false);
        }
        this.length = 0;
        this.firstIndex = -1;
    }

    @Override
    public void printList() {
        if (length == 0) {
            return;
        }
        System.out.println(list[firstIndex].getData());
        if (length == 1) {
            return;
        }
        int tempIndex = list[firstIndex].getNextIndex();
        while (tempIndex != firstIndex) {
            System.out.println(list[tempIndex].getData());
            tempIndex = list[tempIndex].getNextIndex();
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int locate(T element) {
        return 0;
    }

    @Override
    public T getElement(int i) throws ListException {
        if (i > length || i <= 0) {
            throw new IndexOutOfBoundsException("静态链表查询越界");
        }
        int tempIndex = firstIndex;
        for (int j = 1; j < i; j++) {
            tempIndex = list[tempIndex].getNextIndex();
        }
        return list[tempIndex].getData();
    }

    @Override
    public void insert(int i, T element) throws ListException {

    }

    @Override
    public T delete(int i) throws ListException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

}
