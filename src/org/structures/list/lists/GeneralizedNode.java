package org.structures.list.lists;

/**
 * 广义表双链表示的结点类
 * @param <T> 指定结点的元素类型
 */
public class GeneralizedNode<T> {

    /**
     * 数据域
     */
    T data;

    /**
     * 地址域，指向子表
     */
    GeneralizedList<T> child;

    /**
     * 地址域，指向后继结点
     */
    GeneralizedNode<T> next;

    public GeneralizedNode() {
        this(null, null, null);
    }

    public GeneralizedNode(T data) {
        this(data, null, null);
    }

    /**
     * 构造结点
     * @param data 指定元素
     * @param child 指向子表
     * @param next 指向后继结点
     */
    public GeneralizedNode(T data, GeneralizedList<T> child, GeneralizedNode<T> next) {
        this.data = data;
        this.child = child;
        this.next = next;
    }

}
