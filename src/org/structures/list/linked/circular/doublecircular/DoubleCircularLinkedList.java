package org.structures.list.linked.circular.doublecircular;

import org.structures.list.ListException;
import org.structures.list.ListInterface;
import org.structures.list.linked.circular.CircularLinkedNode;

/**
 * 一个普通的双循环链表<br/>
 * 之前的就不调整了<br/>
 * 这里新增属性length以减少获取Length的遍历时间
 * @param <T>
 */
public class DoubleCircularLinkedList<T> implements DoubleCircularLinkedListInterface<T> {

    private final DoubleCircularLinkedNode<T> first;

    private int length;

    public DoubleCircularLinkedList() {
        this.length = 0;
        this.first = new DoubleCircularLinkedNode<>();
        this.first.setNext(first);
        this.first.setPrev(first);
    }

    public DoubleCircularLinkedList(T[] init) {
        this.length = init.length;
        this.first = new DoubleCircularLinkedNode<>();
        DoubleCircularLinkedNode<T> temp = first;
        for (T t : init) {
            DoubleCircularLinkedNode<T> node = new DoubleCircularLinkedNode<>(t);
            node.setNext(first);
            node.setPrev(temp);
            temp.setNext(node);
            first.setPrev(node);
            temp = node;
        }
    }

    @Override
    public void printList() {
        DoubleCircularLinkedNode<T> temp = first;
        while (!temp.getNext().equals(first)) {
            temp = temp.getNext();
            System.out.println(temp.getData());
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int locate(T element) {
        DoubleCircularLinkedNode<T> temp = first;
        int counter = 0;
        boolean flag = false;
        while (!temp.getNext().equals(first)) {
            counter++;
            temp = temp.getNext();
            if (temp.getData().equals(element)) {
                flag = true;
                break;
            }
        }
        return flag ? counter : -1;
    }

    @Override
    public T getElement(int i) throws ListException {
        if (i > length) {
            throw new IndexOutOfBoundsException("链表越界");
        }
        DoubleCircularLinkedNode<T> temp = first;
        for (int j = 0; j < i; j++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public void insert(int i, T element) throws ListException {
        if (i > length) {
            throw new IndexOutOfBoundsException("链表越界");
        }
        DoubleCircularLinkedNode<T> temp = first, newNode = new DoubleCircularLinkedNode<>(element);
        for (int j = 0; j < i-1; j++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        temp.getNext().setPrev(newNode);
        temp.setNext(newNode);
        length++;
    }

    @Override
    public T delete(int i) throws ListException {
        if (i > length) {
            throw new IndexOutOfBoundsException("链表越界");
        }
        DoubleCircularLinkedNode<T> temp = first;
        for (int j = 0; j < i-1; j++) {
            temp = temp.getNext();
        }
        T deleteElement = temp.getNext().getData();
        temp.setNext(temp.getNext().getNext());
        temp.getNext().setPrev(temp);
        length--;
        return deleteElement;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public void printReverseList() {
        DoubleCircularLinkedNode<T> temp = first;
        while (!temp.getPrev().equals(first)) {
            temp = temp.getPrev();
            System.out.println(temp.getData());
        }
    }

}
