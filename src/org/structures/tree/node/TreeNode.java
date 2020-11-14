package org.structures.tree.node;

/**
 * 与孩子结点同时存在的头结点
 * @author yk
 *
 * @param <T>
 */
public class TreeNode<T> {
    
    /**
     * 结点对应头结点下标
     */
    private T data;
    
    /**
     * 引用下一个孩子
     */
    private ChildNode firstChild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ChildNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(ChildNode firstChild) {
        this.firstChild = firstChild;
    }

}
