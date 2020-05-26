package org.structures.tree.avl;

public class AvlNode<T> {
    
    /**
     * 数据元素
     */
    T element;
    
    /**
     * 结点高度
     */
    int height;
    
    /**
     * 结点左儿子
     */
    AvlNode<T> left;
    
    /**
     * 结点右儿子
     */
    AvlNode<T> right;
    
    AvlNode(T element) {
        this(element, null, null);
    }
    
    AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
        this.element = element;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
    
}