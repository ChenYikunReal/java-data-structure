package org.structures.list.sequential2;


public interface ISequentialList<T> {
    
    /**
     * 获取长度
     * @return
     */
    int size();
    
    /**
     * 判空
     * @return
     */
    boolean isEmpty();
    
    /**
     * 是否包含某元素
     * @param o
     * @return
     */
    boolean contains(Object o);
    
    /**
     * 末尾添加
     * @param t
     * @return
     */
    boolean add(T t);
    
    /**
     * 末尾删除
     * @param o
     * @return
     */
    boolean remove(Object o);
    
    /**
     * 是否包含全部
     * @param c
     * @return
     */
    boolean containsAll(ISequentialList<T> c);
    
    /**
     * 添加全部
     * @param c
     * @return
     */
    boolean addAll(ISequentialList<T> c);
    
    /**
     * 指定位置添加全部
     * @param index
     * @param c
     * @return
     */
    boolean addAll(int index, ISequentialList<T> c);
    
//    boolean removeAll(ISequentialList<T> c);
//    
//    boolean retainAll(ISequentialList<T> c);
    
    /**
     * 使size为0，清空列表
     */
    void clear();
    
    /**
     * 获取指定索引元素
     * @param index
     * @return
     */
    T get(int index);
    
    /**
     * 修改指定索引处的元素
     * @param index
     * @param element
     * @return
     */
    T set(int index, T element);
    
    /**
     * 在指定索引处增加元素
     * @param index
     * @param element
     */
    void add(int index, T element);
    
    /**
     * 删除指定索引处的元素
     * @param index
     * @return
     */
    T remove(int index);
    
    /**
     * 元素第一次出现的索引
     * @param o
     * @return
     */
    int indexOf(Object o);
    
    /**
     * 元素最后一次出现的索引
     * @param o
     * @return
     */
    int lastIndexOf(Object o);
    
    /**
     * 子列表
     * @param fromIndex
     * @param toIndex
     * @return
     */
    ISequentialList<T> subList(int fromIndex, int toIndex);
    
    /**
     * 清除无用的冗余空间
     */
    void trimToSize();

}
