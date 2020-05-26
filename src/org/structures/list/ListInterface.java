package org.structures.list;

public interface ListInterface<T> {
    
    /**
     * 遍历线性表
     */
    void printList();

    /**
     * 求线性表的长度
     * @return
     */
    int length();

    /**
     * 按值查找
     * @param element
     * @return
     */
    int locate(T element);

    /**
     * 按位查找
     * @param i
     * @return
     * @throws ListException
     */
    T getElement(int i) throws ListException;

    /**
     * 在指定逻辑位置插入
     * @param i
     * @param element
     * @throws ListException
     */
    void insert(int i, T element) throws ListException;

    /**
     * 删除指定逻辑位元素
     * @param i
     * @return
     * @throws ListException
     */
    T delete(int i) throws ListException;

    /**
     * 判断表空
     * @return
     */
    boolean isEmpty();

}
