package org.structures.list.lists;

/**
 * 广义表结点   
 * @param <T>
 */
public class ListsNode<T> {
    
    /**
     * 定义标识，区分元素结点和表结点
     * tag == 1 -> 表结点
     * tag == 0 -> 数据结点
     */
    private int tag;
    
    /**
     * 定义结点数据域
     */
    private T data;
    
    /**
     * 定义hp表头引用
     */
    private ListsNode<T> hp;
    
    /**
     * 定义tp表尾引用
     */
    private ListsNode<T> tp;

    public ListsNode(int tag, T data, ListsNode<T> hp, ListsNode<T> tp) {
        if (tag == 1) {
            data = null;
            this.hp = hp;
            this.tp = tp;
        } else if (tag == 0) {
            this.data = data;
        }
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListsNode<T> getHp() {
        return hp;
    }

    public void setHp(ListsNode<T> hp) {
        this.hp = hp;
    }

    public ListsNode<T> getTp() {
        return tp;
    }

    public void setTp(ListsNode<T> tp) {
        this.tp = tp;
    }

}
