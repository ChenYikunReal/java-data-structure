package org.structures.list.linked.sorted;

import org.structures.list.ListException;

/**
 * 有序单链表的功能和普通单链表的功能不同
 * @param <T>
 */
public interface SortedLinkedListInterface<T extends Comparable<? super T>> {

    /**
     * 遍历有序单链表
     */
    void printList();

    /**
     * 求有序单链表的长度
     * @return
     */
    int length();

    /**
     * 按值查找有序单链表
     * @param element
     * @return
     */
    int locate(T element);

    /**
     * 按位查找有序单链表
     * @param i
     * @return
     * @throws ListException
     */
    T getElement(int i) throws ListException;

    /**
     * 向有序单链表插入
     * @param element
     * @throws ListException
     */
    void insert(T element) throws ListException;

    /**
     * 删除有序单链表指定逻辑位元素
     * @param i
     * @return
     * @throws ListException
     */
    T delete(int i) throws ListException;

    /**
     * 判断有序单链表空
     * @return
     */
    boolean isEmpty();

}
