package org.structures.list.sequential2;


import java.io.Serializable;

import org.structures.list.ListException;

/**
 * 顺序表
 * @author BlankSpace
 * @time 2019-09-22
 * @version 2.0
 * @param <T>
 */
public class SequentialList<T> implements ISequentialList<T>, Serializable {
    
    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 内部储存T元素的数组
     */
    private T[] data;
    
    /**
     * 数组指针的位置
     */
    private int size;
    
    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 20;
    
    @SuppressWarnings("unchecked")
    public SequentialList() {
        this.data = (T[])new Object[DEFAULT_SIZE];
        this.size = 0;
    }
    
    public SequentialList(T[] list) {
        this();
        if (list == null) {
            return;
        }
        this.data = list;
        this.size = list.length;
    }
    
    @SuppressWarnings("unchecked")
    public SequentialList(int size) {
        this();
        if (size < 0) {
            return;
        }
        this.data = (T[])new Object[size];
        this.size = size;
    }
    
    @SuppressWarnings("unchecked")
    public SequentialList(int length, T[] list) {
        this();
        if (list == null || length < list.length) {
            return;
        }
        this.data = (T[])new Object[length];
        for (int i = 0; i < list.length; i++) {
            T element = list[i];
            if (element == null) {
                this.data = (T[])new Object[length];
                this.size = 0;
                return;
            }
            this.data[i] = list[i];
        }
        this.size = list.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !(size > 0);
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(T t) {
        if (t == null) {
            throw new ListException("待添加元素为空");
        } else if (size == data.length) {
            //扩增数组
            enlargeSize();
        }
        data[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new ListException("待删除元素为空");
        } else if (size == 0) {
            throw new ListException("空表，没有可删除的对象");
        }
        int index = indexOf(o);
        if (index == -1) {
            throw new ListException("元素不存在");
        }
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(ISequentialList<T> c) {
        if (c == null) {
            throw new ListException("传入空对象");
        }
        for (int i = 0; i < c.size(); i++) {
            T t = c.get(i);
            if (!contains(t)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(ISequentialList<T> c) {
        if (c == null) {
            throw new ListException("传入空对象");
        }
        int length = c.size();
        if (data.length < length+size) {
            enlargeSize(length);
        }
        for (int i = 0; i < length; i++) {
            T t = c.get(i);
            data[size+i] = t;
        }
        size += length;
        return true;
    }

    @Override
    public boolean addAll(int index, ISequentialList<T> c) {
        if (c == null) {
            throw new ListException("传入空对象");
        } else if (index < 0) {
            throw new ListException("负数索引不合法");
        } else if (index > size) {
            throw new ListException("数组上越界");
        } else if (!isAllNotNull(c)) {
            throw new ListException("传入列表存在空对象");
        }
        int length = c.size();
        if (data.length < length+size) {
            enlargeSize(length);
        }
        for (int i = size-index-1; i >= 0; i--) {
            data[i+index+length] = data[i+index];
        }
        for (int i = 0; i < length; i++) {
            T t = c.get(i);
            data[index+i] = t;
        }
        size += length;
        return true;
    }

//    @Override
//    public boolean removeAll(ISequentialList<T> c) {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public boolean retainAll(ISequentialList<T> c) {
//        // TODO Auto-generated method stub
//        return false;
//    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public T get(int index) {
        preJudge(index);
        return data[index];
    }

    @Override
    public T set(int index, T element) {
        preJudge(index);
        T t = data[index];
        data[index] = element;
        return t;
    }

    @Override
    public void add(int index, T element) {
        preJudge(index);
        if (data.length < size+1) {
            enlargeSize();
        }
        for (int i = size-index-1; i >= 0; i--) {
            data[i+index+1] = data[i+index];
        }
        data[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        preJudge(index);
        T t = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                try {
                    T t = (T)o;
                    if (t.equals(data[i])) {
                        return i;
                    }
                } catch (ClassCastException e)  {
                    throw new ListException("传入对象类型错误");
                }
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            return -1;
        } else {
            for (int i = size - 1; i >= 0; i--) {
                try {
                    T t = (T)o;
                    if (t.equals(data[i])) {
                        return i;
                    }
                } catch (ClassCastException e)  {
                    throw new ListException("传入对象类型错误");
                }
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ISequentialList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new ListException("负数索引不合法");
        } else if (toIndex > size) {
            throw new ListException("数组上越界");
        } else if (fromIndex > toIndex) {
            throw new ListException("末尾索引大于初始索引");
        }  
        //检查通过
        int getLen = toIndex-fromIndex;
        T[] array = (T[])new Object[getLen];
        for (int i = 0; i < getLen; i++) {
            array[i] = data[fromIndex+i];
        }
        return new SequentialList<T>(array);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void trimToSize() {
        T[] tempList = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            tempList[i] = data[i];
        }
        data = tempList;
    }
    
    @SuppressWarnings("unchecked")
    private void enlargeSize() {
        T[] tempList = (T[]) new Object[size*3/2+1];
        for (int i = 0; i < size; i++) {
            tempList[i] = data[i];
        }
        data = tempList;
    }
    
    @SuppressWarnings("unchecked")
    private void enlargeSize(int extra) {
        T[] tempList = (T[]) new Object[size + extra];
        for (int i = 0; i < size; i++) {
            tempList[i] = data[i];
        }
        data = tempList;
    }
    
    private boolean isAllNotNull(ISequentialList<T> c) {
        for (int i = 0; i < c.size(); i++) {
            T t = c.get(i);
            if (t == null) {
                return false;
            }
        }
        return true;
    }
    
    private void preJudge(int index) {
        if (index < 0) {
            throw new ListException("负数索引不合法");
        } else if (index >= size) {
            throw new ListException("数组上越界");
        }
    }

}
