package org.structures.list.sequential;

import org.structures.list.ListException;
import org.structures.list.ListInterface;

public class SequentialList<T> implements ListInterface<T> {
    
    /**
     * 顺序表存储
     */
    private T[] list;
    
    /**
     * 数组容量
     */
    private final static int LIST_SIZE = 100;

    /**
     * 表长
     */
    private int length;

    @SuppressWarnings("unchecked")
    public SequentialList() {
        list = (T[]) (new Object[LIST_SIZE]);
        length = 0;
    }
    
    @SuppressWarnings("unchecked")
    public SequentialList(T[] initialList, int n) throws ListException {
        //初始化泛型数组
        list = (T[]) (new Object[LIST_SIZE]);
        //初始化表长length
        length = n;
        if (length > LIST_SIZE) {
            expandCapacity();
            //throw new ListException("构造线性表，长度越界");
        }
        for (int i = 0; i < length; i++) {
            list[i] = initialList[i];
        }
    }
    
    @Override
    public void printList() {
        if (isEmpty()) {
            System.out.println("空表");
        }
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + "");
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int locate(T element) {
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (list[i].equals(element)) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    @Override
    public T getElement(int i) throws ListException {
        if (isEmpty()) {
            throw new ListException("表空");
        }
        if (i < 1 || i > length) {
            throw new ListException("查找位置非法");
        }
        T element = list[i-1];
        return element;
    }

    @Override
    public void insert(int i, T element) throws ListException {
        if (length == list.length) {
            expandCapacity();
            //throw new ListException("线性表满，插入异常");
        }
        if (i < 1 || i > length + 1) {
            throw new ListException("插入位置异常");
        }
        for (int index = length; index >= i; index--) {
            list[index] = list[index-1];
        }
        list[i-1] = element;
        length++;
    }

    @Override
    public T delete(int i) throws ListException {
        if (length == list.length) {
            throw new ListException("线性表满，插入异常");
        }
        if (i < 1 || i > length) {
            throw new ListException("删除位置异常");
        }
        T element = list[i-1];
        for (int j = i; j < length; j++) {
            list[j-1] = list[j];
        }
        length--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        //定义容量加倍数组
        T[] expandList = (T[]) (new Object[list.length*2]);
        //复制原有内容
        for (int i = 0; i < list.length; i++) {
            expandList[i] = list[i];
        }
        this.list = expandList;
    }

}
